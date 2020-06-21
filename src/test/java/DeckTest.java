import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.zahid.blackjack.Card;
import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Rank;
import io.zahid.blackjack.Suit;

public class DeckTest {

	Deck deck = new Deck();

	@Before
	public void setUp() {
		deck.createDeck();
	}

	@Test
	public void createDeck_firstThreeCards() {
		Assert.assertEquals(deck.getCard().getSuit(), Suit.CLUBS);
		Assert.assertEquals(deck.getCard().getRank(), Rank.DEUCE);
		Assert.assertEquals(deck.getCard().getValue(), 3);
	}

	@Test
	public void shuffle_randomOrderCards() {
		deck.shuffle();

		Card cardOne = deck.getCard();
		Card cardTwo = deck.getCard();

		String cardOneData = cardOne.getSuit().toString() + cardOne.getRank().toString()
				+ Integer.toString(cardOne.getValue());

		String cardTwoData = cardTwo.getSuit().toString() + cardTwo.getRank().toString()
				+ Integer.toString(cardTwo.getValue());

		Assert.assertNotEquals(cardOneData, cardTwoData);
	}

	@Test
	public void getDeck_firstCard() {
		Card firstCard = deck.getDeck()[0];
		Assert.assertEquals(firstCard.getSuit(), Suit.CLUBS);
		Assert.assertEquals(firstCard.getRank(), Rank.ACE);
		Assert.assertEquals(firstCard.getValue(), 1);
	}

	@Test
	public void getCard_LastCard() {
		Card lastCard;

		for (int i = 0; i < 51; i++) {
			deck.getCard();
		}

		lastCard = deck.getCard();

		Assert.assertEquals(lastCard.getSuit(), Suit.SPADES);
		Assert.assertEquals(lastCard.getRank(), Rank.KING);
		Assert.assertEquals(lastCard.getValue(), 10);
	}
}
