import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VideoPoker {
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		kasta(hand(deck));
		
	}
	public static List<Card> hand(Deck deck) {
		List<Card> hand = new ArrayList<>();
		
		while(hand.size()<5) {
			hand.add(deck.draw());
		}
		System.out.println(hand);
		return hand;
	}
	public static void kasta(List<Card> hand) {
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
		System.out.println(hand);
		scan.close();
	}

}
