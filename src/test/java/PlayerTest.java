import org.junit.Assert;
import org.junit.Test;

import io.zahid.blackjack.Card;
import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Player;

public class PlayerTest {

	Player player = new Player();
	Card card = new Card();

	@Test
	public void setWallet_getWallet_playerTotalMoney() {
		player.setWallet(200);
		Assert.assertEquals(player.getWallet(), 200);
	}
/*
	@Test
	public void getScore_playerCardScore() {
		int playerScore = 0;
		Deck deck = new Deck();
		Card cardOne = deck.getCard();
		Card cardTwo = deck.getCard();

		player.addCard(cardOne);
		player.addCard(cardTwo);

		for (int i = 0; i < player.getHand().size(); i++) {
			playerScore += player.getHand().get(i).getValue();
		}
		Assert.assertEquals(player.getScore(), playerScore);
	}
*/
	@Test
	public void setBet_getBet_playerWager() {
		player.setBet(10);
		Assert.assertEquals(player.getBet(), 10);
	}

	@Test
	public void addCard_getHand_playerCards() {
		Deck deck = new Deck();

		Card firstCard = deck.getCard();
		player.addCard(firstCard);

		Assert.assertEquals(player.getHand().get(0), firstCard);

		Card secondCard = deck.getCard();
		player.addCard(secondCard);

		Assert.assertEquals(player.getHand().get(1), secondCard);
	}

	@Test
	public void addToWallet_getWallet() {
		player.setWallet(500);
		player.addToWallet(5);
		Assert.assertEquals(player.getWallet(), 505);
	}

	@Test
	public void minusFromWallet_getWallet() {
		player.setWallet(500);
		player.minusFromWallet(5);
		Assert.assertEquals(player.getWallet(), 495);
	}
}
