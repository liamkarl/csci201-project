package com.example.demo;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
=======
>>>>>>> 62559cc87d6f52945c2829ef0560b23100ba54e6

import com.example.demo.domain.BookmarkRepository;
import com.example.demo.domain.EventRepository;
import com.example.demo.domain.GroupRepository;
import com.example.demo.domain.PostRepository;
import com.example.demo.domain.RestaurantRepository;
import com.example.demo.domain.UserRepository;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Hello Spring Boot");
	}

<<<<<<< HEAD
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Save demo data to database
			UserRepository.save(new User("username1", "password", "email", "user"));
			UserRepository.save(new User("1", "2", "email", "user"));
			ImageRepository.save(new Image(1, "url"));
			PostRepository.save(new Post());
			//restaurants
			RestaurantRepository.save(new Restaurant("Mcdonalds"));
			RestaurantRepository.save(new Restaurant("a", "AssCuisine", "$$$", "ArseAvenue"));
			RestaurantRepository.save(new Restaurant("b","BootyCuisine", "$$$$", "ButtholeBoulevard"));
			RestaurantRepository.save(new Restaurant("c", "CockCuisine", "$", "CockCourt"));
			
			RestaurantRepository.save(new Restaurant());
			EventRepository.save(new Event());
			BookmarkRepository.save(new Bookmark());
		};
	}
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(4);
	    executor.setMaxPoolSize(4);
	    executor.setQueueCapacity(500);
	    executor.setThreadNamePrefix("RestaurantLookup-");
	    executor.initialize();
	    return executor;
	}
=======
	@Autowired
	UserRepository UserRepository;
	@Autowired
	PostRepository PostRepository;
	@Autowired
	RestaurantRepository RestaurantRepository;
	@Autowired
	EventRepository EventRepository;
>>>>>>> 62559cc87d6f52945c2829ef0560b23100ba54e6

	@Autowired
	BookmarkRepository BookmarkRepository;

	@Autowired
	GroupRepository GroupRepository;
}
