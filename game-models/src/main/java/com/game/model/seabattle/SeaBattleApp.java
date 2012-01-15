package com.game.model.seabattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.game.model.common.Grid;
import com.game.model.seabattle.model.Player;
import com.game.model.seabattle.model.SeaBattleGame;
import com.game.model.seabattle.model.SeaGrid;
import com.game.model.seabattle.model.Ship;
import com.game.model.seabattle.util.SeaBattleUtil;

/**
 * @author dhelbert
 *
 */
public class SeaBattleApp {

	private static SeaBattleGame game;
	
	/**
	 * Constructor
	 * 
	 */
	public SeaBattleApp() {
	}
	
	/**
	 * Draw Board
	 */
	public static void draw() {
		Player p = game.getCurrentPlayer();
		
		System.out.println(" 0123456789");
		
		for(int y = 0; y<10; y++) {
			System.out.print(y);
			
			for(int x = 0; x<10; x++) {
				SeaGrid t = p.getGrid(x, y);
				
				if( t == null ) {
					System.out.print('-');
				}
				else {
					if( t.isHit() ) {
						System.out.print('X');
					}
					else {
						System.out.print('O');
					}
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * Get Human Player Input
	 */
	public static void getInput() {
		boolean valid = false;
		String  input = null;
		
		while( !valid ) {
	        System.out.println("Enter your x y selection:");
	        
	        try {
	        	if( game.getCurrentPlayer().isHuman() ) {
	        		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        		input = reader.readLine();
	        	}
	        	else {
	        		Grid rand = SeaBattleUtil.getRandomGrid();
	        		input = rand.getX() + " " + rand.getY();
	        	}
	        	
		        if( input.length() == 3 ) {
		        	int x = Integer.parseInt(input.substring(0,1));
		        	int y = Integer.parseInt(input.substring(2,3));
				
		        	if(x>=0 && x<10 && y>= 0 && y < 10 && game.getCurrentPlayer().isOpen(x, y)) {
		        		Player other = game.getOtherPlayer();
		        		
		        		boolean hit = false;
		        		
		        		for(Ship s : other.getShips()) {
		        			if( s.isHit(x, y) ) {
		        				hit = true;
		        			}
		        		}
		        		
		        		if(hit) {
		        			System.out.println("Hit!");
		        		}
		        		else {
		        			System.out.println("Missed!");
		        		}
		        		
		        		System.out.print("Sunk:");
		        		for(Ship s : other.getShips()) {
		        			if( s.isSunk() ) {
		        				System.out.print(s.getClass().getSimpleName() + " ");
		        			}
		        		}
		        		System.out.println();
		        		
		        		game.getCurrentPlayer().getShots().add(new SeaGrid(x,y,hit));
		        		
		        		if(game.getCurrentPlayer().getShots().size() >= 100 ) {
		        			System.exit(1);
		        		}
		        		
		        		valid = true;
		        	}
		        	else {
		        		System.out.println("Try again!");
		        	}
		        }
	        } 
	        catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
		game.toggleCurrentPlayer();
	}
	
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if(args != null && args.length != 1){
			System.out.println("Number of players required!" );
			System.exit(1);
		}
		
		int players = Integer.parseInt(args[0]);
		
		if(players <0 || players > 2){
			System.out.println("0, 1, or 2 number of players required!" );
			System.exit(1);
		}
		
		game = new SeaBattleGame(players);
		
		while( game.isActive() ) {
			draw();
			System.out.println("Player : " + game.getCurrentPlayer().getNumber() );
			getInput();
		}

		System.out.println("Game Over!" );
	}

}
