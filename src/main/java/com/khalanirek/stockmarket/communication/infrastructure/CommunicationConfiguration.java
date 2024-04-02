package com.khalanirek.stockmarket.communication.infrastructure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
@Configuration
class CommunicationConfiguration {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Profile("!integration")
    @Bean
    KafkaPublisher kafkaPublisher() {
        return new KafkaPublisher(kafkaTemplate);
    }

    @Profile("!integration")
    @Bean
    CommunicationEventListener communicationEventListener() {
        return new CommunicationEventListener(kafkaPublisher());
    }

}
