package com.khalanirek.stockmarket.processor;

import com.khalanirek.stockmarket.avro.account.AccountCreatedEvent;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

public class ExampleProcessor implements Processor<String, AccountCreatedEvent, String, AccountCreatedEvent> {

    private ProcessorContext<String, AccountCreatedEvent> processorContext;

    @Override
    public void init(ProcessorContext<String, AccountCreatedEvent> context) {
        processorContext = context;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(Record<String, AccountCreatedEvent> record) {
        processorContext.forward(record);
    }

}
