package com.khalanirek.stockmarket.communication.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
@Configuration
class CommunicationConfiguration {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Bean
    KafkaPublisher kafkaPublisher() {
        return new KafkaPublisher(kafkaTemplate);
    }

    @Bean
    CommunicationEventListener communicationEventListener() {
        return new CommunicationEventListener(kafkaPublisher());
    }

}
