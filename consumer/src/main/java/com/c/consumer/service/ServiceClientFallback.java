package com.c.consumer.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceClientFallback implements ServiceClient{
    @Override
    public String service(int id) {
        return "fallBack";
    }
}
