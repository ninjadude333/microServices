package com.example.amdocs;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class ItemsCatalogApplication {

	final ApplicationContext context = new ClassPathXmlApplicationContext("items.xml");
	
	public static void main(String[] args) {
		SpringApplication.run(ItemsCatalogApplication.class, args);
	}

	@RequestMapping("/rest/items/{IID}")
	public String getItemById(@PathVariable String IID) {
		singleItem item = (singleItem)context.getBean(IID);
		return item.toString();	
	}
	
	@RequestMapping("/rest/items")
	public String getAllItems() {
		int itemsCount = Arrays.asList(context.getBeanDefinitionNames()).size();
		String returnValue = "";
		
		for (int i = 1; i <= itemsCount; i++) {
			
			singleItem item = (singleItem)context.getBean(Integer.toString(i));
			returnValue = returnValue + item + "\n";
		}
		
		return returnValue;
	}

	@RequestMapping("/rest/items/destroyer")
	public void destroyer() {
		ClassPathXmlApplicationContext cxt = (ClassPathXmlApplicationContext)context;
		cxt.close();
		}
	
	
}
