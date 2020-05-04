package com.online.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.online.dao.AuthenticationDao;

@EnableAutoConfiguration
@ComponentScan("com.online")
@EntityScan(basePackages= {"com.online.entities"})
@SpringBootApplication
public class OnlineSellingApplication extends SpringBootServletInitializer{

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OnlineSellingApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineSellingApplication.class, args);
	}

}
