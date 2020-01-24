// Student ID: 20315409

public class Branching_Functions {
	// This function returns the average of the three numbers
	// passed in as parameters. Note that the average may not be
	// a round number. So you must use the double datatype for it.
	public static double mean_of_3(int n1, int n2, int n3) {
		return (n1 + n2 + n3) / 3.0;
	}

	// This function must return the maximum of the 5 given numbers
	public static int max_of_5(int n1, int n2, int n3, int n4, int n5) {
		int max = n1;
		if (n2 > max) {
			max = n2;
		}
		if (n3 > max) {
			max = n3;
		}
		if (n4 > max) {
			max = n4;
		}
		if (n5 > max) {
			max = n5;
		}
		return max;
	}

	// This function must return the minimum of the 5 given numbers
	public static int min_of_5(int n1, int n2, int n3, int n4, int n5) {
		int min = n1;
		if (n2 < min) {
			min = n2;
		}
		if (n3 < min) {
			min = n3;
		}
		if (n4 < min) {
			min = n4;
		}
		if (n5 < min) {
			min = n5;
		}
		return min;
	}

	// given three lengths, this function should return whether they can be the
	// sides of some triangle.
	public static boolean sides_make_triangle(int a, int b, int c) {
		if (a < c && b < c) {
			if (a + b >= c) {
				return true;
			}
			return false;
		} else if (c < a && b < a) {
			if (c + b >= a) {
				return true;
			}
			return false;
		}
		if (a + c >= b) {
			return true;
		}
		return false;
	}

	// Given three angles as integer degrees, this function should return
	// whether they can be internal angles of some triangle. Treat extreme
	// cases as valid triangles.
	public static boolean angles_make_triangle(int A, int B, int C) {
		if (A + B + C == 180) {
			return true;
		}
		return false;
	}

	// look up the logic for telling leap years and implement it
	public static boolean is_a_leap_year(int yyyy) {
		if (yyyy % 4 == 0) {
			if (yyyy % 100 == 0) {
				if (yyyy % 400 == 0) {
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}
}
