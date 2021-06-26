package com.home.heycar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableR2dbcRepositories(value = {"com.home.heycar.persistence.repositories"})
public class HeycarApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeycarApplication.class, args);
	}

}
