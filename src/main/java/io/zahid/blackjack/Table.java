package io.zahid.blackjack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.zahid.blackjack.eventlisteners.BetEventListener;
import io.zahid.blackjack.eventlisteners.DealEventListener;
import io.zahid.blackjack.eventlisteners.HitEventListener;
import io.zahid.blackjack.eventlisteners.NewGameEventListener;
import io.zahid.blackjack.eventlisteners.StandEventListener;

public class Table extends JFrame {

	private static final long serialVersionUID = -5200587904914844767L;

	private JPanel panel;
	private JLabel dealerLabel;
	private JLabel playerLabel;
	private JLabel dealerScoreLabel;
	private JLabel playerScoreLabel;
	private JLabel walletLabel;
	private JLabel statusLabel;
	private JButton standButton;
	private JButton newGameButton;
	private JButton dealButton;
	private JButton hitButton;
	private JButton betButton;
	private JTextField betTextField;

	private int playerCardTablePositionX;
	private int dealerCardTablePositionX;

	Deck deck = new Deck();
	Access access = new Access();
	Player player = new Player();
	Dealer dealer = new Dealer();

	public Table() {

		setTitle("BlackJack Game");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);

		dealerLabel = new JLabel("Dealer");
		dealerScoreLabel = new JLabel("Score: " + dealer.getScore());
		playerLabel = new JLabel("Player");
		playerScoreLabel = new JLabel("Score: " + player.getScore());
		walletLabel = new JLabel("Wallet: " + player.getWallet());
		hitButton = new JButton("Hit");
		standButton = new JButton("Stand");
		dealButton = new JButton("Deal");
		newGameButton = new JButton("New Game");
		betButton = new JButton("Bet");
		betTextField = new JTextField("");

		newGameButton.addActionListener(new NewGameEventListener(this, this.deck));
		betButton.addActionListener(new BetEventListener(this));
		dealButton.addActionListener(new DealEventListener(this, this.deck));
		hitButton.addActionListener(new HitEventListener(this, this.deck));
		standButton.addActionListener(new StandEventListener(this, this.deck));

		panel.add(dealerLabel);
		panel.add(dealerScoreLabel);
		panel.add(playerLabel);
		panel.add(playerScoreLabel);
		panel.add(walletLabel);
		panel.add(hitButton);
		panel.add(standButton);
		panel.add(dealButton);
		panel.add(newGameButton);
		panel.add(betButton);
		panel.add(betTextField);

		dealerScoreLabel.setBounds(20, 40, 75, dealerScoreLabel.getPreferredSize().height);
		newGameButton.setBounds(200, 500, newGameButton.getPreferredSize().width,
				newGameButton.getPreferredSize().height);
		dealerLabel.setBounds(25, 5, dealerLabel.getPreferredSize().width, dealerLabel.getPreferredSize().height);
		dealerScoreLabel.setBounds(20, 40, 75, dealerScoreLabel.getPreferredSize().height);
		playerLabel.setBounds(25, 200, playerLabel.getPreferredSize().width, playerLabel.getPreferredSize().height);
		playerScoreLabel.setBounds(20, 235, 75, playerScoreLabel.getPreferredSize().height);
		hitButton.setBounds(20, 400, hitButton.getPreferredSize().width, hitButton.getPreferredSize().height);
		standButton.setBounds(100, 400, standButton.getPreferredSize().width, standButton.getPreferredSize().height);
		dealButton.setBounds(60, 450, dealButton.getPreferredSize().width, dealButton.getPreferredSize().height);
		walletLabel.setBounds(385, 350, 200, walletLabel.getPreferredSize().height);
		betButton.setBounds(300, 400, betButton.getPreferredSize().width, betButton.getPreferredSize().height);
		betTextField.setBounds(380, 400, 100, betTextField.getPreferredSize().height);
	}

	public JPanel getPanel() {
		return panel;
	}

	public Access getAccess() {
		return access;
	}

	public JTextField getBetTextField() {
		return betTextField;
	}
	
	public JButton getBetButton() {
		return betButton;
	}

	public void updateWallet() {
		walletLabel.setText("Wallet: " + player.getWallet());
	}

	public Player getPlayer() {
		return player;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void updateDealerScore() {
		dealerScoreLabel.setText("Score: " + dealer.getScore());
	}

	public void updatePlayerScore() {
		playerScoreLabel.setText("Score: " + player.getScore());
	}

	public void updateBothDealerAndPlayerScores() {
		dealerScoreLabel.setText("Score: " + dealer.getScore());
		playerScoreLabel.setText("Score: " + player.getScore());
	}

	public int getNextDealerCardTablePositionX() {
		return dealerCardTablePositionX += 80;
	}

	public int getNextPlayerCardTablePositionX() {
		return playerCardTablePositionX += 80;
	}

	public JLabel getStatusLabel() {
		return statusLabel;
	}

	public void reset() {
		deck.createDeck();
		deck.shuffle();

		playerCardTablePositionX = 20;
		dealerCardTablePositionX = 20;

		for (int i = 0; i < player.getHand().size(); i++) {
			player.getHand().get(i).getPlayingCardLabel().setIcon(null);
			player.getHand().get(i).getPlayingCardLabel().revalidate();
		}

		for (int i = 0; i < dealer.getHand().size(); i++) {
			dealer.getHand().get(i).getPlayingCardLabel().setIcon(null);
			dealer.getHand().get(i).getPlayingCardLabel().revalidate();
		}

		dealer.getHand().clear();
		player.getHand().clear();

		updateBothDealerAndPlayerScores();
		getBetTextField().setText(null);
	}
}