package com.khalanirek.stockmarket.common

import org.springframework.context.ApplicationEventPublisher

class TestApplicationEventPublisher implements ApplicationEventPublisher {

    List<Object> events = new ArrayList<>()
    Object lastEvent

    @Override
    void publishEvent(Object event) {
        events.add(event)
        lastEvent = event
    }

    void clear() {
        events.clear()
    }

}
