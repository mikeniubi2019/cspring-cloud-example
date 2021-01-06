package com.c.rabbitconsumer.controller;

import com.c.rabbitconsumer.service.RabbitConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RebbitConsumerController {
    @Autowired
    RabbitConsumerService consumerService;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value = "/rabbitConsumer/{id}",method = RequestMethod.GET)
    public String get(@PathVariable("id") int id){
        String body = (String) redisTemplate.opsForValue().get(id+"");
        System.out.println(body);
        redisTemplate.delete(id+"");
        return body==null?"":body;
    }

}
