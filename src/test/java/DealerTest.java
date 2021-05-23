import org.junit.Assert;
import org.junit.Test;

import io.zahid.blackjack.Card;
import io.zahid.blackjack.Dealer;
import io.zahid.blackjack.Deck;

public class DealerTest {

	Dealer dealer = new Dealer();
	Card card = new Card();
/*
	@Test
	public void getScore_playerCardScore() {
		int dealerScore = 0;
		Deck deck = new Deck();
		Card cardOne = deck.getCard();
		Card cardTwo = deck.getCard();

		dealer.addCard(cardOne);
		dealer.addCard(cardTwo);

		for (int i = 0; i < dealer.getHand().size(); i++) {
			dealerScore += dealer.getHand().get(i).getValue();
		}
		Assert.assertEquals(dealer.getScore(), dealerScore);
	}
*/
	@Test
	public void addCard_getHand_get_dealerCards() {
		Deck deck = new Deck();

		Card firstCard = deck.getCard();
		dealer.addCard(firstCard);

		Assert.assertEquals(dealer.getHand().get(0), firstCard);

		Card secondCard = deck.getCard();
		dealer.addCard(secondCard);

		Assert.assertEquals(dealer.getHand().get(1), secondCard);
	}
}
