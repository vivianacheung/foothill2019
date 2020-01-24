// Student ID: 20315409

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Eliza {
	/**
	 * rotate_vowels(String s) replaces each vowel in s by its vowel-successor.
	 * 
	 * @return a new string in which the letters a, e, i, o, and u in each casing
	 *         have been replaced by the next vowel in the sequence. u is replaced
	 *         by a.
	 */
	public static String rotate_vowels(String s) {
		char[] vowels = { 'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U', 'a', 'A' };
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < vowels.length; j++) {
				if (s.charAt(i) == vowels[j]) {
					s = s.substring(0, i) + vowels[j + 2] + s.substring(i + 1);
					break;
				}
			}
		}
		return s;
	}

	/**
	 * Return a string in which all occurrences of parameter string s have been
	 * replaced by "th".
	 */
	public static String lispify(String s) {
		s = s.replace("s", "th");
		s = s.replace("S", "Th");
		return s;
	}

	public static void enter(Random random_gen) {
		System.out.println("What?");
		Scanner scan = new Scanner(System.in);
		String input = "";
		do {
			input = scan.nextLine();
			System.out.println("    " + input + "\n");
			if (input == "") {
				System.out.println("What?");
				continue;
			}
			if (input.contains("!")) {
				System.out.println("OMG! You don't say!! " + input + "!!!!!");
				continue;
			}
			if (input.contains("why") || input.contains("what")) {
				System.out.println("I'm sorry, I don't like questions that contain what or why.");
				continue;
			}
			if (input.contains("s")) {
				System.out.println("Interethting. When did you thtop thtopping your thibilanth?");
				System.out.println(lispify(input) + "! Sheesh! Now what?");
				continue;
			}
			int random = random_gen.nextInt(10);
			if (random == 8 || random == 9) {
				System.out.println("Huh? Why do you say: " + input + "?");
			} else {
				System.out.println(rotate_vowels(input) + "?");
			}
			if (input.equalsIgnoreCase("bye") || input.equalsIgnoreCase("quit")) {
				System.out.println("Ok Bye. Nice being a force of change in your life.");
				break;
			}
		} while (!input.equalsIgnoreCase("bye") || !input.equalsIgnoreCase("quit"));
	}
}
