package com.citelislab.agusTestCitelis;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.SpringApplication;

@Configuration
@ComponentScan( basePackages = "com.citelislab")
@EnableAutoConfiguration
public class AgusTestCitelisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgusTestCitelisApplication.class, args);
	}

}
