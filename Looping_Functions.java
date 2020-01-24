// Student ID: 20315409

import java.util.Scanner;

public class Looping_Functions {

	// Give the user 6 chances to guess the secret number n (0-10). If they get
	// it, say so and return true. Else say so and return false.
	public static boolean play_game(int secret) {
		Scanner input = new Scanner(System.in);
		System.out.println("\nWelcome to my number guessing game\n");
		for (int i = 1; i < 7; i++) {
			System.out.println("Enter your guess:");
			String g = input.nextLine();
			int guess = Integer.parseInt(g);
			System.out.println("You entered: " + guess);
			if (guess == secret) {
				System.out.println("You found it in " + i + " guess(es).\n");
				return true;
			}
		}
		System.out.println("\nI'm sorry. You didn't find my number.");
		System.out.println("It was " + secret);
		return false;
	}

	// Calculate e^x using the series summation up to exactly the first
	// n terms including the 0th term.
	// Note that each term is simply x/n times the previous term.
	public static double etox(double x, int n) {
		double e = 1;
		for (int i = n; i > 0; i--) {
			e = 1 + x * (e / i);
		}
		return e;
	}

	// Return the number of occurrences of char c in string s
	public static int count_chars(String s, char c) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	// Use Euclid's algorithm to calculate the GCD of the given numbers
	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		return b;
	}

	// Return a string of the form n1, n2, n3,... for the given AP.
	public static String get_ap_terms(int a, int d, int n) {
		String terms = "";
		for (int i = 0; i < n; i++) {
			terms += a + (i * d);
			if (i < n - 1) {
				terms += ",";
			}
		}
		return terms;
	}

	// Return a string of the form n1, n2, n3,... for the given GP.
	public static String get_gp_terms(double a, double r, int n) {
		String terms = "";
		for (int i = 0; i < n; i++) {
			double product = r;
			int count = 1;
			if (i == 0) {
				product = 1;
			}
			while (i > count) {
				double ratio = r;
				product *= ratio;
				count++;
			}
			terms += String.format("%.12g", a * product);
			if (i < n - 1) {
				terms += ",";
			}
		}
		return terms;
	}

	public static double get_nth_fibonacci_number(int n) {
		double first = 1, second = 1;
		double temp;
		if (n == 0) {
			return first;
		} else if (n == 1) {
			return second;
		}
		for (int i = 2; i < n; i++) {
			temp = second;
			second += first;
			first = temp;
		}
		return second;
	}
}
