package com.c.rabbitprovid;

import com.c.rabbitprovid.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(SendService.class)
public class RabbitProvidApplication {

    public static void main(String[] args) {
        System.out.println("请输入端口号：");
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(RabbitProvidApplication.class).properties("server.port="+port).run(args);
    }

}
