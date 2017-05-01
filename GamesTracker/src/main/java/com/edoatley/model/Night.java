package com.edoatley.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Night {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "NIGHT_ID")
	private int id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;

	private String description;
	private boolean finished;
		
	@OneToMany(cascade=CascadeType.ALL)
	private List<GamePlay> gamesPlayed;
	
	public Night() {
		gamesPlayed = new ArrayList<GamePlay>();
	}

	public Night(String description, LocalDate date, boolean finished, List<GamePlay> gamesPlayed) {
		super();
		this.description = description;
		this.date = date;
		this.finished = finished;
		this.gamesPlayed = gamesPlayed;
	}
	
	public Night(String description, LocalDate date) {
		super();
		this.description = description;
		this.date = date;
		this.finished = false;
		this.gamesPlayed = new ArrayList<GamePlay>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public List<GamePlay> getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(List<GamePlay> gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	public String getIsFinished() {
		return finished ? "Yes" : "No"; 
	}
	public void setIsFinished(String isFinished) {
		finished = "Yes".equals(isFinished); 
	}
	
	public int getNumberOfGamesPlayed() {
		return gamesPlayed.size();
	}

	@Override
	public String toString() {
		return "Night [id=" + id + ", date=" + date + ", description=" + description + ", finished=" + finished
				+ ", gamesPlayed=" + gamesPlayed + "]";
	}
	
}
