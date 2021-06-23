package com.home.heycar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(value = {"com.home.heycar.persistence.repositories"})
public class HeycarApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeycarApplication.class, args);
	}

}
