package com.edoatley.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.edoatley.util.CustomDifficultySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Game {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String name;
	private int minutesToPlay;
	private int timesPlayed;
	
	@JsonSerialize(using=CustomDifficultySerializer.class)
	private Difficulty difficulty;
	
	protected Game() {}
	
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
	
}
