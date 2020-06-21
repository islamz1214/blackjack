package io.zahid.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	private List<Card> hand;

	public Dealer() {
		hand = new ArrayList<Card>();
	}

	public int getScore() {
		int score = 0;
		int aceCounter = 0;

		for (int i = 0; i < getHand().size(); i++) {
			if (getHand().get(i).getRank() == Rank.ACE) {
				aceCounter += 1;
			} else {
				score += getHand().get(i).getValue();
			}
		}

		for (int i = 0; i < aceCounter; i++) {
			if (score <= 10) {
				score += 11;
			} else {
				score += 1;
			}
		}
		return score;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void addCard(Card card) {
		hand.add(card);
	}
}
