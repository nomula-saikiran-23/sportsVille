package com.deepak.sportsville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.sportsville.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
}
