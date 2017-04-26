package com.edoatley.model;

import org.hibernate.validator.constraints.Range;

public class Game {

	@Range(min=1, max=120)
	private int minutes;

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
