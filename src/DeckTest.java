
public class DeckTest {

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
}
