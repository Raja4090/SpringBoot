package com.phoenix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoenix.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
     
}
