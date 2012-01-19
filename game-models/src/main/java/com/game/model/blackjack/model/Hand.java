package com.game.model.blackjack.model;

import java.util.ArrayList;
import java.util.List;

import com.game.model.common.Card;
import com.game.model.common.Card.Type;

/**
 * Hand
 * 
 * @author dhelbert
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

	public int getMaximumValue() {
		int     temp = 0;
		boolean aces = false;
		
		for(Card c : cards) {
			temp += c.getType().getValue();
			
			if(c.getType() == Type.ACE) {
				aces = true;
			}
		}
		
		if(aces) {
			temp += 10;
		}
		
		return temp;
	}
	
	public int getTotalValue() {
		int temp = 0;
		
		for(Card c : cards) {
			temp += c.getType().getValue();
		}
		
		return temp;
	}
}
