package com.edoatley.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edoatley.model.Night;
import com.edoatley.service.NightsService;

@Controller
public class NightsController {
	private static final Logger log = LoggerFactory.getLogger(NightsController.class);
	
	@Autowired
	private NightsService nightsService;
	
    @RequestMapping(value="/nights", method=RequestMethod.GET)
    public String fetchNights(Model model) {
    	
    	List<Night> nights = nightsService.findAllNights(); 
    	
    	model.addAttribute("nights", nights);
    	model.addAttribute("night", new Night());
    	
        return "nights";
    }

	@RequestMapping(value="/nights", method=RequestMethod.POST)
	public String addNight(@ModelAttribute("night") Night newNight, BindingResult result, Model model) {

		log.info("Adding Night " + newNight.getDescription());
		log.info("Adding Night (full details) " + newNight.toString());
		
		List<Night> nights = nightsService.findAllNights(); 
		
		try {			
			nightsService.save(newNight);
			nights = nightsService.findAllNights();
		}
		catch(IllegalArgumentException e) {
			log.error("Error saving: " + e.getMessage());
		}
		
		model.addAttribute("nights", nights);
    	
		return "redirect:nights";
	}
}
