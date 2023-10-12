import java.util.Scanner;

public class PasswordGame {

	public static void main(String[] args) {
		
		Scanner In = new Scanner(System.in);
		System.out.println("Welcome to the Password Game! \nType start to start.");
		
		String lastInput = In.nextLine(); 
		int miss = 0;
		int correct = 0; 
		
		String answers[] = {"start","L","{","9","$","5"};
		String hint[] = {
				"The password has 5 characters. \nHint 1: The first character is the 12th letter in upper case. (Type the soultion to proceed)",
				"Correct! L _ _ _ _ \nHint 2: The next character is an opening brace",
				"Correct! L { _ _ _ \nHint 3: The next character is the result of this math problem: 210/35+15*0,2",
				"Correct! L { 9 _ _ \nHint 4: The next character is a common currency symbol that isnt euro.",
				"Correct! L { 9 $ _ \nHint 5: The next character is the digit sum of the digit sum of 4672841",
				"Correct! L { 9 $ 5 \nYou guessed the password! GG! :D",
		};

		for (boolean gameEnd = false; !gameEnd; lastInput = In.nextLine()) {
			if (lastInput.equals(answers[correct % 6])) {  
				//  Through the % there's always 0-5 as a result so we never leave the options in the array 
				System.out.println(hint[correct++ % 6]); 	
				// The ++ gets applied after the % gets calculated 
			} else if (lastInput.equals("L{9$5") && correct >= 1) {
				System.out.println("Correct! \nYou guessed the passwort... and cheated! :/");
				correct = 6; 	
			} else if (correct >= 1 && correct < 6){
				miss++;
				System.out.print("Wrong. " + miss + "/3 incorrect tries remaining.\n");
				if (miss > 2) {
					gameEnd = true;
					System.out.print("Too many failed attempts. GAME OVER - Press ctrl+F11\n");
				}
			}
		
		}
		In.close();
	}

}


/*
	There's at least 1 correct password 
	There a hint given with leads to more hints to then find out the password 
	Is the correct password typed it says success 
*/ 