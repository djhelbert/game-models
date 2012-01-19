package com.game.model.blackjack.model;

/**
 * Dealer Strategy
 * 
 * @author Derek
 *
 */
public class DealerStrategy implements PlayerStrategy {

	/**
	 * Decide with Hand
	 */
	public OPTION decision(Hand hand) {
		if( hand.getMaximumValue() >= 17) {
			return OPTION.STAND;
		}
		
		return OPTION.HIT;
	}

}
