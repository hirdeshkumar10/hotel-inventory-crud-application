package com.sunglowsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.sunglowsys.domain")
@EnableJpaRepositories(basePackages= "com.sunglowsys.repository")
@EnableTransactionManagement
@ComponentScan("com.sunglowsys")

public class HotelInventoryCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelInventoryCrudApplication.class, args);
	}

}
