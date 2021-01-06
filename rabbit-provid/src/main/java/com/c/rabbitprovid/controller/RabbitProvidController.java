package com.c.rabbitprovid.controller;

import com.c.rabbitprovid.service.SendService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitProvidController {
    @Autowired
    SendService sendService;
    @Value("${name}")
    private String name;
    @RequestMapping(value = "/rabbitProvid/{id}",method = RequestMethod.GET)
    public String rabbitProvid(@PathVariable("id") int id){
        Message message = MessageBuilder.withPayload((id+"").getBytes()).build();
        sendService.send().send(message);
        return name;
    }
}
