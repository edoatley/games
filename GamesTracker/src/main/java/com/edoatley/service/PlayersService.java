package com.edoatley.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.edoatley.controller.PlayersController;
import com.edoatley.model.Player;
import com.edoatley.repository.PlayersRepository;

@Service
public class PlayersService {

	private static final Logger log = LoggerFactory.getLogger(PlayersService.class);
	
	@Autowired
	private PlayersRepository repository;
	
	public List<Player> findAllPlayers() {
		Iterable<Player> allPlayers = repository.findAll();
		List<Player> players = new ArrayList<Player>();
		allPlayers.forEach(players::add);
		return players;
	}
	
	public void save(Player newPlayer) {
		log.info("save() -> " + newPlayer);
		
		if(isValidPlayer(newPlayer)) {
			repository.save(newPlayer);
		}
		else {
			throw new IllegalArgumentException("Player was not valid: " + newPlayer);
		}
	}
	
	
	private boolean isValidPlayer(Player newPlayer) {
		log.info("isValidPlayer() -> " + newPlayer);
		
		boolean isValidPlayer = true;
		
		if(newPlayer == null) {
			isValidPlayer = false;
		}
		else if(!newPlayer.getDateOfBirth().isBefore(LocalDate.now().minusYears(2))){
			isValidPlayer = false;
		}
		else if(newPlayer.getCurrentScore() < 0) {			
			isValidPlayer = false;
		}
		else if(StringUtils.isEmpty(newPlayer.getName())) {
			isValidPlayer = false;
		}
		else {
			Optional<Player> match = findAllPlayers()
												.stream()
												.filter((player) -> player.getName().equalsIgnoreCase(newPlayer.getName())).findFirst();
			if(match.isPresent()) {
				isValidPlayer = false;
			}
		}
		
		return isValidPlayer;
	}



	
}
