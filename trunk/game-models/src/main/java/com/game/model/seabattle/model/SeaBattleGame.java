package com.game.model.seabattle.model;

/**
 * Game
 * 
 * @author dhelbert
 *
 */
public class SeaBattleGame {

	private Player player1;
	
	private Player player2;
	
	private boolean turn = true;
	
	/**
	 * Constructor
	 */
	public SeaBattleGame(int players) {
		if(players == 0) {
			player1 = new Player(1,false);
			player2 = new Player(2,false);
		}
		else if(players == 1) {
			player1 = new Player(1,true);
			player2 = new Player(2,false);
		}
		else if(players == 2)  {
			player1 = new Player(1,true);
			player2 = new Player(2,true);
		}
	}
	
	/**
	 * Toggle Current Player
	 */
	public void toggleCurrentPlayer() {
		if( turn ) {
			turn = false;
		}
		else {
			turn = true;
		}
	}
	
	/**
	 * Get Player 1
	 * 
	 * @return
	 */
	public Player getPlayer1() {
		return player1;
	}

	/**
	 * Get Player 2
	 * 
	 * @return
	 */
	public Player getPlayer2() {
		return player2;
	}

	/**
	 * Get Current Player
	 * 
	 * @return
	 */
	public Player getCurrentPlayer() {
		return turn ? player1 : player2;
	}

	/**
	 * Get Other Player
	 * 
	 * @return
	 */
	public Player getOtherPlayer() {
		return turn ? player2 : player1;
	}
	
	/**
	 * Is Game Active
	 * 
	 * @return
	 */
	public boolean isActive() {
		return player1.isAlive() && player2.isAlive();
	}
	
}
