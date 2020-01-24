
public class Limerick {
	private static double eval_limerick(int dozen, int gross, int score) {
		return (dozen + gross + score + 3 * Math.sqrt(4)) / 7 + 5 * 11;
	}

	public static void main(String[] args) {
		int dozen, gross, score;
		if (args.length < 3) {
			System.err.println("Usage: limerick dozen-val gross-val score-val");
			System.exit(1);
		}
		dozen = Integer.parseInt(args[0]);
		gross = Integer.parseInt(args[1]);
		score = Integer.parseInt(args[2]);

		double x = eval_limerick(dozen, gross, score);
		System.out.println(x);
		return;
	}
}
