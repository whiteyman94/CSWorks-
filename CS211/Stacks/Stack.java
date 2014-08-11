package stack;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a word to be reversed>>");
		String word=input.nextLine();
		Stack stack=new Stack(word);
		
		for(int i=0;i<word.length();i++){
			System.out.println("push " + word.charAt(i));
			stack.push(word.charAt(i));
		}
		
		System.out.print("reversed: ");
		for(int i=0;i<word.length();i++){
			System.out.print(stack.pop());
		}
	}

}



package stack;

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
		Display();
	}

	public char pop() {
		return stackArray[top--];
	}
	
	private void Display(){
		for(int i=stackArray.length-1;i>=0;i--){
			System.out.println("|_" + stackArray[i] + "_|");
		}
	}

}
