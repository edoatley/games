package com.edoatley.model;

public enum Difficulty {
	HARD("Hard"),
	MEDIUM("Medium"),
	EASY("Easy");
	
	private String description;
	
	Difficulty(String description) {
		this.description = description;
	}
	
    public String getDescription() {
        return description;
    }
}

