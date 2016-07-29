package GuessANumber;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {

	public static int gettingRandomNumber() {
		Random rand = new Random();
		int randomNum = rand.nextInt(100) + 1;
		return randomNum;
	}

	public static boolean outsideRange(int x) {
		boolean validate = false;
		if (x < 1 && x > 100) {
			validate = true;
		} else {
			validate = false;
		}
		return validate;
	}

	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		String playAgain = "yes";
		int count = 0;
		int randomNumber = gettingRandomNumber();
		System.out.println("Welcome to the Guess A Number Game! \n");

		while (playAgain.equalsIgnoreCase("yes")) {

			int guess = 0;
			while (guess != randomNumber) {

				count++;
				System.out.println("Please enter a number between 1 and 100:");
				guess = scan1.nextInt();
				scan1.nextLine();

				if (outsideRange(guess)) {
					System.out.println("That number is not between 1 and 100.");
					continue;
				}

				if (guess - randomNumber > 10) {
					System.out.println("Your guess is way too high!");
				} else if (randomNumber - guess > 10) {
					System.out.println("Your guess is way too low!");
				} else if (guess > randomNumber) {
					System.out.println("Your guess is too high!");
				} else if (guess < randomNumber) {
					System.out.println("Your guess is too low!");
				} else if (guess == randomNumber) {
					switch (count) {
					case 1:
					case 2:
					case 3:
					case 4:
						System.out.println("Yes!!! You got it this time in " + count + " tries.  Great job!");
						break;
					case 5:
					case 6:
					case 7:
					case 8:
						System.out.println("You got it in " + count + " tries. Not bad.");
						break;
					default:
						System.out.println("You got it in " + count + " tries. You need to brush up on your guessing.");
						break;
					}
				}
			}

			System.out.println("Do you want to play again? Enter yes or no");
			playAgain = scan1.nextLine();
			if (playAgain.equalsIgnoreCase("no")) {
				System.out.println("Goodbye!");
			}
		}
		scan1.close();
	}

}
