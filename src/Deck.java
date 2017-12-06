import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Deck {

	private List<Card> cards = new LinkedList<>();

	public Deck() {
		for (Suit suit : Suit.values()) {
			for (int i = 2; i <= 14; i++) {
				cards.add(new Card(i, suit));
			}
		}
	}

	public List<Card> getCards() {
		return cards;
	}

	public Card draw() {
		if (cards.isEmpty()) {
			return null;
		}
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}

	public void shuffle() {
		List<Card> shuffledCards = new LinkedList<Card>();
		Random random = new Random();
		while (!cards.isEmpty()) {
			int randomIndex = random.nextInt(cards.size());
			shuffledCards.add(cards.get(randomIndex));
			cards.remove(randomIndex);
		}
		cards = shuffledCards;
	}

}
