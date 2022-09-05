package com.greatoutdoor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddressManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressManagementSystemApplication.class, args);
	}

}
