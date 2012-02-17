package com.game.model.blackjack.model;

import com.game.model.blackjack.model.PlayerStrategy.OPTION;

/**
 * Dealer Strategy
 * 
 * @author Derek
 *
 */
public class DealerStrategy {

	/**
	 * Decide with Hand
	 * 
	 * @param hand
	 */
	public OPTION decision(Hand hand) {
		if( (hand.getMaximumValue() >= 17 && hand.getMaximumValue() <= 21) || (hand.getSoftValue() >= 17 && hand.getSoftValue() <= 21)) {
			return OPTION.STAND;
		}
		
		return OPTION.HIT;
	}

}
