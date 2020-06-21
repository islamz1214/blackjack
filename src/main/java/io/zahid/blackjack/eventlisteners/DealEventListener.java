package io.zahid.blackjack.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.zahid.blackjack.Dealer;
import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Player;
import io.zahid.blackjack.Table;

public class DealEventListener implements ActionListener {

	private Table table;
	private Deck deck;
	private Dealer dealer;
	private Player player;

	public DealEventListener(Table table, Deck deck) {
		this.table = table;
		this.deck = deck;
		dealer = table.getDealer();
		player = table.getPlayer();
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (table.getAccess().isDealAccessible()) {

			dealer.addCard(deck.getCard());
			dealer.addCard(deck.getCard());

			player.addCard(deck.getCard());
			player.addCard(deck.getCard());

			table.updatePlayerScore();

			table.getPanel()
			.add(dealer.getHand().get(0).getCoverCardLabel())
			.setBounds(table.getNextDealerCardTablePositionX(), 10, deck.getCardWidth(), deck.getCardHeight());

			table.getPanel()
			.add(dealer.getHand().get(1).getPlayingCardLabel())
			.setBounds(table.getNextDealerCardTablePositionX(), 10, deck.getCardWidth(), deck.getCardHeight());

			table.getPanel()
			.add(player.getHand().get(0).getPlayingCardLabel())
			.setBounds(table.getNextPlayerCardTablePositionX(), 195, deck.getCardWidth(), deck.getCardHeight());

			table.getPanel()
			.add(player.getHand().get(1).getPlayingCardLabel())
			.setBounds(table.getNextPlayerCardTablePositionX(), 195, deck.getCardWidth(), deck.getCardHeight());

			table.getAccess().dealComplete();
		}
	}
}
