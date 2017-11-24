
public class Card {
	
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
	
	public String toString() {
		return Integer.toString(value) + suit.name().charAt(0);
	}
	
	public boolean equals(Card card) {
		if (card == null) {
			return false;
		}
		if (this.value != card.getValue()) {
			return false;
		}
		if (this.suit != card.getSuit()) {
			return false;
		}
		return true;
	}

}
