package com.c.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class RabbitServiceClientFallback implements ServiceRabbitClient{
    @Override
    public String service(int id) {
        return "fallBack";
    }
}
