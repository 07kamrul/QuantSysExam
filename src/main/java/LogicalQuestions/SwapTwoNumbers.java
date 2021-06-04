package LogicalQuestions;

public class SwapTwoNumbers {

	public static void main(String[] args) {

		int x = 10;
		int y = 5;
		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println("Swap two numbers without using temp: " + "x = " + x + ", y = " + y);
	}

}
