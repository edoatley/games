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

import com.edoatley.model.Player;
import com.edoatley.service.PlayersService;

@Controller
public class PlayersController {
	
	private static final Logger log = LoggerFactory.getLogger(PlayersController.class);
	
	@Autowired
	private PlayersService playersService;
	
    @RequestMapping(value="/players", method=RequestMethod.GET)
    public String fetchPlayers(Model model) {
    	log.error("PlayerRepository " + playersService);
    	
    	List<Player> players = playersService.findAllPlayers(); 
    	
    	model.addAttribute("players", players);
    	model.addAttribute("player", new Player());
    	
        return "players";
    }

	@RequestMapping(value="/players", method=RequestMethod.POST)
	public String addPlayer(@ModelAttribute("player") Player newPlayer, BindingResult result, Model model) {

		System.out.println("Player " + newPlayer.getName());
		List<Player> players = playersService.findAllPlayers(); 
		
		try {			
			playersService.save(newPlayer);
			players = playersService.findAllPlayers();
		}
		catch(IllegalArgumentException e) {
			log.error("Error saving: " + e.getMessage());
		}
		
		model.addAttribute("players", players);
    	
		return "redirect:players";
	}

}
