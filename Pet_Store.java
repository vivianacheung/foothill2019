// Student ID: 20315409

import java.util.Vector;
import java.util.Comparator;
import java.util.Random;

public class Pet_Store {
	private Vector<Pet> _pets;

	Pet_Store(int capacity) {
		_pets = new Vector<Pet>(capacity);
		_sort_order = _SORT_ORDER.NONE;
	}

	public Pet get_pet(int index) {
		return _pets.get(index);
	}

	public int get_size() {
		return _pets.size();
	}

	public void set_size(int size) {
		_pets.setSize(size);
	}

	public void clear() {
		_pets.clear();
	}

	public void populate_with_n_random_pets(int n, Random rand_gen) {
		Pet.get_n_pets(n, _pets, 7, rand_gen);
		_sort_pets_by_id();
	}

	public Pet find_pet_by_id_lin(long id) {
		for (int i = 0; i < _pets.size(); i++) {
			long _id = _pets.get(i).get_id();
			if (_id == id) {
				return _pets.get(i);
			}
		}
		return null;
	}

	public Pet find_pet_by_id_bin(long id) {
		_sort_pets_by_id();
		int max = _pets.size();
		int low = 1;
		while (low <= max) {
			int mid = (low + max) / 2;
			if (_pets.get(mid).get_id() == id) {
				return _pets.get(mid);
			} else if (_pets.get(mid).get_id() > id) {
				max = mid - 1;
			} else if (_pets.get(mid).get_id() < id) {
				low = mid + 1;
			}
		}
		return null;
	}

	public Pet find_pet_by_name_lin(String name) {
		for (int i = 0; i < _pets.size(); i++) {
			String _name = _pets.get(i).get_name();
			if (_name.equals(name)) {
				return _pets.get(i);
			}
		}
		return null;
	}

	public Pet find_pet_by_name_bin(String name) {
		_sort_pets_by_name();
		int low = 0;
		int max = _pets.size() - 1;
		while (low <= max) {
			int mid = (low + max) / 2;
			int result = _pets.get(mid).get_name().compareTo(name);
			if (result == 0) {
				return _pets.get(mid);
			} else if (result > 0) {
				max = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return null;
	}

	// Return a string with the concatenated string reps of pets with
	// indexes n1 to n2 (inclusive)
	String toString(int n1, int n2) {
		String pets = "";
		int diff = n2 - n1;
		for (int i = 0; i <= diff; i++) {
			pets += _pets.get(n1 + i).toString() + '\n';
		}
		return pets;
	}

	public enum _SORT_ORDER {
		BY_ID, BY_NAME, NONE
	};

	public _SORT_ORDER _sort_order = _SORT_ORDER.BY_ID;

	private void _sort_pets_by_id() {
		_pets.sort(new Comparator<Pet>() {
			public int compare(Pet p1, Pet p2) {
				return (int) (p1.get_id() - p2.get_id());
			}
		});
		_sort_order = _SORT_ORDER.BY_ID;
	}

	private void _sort_pets_by_name() {
		_pets.sort(new Comparator<Pet>() {
			public int compare(Pet p1, Pet p2) {
				return p1.get_name().compareTo(p2.get_name());
			}
		});
		_sort_order = _SORT_ORDER.BY_NAME;
	}

	public Vector<Pet> get_pets() {
		return _pets;
	}

	public int get_sort_order() {
		if (_sort_order == _SORT_ORDER.BY_ID) {
			return 0;
		}
		if (_sort_order == _SORT_ORDER.BY_NAME) {
			return 1;
		}
		return -1;
	}
}
