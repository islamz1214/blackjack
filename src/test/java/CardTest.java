import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.junit.Assert;
import org.junit.Test;

import io.zahid.blackjack.Card;
import io.zahid.blackjack.Rank;
import io.zahid.blackjack.Suit;

public class CardTest {

	Card card = new Card();
	JLabel coverCardLabel;
	ImageIcon coverCardImage;

	Suit suit = Suit.HEARTS;
	Rank rank = Rank.EIGHT;

	@Test
	public void get_cardProperties() {
		card.setSuit(suit);
		card.setRank(rank);
		Assert.assertEquals(card.getSuit().toString(), "HEARTS");
		Assert.assertEquals(card.getRank().toString(), "EIGHT");
		Assert.assertEquals(card.getValue(), 8);
		Assert.assertEquals(card.getCardWidth(), 72);
		Assert.assertEquals(card.getCardHeight(), 96);
		Assert.assertEquals(card.getSuitFirstCharacterLowercase(), 'h');
		Assert.assertEquals(card.getCoverCardImage().getDescription(), "Blue cover card image");
		Assert.assertEquals(card.getCoverCardLabel().getIcon().toString(), "Blue cover card image");
		Assert.assertEquals(card.getPlayingCardImage().getDescription(), "Playing card image");
		Assert.assertEquals(card.getPlayingCardLabel().getIcon().toString(), "Playing card image");
	}
}
