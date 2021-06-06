package AdvancedLevel;

import java.util.Scanner;

public class DistanceTwoPoints {

	public static void main(String[] args) {

		int x1, x2;
		int y1, y2;
		double distance;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter x1 point: ");
		x1 = scanner.nextInt();

		System.out.println("Enter x2 point: ");
		x2 = scanner.nextInt();

		System.out.println("Enter y1 point: ");
		y1 = scanner.nextInt();

		System.out.println("Enter y2 point: ");
		y2 = scanner.nextInt();

		distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		System.out.println("Distance between two points : " + distance);
	}

}
