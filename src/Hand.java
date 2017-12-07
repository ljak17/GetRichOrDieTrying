import java.util.Collections;
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

	public void discard(int cardIndex) {
		cards.remove(cardIndex);
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

	public PokerHand getPokerHand() {
		if (isRoyalFlush()) {
			return PokerHand.ROYAL_FLUSH;
		}
		if (isStraightFlush()) {
			return PokerHand.STRAIGHT_FLUSH;
		}
		if (isFourOfAKind()) {
			return PokerHand.FOUR_OF_A_KIND;
		}
		if (isFullHouse()) {
			return PokerHand.FULL_HOUSE;
		}
		if (isFlush()) {
			return PokerHand.FLUSH;
		}
		if (isStraight()) {
			return PokerHand.STRAIGHT;
		}
		if (isThreeOfAKind()) {
			return PokerHand.THREE_OF_A_KIND;
		}
		if (isTwoPair()) {
			return PokerHand.TWO_PAIR;
		}
		if (isRoyalPair()) {
			return PokerHand.ROYAL_PAIR;
		}
		return PokerHand.LOSING_HAND;
	}

	private boolean isRoyalFlush() { //// OBS SORTERA FÄRGEN.
		Collections.sort(cards, new CardSortBySuit());
		if (cards.get(0).getSuit() == cards.get(4).getSuit()) {
			if (cards.get(0).getValue() == 10) {
				if (cards.get(1).getValue() == 11 && cards.get(2).getValue() == 12 && cards.get(3).getValue() == 13
						&& cards.get(4).getValue() == 14) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isStraightFlush() {/// sortera på färg
		Collections.sort(cards, new CardSortBySuit());
		if (cards.get(0).getSuit() == cards.get(4).getSuit()) {
			if (cards.get(0).getValue() == cards.get(1).getValue() - 1
					&& cards.get(1).getValue() == cards.get(2).getValue() - 1
					&& cards.get(2).getValue() == cards.get(3).getValue() - 1
					&& cards.get(3).getValue() == cards.get(4).getValue() - 1) {
				return true;
			}
		}
		return false;
	}

	private boolean isFourOfAKind() {
		Collections.sort(cards, new CardSortByValueAcesHigh());
		if (cards.get(0).getValue() == cards.get(1).getValue() && cards.get(1).getValue() == cards.get(2).getValue()
				&& cards.get(2).getValue() == cards.get(3).getValue()) {
			return true;
		} else if (cards.get(1).getValue() == cards.get(2).getValue()
				&& cards.get(2).getValue() == cards.get(3).getValue()
				&& cards.get(3).getValue() == cards.get(4).getValue()) {
			return true;
		}
		return false;
	}

	private boolean isFullHouse() {
		Collections.sort(cards, new CardSortByValueAcesHigh());
		if ((cards.get(0).getValue() == cards.get(1).getValue()) && (cards.get(2).getValue() == cards.get(3).getValue()
				&& cards.get(3).getValue() == cards.get(4).getValue())) {
			return true;
		} else if ((cards.get(3).getValue() == cards.get(4).getValue())
				&& (cards.get(0).getValue() == cards.get(1).getValue()
						&& cards.get(1).getValue() == cards.get(2).getValue())) {
			return true;
		}
		return false;
	}

	private boolean isFlush() {/// Sortera på färg
		Collections.sort(cards, new CardSortBySuit());
		if (cards.get(0).getSuit() == cards.get(4).getSuit()) {

			return true;

		}
		return false;
	}

	private boolean isStraight() {
		Collections.sort(cards, new CardSortByValueAcesHigh());
		if (cards.get(0).getValue() == cards.get(1).getValue() - 1
				&& cards.get(1).getValue() == cards.get(2).getValue() - 1
				&& cards.get(2).getValue() == cards.get(3).getValue() - 1
				&& cards.get(3).getValue() == cards.get(4).getValue() - 1) {
			return true;
		}
		Collections.sort(cards, new CardSortByValueAcesLow());
		if (cards.get(0).getValue() == cards.get(1).getValue() - 1
				&& cards.get(1).getValue() == cards.get(2).getValue() - 1
				&& cards.get(2).getValue() == cards.get(3).getValue() - 1
				&& cards.get(3).getValue() == cards.get(4).getValue() - 1) {
			return true;
		}

		return false;
	}

	private boolean isThreeOfAKind() {
		Collections.sort(cards, new CardSortByValueAcesHigh());
		if (cards.get(0).getValue() == cards.get(1).getValue() && cards.get(1).getValue() == cards.get(2).getValue()) {
			return true;
		} else if (cards.get(1).getValue() == cards.get(2).getValue()
				&& cards.get(2).getValue() == cards.get(3).getValue()) {
			return true;
		} else if (cards.get(2).getValue() == cards.get(3).getValue()
				&& cards.get(3).getValue() == cards.get(4).getValue()) {
			return true;
		}

		return false;
	}

	private boolean isTwoPair() {
		Collections.sort(cards, new CardSortByValueAcesHigh());
		if (cards.get(0).getValue() == cards.get(1).getValue() && cards.get(3).getValue() == cards.get(4).getValue()) {
			return true;
		} else if (cards.get(1).getValue() == cards.get(2).getValue()
				&& cards.get(3).getValue() == cards.get(4).getValue()) {
			return true;
		} else if (cards.get(0).getValue() == cards.get(1).getValue()
				&& cards.get(2).getValue() == cards.get(3).getValue()) {
			return true;
		}
		return false;
	}

	private boolean isRoyalPair() {
		Collections.sort(cards, new CardSortByValueAcesHigh());
		if (cards.get(0).getValue() == cards.get(1).getValue() && cards.get(0).getValue() >= 11) {
			return true;
		} else if (cards.get(1).getValue() == cards.get(2).getValue() && cards.get(1).getValue() >= 11) {
			return true;
		} else if (cards.get(2).getValue() == cards.get(3).getValue() && cards.get(2).getValue() >= 11) {
			return true;
		} else if (cards.get(3).getValue() == cards.get(4).getValue() && cards.get(3).getValue() >= 11) {
			return true;
		}
		return false;
	}

}
