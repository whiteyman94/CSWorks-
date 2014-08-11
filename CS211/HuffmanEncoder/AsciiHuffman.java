package asciiHuffman;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your sentence: ");
		String sentence = input.nextLine();
		String binaryString = "";
		for (int i = 0; i < sentence.length(); i++) {
			int decimalValue = (int) sentence.charAt(i);
			String binaryValue = Integer.toBinaryString(decimalValue);
			for (int j = 7; j > binaryValue.length(); j--) {
				binaryString += "0";
			}
			binaryString += binaryValue + " ";

		}
		System.out.println(binaryString);

		int[] array = new int[256];

		for (int i = 0; i < sentence.length(); i++) {
			array[(int) sentence.charAt(i)]++;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				System.out.println("'" + (char) i + "' appeared " + array[i]
						+ " times");
			}
		}

	}

}
