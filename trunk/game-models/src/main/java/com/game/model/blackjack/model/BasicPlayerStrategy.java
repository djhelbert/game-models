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
	 * Decide with Hand
	 * 
	 * @param hand
	 * @param dealerCard
	 * @param canSplit
	 * @param canDouble 
	 * 
	 * @return OPTION
	 */
	public OPTION decision(Hand hand, Card dealerCard, boolean canSplit, boolean canDouble ) {
		if(canSplit && hand.getCards().get(0).getType().getValue() == 8 && hand.getCards().get(1).getType().getValue() == 8) {
			return OPTION.SPLIT;
		}

		if(canSplit && hand.getCards().get(0).getType().getValue() == 7 && hand.getCards().get(1).getType().getValue() == 7) {
			return OPTION.SPLIT;
		}
		
		if(canDouble && hand.getMaximumValue() == 10 && dealerCard.getType().getValue() == 6) {
			return OPTION.DOUBLE;
		}
		
		if(hand.getSoftValue() <= 10) {
			return OPTION.HIT;
		}
		
		if( dealerCard.getType().getValue() == 5 || dealerCard.getType().getValue() == 6) {
			return OPTION.STAND;
		}
		
		if( (hand.getMaximumValue() >= 17 && hand.getMaximumValue() <= 21) || hand.getSoftValue() >= 17) {
			return OPTION.STAND;
		}
		
		return OPTION.HIT;
	}
	
}
