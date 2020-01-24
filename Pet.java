// Student ID: 20315409

import java.util.Vector;
import java.util.Random;

public class Pet {
	private String _name;
	private long _id;
	private int _num_limbs;

	Pet() {
		_name = "";
		_id = -1;
		_num_limbs = 0;
	}

	Pet(String name, long id, int num_limbs) {
		_name = name;
		_id = id;
		_num_limbs = num_limbs;
	}

	public String get_name() {
		return _name;
	}

	public long get_id() {
		return _id;
	}

	public int get_num_limbs() {
		return _num_limbs;
	}

	public boolean set_name(String name) {
		if (!"".equals(name)) {
			_name = name;
			return true;
		}
		return false;
	}

	public boolean set_id(long id) {
		if (id >= 0) {
			_id = id;
			return true;
		}
		return false;
	}

	public boolean set_num_limbs(int num_limbs) {
		if (num_limbs >= 0) {
			_num_limbs = num_limbs;
			return true;
		}
		return false;
	}

	public String toString() {
		return "(Name: " + _name + ", ID: " + _id + ", Limb Count: " + _num_limbs + ")";
	}

	// Global helpers
	public boolean equals(Pet that) {
		return (_name.equals(that.get_name()) && _id == that.get_id() && _num_limbs == that.get_num_limbs());
	}

	// Fill in the supplied pets vector with n pets whose
	// properties are chosen randomly. Don't change this method
	// any more than absolutely necessary.
	public static void get_n_pets(int n, Vector<Pet> pets, int name_len, Random rand_gen) {
		if (pets == null)
			return;
		pets.removeAllElements();
		long prev_id = 0;
		for (int i = 0; i < n; i++) {
			long id = prev_id + 1 + rand_gen.nextInt(10);
			prev_id = id;
			int num_limbs = rand_gen.nextInt(9);
			pets.add(new Pet(make_a_name(name_len, rand_gen), id, num_limbs));
		}
	}

	// Public helper
	public static String make_a_name(int len, Random rand_gen) {
		String vowels = "aeiou";
		String consonants = "bcdfghjklmnpqrstvwxyz";
		String name = "";
		if (rand_gen.nextBoolean()) {
			name += consonants.charAt(rand_gen.nextInt(21));
			for (int i = 0; i < len - 1; i++) {
				if (i % 2 == 0) {
					name += vowels.charAt(rand_gen.nextInt(5));
				} else {
					name += consonants.charAt(rand_gen.nextInt(21));
				}
			}
		} else {
			name += vowels.charAt(rand_gen.nextInt(5));
			for (int i = 0; i < len - 1; i++) {
				if (i % 2 != 0) {
					name += vowels.charAt(rand_gen.nextInt(5));
				} else {
					name += consonants.charAt(rand_gen.nextInt(21));
				}
			}
		}
		return name;
	}
}
