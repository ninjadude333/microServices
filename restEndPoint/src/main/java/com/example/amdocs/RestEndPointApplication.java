package com.example.amdocs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestEndPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestEndPointApplication.class, args);
		
		
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public String getAllItems() {
		String url = "http://item-catalog:8702/rest/items";
		return restTemplate.getForObject(url, String.class);
		}
	
}
