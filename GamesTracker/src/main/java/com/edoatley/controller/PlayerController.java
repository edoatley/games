package com.edoatley.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edoatley.model.Player;
import com.edoatley.repository.PlayerRepository;

@Controller
public class PlayerController {
	
	private static final Logger log = LoggerFactory.getLogger(PlayerController.class);
	
	@Autowired
	private PlayerRepository repository;
	
    @RequestMapping(value="/players", method=RequestMethod.GET)
    public String fetchPlayers(Model model) {
    	log.error("PlayerRepository " + repository);
    	
    	List<Player> players = iterableToList(repository.findAll()); 
    	
    	model.addAttribute("players", players);
    	model.addAttribute("newPlayer", new Player());
    	
        return "players";
    }
    
	private <T> List<T> iterableToList(Iterable<T> all) {
		List<T> output = new ArrayList<T>();
		for (T t : all) {
			output.add(t);
		}
		return output;
	}

	@RequestMapping(value="/players", method=RequestMethod.POST)
	public String addPlayer(@ModelAttribute("newPlayer") Player newPlayer, BindingResult result, Model model) {

		System.out.println("Player " + newPlayer.getName());
		List<Player> players = iterableToList(repository.findAll()); 
		
		if(isValidPlayer(newPlayer, players)) {
			repository.save(newPlayer);
			players = iterableToList(repository.findAll()); 
		}
		
		model.addAttribute("players", players);
    	
		return "players";
	}

	private boolean isValidPlayer(Player newPlayer, List<Player> players) {
		boolean isValidPlayer = true;
		
		if(!newPlayer.getDateOfBirth().isBefore(LocalDate.now().minusYears(2))){
			isValidPlayer = false;
		}
		else if(newPlayer.getCurrentScore() < 0) {			
			isValidPlayer = false;
		}
		else if(StringUtils.isEmpty(newPlayer.getName())) {
			isValidPlayer = false;
		}
		else {
			final String playerName = newPlayer.getName();
			Optional<Player> match = players.stream().filter((player) -> player.getName().equalsIgnoreCase(playerName)).findFirst();
			if(match.isPresent()) {
				isValidPlayer = false;
			}
		}
		
		return isValidPlayer;
	}

}
