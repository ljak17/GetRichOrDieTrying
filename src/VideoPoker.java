import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class VideoPoker {

	private int startingBalance = 1000;
	private final Deck deck = new Deck();
	private final Hand hand = new Hand();

	public void playGame() throws IOException {
		startingBalance += readFromFile();
		System.out.println("Du har " + startingBalance + " pengar nu");
		int currentBet = bet(startingBalance);
		startingBalance -= currentBet;
		System.out.println("Du har " + startingBalance + " pengar kvar");
		deck.shuffle();
		giv();
		kasta();
		saveToFile(startingBalance);
	}

	public int bet(int currentCredits) {
		System.out.println("Hur mycket vill du satsa?");
		int i = 0;
		Scanner scan = new Scanner(System.in);

		i = scan.nextInt();
		if (i > currentCredits) {
			System.out.println("Du kan inte satsa mer pengar än vad du äger, pls try agen");
			while (i > currentCredits) {
				i = scan.nextInt();
			}
		}
		System.out.println("Du har satsat: " + i);
		return i;
	}

	public int readFromFile() throws FileNotFoundException {
		System.out.println("Har du en sparfil?");
		Scanner scan = new Scanner(System.in);
		String svar = scan.nextLine();
		if (svar.equals("y")) {
			SaveScore read = new SaveScore();
			TreeMap<String, Integer> x = read.readFromFile();
			String namn = x.firstEntry().getKey();
			int pengar = x.firstEntry().getValue();
			System.out.println("Välkommen tillbaka " + namn);
			return pengar;
		}
		return 0;
	}

	public void saveToFile(int currentCredits) throws IOException {
		System.out.println("Vill du spara dina krediter - y/n");
		Scanner scan = new Scanner(System.in);
		String svar = scan.next();
		if (svar.equals("y")) {
			System.out.println("Vad heter du?");
			scan.nextLine();
			String namn = scan.nextLine();
			SaveScore ss = new SaveScore();
			ss.writeToFile(namn, currentCredits);
			System.out.println("TEST: input från fil" + ss.readFromFile());
		} else {
			System.out.println("ha de gött änna");
		}
	}

	public void giv() {
		while (hand.getSize() < 5) {
			hand.add(deck.draw());
		}
		System.out.println(hand);
	}

	public void kasta() {
		System.out.println("Vilka kort vill du slänga, komma(',') mellan numrena. (', <ENTER>') om du är nöjd");
		Scanner scan = new Scanner(System.in);
		String vilka = scan.next();
		List<String> items = Arrays.asList(vilka.split(","));
		Collections.sort(items, Collections.reverseOrder());
		for (int i = 0; i < items.size(); i++) {
			int temp = Integer.parseInt(items.get(i));
			System.out.println("Du har slängt " + hand.getCard(temp - 1));
			hand.discard(temp - 1);
		}
		for (int i = 0; i < items.size(); i++) {
			hand.add(deck.draw());
		}
		System.out.println("Nu är din hand" + hand);
	}

}
