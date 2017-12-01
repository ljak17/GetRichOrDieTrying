import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VideoPoker {

	public void playGame() throws IOException{

	

		Deck deck = new Deck();
		deck.shuffle();
		kasta(hand(deck), deck);
		
		//Bara f�r att testa, kan vara userinput namn sen
		SaveScore ss = new SaveScore("pelle");
		ss.writeToFile(123);
		System.out.println(ss.readFromFile());
		
	}
		
	public static List<Card> hand(Deck deck) {
		List<Card> hand = new ArrayList<>();
		
		while(hand.size()<5) {
			hand.add(deck.draw());
		}
		System.out.println(hand);
		return hand;
	}
	public static List<Card> kasta(List<Card> hand, Deck d) {
		System.out.println("Vilka kort vill du sl�nga, komma(',') mellan numrena");
		Scanner scan = new Scanner(System.in);
		String vilka = scan.next();
		List<String> items = Arrays.asList(vilka.split(","));
		
		Collections.sort(items, Collections.reverseOrder());
		for(int i = 0; i<items.size(); i++) {
			int temp = Integer.parseInt(items.get(i));
			System.out.println("Du har sl�ngt " + hand.get(temp-1));
			hand.remove(temp-1);		
		}
		
		for(int i = 0; i < items.size();i++) {
			hand.add(d.draw());
		}
		
		
		System.out.println("Nu �r din hand" + hand);
		scan.close();
		return hand;
	}
}

