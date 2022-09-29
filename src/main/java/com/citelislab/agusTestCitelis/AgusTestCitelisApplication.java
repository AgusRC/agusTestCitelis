package com.citelislab.agusTestCitelis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = "main.java.com.citelislab")
@EnableAutoConfiguration
public class AgusTestCitelisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgusTestCitelisApplication.class, args);
	}

}
