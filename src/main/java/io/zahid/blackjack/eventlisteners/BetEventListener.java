package io.zahid.blackjack.eventlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import io.zahid.blackjack.Table;

public class BetEventListener implements ActionListener {

	private Table table;
	private int userInput;

	public BetEventListener(Table table) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent actionEvent) {

		if (table.getAccess().isBetAccessible()) {

			try {
				userInput = Integer.parseInt(table.getBetTextField().getText());
			} catch (NumberFormatException e) {
				if (userInput == 0) {
					JOptionPane.showMessageDialog(null, "Please enter a valid bet!");
					return;
				}
			}

			if (userInput > 0 && userInput <= table.getPlayer().getWallet()) {
				table.getPlayer().setBet(userInput);
				table.getBetTextField().setEditable(false);
			} else {
				JOptionPane.showMessageDialog(null, "Bet value is insufficient!");
				return;
			}

			table.getAccess().betComplete();
		}
	}
}
