package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRedisRepositories
public class SpringBootDocsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDocsDemoApplication.class, args);
	}

}
