package com.game.model.seabattle.model;

import com.game.model.common.Grid;

/**
 * Sea Grid
 * 
 * @author Derek
 *
 */
public class SeaGrid extends Grid {

	boolean hit = false;

	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 * @param hit
	 */
	public SeaGrid(int x, int y, boolean hit) {	
		super(x,y);
		
		this.hit = hit;
	}
	
	/**
	 * @return the hit
	 */
	public boolean isHit() {
		return hit;
	}

	/**
	 * @param hit the hit to set
	 */
	public void setHit(boolean hit) {
		this.hit = hit;
	}

}
