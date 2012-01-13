package com.game.model.tictactoe.model;

/**
 * Player
 * 
 * @author dhelbert
 *
 */
public class Player {

	private char symbol;

	/**
	 * Get Symbol
	 * 
	 * @return
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * Set Symbol
	 * 
	 * @param symbol
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Player) {
			if( ((Player)o).getSymbol() == symbol ) {
				return true;
			}
		}
		
		return false;
	}
}
