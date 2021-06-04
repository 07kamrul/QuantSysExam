package LogicalQuestions;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String strInput = sc.nextLine();
		int len = strInput.length();
		String strReverse = "";
		System.out.println("Reverse String:");

		for (int a = len - 1; a >= 0; a--) {
			strReverse = strReverse + strInput.charAt(a);
		}
		System.out.println(strReverse);
		sc.close();
	}

}
