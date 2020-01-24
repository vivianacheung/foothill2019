import java.util.Scanner;

public class Etox_5_Terms {
	private static double etox_5_terms(double x) {
		return 1 + x + (x * x / 2) + (x * x * x / 6) + (x * x * x * x / 24);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a value for x: ");
		double answer = input.nextDouble();
		System.out.println(etox_5_terms(answer));
	}
}
