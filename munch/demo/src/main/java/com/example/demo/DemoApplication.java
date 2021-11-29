package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.domain.*;

@SpringBootApplication
@ComponentScan("com.packt.userdatabase.domain")
public class DemoApplication {
	
	 @Autowired
	 UserRepository UserRepository;
	 @Autowired
	 ImageRepository ImageRepository;
	 @Autowired
	 PostRepository PostRepository;
	 @Autowired
	 RestaurantRepository RestaurantRepository;
	 
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	    logger.info("Hello Spring Boot");
	}

	@Bean
    CommandLineRunner runner(){
      return args -> {
    	  UserRepository.save(new User("username", "password"));
    	  ImageRepository.save(new Image(1, "url"));
    	  PostRepository.save(new Post());    	  
    	  RestaurantRepository.save(new Restaurant());
      };
    }
	
}
