package com.example.amdocs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class RestEndPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEndPointApplication.class, args);
		
			
	}
	
	@Configuration
	class Config {
		
//		@LoadBalanced
		@Bean
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/items")
	public String getAllItems() {
		String url = "http://items-catalog:8701/rest/items";
		return restTemplate.getForObject(url, String.class);
		}
	
	@RequestMapping("/items/{IID}")
	public String getItemByID(int IID) {
		String url = "http://items-catalog:8701/rest/items/" + IID;
		return restTemplate.getForObject(url, String.class);
		}
	
	@RequestMapping("/orders")
	public String getAllOrders(int IID) {
		String url = "http://orders-catalog:8702/rest/orders";
		return restTemplate.getForObject(url, String.class);
		}
	
	@RequestMapping("/orders/{IID}")
	public String getOrderByID(int OID) {
		String url = "http://orders-catalog:8702/rest/orders/" + OID;
		return restTemplate.getForObject(url, String.class);
		}
	}
