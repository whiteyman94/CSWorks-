package haversine;

import java.util.Scanner;

public class Main {
	static Scanner input;
	static double radius = 6372.8;
	static double StatLon = -74.0445004;
	static double StatLat = 40.6892494;

	public static void main(String args[]) {
		input = new Scanner(System.in);
		System.out
				.println("Enter the longitude of your first position in degrees: ");
		double lon1 = input.nextDouble();
		System.out
				.println("Enter the latitude of your first position in degrees: ");
		double lat1 = input.nextDouble();

		lat1 = Math.toRadians(lat1);
		StatLat = Math.toRadians(StatLat);

		double dLat = Math.toRadians(StatLat - lat1);
		double dLon = Math.toRadians(StatLon - lon1);

		double haversine1 = Math.sin(dLat) * Math.sin(dLat);
		haversine1 = (haversine1 / 2);

		double haversine2 = Math.sin(dLon) * Math.sin(dLon);
		haversine2 = (haversine2) / 2;

		double dlon1 = Math.cos(lat1);
		double dlon2 = Math.cos(StatLat);

		haversine2 = (dlon1) * (dlon2) * (haversine2);

		double result = Math.sqrt(haversine1 + haversine2);
		result = Math.asin(result);
		result = 2 * radius * result;
		System.out.println(result);

	}

}

