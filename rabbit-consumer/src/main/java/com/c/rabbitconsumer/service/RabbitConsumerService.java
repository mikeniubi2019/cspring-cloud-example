package com.c.rabbitconsumer.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitConsumerService {
    @Input("rabbit-test")
    SubscribableChannel receive();
}
