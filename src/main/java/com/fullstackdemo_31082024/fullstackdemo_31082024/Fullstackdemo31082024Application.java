package com.fullstackdemo_31082024.fullstackdemo_31082024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "entity")
@EnableJpaRepositories(basePackages = "com.fullstackdemo_31082024.fullstackdemo_31082024.Repository")
public class Fullstackdemo31082024Application {

	public static void main(String[] args) {
		SpringApplication.run(Fullstackdemo31082024Application.class, args);
	}

}

