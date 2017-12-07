
public enum PokerHand {

	ROYAL_FLUSH(250, "royal flush"), 
	STRAIGHT_FLUSH(50, "straight flush"), 
	FOUR_OF_A_KIND(25, "fyrtal"), 
	FULL_HOUSE(9, "kåk"),
	FLUSH(6, "färg"),
	STRAIGHT(4, "stege"),
	THREE_OF_A_KIND(3, "triss"),
	TWO_PAIR(2, "tvåpar"),
	ROYAL_PAIR(1, "knekt eller högre"),
	LOSING_HAND(0, "kass hand");
	
	private int moneyMultiplier;
	private String name;

	private PokerHand(int moneyMultiplier, String name) {
		this.moneyMultiplier = moneyMultiplier;
		this.name = name;
	}

	public int getMoneyMultiplier() {
		return moneyMultiplier;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
