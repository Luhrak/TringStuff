import java.util.Scanner;
import java.util.stream.IntStream;

public class Blackjack {

	private static int pCalc(int[] arr) {
		return IntStream.of(arr).sum();
	}

	private static int getRandomInt() {
		return (int) (Math.random() * 11 + 1);
	}

	private static void evaluate(int[] c, int[] a) {
		int pScore = pCalc(c);
		int oScore = pCalc(a);

		if ((0 < pScore && pScore <= 21) && (0 < oScore && oScore <= 21)) {
			if (pScore == oScore) {
				System.out.println("Draw!");
			} else if (pScore > oScore) {
				System.out.println("You win!");
			} else {
				System.out.println("You lose!");
			}
		} else if (!(0 < pScore && pScore <= 21)) {
			System.out.println("You lose");
		} else if (!(0 < oScore && oScore <= 21)) {
			System.out.println("Your opponent overshot! You win!");
		} else {
			System.out.println("Idk??? both lose??");
		}
		System.out.println("Your oppenent had these cards: (toal: " + (a[0] + a[1]) + ")  " + a[0] + "  " + a[1]);
	}

	public static void main(String[] args) {
		Scanner into = new Scanner(System.in);
		System.out.println("Welcome to Blackjack");

		String input = "";
		boolean exit = false;

		do {
			// STEP 0 - RESET TO INTIAL STATE
			boolean over = false;
			int[] c = new int[5];
			int[] a = new int[5];
			int pScore = 0;
			int oScore = 0;
			int pPosition = 0;
			int oPosition = 0;
			int turns = 0;

			// STEP 1 - initial state
			while (!input.equals("d")) {
				System.out.println("To begin type [d] to draw 2 cards.");
				input = into.nextLine();

				if (input.equals("d")) {
					c[pPosition++] = getRandomInt();
					c[pPosition++] = getRandomInt();
					a[oPosition++] = getRandomInt();
					a[oPosition++] = getRandomInt();
					pScore = pCalc(c);
					oScore = pCalc(a);
					System.out.println("Your cards: (total: " + pScore + ")  " + c[0] + "  " + c[1]);
					break;
				}
			}

			// STEP 2 - game loop
			while (!over) {
				System.out.println("[d] draw card  [p] pass turn  [c] challenge  [f] forfeit");
				input = into.nextLine();

				switch (input) {

				case "d":
					if (pPosition < 5) {
						c[pPosition++] = getRandomInt();
						pScore = pCalc(c);
					} else {
						System.err.println("You already have 5 cards!");
					}
					System.out.flush(); // Soooo... since System.err and System.out are 2 different outputs they can
										// draw over each other which can end up mangling text real badly
					System.out.print("Your cards: (total: " + pScore + ")  ");
					for (int card : c) {
						if (card > 0) {
							System.out.print(card + " ");
						}
					}
					System.out.println();
				case "p":
					// 50% chance opponent draws card
					if (Math.random() > 0.5 && oPosition < 5 && oScore < 21) {
						a[oPosition++] = getRandomInt();
					}
					if (turns >= 5) {
						System.out.println("Grrrr.. this takes too long. Im challenging!");
						evaluate(c, a);
						over = true;
					}
					break;

				case "c":
					evaluate(c, a);
					over = true;
					break;

				case "f":
					System.out.println("You lose. Your oppenent had these cards: (toal: " + (a[0] + a[1]) + ")  " + a[0]
							+ "  " + a[1]);
					over = true;
					break;

				default:
					System.err.println("Error! Invalid option");
				}

				// Update scores
				pScore = pCalc(c);
				oScore = pCalc(a);
				turns++;
			}

			// STEP 3 - Retry y / n?
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