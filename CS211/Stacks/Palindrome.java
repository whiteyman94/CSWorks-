package Palindrome;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the word to check:");
		String word = input.nextLine();
		Stack stack = new Stack(word);

		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}

		char[] s1 = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			s1[i] = stack.pop();

		}

		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			if(s1[i]==word.charAt(i)){
			}
			else{
				count=-1;
				break;
			}
			
		}
		
		if(count==-1){
			System.out.println("not a match");
		}
		else{
			for(int i=0;i<s1.length;i++){
				System.out.print(s1[i]);
			}
			System.out.print(" is a match to " + word);
		}
	}

}


package Palindrome;

public class Stack {

		private int maxSize;
		private char[] stackArray;
		private int top;

		public Stack(String s) {

			maxSize = s.length();
			stackArray = new char[maxSize];
			top = -1;
		}

		public void push(char c) {

			top++;
			stackArray[top] = c;
		}

		public char pop() {
			return stackArray[top--];
		}
		

	}




