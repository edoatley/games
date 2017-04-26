package com.edoatley.model;

import java.time.LocalDate;
import java.util.List;

public class Night {
	private LocalDate date;
	private List<GamePlay> gamesPlayed;
	
	public Night(LocalDate date, List<GamePlay> gamesPlayed) {
		super();
		this.date = date;
		this.gamesPlayed = gamesPlayed;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<GamePlay> getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(List<GamePlay> gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
}
