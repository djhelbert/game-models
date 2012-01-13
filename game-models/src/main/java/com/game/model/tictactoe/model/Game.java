package com.game.model.tictactoe.model;

/**
 * Game
 * 
 * @author dhelbert
 *
 */
public class Game {

	private Player player1 = new Player();
	
	private Player player2 = new Player();
	
	private Player currentPlayer;
	
	private Board board = new Board();
	
	/**
	 * Constructor
	 */
	public Game() {
		player1.setSymbol('X');
		player2.setSymbol('O');
		currentPlayer = player1;
	}
	
	/**
	 * Toggle Current Player
	 */
	public void toggleCurrentPlayer() {
		if( currentPlayer.equals(player1) ) {
			currentPlayer = player2;
		}
		else {
			currentPlayer = player1;
		}
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Is Game Active
	 * 
	 * @return
	 */
	public boolean isActive() {
		return !board.isWinner(player1) && !board.isWinner(player2) && board.isEmptyGrid();
	}
	
}
