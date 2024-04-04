package com.khalanirek.stockmarket.infrastructure;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

import static com.khalanirek.stockmarket.infrastructure.KafkaConfiguration.Topics.*;
import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;

@RequiredArgsConstructor
@Configuration
public class KafkaConfiguration {

    @Autowired
    private KafkaProperties kafkaProperties;

    public static final class Topics {

        public static final String ACCOUNTS = "accounts";
        public static final String COMPANIES = "companies";
        public static final String INVESTMENT_PORTFOLIOS = "investment-portfolios";
        public static final String INVESTORS = "investors";
        public static final String ORDERS = "orders";

    }

    @Profile("!integration")
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        config.put(SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProducer().getProperties().get(SCHEMA_REGISTRY_URL_CONFIG));
        return new DefaultKafkaProducerFactory<>(config);
    }


    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(ProducerFactory<String, Object> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        config.put(SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getConsumer().getProperties().get(SCHEMA_REGISTRY_URL_CONFIG));
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        config.put("specific.avro.reader", true);
        return new DefaultKafkaConsumerFactory<>(config);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory(ConsumerFactory<String, Object> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, Object> containerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setConsumerFactory(consumerFactory);
        return containerFactory;
    }

    @Profile("!integration")
    @Bean
    public NewTopic accountsTopic() {
        return new NewTopic(ACCOUNTS, 3, (short) 1);
    }

    @Profile("!integration")
    @Bean
    public NewTopic companiesTopic() {
        return new NewTopic(COMPANIES, 3, (short) 1);
    }

    @Profile("!integration")
    @Bean
    public NewTopic investmentsPortfoliosTopic() {
        return new NewTopic(INVESTMENT_PORTFOLIOS, 3, (short) 1);
    }

    @Profile("!integration")
    @Bean
    public NewTopic investorsTopic() {
        return new NewTopic(INVESTORS, 3, (short) 1);
    }

    @Profile("!integration")
    @Bean
    public NewTopic ordersTopic() {
        return new NewTopic(ORDERS, 3, (short) 1);
    }

}
