package com.game.model.seabattle.util;

import com.game.model.common.CommonUtil;
import com.game.model.common.Grid;
import com.game.model.seabattle.model.SeaGrid;

/**
 * Utility Class
 * 
 * @author Derek
 *
 */
public class SeaBattleUtil {
	
	public static int RIGHT = 0;
	
	public static int DOWN = 1;
	
	/**
	 * Get Random Grid
	 * 
	 * @return Grid
	 */
	public static Grid getRandomGrid() {
		int x = CommonUtil.getRandomNumber(10);
		int y = CommonUtil.getRandomNumber(10);
		
		Grid temp = new Grid(x,y);
		
		return temp;
	}
	
	/**
	 * Get Random Location
	 * 
	 * @param size
	 * 
	 * @return SeaGrid[]
	 */
	public static SeaGrid[] getRandomLocation(int size) {
		SeaGrid[] temp = new SeaGrid[size];
		
		int x = CommonUtil.getRandomNumber(10-size);
		int y = CommonUtil.getRandomNumber(10-size);
		
		SeaGrid g = new SeaGrid(x,y,false);
		temp[0] = g;
		
		int direction = CommonUtil.getRandomNumber(2);
		
		if(direction == DOWN ) {
			for(int i=1; i<size; i++) {
				temp[i] = new SeaGrid(x,y+i,false);
			}
		}
		else if( direction == RIGHT) {
			for(int i=1; i<size; i++) {
				temp[i] = new SeaGrid(x+i,y,false);
			}
		}
		
		return temp;
	}
	
}
