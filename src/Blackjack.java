import java.util.Scanner;
import java.util.stream.IntStream;

public class Blackjack {

	private static int pCalc(int[] arr) {
		return IntStream.of(arr).sum();
	}
	
	private static int getRandomInt() {
		return (int) (Math.random() * 11 + 1);
	}
	
	public static void main(String[] args) {

		Scanner into = new Scanner(System.in);
		System.out.println("Welcome to Blackjack");

		//HINT: variables that DONT need resetting can go outside the loop
		//		variables that need resetting can go inside. that way they get reassigned every time
		String input = "";
		boolean exit = false;

		do {
			// STEP 0 - RESET TO INTIAL STATE
			boolean over = false;
			int[] c = new int[5];
			int[] a = new int[5];
			//int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;
			//int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0;
			int pScore = 0;
			int oScore = 0;

			// STEP 1 -
			while (!input.equals("d")) {
				System.out.println("To begin type [d] to draw 2 cards.");
				input = into.nextLine();

				if (input.equals("d")) {
					c[0] = getRandomInt();
					c[1] = getRandomInt();
					a[0] = getRandomInt();
					a[1] = getRandomInt();
					pScore = pCalc(c);
					oScore = pCalc(a);
					System.out.println("Your cards: (total: " + pScore + ")  " + c[0] + "  " + c[1]);

					/*
					 * c1 = (int) (Math.random() * 11 + 1); c2 = (int) (Math.random() * 11 + 1); a1
					 * = (int) (Math.random() * 8 + 3); a2 = (int) (Math.random() * 8 + 3); pScore =
					 * c1+c2+c3+c4+c5; oScore = a1+a2+a3+a4+a5;
					 * System.out.println("Your cards: (total: " + pScore + ")  " + c1 + "  " + c2);
					 */
					break;
				}
			}

			// STEP 2 -
			while (!over) {
				System.out.println("[d] draw card  [p] pass turn  [c] challenge  [f] forfeit");
				input = into.nextLine();

				if (input.equals("d")) {
					// Problem: How to make adapt to 4 and 5
					
					c[2] = getRandomInt();
					pScore = pCalc(c);
					System.out.println("Your cards: (total: " + pScore + ")  " + c[0] + "  " + c[1] + "  " + c[2]);
					
					//c3 = (int) (Math.random() * 11 + 1);
					//pScore = c1 + c2 + c3 + c4 + c5;
					//System.out.println("Your cards: (total: " + pScore + ")  " + c1 + "  " + c2 + "  " + c3);
				}
				if (input.equals("p")) {
					// Problem: How to make adapt to 4 and 5
					c[2] = 0;
					//c3 = 0;
				}
				if (input.equals("c")) {
					// Your cards
					// oppenments cards
					// win / lose
					over = true;
				}
				if (input.equals("f")) {
					System.out.println(
							"You loose. Your oppenent had these cards: (toal: " + (a[0] + a[1]) + ")  " + a[0] + "  " + a[1]);
					over = true;
				}
			}

			// STEP 3 -
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
 * Welcome d to draw > get 2 random (always below 21) > Ai gets a random numer
 * (6-20)
 * 
 * while d to draw - p to pass - f to forfeit - c to challenge/compare d > get 1
 * random (1-11) each round ai might get another card or forfit f > wanna play
 * again? c > show all cards of player and ai announce winner wanna play again?
 * 
 * always compare after 5 cards
 */