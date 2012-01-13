package com.game.model.tictactoe.model;

/**
 * Grid
 * 
 * @author dhelbert
 *
 */
public class Grid {

	private int x;
	
	private int y;
	
	private Player player;

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
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
