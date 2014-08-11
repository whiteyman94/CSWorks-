package hashing;

import java.io.*;
import java.util.*;

public class Hashing {
	static int size = 600000;
	static int result = 0;
	static int modulo = 0;
	static int uniqueNum = 0;
	// this is the size of the hash table
	static String[] hashTable = new String[size];
	static String[] array = new String[216555];

	public static void main(String[] args) throws IOException {
		File testFile = new File("dictionary.txt");
		getContents(testFile);
		System.out
				.println("Which type of open addressing would you like to use?");
		System.out.println("1) Linear Probing");
		System.out.println("2) Quadratic Probing");
		System.out.println("3) Double Hashing");
		Scanner in = new Scanner(System.in);
		int strategy = in.nextInt();
		// the user enters a number for the hashing strategy they want to use
		switch (strategy) {
		case 1:
			fillLinearProbing();
			break;
		case 2:
			fillQuadraticProbing();
			break;
		case 3:
			fillDoubleHash();
			break;
		}
		in.nextLine();
		System.out.print("\nEnter a word to find: ");
		String word = in.nextLine();
		while (!word.equals("quit")) {
			find(word, strategy);
			System.out.print("\nEnter a word to find: ");
			word = in.nextLine();
			// the user is asked to enter words to search for until they enter
			// the word 'quit'
		}
	}

	public static void find(String word, int strategy) {
		// this method takes in a word to look for and the strategy by which it
		// has been placed in the hash table
		int probes = 1;
		int index = getHashKey(word);
		// calculate the hash key for the word
		System.out.println();
		while (hashTable[index] != null && !hashTable[index].equals(word)) {
			System.out.println("Checking slot " + index + "...collision with "
					+ hashTable[index]);
			// as long as you do not stumble across either the word or a blank
			// keep searching
			if (strategy == 1) {
				// depending on the strategy go up in linear jumps, quadratic
				// jumps or the double hash jump
				index++;
				probes++;
				index = index % size;
				// always mod the index size so it doesn't go out of bounds
			} else if (strategy == 2) {
				index = index + (probes * probes);
				probes++;
				index = index % size;
			} else if (strategy == 3) {
				index = index + getDoubleHashKey(word);
				probes++;
				index = index % size;
			}
		}
		if (hashTable[index] == null) {
			System.out.println("NOT IN HASHTABLE");
			// if you've found a space then the word cannot be in the hash table
		} else {
			System.out.println("The word " + word + " was found in slot "
					+ index + " of the hashtable");
		}
		System.out.println("Number of hash table probes: " + probes);
		// print out the total number of attempts to find the correct slot
	}

	public static int getHashKey(String word) {
		for (int i = 0; i < word.length(); i++) {
			int ASCIIval = (int) word.charAt(i);
			int power = modPow(256, i, 216555);
			modulo = modMult(ASCIIval, power, size);
			result += modulo;

		}
		result = result % size;
		return result;

	}

	public static int getDoubleHashKey(String word) {
		for (int i = 0; i < word.length() - 1; i++) {
			int num = (int) word.charAt(i);
			uniqueNum += num;
		}
		int jumpsize = size - (uniqueNum % size);
		return jumpsize;
	}

	public static void fillLinearProbing() {
		int totalcollisions = 0;
		for (int i = 0; i < array.length; i++) {
			int collisions = 0;
			int index = getHashKey(array[i]);
			// generate a hash key
			while (hashTable[index] != null) {
				// if that slot is already filled move onto the next slot and
				// increment the collisions
				collisions++;
				index++;
				index = index % size;
				// make sure you don't go off the edge of the hash table
			}
			hashTable[index] = array[i];
			if (i % 100 == 0) {
				System.out.println(array[i] + " was placed in slot " + index
						+ " of the hash table after " + collisions
						+ " collisions");
			}
			totalcollisions += collisions;
			// print out the information for the last 1,000 words only
		}
		System.out.println("The total number of collisions was "
				+ totalcollisions);
	}

	public static void fillQuadraticProbing() {
		int totalcollisions = 0;
		for (int i = 0; i < array.length; i++) {
			int collisions = 0;
			int index = getHashKey(array[i]);
			int queries = 1;
			while (hashTable[index] != null) {
				collisions++;
				index = index + (queries * queries);
				index = index % size;
				queries++;
			}
			hashTable[index] = array[i];
			if (i % 100 == 0) {
				System.out.println(array[i] + " was placed in slot " + index
						+ " of the hash table after " + collisions
						+ " collisions");
			}
			totalcollisions += collisions;
		}
		System.out.println("The total number of collisions was "
				+ totalcollisions);
	}

	public static void fillDoubleHash() {
		int totalcollisions = 0;
		for (int i = 0; i < array.length; i++) {
			int collisions = 0;
			int index = getHashKey(array[i]);
			int doubleHash = getDoubleHashKey(array[i]);
			while (hashTable[index] != null) {
				collisions++;
				index = index + doubleHash;
				index = index % size;
			}
			hashTable[index] = array[i];
			if (i % 100 == 0) {
				System.out.println(array[i] + " was placed in slot " + index
						+ " of the hash table after " + collisions
						+ " collisions");
			}
			totalcollisions += collisions;
		}
		System.out.println("The total number of collisions was "
				+ totalcollisions);
	}

	public static int modPow(int number, int power, int modulus) {
		if (power == 0)
			return 1;
		else if (power % 2 == 0) {
			int halfpower = modPow(number, power / 2, modulus);
			return modMult(halfpower, halfpower, modulus);
		} else {
			int halfpower = modPow(number, power / 2, modulus);
			int firstbit = modMult(halfpower, halfpower, modulus);
			return modMult(firstbit, number, modulus);
		}
	}

	public static int modMult(int first, int second, int modulus) {
		if (second == 0)
			return 0;
		else if (second % 2 == 0) {
			int half = modMult(first, second / 2, modulus);
			return (half + half) % modulus;
		} else {
			int half = modMult(first, second / 2, modulus);
			return (half + half + first) % modulus;
		}
	}

	public static String getContents(File aFile) {
		StringBuffer contents = new StringBuffer();
		BufferedReader input = null;
		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!
			input = new BufferedReader(new FileReader(aFile));
			String line = null; // not declared within while loop
			int i = 0;
			while ((line = input.readLine()) != null) {
				array[i] = line;
				i++;
				contents.append(System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return contents.toString();
	}

	public static void setContents(File aFile) throws FileNotFoundException,
			IOException {
		Writer output = null;
		try {
			output = new BufferedWriter(new FileWriter(aFile));
			int i = 0;
			while (array[i] != null) {
				output.write(array[i]);
				output.write(System.getProperty("line.separator"));
				i++;
			}
		} finally {
			if (output != null)
				output.close();
		}
	}
}
