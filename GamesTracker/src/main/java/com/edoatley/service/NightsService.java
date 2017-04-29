package com.edoatley.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
