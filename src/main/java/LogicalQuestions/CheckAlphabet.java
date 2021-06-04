package LogicalQuestions;

import java.util.Scanner;

public class CheckAlphabet {

	public static void main(String[] args) {

		char ca;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an alphabat: ");

		String input = sc.next();
		ca = input.charAt(0);

		if ((ca >= 'a' && ca <= 'z') || (ca >= 'A' && ca <= 'Z')) {
			System.out.println(ca + " is an alphabat");
		} else {
			System.out.println(ca + " is not an alphabat");
		}
	}

}
