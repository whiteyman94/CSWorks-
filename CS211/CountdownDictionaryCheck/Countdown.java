package countdown;

import java.io.*;

public class FileIO {

	public String[] load(String file) {
		File aFile = new File(file);
		StringBuffer contents = new StringBuffer();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(aFile));
			String line = null;
			int i = 0;
			while ((line = input.readLine()) != null) {
				contents.append(line);
				i++;
				contents.append(System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException ex) {
			System.out
					.println("Can't find the file - are you sure the file is in this location: "
							+ file);
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Input output exception while processing file");
			ex.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException ex) {
				System.out
						.println("Input output exception while processing file");
				ex.printStackTrace();
			}
		}
		String[] array = contents.toString().split("\n");
		return array;
	}

	public void save(String file, String[] array) throws FileNotFoundException,
			IOException {

		File aFile = new File(file);
		Writer output = null;
		try {
			output = new BufferedWriter(new FileWriter(aFile));
			for (int i = 0; i < array.length; i++) {
				output.write(array[i]);
				output.write(System.getProperty("line.separator"));
			}
		} finally {
			if (output != null)
				output.close();
		}
	}
}



package countdown;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		FileIO reader = new FileIO();
		String[] contents = reader.load("C:\\dictionary.txt");
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter the string of random letters");
		String input = myScanner.nextLine();
		int biggest = 0;
		ArrayList<String> myList = new ArrayList<String>();
		for (int i = 0; i < contents.length; i++) {
			int length = check(input,
					contents[i].substring(0, contents[i].length() - 1));

			if (length > biggest) {
				biggest = length;
				myList.clear();
				myList.add(contents[i]);
			} else if (length == biggest) {
				myList.add(contents[i]);
			}
		}
		System.out.println("The longest word that can be formed is one with "
				+ biggest + " letters:");
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
	}

	public static int check(String letters, String word) {

		for (int i = 0; i < word.length(); i++) {
			if (!letters.contains("" + word.charAt(i))) {
				return -1;
			}
			letters = letters.replaceFirst("" + word.charAt(i), " ");
		}
		return word.length();
	}
}
