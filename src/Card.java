
public class Card implements Comparable<Card> {
	
	private int value;
	private Suit suit;
	
	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		return Integer.toString(value) + suit.name().charAt(0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;
		Card other = (Card) object;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public int compareTo(Card card) {
		if (card == null) {
			throw new NullPointerException();
		}
		if (getClass() != card.getClass()) {
			throw new ClassCastException();
		}
		if (value < card.value) {
			return -1;
		} else if (value > card.value) {
			return 1;
		}
		return 0;
	}

}
