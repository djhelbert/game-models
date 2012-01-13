package com.game.model.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.game.model.tictactoe.model.Game;
import com.game.model.tictactoe.model.Grid;

/**
 * @author dhelbert
 *
 */
public class MainApp {

	private static Game game;
	
	/**
	 * Constructor
	 * 
	 */
	public MainApp() {
	}
	
	/**
	 * Draw Board
	 */
	public static void draw() {
		Grid[][] grids = game.getBoard().getGrids();
		
		for(int y=0; y<3; y++) {
			for(int x=0; x<3; x++) {
				if( grids[x][y].getPlayer() != null ) {
					System.out.print(grids[x][y].getPlayer().getSymbol());
				}
				else {
					System.out.print(' ');
				}
				if( x < 2 && y < 3) {
					System.out.print('|');
				}
			}
			
			System.out.println();
		}
	}
	
	/**
	 * Get Player Input
	 */
	public static void getInput() {
		boolean valid = false;
		String  input = null;
		
		while( !valid ) {
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        System.out.println("Enter your x y selection:");
	        
	        try {
	            input = reader.readLine();
	            
		        if( input.length() == 3 ) {
		        	int x = Integer.parseInt(input.substring(0,1));
		        	int y = Integer.parseInt(input.substring(2,3));
				
		        	if(game.getBoard().isOpen(x, y)) {
		        		game.getBoard().select(x, y, game.getCurrentPlayer());
		        		valid = true;
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
		game = new Game();
		
		while( game.isActive() ) {
			draw();
			System.out.println("Player : " + game.getCurrentPlayer().getSymbol() );
			getInput();
		}
		
		draw();
		System.out.println("Game Over!" );
	}

}
