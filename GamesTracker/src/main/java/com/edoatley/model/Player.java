package com.edoatley.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.edoatley.util.CustomLocalDateSerializer;
import com.edoatley.util.JsonDateFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Player {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	private int currentScore;
	private int age;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonDateFormat("dd/MM/yyyy")
	@JsonSerialize(using=CustomLocalDateSerializer.class)
	private LocalDate dateOfBirth;
	
	public Player() {}
	
	public Player(String name, LocalDate dateOfBirth, int currentScore) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.age = (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now()); 
		this.currentScore = currentScore;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		this.age  = (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
	}
	public int getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	public int getAge() {
		return age;
	}
	// don't really want other classes to use this but keeping as protected for JPA
	protected void setAge(int age) { 
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", currentScore=" + currentScore + ", age=" + age
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
