package com.game.model.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

	private int bet = 0;
	
	private UUID uuid = UUID.randomUUID();

	/**
	 * Constructor
	 * 
	 */
	public Hand() {
	}
	
	/**
	 * Constructor
	 * 
	 * @param id
	 */
	public Hand(int bet) {
		this.bet = bet;
	}
	
	/**
	 * Add Card
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		cards.add(card);
	}
	
	/**
	 * Clear
	 */
	public void clear() {
		cards.clear();
	}
	
	/**
	 * Get UUID
	 * 
	 * @return
	 */
	public UUID getUuid() {
		return uuid;
	}
	
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

	/**
	 * Get Maximum Value
	 * 
	 * @return
	 */
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
	
	/**
	 * Get Soft Value
	 * 
	 * @return
	 */
	public int getSoftValue() {
		int temp = 0;
		
		for(Card c : cards) {
			temp += c.getType().getValue();
		}
		
		return temp;
	}
	
	/**
	 * Get Number of Cards
	 * 
	 * @return int
	 */
	public int getNumberCards() {
		return cards.size();
	}
	
	public boolean isBusted() {
		return getSoftValue() > 21;
	}

	/**
	 * Get Bet
	 * 
	 * @return
	 */
	public int getBet() {
		return bet;
	}

	/**
	 * Set Bet
	 * 
	 * @param bet
	 */
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof Hand) {
			return uuid.equals(((Hand) object).getUuid());
		}
		
		return false;
	}
}