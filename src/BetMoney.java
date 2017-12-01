import java.util.Scanner;

public class BetMoney {
	
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
}
