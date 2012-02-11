package com.game.model.blackjack.model;

import com.game.model.common.Card;

/**
 * Basic Player Strategy
 * 
 * @author Derek
 *
 */
public class BasicPlayerStrategy implements PlayerStrategy {

	/**
	 * Decision
	 * 
	 * @param hand
	 * @param delaerCard
	 * 
	 * @return OPTION
	 */
	public OPTION decision(Hand hand, Card dealerCard) {
		if( dealerCard.getType().getValue() == 5 || dealerCard.getType().getValue() == 6) {
			return OPTION.STAND;
		}
		
		if( hand.getMaximumValue() >= 17 || hand.getSoftValue() >= 17) {
			return OPTION.STAND;
		}
		
		return OPTION.HIT;
	}
	
}
