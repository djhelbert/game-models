package com.game.model.blackjack;

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
	 * Constructor
	 */
	public BlackjackApp() {
		init();
	}
	
	/**
	 * Get Table
	 * 
	 * @return Table
	 */
	public Table getTable() {
		return table;
	}
	
	/**
	 * Init
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
			System.out.print(name + "\t" + hand.getValue() + "\t");
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

		for(Player p : table.getPlayers() ) {
			System.out.print("Player" + p.getPosition() + " $" + p.getMoney() + " ");
		}
		
		System.out.println("\n");
		
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
	
	/**
	 * Dealer Play
	 */
	public void dealerPlay() {
		Hand hand = table.getDealer().getHand();
		
		if(hand.getMaximumValue() == 21) {
			hand.setBlackjack(true);
		}
		
		OPTION option = dealerStrategy.decision(hand);
		
		while(option != OPTION.STAND && hand.getSoftValue() <= 21) {
			Card c = table.getShoe().getCard();
			hand.addCard(c);
			System.out.println("Dealer " + c);
			option = dealerStrategy.decision(hand);
		}
		
		hand.setDone(true);
		
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
		Hand h = player.getActiveHand();
		
		while(h != null) {
			if(h.getMaximumValue() == 21) {
				h.setDone(true);
				h.setBlackjack(true);
				System.out.println("Player " +  player.getPosition() + " Blackjack!");
			}
			
			OPTION option = player.getPlayerStrategy().decision(h,dealerCard,true,true);
			
			if(option == OPTION.SPLIT) {
				player.splitHand(h,table.getShoe().getCard(),table.getShoe().getCard());
				System.out.println("Player " +  player.getPosition() + " splits!");
			}
			else if(option == OPTION.DOUBLE) {
				Card c = table.getShoe().getCard();
				h.addCard(c);
				h.setDone(true);
				h.setBet(h.getBet()*2);
				System.out.println("Player " + player.getPosition() + " " + c);
			}
			else {
				while(option != OPTION.STAND && h.getSoftValue() <= 21) {
					Card c = table.getShoe().getCard();
					h.addCard(c);
					System.out.println("Player " + player.getPosition() + " " + c);
					option = player.getPlayerStrategy().decision(h,dealerCard,false,false);
				}
			
				h.setDone(true);
			}
			
			if( h.getSoftValue() > 21 ) {
				System.out.println("Player " +  player.getPosition() + " Bust!");
			}
			
			h = player.getActiveHand();
		}
		
		System.out.println();
	}
	
	/**
	 * Play
	 */
	public void play() {
		getTable().clearHands();
		getTable().dealHand();
		
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
		
		for(Player p : table.getPlayers() ) {
			for(Hand h : p.getHands()) {
				if(h.getSoftValue() > 21) {
					p.setMoney(p.getMoney() - h.getBet());
				}
				else if(h.isBlackjack()) {
					p.setMoney(p.getMoney() + (int)(1.5*h.getBet()));
				}
				else if(h.getValue() <=21 && h.getValue() == table.getDealer().getHand().getValue()) {
					// Push
				}
				else if(h.getValue() <=21 && h.getValue() > table.getDealer().getHand().getValue()) {
					p.setMoney(p.getMoney() + h.getBet());
				}
				else if(h.getValue() <=21 && table.getDealer().getHand().getValue() > 21) {
					p.setMoney(p.getMoney() + h.getBet());
				}
				else {
					p.setMoney(p.getMoney() - h.getBet());
				}
			}
		}
		
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

		Player p3 = new Player(3,false,100);
		p3.setPlayerStrategy(new BasicPlayerStrategy());
		app.getTable().getPlayers().add(p3);
		
		app.play();
		
		if( args != null ) {
			if( args.length == 1) {
				int cnt = Integer.parseInt(args[0]);
				
				for(int i = 0; i < (cnt-1); i++ ) {
					app.play();
				}
			}
		}
	}
}
