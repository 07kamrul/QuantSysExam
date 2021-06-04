package LogicalQuestions;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = sc.nextInt();

		int firstNum = 0;
		int secondNum = 1;
		int i;
		for (i = 1; i <= n; ++i) {
			System.out.print(firstNum + ",");
			int nextNum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = nextNum;
		}
	}

}
