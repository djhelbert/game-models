package com.game.model.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.game.model.common.Card;

/**
 * Hand
 * 
 * @author Derek
 *
 */
public class Hand {

	private List<Card> cards = new ArrayList<Card>();

	/**
	 * Get Cards
	 * 
	 * @return
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * Set Cards
	 * 
	 * @param cards
	 */
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
}
