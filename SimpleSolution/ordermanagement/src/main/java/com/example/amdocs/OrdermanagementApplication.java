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
public class OrdermanagementApplication {

	final ApplicationContext context = new ClassPathXmlApplicationContext("orders.xml");
	
	public static void main(String[] args) {
		SpringApplication.run(OrdermanagementApplication.class, args);
	}
	
	@RequestMapping("/orders/getOrder")
	public String getOrder(String id) {
		singleOrder item = (singleOrder)context.getBean(id);
		return item.toString();
	}
	
	@RequestMapping("/orders/getCustomerInfo")
	public String getCustomerInfo(String id) {
		singleOrder item = (singleOrder)context.getBean(id);
		return item.customerDetails;	
	}
	
	@RequestMapping("/orders/getAllOrders")
	public String getAllOrders() {
		int itemsCount = Arrays.asList(context.getBeanDefinitionNames()).size();
		String returnValue = "";
		
		for (int i = 1; i <= itemsCount; i++) {
			
			singleOrder item = (singleOrder)context.getBean(Integer.toString(i));
			returnValue = returnValue + item + "\n";
		}
		
		return returnValue;
	}

	@RequestMapping("/orders/destroyer")
	public void destroyer() {
		ClassPathXmlApplicationContext cxt = (ClassPathXmlApplicationContext)context;
		cxt.close();
		}
}