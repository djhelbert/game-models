package com.game.model.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Table
 * 
 * @author Derek
 *
 */
public class Table {

	private Shoe shoe = new Shoe();
	
	private Dealer dealer = new Dealer();
	
	private List<Player> players = new ArrayList<Player>();

	/**
	 * Constructor
	 */
	public Table() {	
	}
	
	/**
	 * Get Shoe
	 * 
	 * @return
	 */
	public Shoe getShoe() {
		return shoe;
	}

	/**
	 * Get Dealer
	 * 
	 * @return
	 */
	public Dealer getDealer() {
		return dealer;
	}

	/**
	 * Get Player
	 * 
	 * @return
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * Set Players
	 * 
	 * @param players
	 */
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}
