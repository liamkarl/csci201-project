package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	Optional<Restaurant> findByRestaurantID(long restaurantID);

	List<Restaurant> findByName(String name);

	List<Restaurant> findByCusine(String cuisine);
}
