package com.carrentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CarrentalsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrentalsServiceApplication.class, args);
	}

}
