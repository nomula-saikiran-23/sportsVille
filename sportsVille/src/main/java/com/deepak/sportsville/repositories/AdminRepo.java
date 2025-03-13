package com.deepak.sportsville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.sportsville.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

}
