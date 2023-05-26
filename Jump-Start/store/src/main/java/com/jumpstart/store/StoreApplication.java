package com.jumpstart.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.jumpstart.store.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
		System.out.println("====== Jumpstart Store API Start! ======");
	}

}
