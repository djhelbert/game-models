package com.game.model.blackjack.model;

import com.game.model.common.Card;

/**
 * Player Action
 * 
 * @author Derek
 *
 */
public interface PlayerStrategy {

	/** Options */
	public enum OPTION { HIT, STAND, SPLIT, DOUBLE }
	
	/**
	 * Decide with Hand
	 * 
	 * @param hand
	 * @param dealerCard
	 * @param canSplit
	 * @param canDouble 
	 * 
	 * @return OPTION
	 */
	public OPTION decision(Hand hand, Card dealerCard, boolean canSplit, boolean canDouble);
	
}
