package com.harry.security.oauth2.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverServer {
    public static void main(String[] args) {
        SpringApplication.run(DiscoverServer.class, args);
    }
}
