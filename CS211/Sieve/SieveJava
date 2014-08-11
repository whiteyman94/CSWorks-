package Sieve;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Please enter prime to find: ");
		int prime = in.nextInt();
		int size = (int) (prime * Math.log(prime) * 2);

		long start = System.currentTimeMillis();

		boolean[] sieve = new boolean[size];
		for (int i = 2; i < size; i++) {
			sieve[i] = true;

		}
		for (int i = 2; i < Math.sqrt(size); i++) {
			for (int j = i * i; j < size; j = j + i) {
				sieve[j] = false;
			}
		}
		int counter = 0;
		int slot = 1;
		while (counter < prime) {
			slot++;
			if (sieve[slot] == true) {
				counter++;
			}
		}

		long elapsed = System.currentTimeMillis() - start;
		System.out.println("The " + prime + "th prime number is " + slot);
		System.out.println("The answer took " + elapsed
				+ " milliseconds to computer");
	}
}
