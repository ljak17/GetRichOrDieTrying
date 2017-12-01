import java.util.Scanner;

public class BetMoney {
	
	public int bet(int currentCredits) {
		System.out.println("Hur mycket vill du satsa?");
		
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		if(i>currentCredits) {
			System.out.println("Du kan inte satsa mer pengar än vad du äger, pls try agen");
			while(i>currentCredits) {
				i = scan.nextInt();
			}
		}
		System.out.println("Du har satsat: " + i);
		scan.close();
		return i;
	}
}
