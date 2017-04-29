package com.edoatley.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.edoatley.model.Game;
import com.edoatley.repository.GamesRepository;

@Service
public class GamesService {

	@Autowired
	private GamesRepository repository;
	
	public List<Game> findAllGames() {
		Iterable<Game> allGames = repository.findAll();
		List<Game> games = new ArrayList<Game>();
		allGames.forEach(games::add);
		return games;
	}

	public void save(Game newGame) {
		if(isValidGame(newGame)) {
			repository.save(newGame);
		}
		else {
			throw new IllegalArgumentException("Game was not valid: " + newGame);
		}
	}

	private boolean isValidGame(Game newGame) {
		boolean isValidGame = true;
		
		if(newGame == null) {
			isValidGame = false;
		}
		else if(newGame.getMinutesToPlay() < 0) {			
			isValidGame = false;
		}
		else if(newGame.getTimesPlayed() < 0) {			
			isValidGame = false;
		}
		else if(StringUtils.isEmpty(newGame.getName())) {
			isValidGame = false;
		}
		else {
			Optional<Game> match = findAllGames().stream()
												.filter((game) -> game.getName().equalsIgnoreCase(newGame.getName())).findFirst();
			if(match.isPresent()) {
				isValidGame = false;
			}
		}
		
		return isValidGame;
	}
}
