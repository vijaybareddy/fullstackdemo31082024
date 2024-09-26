package com.fullstackdemo_31082024.fullstackdemo_31082024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fullstackdemo_31082024.fullstackdemo_31082024.Repository")
@EntityScan(basePackages = "entity") // Add this line if it's not already present
public class Fullstackdemo31082024Application {

	public static void main(String[] args) {
		SpringApplication.run(Fullstackdemo31082024Application.class, args);
	}

}

