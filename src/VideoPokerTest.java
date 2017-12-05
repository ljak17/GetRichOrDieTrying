import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
	void testDeckDraw() {
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
	void testShuffleChangeOrder() {
		List<Card>orderedCards = new ArrayList<>();
		for (Card card : deck.getCards()) {
			orderedCards.add(card);
		}
		List<Card>shuffledCards = new ArrayList<>();
		deck.shuffle();
		for (Card card : deck.getCards()) {
			shuffledCards.add(card);
		}
		for (int i = 0; i < shuffledCards.size(); i++) {
			if (!shuffledCards.get(i).equals(orderedCards.get(i))) {
				break;
			}
			if (i == shuffledCards.size() - 1) {
				fail("Calling shuffle() changes order of cards in deck.");
			}
		}
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
	void testCardProperties() {
		Card card;
		for (Suit suit : Suit.values()) {
			for (int value = 1; value < 14; value++) {
				card = new Card(value, suit);
				assertEquals(value, card.getValue(), "card.getValue returns correct value");
				assertEquals(suit, card.getSuit(), "card.getSuit returns correct suit");
			}
		}
	}
	
	// Comparator tests ------------------
	
//	@Test
	void testCardSortBySuit() {
		
	}
	
//	@Test
	void testCardSortByValueNoAces() {
		
	}
	
//	@Test
	void testCardSortByValueAcesHigh() {
		
	}
	
//	@Test
	void testCardSortByValueAcesLow() {
		
	}
	
	// Hand tests -----------------------
/*
 * Features att testa:
 * hand som skapas fr�n lista ska inneh�lla samma kort som listan
 * samma test igen fast denna g�ngen skapas tom hand och korten l�ggs med add (lista)
 * samma test igen fast denna g�ngen skapas tom hand och korten l�ggs med add (ett efter ett)
 * hand ska f�rlora de kort som tas bort med discard (lista)
 * hand ska f�rlora de kort som tas bort med discard (ett efter ett)
 */
	
	@Test
	void testGetMoneyMultiplierRoyalFlush() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(10, Suit.CLUBS));
		cards.add(new Card(11, Suit.CLUBS));
		cards.add(new Card(12, Suit.CLUBS));
		cards.add(new Card(13, Suit.CLUBS));
		cards.add(new Card(14, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.ROYAL_FLUSH.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Royal flush equals 250 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierStraightFlush() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(2, Suit.CLUBS));
		cards.add(new Card(3, Suit.CLUBS));
		cards.add(new Card(4, Suit.CLUBS));
		cards.add(new Card(5, Suit.CLUBS));
		cards.add(new Card(6, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.STRAIGHT_FLUSH.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Straight flush equals 50 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierFourOfAKind() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(5, Suit.CLUBS));
		cards.add(new Card(5, Suit.HEARTS));
		cards.add(new Card(5, Suit.SPADES));
		cards.add(new Card(5, Suit.DIAMONDS));
		cards.add(new Card(6, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.FOUR_OF_A_KIND.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Four of a kind equals 25 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierFullHouse() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(3, Suit.CLUBS));
		cards.add(new Card(3, Suit.CLUBS));
		cards.add(new Card(6, Suit.CLUBS));
		cards.add(new Card(6, Suit.DIAMONDS));
		cards.add(new Card(6, Suit.HEARTS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.FULL_HOUSE.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Full house equals 9 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierFlush() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(3, Suit.CLUBS));
		cards.add(new Card(4, Suit.CLUBS));
		cards.add(new Card(6, Suit.CLUBS));
		cards.add(new Card(8, Suit.CLUBS));
		cards.add(new Card(5, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.FLUSH.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Flush equals 6 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierStraight() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(3, Suit.HEARTS));
		cards.add(new Card(4, Suit.CLUBS));
		cards.add(new Card(5, Suit.CLUBS));
		cards.add(new Card(6, Suit.CLUBS));
		cards.add(new Card(7, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.STRAIGHT.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Straight equals 4 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierThreeOfAKind() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(4, Suit.HEARTS));
		cards.add(new Card(4, Suit.DIAMONDS));
		cards.add(new Card(4, Suit.CLUBS));
		cards.add(new Card(6, Suit.CLUBS));
		cards.add(new Card(7, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.THREE_OF_A_KIND.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Three of a kind equals 3 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierTwoPair() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(9, Suit.HEARTS));
		cards.add(new Card(9, Suit.CLUBS));
		cards.add(new Card(5, Suit.SPADES));
		cards.add(new Card(5, Suit.CLUBS));
		cards.add(new Card(7, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.TWO_PAIR.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Two pair equals 2 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierRoyalPair() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(11, Suit.HEARTS));
		cards.add(new Card(11, Suit.CLUBS));
		cards.add(new Card(5, Suit.CLUBS));
		cards.add(new Card(6, Suit.CLUBS));
		cards.add(new Card(7, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(PokerHand.ROYAL_PAIR.getMoneyMultiplier(),
				hand.getMoneyMultiplier(), "Royal pair equals 1 multiplier");
	}
	
	@Test
	void testGetMoneyMultiplierLosingHand() {
		List<Card> cards = new LinkedList<>();
		cards.add(new Card(2, Suit.HEARTS));
		cards.add(new Card(11, Suit.CLUBS));
		cards.add(new Card(5, Suit.CLUBS));
		cards.add(new Card(4, Suit.CLUBS));
		cards.add(new Card(7, Suit.CLUBS));
		Hand hand = new Hand(cards);
		assertEquals(0,	hand.getMoneyMultiplier(), "Losing hand equals 0 multiplier");
	}
	
}
