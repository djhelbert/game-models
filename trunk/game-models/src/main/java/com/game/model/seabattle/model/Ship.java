package com.game.model.seabattle.model;

/**
 * Ship
 * 
 * @author Derek
 *
 */
public abstract class Ship {

	private boolean sunk = false;

	private int size;
	
	private SeaGrid[] grids;
	
	/**
	 * 
	 * @param size
	 */
	public Ship(int size) {
		this.size = size;
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * @return the sunk
	 */
	public boolean isSunk() {
		return sunk;
	}
	
	/**
	 * @return the grids
	 */
	public SeaGrid[] getGrids() {
		return grids;
	}

	/**
	 * @param grids the grids to set
	 */
	public void setGrids(SeaGrid[] grids) {
		this.grids = grids;
	}

	/**
	 * Is Overlap
	 * 
	 * @param tests
	 * 
	 * @return boolean
	 */
	public boolean isOverlap(SeaGrid[] tests) {
		if( grids == null) {
			return false;
		}
		
		for(SeaGrid temp : tests) {
			if( isOverlap(temp.getX(),temp.getY())) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Is Overlap
	 * 
	 * @param x
	 * @param y
	 * 
	 * @return boolean
	 */
	public boolean isOverlap(int x, int y) {
		if( grids == null) {
			return false;
		}
		
		for(SeaGrid temp : grids) {
			if( temp.getX() == x && temp.getY() == y) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Is Hit
	 * 
	 * @param x
	 * @param y
	 * 
	 * @return boolean
	 */
	public boolean isHit(int x, int y) {
		if( grids == null ){
			return false;
		}
		
		for(SeaGrid grid : grids) {
			if( grid.getX() == x && grid.getY() == y) {
				grid.setHit(true);
				
				int test = 0;
				
				for(SeaGrid temp : grids) {
					if(temp.isHit()) {
						test++;
					}
				}
				
				if( test >= size) {
					sunk = true;
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Ship{size:" + size + "}";
	}
}
