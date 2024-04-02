package com.khalanirek.stockmarket.communication.domain;

import com.khalanirek.stockmarket.account.dto.AccountEventsDto;
import com.khalanirek.stockmarket.communication.infrastructure.KafkaPublisherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class CommunicationFacade {

    private final KafkaPublisherClient kafkaPublisherClient;

    public void processAccountEvent(AccountEventsDto.AccountEvent accountEvent) {

    }

}
