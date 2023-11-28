import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {

		Scanner into = new Scanner(System.in);
		System.out.println("Welcome to Blackjack");

		String input = "";
		boolean over = false;
		boolean exit = false;
		int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;
		int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;
		int pScore = c1+c2+c3+c4+c5;
		int oScore = a1+a2+a3+a4+a5;
		

		do {
			while (!input.equals("d")) {
				System.out.println("To begin type [d] to draw 2 cards.");
				input = into.nextLine();

				if (input.equals("d")) {
					c1 = (int) (Math.random() * 11 + 1);
					c2 = (int) (Math.random() * 11 + 1);
					a1 = (int) (Math.random() * 8 + 3);
					a2 = (int) (Math.random() * 8 + 3);
					System.out.println("Your cards: (total: " + pScore + ")  " + c1 + "  " + c2);
					break;
				}
			}
			while (!over) {
				System.out.println("[d] draw card  [p] pass turn  [c] challenge  [f] forfit");
				input = into.nextLine();

				if (input.equals("d")) {
					// Problem: How to make adapt to 4 and 5
					c3 = (int) (Math.random() * 11 + 1);
					System.out.println("Your cards: (total: " + pScore + ")  " + c1 + "  " + c2 + "  " + c3);
				}
				if (input.equals("p")) {
					// Problem: How to make adapt to 4 and 5
					c3 = 0; 
				}
				if (input.equals("c")) {
					// Your cards 
					// oppenments cards 
					// win / lose
					over = true;
				}
				if (input.equals("f")) {
					System.out.println(
							"You loose. Your oppenent had these cards: (toal: " + (a1 + a2) + ")  " + a1 + "  " + a2);
					over = true;
				}
			}
			System.out.println("Would you like to play again? (y/n)");
			while (!input.equals("n") && !input.equals("y")) {
				input = into.nextLine();
				if (input.equals("n")) {
					exit = true;
				}

			}
		} while (!exit);
	}
}
/*
 * ++Winstreak! 
 * Welcome d to draw > get 2 random (always below 21) > Ai gets a random numer
 * (6-20)
 * 
 * while d to draw - p to pass - f to forfit - c to challenge/compare d > get 1
 * random (1-11) each round ai might get another card or forfit f > wanna play
 * again? c > show all cards of player and ai announce winner wanna play again?
 * 
 * always compare after 5 cards
 */