import java.util.LinkedList;
import java.util.List;

public class Hand {

	private final List<Card> cards;

	public Hand() {
		super();
		this.cards = new LinkedList<>();
	}

	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}
	
	public int getSize() {
		return cards.size();
	}
	
	public Card getCard(int index) {
		return cards.get(index);
	}

	public void add(Card card) {
		cards.add(card);
	}

	public void add(List<Card> cards) {
		cards.addAll(cards);
	}

	public void discard(int cardIndex) {
		cards.remove(cardIndex);
	}

	public void discard(List<Integer> cardIndices) {
		List<Card> cardsToDiscard = new LinkedList<>();
		for (Integer index : cardIndices) {
			cardsToDiscard.add(cards.get(index));
		}
		cards.removeAll(cardsToDiscard);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("[");
		for (Card card : cards) {
			stringBuilder.append(card.toString()).append(", ");
		}
		stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
		return stringBuilder.append("]").toString();
	}

	public int getMoneyMultiplier() {
		if (isRoyalFlush()) {
			return PokerHand.ROYAL_FLUSH.getMoneyMultiplier();
		}
		if (isStraightFlush()) {
			return PokerHand.STRAIGHT_FLUSH.getMoneyMultiplier();
		}
		if (isFourOfAKind()) {
			return PokerHand.FOUR_OF_A_KIND.getMoneyMultiplier();
		}
		if (isFullHouse()) {
			return PokerHand.FULL_HOUSE.getMoneyMultiplier();
		}
		if (isFlush()) {
			return PokerHand.FLUSH.getMoneyMultiplier();
		}
		if (isStraight()) {
			return PokerHand.STRAIGHT.getMoneyMultiplier();
		}
		if (isThreeOfAKind()) {
			return PokerHand.THREE_OF_A_KIND.getMoneyMultiplier();
		}
		if (isTwoPair()) {
			return PokerHand.TWO_PAIR.getMoneyMultiplier();
		}
		if (isRoyalPair()) {
			return PokerHand.ROYAL_PAIR.getMoneyMultiplier();
		}
		return 0;
	}

	private boolean isRoyalFlush() {
		return false;
	}

	private boolean isStraightFlush() {
		return false;
	}

	private boolean isFourOfAKind() {
		return false;
	}

	private boolean isFullHouse() {
		return false;
	}

	private boolean isFlush() {
		return false;
	}

	private boolean isStraight() {
		return false;
	}

	private boolean isThreeOfAKind() {
		return false;
	}

	private boolean isTwoPair() {
		return false;
	}

	private boolean isRoyalPair() {
		return false;
	}

}
