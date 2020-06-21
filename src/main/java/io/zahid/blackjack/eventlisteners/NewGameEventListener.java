package io.zahid.blackjack.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Table;

public class NewGameEventListener implements ActionListener {

	private Table table;

	public NewGameEventListener(Table table, Deck deck) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (table.getAccess().isNewGameAccessible()) {
			table.reset();
			table.getBetTextField().setEditable(true);
			table.getAccess().newGameComplete();
		}
	}
}
