package com.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.address.web ,+ com.address.service")
public class AddressFormSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressFormSpringBootApplication.class, args);
	}

}
