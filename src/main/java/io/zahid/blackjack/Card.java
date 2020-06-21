package io.zahid.blackjack;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Card {

	private Suit suit;
	private Rank rank;
	private int cardWidth = 72;
	private int cardHeight = 96;
	private ImageIcon coverCardImage;
	private ImageIcon playingCardImage;
	private JLabel playingCardLabel;
	private JLabel coverCardLabel;

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Rank getRank() {
		return rank;
	}

	public int getValue() {
		return rank.getValue();
	}

	public int getCardWidth() {
		return cardWidth;
	}

	public int getCardHeight() {
		return cardHeight;
	}

	public ImageIcon getCoverCardImage() {
		if (coverCardImage == null) {
			coverCardImage = new ImageIcon(getClass().getResource("/cards/blueCoverCard.png"), "Blue cover card image");
		}
		return coverCardImage;
	}

	public JLabel getCoverCardLabel() {
		if (coverCardLabel == null) {
			coverCardLabel = new JLabel(getCoverCardImage());
		}
		return coverCardLabel;
	}

	public ImageIcon getPlayingCardImage() {
		if (playingCardImage == null) {
			playingCardImage = new ImageIcon(getClass().getResource(
					"/cards/" + getRankFirstCharacterLowercaseOrDigit() + getSuitFirstCharacterLowercase() + ".png"),
					"Playing card image");

		}
		return playingCardImage;
	}

	public JLabel getPlayingCardLabel() {
		if (playingCardLabel == null) {
			playingCardLabel = new JLabel(getPlayingCardImage());
		}
		return playingCardLabel;
	}

	public char getSuitFirstCharacterLowercase() {
		return suit.toString().toLowerCase().charAt(0);
	}

	public String getRankFirstCharacterLowercaseOrDigit() {
		switch (rank.toString()) {
		case "ACE":
			return "a";
		case "DEUCE":
			return "2";
		case "THREE":
			return "3";
		case "FOUR":
			return "4";
		case "FIVE":
			return "5";
		case "SIX":
			return "6";
		case "SEVEN":
			return "7";
		case "EIGHT":
			return "8";
		case "NINE":
			return "9";
		case "TEN":
			return "10";
		case "JACK":
			return "j";
		case "QUEEN":
			return "q";
		case "KING":
			return "k";
		}
		return "Invalid rank";
	}
}