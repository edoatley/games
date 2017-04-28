package com.edoatley;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edoatley.model.Player;
import com.edoatley.repository.GameRepository;
import com.edoatley.repository.NightRepository;
import com.edoatley.repository.PlayerRepository;

@SpringBootApplication
public class GamesTracker {
	
	private static final Logger log = LoggerFactory.getLogger(GamesTracker.class);
	
    public static void main(String args[]) {
        SpringApplication.run(GamesTracker.class, args);
    }
    
	@Bean
	public CommandLineRunner demo(GameRepository gameRepo, PlayerRepository playerRepo, NightRepository nightRepo) {
		return (args) -> {
			
			log.info("Finding Players...");
			Iterable<Player> players = playerRepo.findAll();
			for (Player p : players) {
				log.info(p.toString());				
			}
			log.info("");
			
		};
	}

}