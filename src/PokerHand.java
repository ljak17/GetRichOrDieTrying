
public enum PokerHand {

	ROYAL_FLUSH(250, "royal flush"), 
	STRAIGHT_FLUSH(50, "straight flush"), 
	FOUR_OF_A_KIND(25, "four of a kind"), 
	FULL_HOUSE(9, "full house"),
	FLUSH(6, "flush"),
	STRAIGHT(4, "straight"),
	THREE_OF_A_KIND(3, "three of a kind"),
	TWO_PAIR(2, "two pair"),
	ROYAL_PAIR(1, "royal pair"),
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
