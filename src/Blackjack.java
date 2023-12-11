import java.util.Scanner;
import java.util.stream.IntStream;

public class Blackjack {

	public static void main(String[] args) {

		try (Scanner into = new Scanner(System.in)) {
			boolean exit = false;
			int winstreak = 0;
			
			System.out.println("Welcome to Blackjack");
	
			// RESET TO INTIAL STATE -
			while (!exit) {
				String input = "";
				boolean gameActive = true;
				int[] c = new int[5];
				int[] a = new int[5];
				int round = 1;
	
				// STEP 1 -
				while (!input.equals("d")) {
					System.out.println("To begin type [d] to draw 2 cards.");
					input = into.nextLine();
	
					if (input.equals("d")) {
						c[0] = getRandomInt();
						c[1] = getRandomInt();
						a[0] = getRandomInt();
						a[1] = getRandomInt();
						System.out.print("Your cards: ");
						outPutHand(c, round);	
						break;
					}
				}
	
				// STEP 2 -
				while (gameActive) {
					round++;
					
					if (round == 5) {
						System.out.println("Your opponent challenges you!");
						System.out.print("They had these cards: ");
						outPutHand(a, round);

						boolean win = playerWin(c,a);
						if (win) {winstreak++;}
						gameActive = false;
						break;
					}
					
					input = getUserMove(into);

					if (input.equals("d")) {
						c[round] = getRandomInt();
						System.out.print("Your cards: ");
						outPutHand(c, round);
						
					} else if (input.equals("p")) {
						c[round] = 0;
						System.out.print("Your cards: ");
						outPutHand(c, round);
						
					} else if (input.equals("c")) {
						System.out.println("You challenged your opponent.");
						System.out.print("Your cards: ");
						outPutHand(c, round);
						System.out.print("Your opponent had these cards: ");
						outPutHand(a, round);

						boolean win = playerWin(c,a);
						if (win) {winstreak++;}
						gameActive = false;
						
					} else if (input.equals("f")) {
						System.out.print("You forfeited. \nYour opponents cards: ");
						outPutHand(a, round);	
						gameActive = false;
					}
					
					// Opponent turn 
					if (calcRes(a)< 19) {
						a[round] = getRandomInt();
					} else {
						a[round] = 0;
					}
					
					
					
				}
	
				// STEP 3 -
				System.out.println("Your winstreak: " + winstreak + "\n\nWould you like to play again? (y/n)");
				while (!input.equals("n") && !input.equals("y")) {
					input = into.nextLine();
					if (input.equals("n")) {
						exit = true;
					}

				}
			} 
		}
	}

	
	
	private static boolean playerWin(int[] c, int[] a) {
		int cScore = calcRes(c);
		int aScore = calcRes(a);
		
		if (cScore > 21 && aScore > 21) {
			System.out.print("Its a draw, you're both over 21. ");
			return false;
		} else if (cScore > 21) { 
			System.out.print("You lose, your total is above 21. ");
			return false;
		} else if (aScore > 21) { 
			System.out.print("You win, your opponents total is above 21. ");
			return true;
		} else if (cScore < aScore) {
			System.out.print("You lose, your total is lower than your opponents. ");
			return false;
		} else {
			System.out.print("You win, your total is higher than your opponents. ");
			return true;
		}
		
	}


	public static void outPutHand(int[] b, int round) {
		int Score = calcRes(b);
		if (round == 6) {round = 5;}
		
		System.out.print("(total: " + Score + ") ");
		
		for (int i = 0; i<=round-1; i++) {
			System.out.print("[" + b[i] + "] ");
		}
		if (round < 5) {
		System.out.print("[" + b[round] + "] ");
		}
		System.out.println();
	}


	private static String getUserMove(Scanner into) {
		System.out.println("[d] draw card  [p] pass turn  [c] challenge  [f] forfeit");
		String input = into.nextLine();
		return input;
	}


	private static int calcRes(int[] arr) {
		return IntStream.of(arr).sum();
	}

	
	private static int getRandomInt() {
		return (int) (Math.random() * 11 + 1);
	}
	
}



/*
 * ++Winstreak! Welcome d to draw > get 2 random (always below 21) > Ai gets a
 * random numer (6-20)
 * 
 * while d to draw - p to pass - f to forfeit - c to challenge/compare d > get 1
 * random (1-11) each round ai might get another card or forfit f > wanna play
 * again? c > show all cards of player and ai announce winner wanna play again?
 * 
 * always compare after 5 cards
 */