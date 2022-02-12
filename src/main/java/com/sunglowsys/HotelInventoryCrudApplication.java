package com.sunglowsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.sunglowsys.repository")
@EntityScan(basePackages = "com.sunglowsys.domain")

public class HotelInventoryCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelInventoryCrudApplication.class, args);
	}

}
