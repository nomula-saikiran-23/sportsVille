package com.deepak.sportsville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.sportsville.entities.Sports;

public interface SportsRepo extends JpaRepository<Sports,Integer>{

}
