package com.game.model.tictactoe.model;

/**
 * Board
 * 
 * @author dhelbert
 *
 */
public class Board {

	private Grid[][] grids = new Grid[3][3];
	
	/**
	 * Constructor
	 */
	public Board() {
		for(int x=0; x<3; x++) {
			for(int y=0; y<3; y++) {
				grids[x][y] = new Grid(x,y);
			}
		}
	}
	
	/**
	 * Get Grids
	 * 
	 * @return
	 */
	public Grid[][] getGrids() {
		return grids;
	}
	
	/**
	 * Is Player a Winner
	 * 
	 * @param p
	 * @return
	 */
	public boolean isWinner(Player p) { 
		// Check vertical
		for(int x=0; x<3; x++) {
			if( check(grids[x][0].getPlayer(),p) && check(grids[x][1].getPlayer(),p) && check(grids[x][2].getPlayer(),p) ) {
				return true;
			}
		}

		// Check horizontal
		for(int y=0; y<3; y++) {
			if( check(grids[0][y].getPlayer(),p) && check(grids[1][y].getPlayer(),p) && check(grids[2][y].getPlayer(),p) ) {
				return true;
			}
		}
		
		if(check(grids[0][0].getPlayer(),p) && check(grids[1][1].getPlayer(),p) && check(grids[2][2].getPlayer(),p)) {
			return true;
		}

		if(check(grids[2][0].getPlayer(),p) && check(grids[1][1].getPlayer(),p) && check(grids[0][2].getPlayer(),p)) {
			return true;
		}
		
		return false;
	}

	/**
	 * Check Equals
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private boolean check(Player a, Player b) {
		if(a != null) {
			return a.equals(b);
		}
		
		return false;
	}
	
	/**
	 * Select Grid
	 * 
	 * @param x
	 * @param y
	 * @param p
	 * @return
	 */
	public boolean select(int x, int y, Player p) {
		if(isOpen(x,y)) {
			grids[x][y].setPlayer(p);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Is Grid Open
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isOpen(int x, int y) {
		if(grids[x][y].getPlayer() == null) {
			return true;
		}
		
		return false;
	}

	/**
	 * Is Anything Empty
	 * 
	 * @return
	 */
	public boolean isEmptyGrid() {
		for(int x=0; x<3; x++) {
			for(int y=0; y<3; y++) {
				if( grids[x][y].getPlayer() == null )
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Reset
	 */
	public void reset() {
		for(int x=0; x<3; x++) {
			for(int y=0; y<3; y++) {
				grids[x][y].setPlayer(null);
			}
		}
	}
	
}
