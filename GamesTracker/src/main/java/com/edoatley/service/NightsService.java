package com.edoatley.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.edoatley.model.Night;
import com.edoatley.repository.NightsRepository;

@Service
public class NightsService {

	@Autowired
	private NightsRepository repository;
	
	public List<Night> findAllNights() {
		Iterable<Night> allNights = repository.findAll();
		List<Night> nights = new ArrayList<Night>();
		allNights.forEach(nights::add);
		return nights;
	}

	public void save(Night newNight) {
		
		if(isValidNight(newNight)) {
			repository.save(newNight);
		}
		else {
			throw new IllegalArgumentException("Night was not valid: " + newNight);
		}
	}

	private boolean isValidNight(Night newNight) {
		boolean isValidNight = true;
		
		if(newNight == null) {
			isValidNight = false;
		}
		else if(StringUtils.isEmpty(newNight.getDescription())) {
			isValidNight = false;
		}
		else if(newNight.getDate() == null) {
			isValidNight = false;
		}
		else {
			Optional<Night> match = findAllNights().stream()
												.filter((night) -> night.getDescription().equalsIgnoreCase(newNight.getDescription())).findFirst();
			if(match.isPresent()) {
				isValidNight = false;
			}
		}
		
		return isValidNight;
	}
}
