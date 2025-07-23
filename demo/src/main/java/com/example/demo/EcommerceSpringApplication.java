package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // used to activate JPA auditing features
public class EcommerceSpringApplication {

	public static void main(String[] args) {
		
		Dotenv dotenv = Dotenv.configure().load(); // load .env from root path
		
		dotenv.entries().forEach( (DotenvEntry entry ) -> System.setProperty(entry.getKey() , entry.getValue()));
		// set system properties from environment variables and set them
		// setting environment variable
		
		
		SpringApplication.run(EcommerceSpringApplication.class, args);
		
	}
	
}
