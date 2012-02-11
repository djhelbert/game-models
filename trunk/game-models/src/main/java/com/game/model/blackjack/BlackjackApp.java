package com.game.model.blackjack;

import java.util.List;

import com.game.model.blackjack.model.BasicPlayerStrategy;
import com.game.model.blackjack.model.Dealer;
import com.game.model.blackjack.model.DealerStrategy;
import com.game.model.blackjack.model.Hand;
import com.game.model.blackjack.model.Player;
import com.game.model.blackjack.model.PlayerStrategy.OPTION;
import com.game.model.blackjack.model.Table;
import com.game.model.common.Card;
import com.game.model.common.Card.Type;

/**
 * Blackjack Application
 * 
 * @author Derek
 *
 */
public class BlackjackApp {

	private Table table = new Table(10);
	
	private DealerStrategy dealerStrategy = new DealerStrategy();
	
	/**
	 * 
	 */
	public BlackjackApp() {
		init();
	}
	
	/**
	 * 
	 * @return
	 */
	public Table getTable() {
		return table;
	}
	
	/**
	 * 
	 */
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
	
	/**
	 * Draw Hand
	 * 
	 * @param name
	 * @param hand
	 * @param hide
	 */
	public void drawHand(String name, Hand hand, boolean hide) {
		int i = 0;
		
		if( hide ) {
			System.out.print(name + "\t**\t");
		}
		else {
			System.out.print(name + "\t" + (hand.getMaximumValue() <=21 ? hand.getMaximumValue() : hand.getSoftValue()) + "\t");
		}
		
		for(Card c : hand.getCards() ) {
			if( !hide || (i > 0) ) {
				System.out.print(c);
			}
			else {
				System.out.print("* *");
			}
			
			System.out.print(" ");
			
			i++;
		}
		
		System.out.println();
	}
	
	/**
	 * Draw Table
	 * 
	 * @param hide
	 */
	public void drawTable(boolean hide) {
		Dealer dealer = table.getDealer();
		
		drawHand("Dealer",dealer.getHand(),hide);
		
		for(Player p : table.getPlayers() ) {
			for(Hand h : p.getHands()) {
				drawHand("Player" + p.getPosition(),h,false);
			}
		}
		
		System.out.println();
	}
	
	/**
	 * Dealer Black jack Check
	 * 
	 * @return
	 */
	public boolean dealerBlackJack() {
		if( table.getDealer().getHand().isBlackjack() ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void dealerPlay() {
		Hand hand = table.getDealer().getHand();
		
		OPTION option = dealerStrategy.decision(hand);
		
		while(option != OPTION.STAND && hand.getSoftValue() <= 21) {
			Card c = table.getShoe().getCard();
			hand.addCard(c);
			System.out.println("Dealer " + c);
			option = dealerStrategy.decision(hand);
		}
		
		if( hand.getSoftValue() > 21 ) {
			System.out.println("Dealer Bust!");
		}
		
		System.out.println();
	}
	
	/**
	 * Player Play
	 * 
	 * @param player
	 * @param dealerCard
	 */
	public void playerPlay(Player player, Card dealerCard) {
		List<Hand> hands = player.getHands();
		
		for(Hand h : hands) {
			OPTION option = player.getPlayerStrategy().decision(h,dealerCard);
			
			while(option != OPTION.STAND && h.getSoftValue() <= 21) {
				Card c = table.getShoe().getCard();
				h.addCard(c);
				System.out.println("Player " + player.getPosition() + " " + c);
				option = player.getPlayerStrategy().decision(h,dealerCard);
			}
			
			if( h.getSoftValue() > 21 ) {
				System.out.println("Player Bust!");
			}			
		}
		
		System.out.println();
	}
	
	public void play() {
		drawTable(true);
		
		if(dealerBlackJack()) {
			drawTable(false);
			System.out.println("Dealer Black Jack!");
			return;
		}
		
		Card c = table.getDealer().getHand().getCards().get(1);
		
		for(Player p : table.getPlayers()) {
			playerPlay(p,c);
		}
		
		dealerPlay();
		
		drawTable(false);
	}
	
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		
		Player p1 = new Player(1,false,100);
		p1.setPlayerStrategy(new BasicPlayerStrategy());
		app.getTable().getPlayers().add(p1);
		
		Player p2 = new Player(2,false,100);
		p2.setPlayerStrategy(new BasicPlayerStrategy());
		app.getTable().getPlayers().add(p2);
		
		app.getTable().clearHands();
		app.getTable().dealHand();
		
		app.play();
	}
}
