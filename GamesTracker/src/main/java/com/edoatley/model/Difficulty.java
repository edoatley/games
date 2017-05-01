package com.edoatley.model;

public enum Difficulty {
	HARD("Hard", 25),
	MEDIUM("Medium", 10),
	EASY("Easy", 5);
	
	private String description;
	private int scoreForAWin;
	
	
	Difficulty(String description, int scoreForAWin) {
		this.description = description;
		this.scoreForAWin = scoreForAWin;
	}
	
    public String getDescription() {
        return description;
    }
    
    public int getScoreForAWin() {
        return scoreForAWin;
    }
}

