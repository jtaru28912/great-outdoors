package com.greatoutdoor;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderServiceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceManagementApplication.class, args);
	}

	@Bean
	//rest template creats app which consumes restful api
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
