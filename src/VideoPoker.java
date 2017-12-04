import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VideoPoker {
	private int startingBalance = 1000;

	public void playGame() throws IOException {

		BetMoney bm = new BetMoney();
		bm.bet(startingBalance);

		Deck deck = new Deck();
		deck.shuffle();
		kasta(hand(deck), deck);

		saveToFile(startingBalance);
		

	}

	public void saveToFile(int currentCredits) throws IOException {
		System.out.println("Vill du spara dina krediter - y/n");
		Scanner scan = new Scanner(System.in);
		String svar = scan.next();
		if(svar.equals("y")) {
			System.out.println("Vad heter du?");
			scan.nextLine();
			String namn = scan.nextLine();
			SaveScore ss = new SaveScore(namn);
			ss.writeToFile(currentCredits);
			System.out.println("TEST: input från fil" + ss.readFromFile());
		}
		else {
			System.out.println("ha de gött änna");
		}
	}
	
	public static List<Card> hand(Deck deck) {
		List<Card> hand = new ArrayList<>();

		while (hand.size() < 5) {
			hand.add(deck.draw());
		}
		System.out.println(hand);
		return hand;
	}

	public static List<Card> kasta(List<Card> hand, Deck d) {
		System.out.println("Vilka kort vill du slänga, komma(',') mellan numrena. (', <ENTER>') om du är nöjd");
		Scanner scan = new Scanner(System.in);
		String vilka = scan.next();
		
		
		List<String> items = Arrays.asList(vilka.split(","));

		Collections.sort(items, Collections.reverseOrder());
		for (int i = 0; i < items.size(); i++) {
			int temp = Integer.parseInt(items.get(i));
			System.out.println("Du har slängt " + hand.get(temp - 1));
			hand.remove(temp - 1);
		}

		for (int i = 0; i < items.size(); i++) {
			hand.add(d.draw());
		}

		System.out.println("Nu är din hand" + hand);
		return hand;
	}
}
