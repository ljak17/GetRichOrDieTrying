import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
	public List<Card> cards = new ArrayList<>();

	public Deck() {
		for (int i = 0; i < Suit.values().length; i++) {
			for (int j = 1; j < 14; j++) {
				cards.add(new Card(j, Suit.values()[i]));
			}
		}
	}
	
	public Card draw() {
		Card currentCard = cards.get(0);
		cards.remove(currentCard);
		return currentCard;
	}
	
	public void shuffle() {
		List<Card> shuffledCards = new ArrayList<>();
		Random random = new Random();
		Card card;

		while (cards.size() > 0) {
			card = cards.get(random.nextInt(cards.size()));
			shuffledCards.add(card);
			cards.remove(card);
		}
		
		cards = shuffledCards;
	}
	
	public static boolean testDeckSizeBeforeAndAfterShuffle(Deck deck) {		
		int sizeBeforeShuffle = deck.cards.size();

		deck.shuffle();
		
		return deck.cards.size() == sizeBeforeShuffle;
	}
	
	public static boolean testDeckSizeBeforeAndAfterShuffle() {
		Deck deck = new Deck();
		
		return testDeckSizeBeforeAndAfterShuffle(deck);
	}

	public static boolean testDrawAndDeckSizeBeforeAndAfterShuffle() {
		Deck deck = new Deck();
		
		deck.draw();
		
		return testDeckSizeBeforeAndAfterShuffle(deck);
	}

	public static boolean testNoDuplicateCards(Deck deck) {
		while (deck.cards.size() > 0) {
			Card card = deck.draw();
			
			for (int i = 0; i < deck.cards.size(); i++) {
				if (card.equals(deck.cards.get(i))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean testNoDuplicateCardsWithoutShuffle() {
		Deck deck = new Deck();
		
		return testNoDuplicateCards(deck);
	}

	public static boolean testNoDuplicateCardsWithShuffle() {
		Deck deck = new Deck();
		
		deck.shuffle();
		
		return testNoDuplicateCards(deck);
	}

	public static void main(String[] args) {
		System.out.println(testDeckSizeBeforeAndAfterShuffle());
		System.out.println(testDrawAndDeckSizeBeforeAndAfterShuffle());
		System.out.println(testNoDuplicateCardsWithoutShuffle());
		System.out.println(testNoDuplicateCardsWithShuffle());
	}
}
