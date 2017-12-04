import java.util.Comparator;

public class CardSortByValueAcesLow implements Comparator<Card> {

	@Override
	public int compare(Card card1, Card card2) {
		if (card1.getValue() == 14 && card2.getValue() != 14) {
			return -1;
		}
		if (card1.getValue() != 14 && card2.getValue() == 14) {
			return 1;
		}
		if (card1.getValue() == 14 && card2.getValue() == 14) {
			return 0;
		}
		return card1.getValue() - card2.getValue();
	}

}
