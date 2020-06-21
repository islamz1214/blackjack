package io.zahid.blackjack.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import io.zahid.blackjack.Dealer;
import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Player;
import io.zahid.blackjack.Table;

public class StandEventListener implements ActionListener {

	private Table table;
	private Deck deck;
	private Dealer dealer;
	private Player player;
	private boolean dealerLimit = false;

	public StandEventListener(Table table, Deck deck) {
		this.table = table;
		this.deck = deck;
		dealer = table.getDealer();
		player = table.getPlayer();
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (table.getAccess().isStandAccessible()) {
			table.getAccess().hitComplete();

			dealer.getHand().get(0).getCoverCardLabel().setIcon(null);
			dealer.getHand().get(0).getCoverCardLabel().revalidate();

			table.getPanel()
			.add(dealer.getHand().get(0).getPlayingCardLabel())
			.setBounds(100, 10, deck.getCardWidth(),deck.getCardHeight());

			while (dealer.getScore() < 17 && dealerLimit == false) {

				dealer.addCard(deck.getCard());

				table.getPanel()
				.add(dealer.getHand().get(dealer.getHand().size() - 1).getPlayingCardLabel())
				.setBounds(table.getNextDealerCardTablePositionX(), 10, deck.getCardWidth(), deck.getCardHeight());

				if (dealer.getScore() >= 17) {
					dealerLimit = true;
				}
			}

			table.updateDealerScore();

			if (player.getScore() > dealer.getScore()) {
				JOptionPane.showMessageDialog(null, "You Win!");
				player.setWallet(player.getWallet() + player.getBet());

			} else if (dealer.getScore() > player.getScore()) {

				if (dealer.getScore() > 21) {
					JOptionPane.showMessageDialog(null, "You Win!");
					player.setWallet(player.getWallet() + player.getBet());

				} else {
					JOptionPane.showMessageDialog(null, "You Lose!");
					player.setWallet(player.getWallet() - player.getBet());
				}

			} else if (dealer.getScore() == player.getScore()) {
				JOptionPane.showMessageDialog(null, "Draw!");
			}

			if (player.getWallet() == 0) {
				JOptionPane.showMessageDialog(null, "GAME OVER!");
			}

			table.updateWallet();
			table.getAccess().standComplete();
		}
	}
}
