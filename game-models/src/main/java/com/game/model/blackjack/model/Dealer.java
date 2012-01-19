package com.game.model.blackjack.model;

/**
 * Dealer
 * 
 * @author Derek
 *
 */
public class Dealer {

	private Hand hand = new Hand();

	/**
	 * Constructor
	 */
	public Dealer() {	
	}
	
	/**
	 * Clear
	 */
	public void clear() {
		hand = new Hand();
	}
	
	/**
	 * Get Hand
	 * 
	 * @return
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * Set Hand
	 * 
	 * @param hand
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
}
