package com.game.model.common;

/**
 * Card
 * 
 * @author dhelbert
 *
 */
public class Card implements Comparable<Card> {
	
    /**
     * Suit
     * 
     * @author dhelbert
     *
     */
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    
	/**
	 * Type
	 * 
	 * @author dhelbert
	 *
	 */
    public enum Type { DEUCE(0), THREE(1), FOUR(2), FIVE(3), SIX(4), SEVEN(5), EIGHT(6), NINE(7), TEN(8), JACK(9), QUEEN(10), KING(11), ACE(12);
    	
    	private final int order;
    
    	private int value;
    	
    	Type(int order) {
    		this.order = order;
    	}
    	
    	/**
    	 * Get Order
    	 * @return
    	 */
    	public int getOrder() {
    		return order;
    	}
    	
    	/**
    	 * Get Value
    	 * 
    	 * @return
    	 */
    	public int getValue() {
    		return value;
    	}
    	
    	/**
    	 * Set Value
    	 * 
    	 * @param value
    	 */
    	public void setValue(int value) {
    		this.value = value;
    	}
    }

    /** Type */
    private final Type type;
    
    /** Suit */
    private final Suit suit;
    
    /**
     * Constructor
     * 
     * @param rank
     * @param suit
     */
    private Card(Type type, Suit suit) {
        this.type = type;
        this.suit = suit;
    }

    /**
     * Get Type
     * 
     * @return
     */
    public Type getType() { 
    	return type; 
    }
    
    /**
     * Get Suit
     * 
     * @return
     */
    public Suit getSuit() { 
    	return suit; 
    }
    
    @Override
    public String toString() { 
    	return "{type:" + type + " suit: " + suit + "}"; 
    }

    /**
     * Compare To
     * 
     * @param o
     */
	public int compareTo(Card o) {
		if( o.getType().getOrder() < getType().getOrder() ) {
			return 1;
		}
		if( o.getType().getOrder() > getType().getOrder() ) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
