package com.c.rabbitprovid.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SendService {
    @Output("rabbit-test")
    SubscribableChannel send();
}
