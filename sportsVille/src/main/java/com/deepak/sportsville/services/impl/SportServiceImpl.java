package com.deepak.sportsville.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.sportsville.entities.Sports;
import com.deepak.sportsville.exceptions.ResourceNotFoundException;
import com.deepak.sportsville.payloads.SportDto;
import com.deepak.sportsville.repositories.SportsRepo;
import com.deepak.sportsville.services.SportService;

@Service
public class SportServiceImpl implements SportService {
	
	
	@Autowired
	private SportsRepo sportsRepo;

	@Autowired
	private ModelMapper modelMapper;
	@Override
	public SportDto createSport(SportDto sportDto) {
		
		Sports sport = this.modelMapper.map(sportDto,Sports.class);
		Sports savedSport = this.sportsRepo.save(sport);
		return this.modelMapper.map(savedSport,SportDto.class);
	}
	
	@Override
	public void deleteSport(Integer id) {
		Sports sports = this.sportsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sport","with sport Id : ",id));
		this.sportsRepo.delete(sports);
		
	}
	
	
	@Override
	public SportDto getSport(Integer id) {
		Sports sports = this.sportsRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sport","with sport Id : ",id));
		return this.modelMapper.map(sports,SportDto.class);
	}
	
	
	@Override
	public List<SportDto> getAllSports() {
		List<Sports> sports = this.sportsRepo.findAll();
		return sports.stream().map(user->this.modelMapper.map(user,SportDto.class)).collect(Collectors.toList());
	}
}