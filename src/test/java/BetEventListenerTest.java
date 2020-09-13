import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.DefaultKeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.awt.Robot; 
import java.awt.event.KeyEvent; 
import java.awt.AWTException; 



import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Table;
import io.zahid.blackjack.eventlisteners.BetEventListener;
import io.zahid.blackjack.eventlisteners.DealEventListener;
import io.zahid.blackjack.eventlisteners.NewGameEventListener;

public class BetEventListenerTest {
	
	Table table = new Table();
	Deck deck = new Deck();

	@Test
	public void betNotAccessible() {

		Table table = new Table();

		BetEventListener betEventListener = new BetEventListener(table);
		ActionEvent mockEvent = mock(ActionEvent.class);
		betEventListener.actionPerformed(mockEvent);
	}

	
	@Test
	public void inputZeroBet() throws AWTException, InterruptedException {
		Table table = new Table();
		Deck deck = new Deck();
	    Robot robot = new Robot(); 
		
		
		NewGameEventListener newGameEventListener = new NewGameEventListener(table, deck);
		ActionEvent mockEvent = mock(ActionEvent.class);
		newGameEventListener.actionPerformed(mockEvent);
		BetEventListener betEventListener = new BetEventListener(table);
		table.getBetTextField().setText("0.0");

		betEventListener.actionPerformed(mockEvent);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER); 

	}
	/*
	@Test
	public void inputInvalidBet() {
		Table table = new Table();
		Deck deck = new Deck();
				
		NewGameEventListener newGameEventListener = new NewGameEventListener(table, deck);
		ActionEvent mockEvent = mock(ActionEvent.class);
		newGameEventListener.actionPerformed(mockEvent);
		BetEventListener betEventListener = new BetEventListener(table);
		table.getBetTextField().setText("a");
		betEventListener.actionPerformed(mockEvent);
		betEventListener.actionPerformed(mockEvent);

	}
	
	@Test
	public void inputInalidBet_then_inputValidBet() {
		Table table = new Table();
		Deck deck = new Deck();
				
		NewGameEventListener newGameEventListener = new NewGameEventListener(table, deck);
		ActionEvent mockEvent = mock(ActionEvent.class);
		newGameEventListener.actionPerformed(mockEvent);
		BetEventListener betEventListener = new BetEventListener(table);
		table.getBetTextField().setText("-1");
		betEventListener.actionPerformed(mockEvent);
		table.getBetTextField().setText("10");
		betEventListener.actionPerformed(mockEvent);
	}
	
	@Test
	public void actionPerformed_inputInsufficentBet() {
		Table table = new Table();
		Deck deck = new Deck();
				
		NewGameEventListener newGameEventListener = new NewGameEventListener(table, deck);
		ActionEvent mockEvent = mock(ActionEvent.class);
		newGameEventListener.actionPerformed(mockEvent);
		BetEventListener betEventListener = new BetEventListener(table);
		table.getBetTextField().setText("-1");
		betEventListener.actionPerformed(mockEvent);
	}*/


}
