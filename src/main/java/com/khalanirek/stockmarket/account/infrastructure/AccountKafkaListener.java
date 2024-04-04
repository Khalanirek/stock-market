package com.khalanirek.stockmarket.account.infrastructure;

import com.khalanirek.stockmarket.avro.account.AccountCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.khalanirek.stockmarket.infrastructure.KafkaConfiguration.Topics.ACCOUNTS;

@Component
public class AccountKafkaListener {

    @KafkaListener(topics = ACCOUNTS, groupId = "interview")
    public void listen(AccountCreatedEvent message) {
        System.out.println("Received message: " + message);
    }

}
