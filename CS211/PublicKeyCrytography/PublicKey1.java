package pkc;

import java.util.*;

public class Main {

	public static void main(String args[]) {
		Scanner myscanner = new Scanner(System.in);
		System.out
				.println("You need the public key of the person you want to communicate with");
		System.out.println("Please input the modulus");
		long modulus = myscanner.nextLong();
		System.out.println("Please input the generator");
		long generator = myscanner.nextLong();
		System.out.println("Please input g^x mod p");
		long gx = myscanner.nextLong();

		// this is the brute force search part

		long current = generator;
		long power = 1;
		while (current != gx) {
			power = power + 1;
			current = modMult(current, generator, modulus);
			if (current >= modulus) {
				current = current % modulus;
			}
		}
		System.out.println("The key has been hacked by brute force: " + power);
		System.out.println("Please enter c1");
		long c1 = myscanner.nextLong();
		System.out.println("Please enter c2");
		long c2 = myscanner.nextLong();
		System.out.println("The ElGamal cipher is (" + c1 + ", " + c2 + ")");

		System.out.println("Please input your private key");
		long key = myscanner.nextLong();
		long divisor = modPow(c1, modulus - 1 - key, modulus);
		long quotient = modMult(divisor, c2, modulus);
		System.out.println("The message is " + quotient);

	}

	public static long modPow(long number, long power, long modulus) {
		if (power == 0)
			return 1;
		else if (power % 2 == 0) {
			long halfpower = modPow(number, power / 2, modulus);
			return modMult(halfpower, halfpower, modulus);
		} else {
			long halfpower = modPow(number, power / 2, modulus);
			long firstbit = modMult(halfpower, halfpower, modulus);
			return modMult(firstbit, number, modulus);
		}
	}

	public static long modMult(long first, long second, long modulus) {
		if (second == 0)
			return 0;
		else if (second % 2 == 0) {
			long half = modMult(first, second / 2, modulus);
			return (half + half) % modulus;
		} else {
			long half = modMult(first, second / 2, modulus);
			return (half + half + first) % modulus;
		}
	}

}
