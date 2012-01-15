package com.game.model.common;

/**
 * Grid
 * 
 * @author dhelbert
 *
 */
public class Grid {

	private int x;
	
	private int y;

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
