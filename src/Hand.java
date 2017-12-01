import java.util.LinkedList;
import java.util.List;

public class Hand {
	
	private final List<Card> cards;
	
	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Card card : cards) {
			stringBuilder.append(card.toString());
			stringBuilder.append(", ");
		}
		stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length() - 1);
		return stringBuilder.toString();
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
