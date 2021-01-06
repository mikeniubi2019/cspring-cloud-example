package com.c.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "rabbit-consumer",fallback = RabbitServiceClientFallback.class)
public interface ServiceRabbitClient {
    @RequestMapping(value = "/rabbitConsumer/{id}",method = RequestMethod.GET)
    String service(@PathVariable("id")int id);
}
