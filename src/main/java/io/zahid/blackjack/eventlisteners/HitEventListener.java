package io.zahid.blackjack.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import io.zahid.blackjack.Dealer;
import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Player;
import io.zahid.blackjack.Table;

public class HitEventListener implements ActionListener {

	private Table table;
	private Deck deck;
	private Dealer dealer;
	private Player player;

	public HitEventListener(Table table, Deck deck) {
		this.table = table;
		this.deck = deck;
		dealer = table.getDealer();
		player = table.getPlayer();
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (table.getAccess().isHitAccessible()) {

			player.addCard(deck.getCard());

			table.updatePlayerScore();

			table.getPanel()
			.add(player.getHand().get(player.getHand().size() - 1).getPlayingCardLabel())
			.setBounds(table.getNextPlayerCardTablePositionX(), 195, deck.getCardWidth(), deck.getCardHeight());

			if (player.getScore() > 21) {

				dealer.getHand().get(0).getCoverCardLabel().setIcon(null);
				dealer.getHand().get(0).getCoverCardLabel().revalidate();

				table.getPanel()
				.add(dealer.getHand().get(0).getPlayingCardLabel())
				.setBounds(100, 10, deck.getCardWidth(), deck.getCardHeight());

				player.setWallet(player.getWallet() - player.getBet());

				table.updateBothDealerAndPlayerScores();
				JOptionPane.showMessageDialog(null, "Busted!");

				table.updateWallet();
				table.getAccess().hitComplete();
			}
		}
	}
}
