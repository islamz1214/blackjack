package io.zahid.blackjack;

import java.util.Arrays;
import java.util.Collections;

public class Deck extends Card {

	Rank rank[] = Rank.values();
	Suit suit[] = Suit.values();

	private Card[] deck;
	private int cardPosition;

	public Deck() {
		deck = new Card[52];
	}

	public void createDeck() {

		cardPosition = 0;

		for (int x = 0; x < deck.length; x++) {
			Rank rankTemp = rank[x % 13];
			Suit suitTemp = suit[x / 13];
			deck[x] = new Card();
			deck[x].setRank(rankTemp);
			deck[x].setSuit(suitTemp);
		}
	}

	public void shuffle() {
		Collections.shuffle(Arrays.asList(deck));
	}

	public Card[] getDeck() {
		return deck;
	}

	public Card getCard() {
		return deck[cardPosition++];
	}
}
