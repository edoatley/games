package com.edoatley.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class GamePlay {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(optional=false)
	private Game game;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Player> players;
	
	@OneToOne
	private Player winner;
	
	public GamePlay() {}
	
	public GamePlay(Game game, Set<Player> players, Player winner) {
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

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "GamePlay [id=" + id + ", game=" + game + ", players=" + players + ", winner=" + winner + "]";
	}
	
	
	
}
