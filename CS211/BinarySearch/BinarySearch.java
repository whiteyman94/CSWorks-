
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input the highest number:");
		int upperBound = in.nextInt();

		System.out.println("Ok, pick a random number between 1 and "
				+ upperBound + ". Are you ready?");
		String response = in.next();

		int lowerBound = 0;
		int tries = 0;

		int guess = (upperBound + lowerBound) / 2;
		long start = System.currentTimeMillis();

		while (!response.equals("correct")) {
			System.out.println("I guess " + guess);
			response = in.next();

			if (response.equals("lower")) {
				upperBound = guess;
				guess = (lowerBound + upperBound) / 2;

			} else {
				lowerBound = guess;
				guess = (lowerBound + upperBound) / 2;

			}
			tries++;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("I got it in " + tries + " guesses in " + time
				+ " ms");
	}
}
