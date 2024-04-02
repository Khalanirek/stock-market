package com.khalanirek.stockmarket.infrastructure;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static com.khalanirek.stockmarket.infrastructure.KafkaConfiguration.Topics.*;

@Configuration
public class KafkaConfiguration {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

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
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
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
