import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class VideoPokerTest {

	Deck deck;

	// Deck tests --------------------------
	@BeforeEach
	void renewDeck() {
		deck = new Deck();
	}

	@Test
	void testNewDeckSize() {
		assertEquals(deck.getCards().size(), 52, "New deck contains 52 cards");
	}

	@Test
	void testDeckDraw0() {
		deck.draw();
		assertEquals(deck.getCards().size(), 51, "Deck size decreases by 1 when draw() is called");
	}

	@Test
	void testDeckNoDuplicateCards() {
		while (!deck.getCards().isEmpty()) {
			assertFalse(deck.getCards().contains(deck.draw()), "Deck does not contain the card returned by draw");
		}
	}

	@Test
	void testDeckShuffleNoException() {
		deck.shuffle();
	}

	@Test
	void testDeckNoCardIsNull() {
		for (int i = 0; i < 52; i++) {
			assertNotNull(deck.draw(), "Card returned from draw() is not null");
		}
	}

	@Test
	void testDeck53rdCardIsNull() {
		for (int i = 0; i < 52; i++) {
			deck.draw();
		}
		assertNull(deck.draw(), "53rd call to draw() returns null");
	}

	@RepeatedTest(100)
	void testDeckShuffleDoesNotChangeSize() {
		int unshuffledDeckSize = deck.getCards().size();
		deck.shuffle();
		assertEquals(unshuffledDeckSize, deck.getCards().size(), "Shuffle does not change deck size");
	}

	// Card tests ------------------
	@Test
	void testCardConstructor() {
		Card card;
		for (Suit suit : Suit.values()) {
			for (int value = 1; value < 14; value++) {
				card = new Card(value, suit);
				assertEquals(value, card.getValue(), "card.getValue returns correct value");
				assertEquals(suit, card.getSuit(), "card.getSuit returns correct suit");
			}
		}
	}
	
	// Hand tests -----------------------
	
}
