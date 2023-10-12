import java.util.Scanner;

public class PasswordGame {

	public static void main(String[] args) {
		
		Scanner In = new Scanner(System.in);
		System.out.println("Welcome to the Password Game! \nType start to start.");
		
		String lastInput = In.nextLine(); 
		String thePassword = "L????"; 
		int miss = 0;
		int correct = 0; 
		

		for (boolean gameEnd = false; !gameEnd; lastInput = In.nextLine()) {
			if (lastInput.equals("start") && correct == 0) {
				System.out.println("The password has 5 characters. "
						+ "\nHint 1: The first character is the 12th letter in upper case. (Type the soultion to proceed)");
				correct = correct + 1; 
			} else if (lastInput.equals("L") && correct == 1) {
				System.out.println("Correct! L _ _ _ _ \nHint 2: The next character is an opening brace");
				correct = correct + 1; 	
			} else if (lastInput.equals("{")  && correct == 2) {
				System.out.println("Correct! L { _ _ _ \nHint 3: The next character is the result of this math problem: 210/35+15*0,2");
				correct = correct + 1; 	
			} else if (lastInput.equals("9")  && correct == 3) {
				System.out.println("Correct! L { 9 _ _ \nHint 4: The next character is a common currency symbol that isnt euro.");
				correct = correct + 1; 	
			} else if (lastInput.equals("$")  && correct == 4) {
				System.out.println("Correct! L { 9 $ _ \nHint 5: The next character is the digit sum of the digit sum of 4672841");
				correct = correct + 1; 	
			} else if (lastInput.equals("5")  && correct == 5) {
				System.out.println("Correct! L { 9 $ 5 \nYou guessed the password! GG! :D");
				correct = correct + 1; 	
			} else if (lastInput.equals("L{9$5") && correct >= 1) {
				System.out.println("Correct! L { 9 $ 5 \nYou guessed the password! GG! :D");
				correct = 6; 	
			} else if (correct >= 1 && correct < 6){
				miss = miss + 1;
				System.out.print("Wrong. " + miss + "/3 incorrect tries remaining.\n");
				if (miss > 2) {
					gameEnd = true;
					System.out.print("Too many failed attempts. GAME OVER - Press ctrl+F11\n");
				}
			}
			
		}

	}

}


/*
	There's at least 1 correct password 
	There a hint given with leads to more hints to then find out the password 
	Is the correct password typed it says success 
*/ 