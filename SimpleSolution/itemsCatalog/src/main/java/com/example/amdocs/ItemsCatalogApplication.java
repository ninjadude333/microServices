package com.example.amdocs;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@SpringBootApplication
public class ItemsCatalogApplication {

	final ApplicationContext context = new ClassPathXmlApplicationContext("items.xml");
	
	public static void main(String[] args) {
		SpringApplication.run(ItemsCatalogApplication.class, args);
	}
	
	@RequestMapping("/items/getItemName")
	public String getItemName(String id) {
		singleItem item = (singleItem)context.getBean(id);
		return item.name;
	}
	
	@RequestMapping("/items/getItemDescription")
	public String getItemDescription(String id) {
		singleItem item = (singleItem)context.getBean(id);
		return item.description;	
	}
	
	@RequestMapping("/items/getAllItems")
	public String getAllItems() {
		int itemsCount = Arrays.asList(context.getBeanDefinitionNames()).size();
		String returnValue = "";
		
		for (int i = 1; i <= itemsCount; i++) {
			
			singleItem item = (singleItem)context.getBean(Integer.toString(i));
			returnValue = returnValue + item + "\n";
		}
		
		return returnValue;
	}

	@RequestMapping("/items/destroyer")
	public void destroyer() {
		ClassPathXmlApplicationContext cxt = (ClassPathXmlApplicationContext)context;
		cxt.close();
		}
}