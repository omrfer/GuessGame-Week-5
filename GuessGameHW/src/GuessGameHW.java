import java.util.Scanner;
import java.util.Random;

public class GuessGameHW {

	// Author @ Omar Fernandez

	public static void main(String[] args) {
		Random rnumber = new Random();
		Scanner input = new Scanner(System.in);
		int cpunum = rnumber.nextInt(10);
		// System.out.println(cpunum); rnumber test
		int guess, x, a = 0, games = 0;
		double goodguess = 0, badguess = 0, totalgood = 0, totalguess = 0;
		String repeat;
		System.out.printf(
				"Let's play guess the random number.%nThe computer will generate a random number between 0-9.%nWhat do you think the number is?");
		do {

			guess = input.nextInt();
			if (guess < 0 || guess > 9) {
				badguess++;
				System.out.println("Not a valid choice. You lose.");
			} else if (cpunum == guess) {
				games++;
				goodguess++;
				totalguess = totalguess + goodguess + badguess;
				totalgood = totalgood + goodguess;
				System.out.printf("That is the correct number.%n");
				System.out.printf(
						"Your correct guess percentage this game was %f.%nYour overall guess percentage is %f.%nThat was game number %d.%n",
						goodguess / (goodguess + badguess), totalgood / totalguess, games);
				goodguess = 0;
				badguess = 0;
				cpunum = rnumber.nextInt(10);
				// fixes random number staying the same
				a = 1;
				// Used to indicate that a new number has been generated line 51
			} else if (cpunum > guess) {
				badguess++;
				System.out.println("That number is too small.");
			} else {
				badguess++;
				System.out.println("That number is too big.");

			}
			System.out.println("Would you like to keep playing? Enter Y or yes to continue.");
			repeat = input.next();
			if (repeat.equalsIgnoreCase("Y") || repeat.equalsIgnoreCase("yes")) {
				x = 1;
				if (a == 1) {
					System.out.println("A new random number between 0-9 has been generated.");
					a = 0;
				}
			} else {
				x = 2;
				System.out.printf("Goodbye.%nYour overall guess percentage was %f.", totalgood / totalguess);
			}
		} while (x == 1);
	}
}
// Good job, Omar.
