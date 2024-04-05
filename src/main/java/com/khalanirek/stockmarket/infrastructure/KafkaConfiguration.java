package com.khalanirek.stockmarket.infrastructure;

import com.khalanirek.stockmarket.processor.ExampleProcessor;
import io.confluent.kafka.streams.serdes.avro.GenericAvroDeserializer;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerializer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

import static com.khalanirek.stockmarket.infrastructure.KafkaConfiguration.Topics.*;
import static io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.*;

@RequiredArgsConstructor
@EnableKafka
@EnableKafkaStreams
@Configuration
public class KafkaConfiguration {

    @Autowired
    private KafkaProperties kafkaProperties;

    public static final class Topics {

        public static final String ACCOUNTS = "accounts";
        public static final String ACCOUNTS2 = "accounts2";
        public static final String COMPANIES = "companies";
        public static final String INVESTMENT_PORTFOLIOS = "investment-portfolios";
        public static final String INVESTORS = "investors";
        public static final String ORDERS = "orders";

    }

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration streamsConfiguration() {
        Map<String, Object> props = new HashMap<>();
        props.put(APPLICATION_ID_CONFIG, "streams-app");
        props.put(SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getProducer().getProperties().get(SCHEMA_REGISTRY_URL_CONFIG));
        props.put(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        props.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, GenericAvroSerde.class.getName());
        props.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 1);
        props.put("specific.avro.reader", true);
        return new KafkaStreamsConfiguration(props);
    }

    @Bean
    Topology exampleTopology(StreamsBuilder streamsBuilder) {
        Topology topology = streamsBuilder.build();
        topology.addSource("AccountSource", ACCOUNTS);
        topology.addProcessor("ExampleProcessor", ExampleProcessor::new, "AccountSource");
        topology.addSink("AccountSink", "accounts2", "ExampleProcessor");
        return topology;
    }

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
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GenericAvroSerializer.class);
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
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, GenericAvroDeserializer.class);
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

    @Bean
    public NewTopic accountsTopic() {
        return new NewTopic(ACCOUNTS, 3, (short) 1);
    }

    @Bean
    public NewTopic accounts2Topic() {
        return new NewTopic(ACCOUNTS2, 3, (short) 1);
    }

    @Bean
    public NewTopic companiesTopic() {
        return new NewTopic(COMPANIES, 3, (short) 1);
    }

    @Bean
    public NewTopic investmentsPortfoliosTopic() {
        return new NewTopic(INVESTMENT_PORTFOLIOS, 3, (short) 1);
    }

    @Bean
    public NewTopic investorsTopic() {
        return new NewTopic(INVESTORS, 3, (short) 1);
    }

    @Bean
    public NewTopic ordersTopic() {
        return new NewTopic(ORDERS, 3, (short) 1);
    }

}
