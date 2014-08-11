package Exam;

import java.util.Scanner;
import java.util.Random;

public class HeadTail {

	private static final int SomeBigNumber = 500000;
	private static final int Outcomes = 2;

	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of player1 coins");
		int num1=input.nextInt();
		System.out.println("Enter number of player2 coins");
		int num2=input.nextInt();
		System.out.println(coinFlip(num1,num2));
	}

	public static float coinFlip(int player1Coins, int player2Coins) {
		Random rand = new Random(System.currentTimeMillis());
		int player1Total = 0;
		int iterCount = 0;
		while (iterCount < SomeBigNumber) {
			int player1Heads = 0;
			int player2Heads = 0;
			for (int toss = 0; toss < player1Coins; ++toss)
				player1Heads += rand.nextInt(Outcomes);
			for (int toss = 0; toss < player2Coins; ++toss)
				player2Heads += rand.nextInt(Outcomes);
			if (player1Heads - player2Heads != 0) {
				++iterCount;
				if (player1Heads > player2Heads) {
					++player1Total;
				}
			}
		}
		return (float) player1Total / (float) SomeBigNumber;
	}

}
