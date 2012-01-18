package com.game.model.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Player
 * 
 * @author Derek
 *
 */
public class Player {

	private int position;
	
	private List<Hand> hands = new ArrayList<Hand>();

	/**
	 * Constructor
	 * 
	 * @param position
	 */
	public Player(int position) {
		this.position = position;
	}
	
	/**
	 * Get Position
	 * 
	 * @return int
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Clear
	 */
	public void clear() {
		hands.clear();
	}
	
	/**
	 * Get Hands
	 * 
	 * @return
	 */
	public List<Hand> getHands() {
		return hands;
	}

	/**
	 * Set Hands
	 * 
	 * @param hands
	 */
	public void setHands(List<Hand> hands) {
		this.hands = hands;
	}
	
}
