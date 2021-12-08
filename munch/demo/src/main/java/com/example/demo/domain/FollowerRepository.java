package com.example.demo.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {
	Boolean existsByUserFollowerAndUserFollowing(User userFollower, User userFollowing);

	Optional<Follower> findByFollowerID(Long followerId);

	Optional<Follower> findByUserFollowerAndUserFollowing(User userFollower, User userFollowing);
}