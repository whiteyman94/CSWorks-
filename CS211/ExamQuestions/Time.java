package Exam;

import java.util.Scanner;

public class Time {

	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a number u would like to check");
		int num=input.nextInt();
		System.out.println(percentClock(num));
	}

	public static float percentClock(int inSum) {
		final int hourLimit = 24;
		final int minuteLimit = 60;
		final int totalTimes = hourLimit * minuteLimit; // 24 * 60
		int above = 0;
		for (int hours = 0; hours < hourLimit; ++hours) {
			for (int minutes = 0; minutes < minuteLimit; ++minutes) {
				if (inSum < clockSum(hours, minutes))
					++above;
			}
		}
		return (float) above / (float) totalTimes;
	}

	private static int clockSum(int hours, int minutes) {
		return (hours / 10) + (hours % 10) + (minutes / 10) + (minutes % 10);
	}

}
