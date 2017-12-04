import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VideoPoker {
	
	private int startingBalance = 1000;
	private final Deck deck = new Deck();
	private final Hand hand = new Hand();

	public void playGame() throws IOException {
		bet(startingBalance);
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
		if(i>currentCredits) {
			System.out.println("Du kan inte satsa mer pengar än vad du äger, pls try agen");
			while(i>currentCredits) {
				i = scan.nextInt();
			}
		}
		System.out.println("Du har satsat: " + i);
		return i;
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
	
	public void giv() {
		while (hand.getSize() < 5) {
			hand.add(deck.draw());
		}
		System.out.println(hand);
	}

	public void kasta() {
		System.out.println("Vilka kort vill du slänga, komma(',') mellan numrena");
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
