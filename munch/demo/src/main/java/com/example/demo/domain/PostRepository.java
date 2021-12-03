package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	Optional<Post> findByPostID(long postID);

	List<Post> findByUserID(long userID);

	List<Post> findByRestaurantID(long restaurantID);

	@Query("count p from Posts p where p.restaurantID = ?1")
	long getRestaurantNumPosts(long restaurantID);
}
