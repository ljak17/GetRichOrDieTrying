import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class VideoPoker {
	private int startingBalance = 1000;

	public void playGame() throws IOException {

		BetMoney bm = new BetMoney();
		startingBalance += readFromFile();
		System.out.println("Du har " + startingBalance + " pengar nu");
		int currentBet = bm.bet(startingBalance);
		startingBalance -= currentBet;
		System.out.println("Du har " + startingBalance + " pengar kvar");
		
		Deck deck = new Deck();
		deck.shuffle();
		kasta(hand(deck), deck);
		saveToFile(startingBalance);
		

	}
	public int readFromFile() throws FileNotFoundException {
		System.out.println("Har du en sparfil?");
		Scanner scan = new Scanner(System.in);
		String svar = scan.nextLine();
		if(svar.equals("y")) {
			SaveScore read = new SaveScore();
			TreeMap<String, Integer> x = read.readFromFile();
			String namn = x.firstEntry().getKey();
			int pengar = x.firstEntry().getValue();
			System.out.println("V�lkommen tillbaka " + namn);
			return pengar;
		}
		return 0;
	}
	public void saveToFile(int currentCredits) throws IOException {
		System.out.println("Vill du spara dina krediter - y/n");
		Scanner scan = new Scanner(System.in);
		String svar = scan.next();
		if(svar.equals("y")) {
			System.out.println("Vad heter du?");
			scan.nextLine();
			String namn = scan.nextLine();
			SaveScore ss = new SaveScore();
			ss.writeToFile(namn, currentCredits);
			System.out.println("TEST: input fr�n fil" + ss.readFromFile());
		}
		else {
			System.out.println("ha de g�tt �nna");
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

	public List<Card> kasta(List<Card> hand, Deck d) {
		System.out.println("Vilka kort vill du sl�nga, komma(',') mellan numrena. (', <ENTER>') om du �r n�jd");
		Scanner scan = new Scanner(System.in);
		String vilka = scan.next();
		
		
		List<String> items = Arrays.asList(vilka.split(","));

		Collections.sort(items, Collections.reverseOrder());
		for (int i = 0; i < items.size(); i++) {
			int temp = Integer.parseInt(items.get(i));
			System.out.println("Du har sl�ngt " + hand.get(temp - 1));
			hand.remove(temp - 1);
		}

		for (int i = 0; i < items.size(); i++) {
			hand.add(d.draw());
		}

		System.out.println("Nu �r din hand" + hand);
		return hand;
	}
}
