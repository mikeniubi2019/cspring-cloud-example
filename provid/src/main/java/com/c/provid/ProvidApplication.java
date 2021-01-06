package com.c.provid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class ProvidApplication {

    public static void main(String[] args) {
        System.out.println("请输入端口号：");
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(ProvidApplication.class).properties("server.port="+port).run(args);
    }

}
