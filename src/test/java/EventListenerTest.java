import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.event.ActionEvent;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import io.zahid.blackjack.Deck;
import io.zahid.blackjack.Table;
import io.zahid.blackjack.eventlisteners.BetEventListener;
import io.zahid.blackjack.eventlisteners.NewGameEventListener;

public class EventListenerTest {
	
	Table table = new Table();
	Deck deck = new Deck();
	
	@Test
	public void actionPerformed_newGameEventListener() {
		NewGameEventListener newGameEventListener = new NewGameEventListener(table, deck);
		ActionEvent mockEvent = mock(ActionEvent.class);
		newGameEventListener.actionPerformed(mockEvent);
		newGameEventListener.actionPerformed(mockEvent);
	}
	
}
