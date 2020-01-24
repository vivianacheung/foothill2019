// Student ID: 20315409

import java.util.Vector;

public class Stack_String {
	private Vector<String> _data;

	Stack_String() {
		_data = new Vector<String>();
	}

	public boolean is_empty() {
		return _data.isEmpty();
	}

	public int size() {
		return _data.size();
	}

	public void push(String value) {
		_data.add(value);
	}

	// You can take advantage of Java's int/Integer auto-conversion
	// features and use the object to signal failure (i.e. top of
	// empty stack)
	public String top() {
		if (!_data.isEmpty()) {
			return _data.lastElement();
		}
		return null;
	}

	public String pop() {
		if (!_data.isEmpty()) {
			String x = _data.lastElement();
			_data.remove(x);
			return x;
		}
		return null;
	}

	public String toString() {
		String first = "Stack (" + _data.size() + " elements):";
		String mid = "";
		int count = 0;
		while (!_data.isEmpty() && count < 10) {
			mid += "\n" + pop();
			count++;
		}
		if (_data.size() > 10) {
			mid += "\n...";
		}
		String end = "\nElements, if listed above, are in increasing order of age.";
		return first + mid + end;
	}

	public Vector<String> get_data() {
		return _data;
	}
}
