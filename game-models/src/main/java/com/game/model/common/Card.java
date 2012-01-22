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
    public enum Suit { CLUBS('C'), DIAMONDS('D'), HEARTS('H'), SPADES('S'); 
    	
    	private final char label;
    	
    	Suit(char label) {
    		this.label = label;
    	}
    	
    	@Override
    	public String toString() {
    		return "" + label;
    	}
    }
    
	/**
	 * Type
	 * 
	 * @author dhelbert
	 *
	 */
    public enum Type { DEUCE(0,'2'), THREE(1,'3'), FOUR(2,'4'), FIVE(3,'5'), SIX(4,'6'), SEVEN(5,'7'), EIGHT(6,'8'), NINE(7,'9'), TEN(8,'T'), JACK(9,'J'), QUEEN(10,'Q'), KING(11,'K'), ACE(12,'A');
    	
    	private final int order;
    	
    	private final char label;
    	
    	private int value;
    	
    	Type(int order,char label) {
    		this.order = order;
    		this.label = label;
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
    	
    	@Override
    	public String toString() {
    		return "" + label;
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
    public Card(Type type, Suit suit) {
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
    	return type + " " + suit; 
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
		else if( o.getType().getOrder() > getType().getOrder() ) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
