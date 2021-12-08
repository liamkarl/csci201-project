package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	Boolean existsByName(String name);

	List<Restaurant> findByCuisine(String cuisine);

<<<<<<< HEAD
	Restaurant findByName(String name);
	
	List<Restaurant> findAllByName(String search);
	List<Restaurant> findByCuisine(String cuisine);
}
=======
	List<Restaurant> findByName(String name);

	Optional<Restaurant> findByRestaurantID(Long restaurantID);
}
>>>>>>> 62559cc87d6f52945c2829ef0560b23100ba54e6
