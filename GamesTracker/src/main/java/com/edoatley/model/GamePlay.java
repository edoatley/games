package com.edoatley.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class GamePlay {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "GAMEPLAY_ID")
	private int id;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	@JoinColumn(name="GAME_ID")
	private Game game;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable
	(
	      name="GP_PLAY",
	      joinColumns=@JoinColumn(name="GAMEPLAY_ID", referencedColumnName="GAMEPLAY_ID"),
	      inverseJoinColumns=@JoinColumn(name="PLAYER_ID", referencedColumnName="ID")
	)
	private Set<Player> players;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="WIN_PLAY_ID")
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
