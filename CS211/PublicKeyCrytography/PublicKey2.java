package publicKey;

public class PK2 {

	public static void main(String args[]) {
		long P = 29;
		long G = 2;
		long GmodP = 3;
		long PK = 5;
		long C1 = 23;
		long C2 = 17;
		long x = P - 1 - PK;
		long result1 = modPow(C1, x, P);
		System.out.println(result1);
		long message = (result1) * (C2 % P);
		System.out.println(message);

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
