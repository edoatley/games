package com.edoatley.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.edoatley.util.CustomBooleanSerializer;
import com.edoatley.util.CustomLocalDateSerializer;
import com.edoatley.util.JsonDateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Night {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "NIGHT_ID")
	private int id;
	
	private String description;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonDateFormat("dd/MM/yyyy")
	@JsonSerialize(using=CustomLocalDateSerializer.class)
	private LocalDate date;
	
	@JsonSerialize(using=CustomBooleanSerializer.class)
	private Boolean finished;
		
	@OneToMany
	@JoinColumn(name="GAMEPLAY_ID")
	private List<GamePlay> gamesPlayed;
	
	protected Night() {}

	public Night(int id, String description, LocalDate date, boolean finished, List<GamePlay> gamesPlayed) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.finished = finished;
		this.gamesPlayed = gamesPlayed;
	}
	
	public Night(int id, String description, LocalDate date) {
		super();
		this.id = id;
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
	
	
}
