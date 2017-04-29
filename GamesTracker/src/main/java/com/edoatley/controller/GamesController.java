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

import com.edoatley.model.Game;
import com.edoatley.service.GamesService;

@Controller
public class GamesController {
	private static final Logger log = LoggerFactory.getLogger(GamesController.class);

	@Autowired
	private GamesService gamesService;
	
    @RequestMapping(value="/games", method=RequestMethod.GET)
    public String fetchGames(Model model) {
    	
    	List<Game> games = gamesService.findAllGames(); 
    	
    	model.addAttribute("games", games);
    	model.addAttribute("game", new Game());
    	
        return "games";
    }

	@RequestMapping(value="/games", method=RequestMethod.POST)
	public String addGame(@ModelAttribute("game") Game newGame, BindingResult result, Model model) {

		log.info("Adding Game " + newGame.getName());
		log.info("Adding Game (full details) " + newGame.toString());
		
		List<Game> games = gamesService.findAllGames(); 
		
		try {			
			gamesService.save(newGame);
			games = gamesService.findAllGames();
		}
		catch(IllegalArgumentException e) {
			log.error("Error saving: " + e.getMessage());
		}
		
		model.addAttribute("games", games);
    	
		return "redirect:games";
	}

	
}
