package com.edoatley.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	private int minutesToPlay;
	private int timesPlayed;
	private Difficulty difficulty;
	
	public Game() {} // easier with thymeleaf
	
	public Game(String name, int minutesToPlay, Difficulty difficulty, int timesPlayed) {
		super();
		this.name = name;
		this.minutesToPlay = minutesToPlay;
		this.difficulty = difficulty;
		this.timesPlayed = timesPlayed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public int getTimesPlayed() {
		return timesPlayed;
	}

	public void setTimesPlayed(int timesPlayed) {
		this.timesPlayed = timesPlayed;
	}

	public int getMinutesToPlay() {
		return minutesToPlay;
	}

	public void setMinutesToPlay(int minutesToPlay) {
		this.minutesToPlay = minutesToPlay;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", minutesToPlay=" + minutesToPlay + ", timesPlayed=" + timesPlayed
				+ ", difficulty=" + difficulty + "]";
	}
	
	
	
}
