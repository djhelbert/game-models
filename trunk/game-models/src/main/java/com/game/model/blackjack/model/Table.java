package com.game.model.blackjack.model;

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

	private int minimum = 0;
	
	/**
	 * Constructor
	 */
	public Table(int minimum) {
		this.minimum = minimum;
	}
	
	/**
	 * Clear Hands
	 */
	public void clearHands() {
		dealer.getHand().clear();
		
		for(Player p : players) {
			p.clearHands();
		}
	}
	
	/**
	 * Deal Hand
	 * 
	 */
	public void dealHand() {
		for(int i =0; i<2; i++) {
			for(Player p : players) {
				p.getHands().get(0).addCard(shoe.getCard());
			}
		}
		
		dealer.getHand().addCard(shoe.getCard());
		dealer.getHand().addCard(shoe.getCard());
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

	/**
	 * Get Minimum
	 * 
	 * @return
	 */
	public int getMinimum() {
		return minimum;
	}
	
}
