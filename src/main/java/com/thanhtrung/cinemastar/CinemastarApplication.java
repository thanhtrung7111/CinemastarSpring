package com.thanhtrung.cinemastar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "controller", "admincontroller", "dao", "helper", "service", "config", "filter" })
@EntityScan(basePackages = { "model" })
@EnableJpaRepositories(basePackages = { "dao" })
public class CinemastarApplication {
	public static void main(String[] args) {
		SpringApplication.run(CinemastarApplication.class, args);
	}

}
