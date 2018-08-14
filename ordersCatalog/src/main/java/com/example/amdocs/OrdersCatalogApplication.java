package com.example.amdocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrdersCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersCatalogApplication.class, args);
	}
}
