package com.c.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入环境");
        String profile = scanner.nextLine();
        new SpringApplicationBuilder(EurekaApplication.class).profiles(profile).run(args);
        SpringApplication.run(EurekaApplication.class, args);
    }

}
