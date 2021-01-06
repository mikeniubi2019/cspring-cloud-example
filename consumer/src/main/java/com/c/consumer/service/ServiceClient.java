package com.c.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "provid",fallback = ServiceClientFallback.class)
public interface ServiceClient {
    @RequestMapping(value = "/service/{id}",method = RequestMethod.GET)
    String service(@PathVariable("id")int id);
}
