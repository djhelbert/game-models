package com.game.model.blackjack;

import com.game.model.blackjack.model.Table;
import com.game.model.common.Card.Type;

/**
 * Blackjack Application
 * 
 * @author Derek
 *
 */
public class BlackjackApp {

	private Table table = new Table();
	
	public BlackjackApp() {
		init();
	}
	
	private void init() {
		Type.ACE.setValue(1);
		Type.DEUCE.setValue(2);
		Type.THREE.setValue(3);
		Type.FOUR.setValue(4);
		Type.FIVE.setValue(5);
		Type.SIX.setValue(6);
		Type.SEVEN.setValue(7);
		Type.EIGHT.setValue(8);
		Type.NINE.setValue(9);
		Type.TEN.setValue(10);
		Type.JACK.setValue(10);
		Type.QUEEN.setValue(10);
		Type.KING.setValue(10);
	}
	
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
	}
}
