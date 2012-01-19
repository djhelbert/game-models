package com.game.model.blackjack.model;

/**
 * Player Action
 * 
 * @author Derek
 *
 */
public interface PlayerStrategy {

	public enum OPTION { HIT, STAND, SPLIT, DOUBLE }
	
	/**
	 * Decide with Hand
	 * 
	 * @param hand
	 * @return
	 */
	public OPTION decision(Hand hand);
	
}
