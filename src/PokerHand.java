
public enum PokerHand {

	ROYAL_FLUSH(250), 
	STRAIGHT_FLUSH(50), 
	FOUR_OF_A_KIND(25), 
	FULL_HOUSE(9),
	FLUSH(6),
	STRAIGHT(4),
	THREE_OF_A_KIND(3),
	TWO_PAIR(2),
	ROYAL_PAIR(1);
	
	private int moneyMultiplier;

	private PokerHand(int moneyMultiplier) {
		this.moneyMultiplier = moneyMultiplier;
	}

	public int getMoneyMultiplier() {
		return moneyMultiplier;
	}
	
}
