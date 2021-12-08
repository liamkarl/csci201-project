package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
<<<<<<< HEAD
	User findByUsername(String username);
	User findByUserID(long userID);
=======
>>>>>>> 62559cc87d6f52945c2829ef0560b23100ba54e6
	Boolean existsByUsername(String username);

	Optional<User> findByUsername(String username);
}