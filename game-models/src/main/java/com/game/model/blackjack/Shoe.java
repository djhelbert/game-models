package com.game.model.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.game.model.common.Card;
import com.game.model.common.Card.Suit;
import com.game.model.common.Card.Type;

/**
 * Card Shoe
 * 
 * @author Derek
 *
 */
public class Shoe {

	private int decks = 6;
	
	private List<Card> cards = new ArrayList<Card>();

	/**
	 * Constructor
	 */
	public Shoe() {
		init();
		shuffle();
	}
	
	/**
	 * Constructor
	 * 
	 * @param decks
	 */
	public Shoe(int decks) {
		this.decks = decks;
		init();
		shuffle();
	}
	
	/**
	 * Init
	 */
	public void init() {
		for(int i=0; i<decks; i++) {
			for(Suit s : Suit.values()) {
				for(Type t : Type.values()) {
					cards.add(new Card(t,s));
				}
			}
		}
	}
	
	/**
	 * Get Card
	 * 
	 * @return
	 */
	public Card getCard() {
		if(cards.size() <= 0) {
			init();
			shuffle();
		}
		
		return cards.remove(0);
	}
	
	/**
	 * Shuffle Cards
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

}
