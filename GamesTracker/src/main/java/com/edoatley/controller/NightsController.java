package com.edoatley.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edoatley.model.GamePlay;
import com.edoatley.model.Night;
import com.edoatley.service.GamesService;
import com.edoatley.service.NightsService;
import com.edoatley.service.PlayersService;

@Controller
public class NightsController {
	private static final Logger log = LoggerFactory.getLogger(NightsController.class);
	
	@Autowired
	private NightsService nightsService;
	@Autowired
	private GamesService gamesService;
	@Autowired
	private PlayersService playersService;
	
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
	
    @RequestMapping(value="/nights/details/{nightId}", method=RequestMethod.GET)
    public String nightDetails(Model model, @PathVariable(value="nightId") int nightId) {
    	log.info("Looking up Night " + nightId);
    	
    	Optional<Night> gamesnight = nightsService.getNight(nightId); 
    	
    	if(!gamesnight.isPresent()) {
    		log.error("Night with id " + nightId + " could not be found");
    		return "nights";
    	}
    	
    	log.error("Night with id " + nightId + " \n" + gamesnight.get());
    	
    	model.addAttribute("gamesnight", gamesnight.get());
    	model.addAttribute("gameslist", gamesService.findAllGames());
    	model.addAttribute("playerslist", playersService.findAllPlayers());
    	model.addAttribute("gameplay", new GamePlay());
    	
    	
    	return "nights-edit";
    }

    @RequestMapping(value="/nights/{nightId}/gameplay", method=RequestMethod.POST)
    public String addGamePlayToNight(@PathVariable("nightId") int nightId, @ModelAttribute("gameplay") GamePlay newGameplay, BindingResult result, Model model) {
    	
    	log.info("Adding Gameplay " + newGameplay);
		Night night = nightsService.getNight(nightId).get();
    	nightsService.addGamePlayToNight(night, newGameplay);
    	playersService.updateScore(newGameplay.getWinner().getId()
    							 , newGameplay.getGame().getDifficulty().getScoreForAWin());
    	gamesService.increaseTimesPlayed(newGameplay.getGame().getId(), 1);
    	
    	return fetchNights(model);
    }
}
