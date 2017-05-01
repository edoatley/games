package com.edoatley;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edoatley.model.Difficulty;
import com.edoatley.model.Game;
import com.edoatley.model.Night;
import com.edoatley.model.Player;
import com.edoatley.service.GamesService;
import com.edoatley.service.NightsService;
import com.edoatley.service.PlayersService;

@SpringBootApplication
public class GamesTracker {
	
	private static final Logger log = LoggerFactory.getLogger(GamesTracker.class);
	
    public static void main(String args[]) {
        SpringApplication.run(GamesTracker.class, args);
    }
    
	@Bean
	public CommandLineRunner loadBasicData(GamesService games, PlayersService players, NightsService nights) {
		return (args) -> {
			
			log.info("Adding Games...");
			//games.save(new Game("Ticket to Ride", 25, Difficulty.EASY, 5));
			//games.save(new Game("My First Stone Age", 30, Difficulty.MEDIUM, 5));
			log.info("");

			log.info("Adding Players...");
			//players.save(new Player("Edd", LocalDate.of(1981, 1, 1), 888));
			//players.save(new Player("Hannah", LocalDate.of(1980, 1, 1), 888));
			log.info("");
			
			log.info("Adding Nights...");
			//nights.save(new Night("May Inaugural", LocalDate.of(2017, 5, 1)));
			log.info("");
			
		};
	}

}