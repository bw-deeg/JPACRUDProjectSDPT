package com.skilldistillery.bootcandy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.jpacandy")
public class BootCandyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCandyApplication.class, args);
	}

}
