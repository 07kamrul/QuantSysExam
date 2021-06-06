package AdvancedLevel;

import java.util.Scanner;

public class CalculatePowerNumber {

	public static void main(String[] args) {

		int base;
		int expo;
		long result = 1;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter base number: ");
		base = scanner.nextInt();

		System.out.println("Enter exponent number :");
		expo = scanner.nextInt();

		while (expo != 0) {
			result *= base;
			--expo;
		}

		System.out.println("The calculated power of a number is : " + result);

	}

}
