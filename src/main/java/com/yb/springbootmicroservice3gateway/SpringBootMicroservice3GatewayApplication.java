package com.yb.springbootmicroservice3gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class SpringBootMicroservice3GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservice3GatewayApplication.class, args);
	}

}
