package GetRichOrDieTrying;

import java.util.LinkedList;
import java.util.List;

import GetRichOrDieTrying.src.Card;
import GetRichOrDieTrying.src.PokerHand;

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
		if (cards.get(0).getSuit() == cards.get(4).getSuit()) { //// OBS SORTERA FÄRGEN.
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
		if (cards.get(0).getSuit() == cards.get(4).getSuit()) {

			return true;

		}
		return false;
	}

	private boolean isStraight() {
		if (cards.get(0).getValue() == cards.get(1).getValue() - 1
				&& cards.get(1).getValue() == cards.get(2).getValue() - 1
				&& cards.get(2).getValue() == cards.get(3).getValue() - 1
				&& cards.get(3).getValue() == cards.get(4).getValue() - 1) {
			return true;
		}

		return false;
	}

	private boolean isThreeOfAKind() {
		if (cards.get(0).getValue() == cards.get(1).getValue() && cards.get(1).getValue() == cards.get(0).getValue()) {
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
