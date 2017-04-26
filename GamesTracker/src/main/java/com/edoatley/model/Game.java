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
	private int minutes;
	private int pointsForWin;
	
	public Game(String name, int minutes, int pointsForWin) {
		super();
		this.name = name;
		this.minutes = minutes;
		this.pointsForWin = pointsForWin;
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

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public int getPointsForWin() {
		return pointsForWin;
	}
	
	public void setPointsForWin(int pointsForWin) {
		this.pointsForWin = pointsForWin;
	}
}
