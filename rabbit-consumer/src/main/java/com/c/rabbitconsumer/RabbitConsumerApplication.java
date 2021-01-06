package com.c.rabbitconsumer;

import com.c.rabbitconsumer.service.RabbitConsumerService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Scanner;

@SpringBootApplication
@EnableBinding(RabbitConsumerService.class)

public class RabbitConsumerApplication {
    private static ConfigurableApplicationContext configurableApplicationContext;
    public static void main(String[] args) {
        System.out.println("请输入端口号：");
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        configurableApplicationContext = new SpringApplicationBuilder(RabbitConsumerApplication.class).properties("server.port="+port).run(args);
    }

    @StreamListener("rabbit-test")
    public void recieve(byte[] msg){
        RedisTemplate redisTemplate = (RedisTemplate)configurableApplicationContext.getBean("redisTemplate");
        redisTemplate.opsForValue().set(new String(msg), new String(msg));
    }

}
