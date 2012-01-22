package com.game.model.blackjack.model;

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

	private PlayerStrategy playerStrategy;
	
	private List<Hand> hands = new ArrayList<Hand>();

	private boolean human = false;

	private int money = 0;
	
	/**
	 * Constructor
	 * 
	 * @param position
	 */
	public Player(int position, boolean human, int money) {
		this.position = position;
		this.human    = human;
		this.money    = money;
	}
	
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
	public void clearHands() {
		hands.clear();
		hands.add(new Hand(10));
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

	/**
	 * Get Player Strategy
	 * 
	 * @return
	 */
	public PlayerStrategy getPlayerStrategy() {
		return playerStrategy;
	}

	/**
	 * Set Player Strategy
	 * 
	 * @param playerStrategy
	 */
	public void setPlayerStrategy(PlayerStrategy playerStrategy) {
		this.playerStrategy = playerStrategy;
	}

	/**
	 * Is Human
	 * 
	 * @return
	 */
	public boolean isHuman() {
		return human;
	}

	/**
	 * Set Human
	 * 
	 * @param human
	 */
	public void setHuman(boolean human) {
		this.human = human;
	}

	/**
	 * Get Money
	 * 
	 * @return
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * 
	 * @param money
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Split Hand
	 * 
	 * @param hand
	 */
	public void splitHand(Hand hand) {
		Hand h2 = new Hand();
		h2.addCard(hand.getCards().remove(0));
		hands.add(h2);
	}
}
