package com.harry.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8803_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8803_App.class, args);

	}
}
