package com.game.model.seabattle.model;

import java.util.ArrayList;
import java.util.List;

import com.game.model.seabattle.util.SeaBattleUtil;

/**
 * Player
 * 
 * @author dhelbert
 *
 */
public class Player {

	private int number;
	
	private boolean human;
	
	private List<SeaGrid> shots = new ArrayList<SeaGrid>();
	
	private List<Ship> ships = new ArrayList<Ship>();
	
	/**
	 * Constructor
	 * 
	 * @param number
	 */
	public Player(int number, boolean human) {
		this.number = number;
		this.human  = human;
		
		ships.add(new Carrier());
		ships.add(new Battleship());
		ships.add(new Submarine());
		ships.add(new Destroyer());
		ships.add(new PatrolBoat());
		
		initShips();
	}
	
	public void initShips() {
		for(Ship s : ships) {
			boolean valid = false;
			SeaGrid[]  loc   = null;
			
			while( !valid ) {
				loc   = SeaBattleUtil.getRandomLocation(s.getSize());
				valid = true;
				
				for(Ship temp : ships) {
					if(temp.isOverlap(loc)) {
						valid = false;
					}
				}
			}
			
			s.setGrids(loc);
		}
	}
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public SeaGrid getGrid(int x, int y) {
		for(SeaGrid t : shots) {
			if( t.getX() == x && t.getY() == y) {
				return t;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isOpen(int x, int y) {
		return getGrid(x,y) == null;
	}
	
	/**
	 * @return the shots
	 */
	public List<SeaGrid> getShots() {
		return shots;
	}

	/**
	 * Get Ships
	 * 
	 * @return the ships
	 */
	public List<Ship> getShips() {
		return ships;
	}

	/**
	 * Is Alive
	 * 
	 * @return boolean
	 */
	public boolean isAlive() {
		boolean temp = false;
		
		for(Ship s : ships) {
			if( !s.isSunk() ) {
				return true;
			}
		}
		
		return temp;
	}
	
	/**
	 * Is Human
	 * 
	 * @return boolean
	 */
	public boolean isHuman() {
		return human;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Player) {
			if( ((Player)o).getNumber() == number ) {
				return true;
			}
		}
		
		return false;
	}
}
