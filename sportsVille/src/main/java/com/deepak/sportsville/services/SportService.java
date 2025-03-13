package com.deepak.sportsville.services;

import java.util.List;

import com.deepak.sportsville.payloads.SportDto;

public interface SportService {
	SportDto createSport(SportDto sportDto);
	
	void deleteSport(Integer id);
	
	SportDto getSport(Integer id);
	
	List<SportDto> getAllSports();
}
