package com.edoatley.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GamePlay {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Game game;
	private List<Player> players;
	private Player winner;
	
	public GamePlay(Game game, List<Player> players, Player winner) {
		super();
		this.game = game;
		this.players = players;
		this.winner = winner;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
}
