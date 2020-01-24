// Student ID: 20315409

public class String_List {
	// A private class (You can even eventually make it an inner class
	class Node {
		public String data;
		public Node next;

		public Node(String s, Node n) {
			data = s;
			next = n;
		}
	}

	Node _head, _tail, _prev_to_curr;
	int _size;

	public String_List() {
		Node x = new Node("_LIST_SENTINEL_", null);
		_head = x;
		_prev_to_curr = x;
		_tail = x;
		_size = 0;
	}

	public String_List insert_at_curr(String s) {
		Node xia = _prev_to_curr.next;
		_prev_to_curr.next = new Node(s, xia);
		_size++;
		while (_tail.next != null) {
			_tail = _tail.next;
		}
		return this;
	}

	public String_List push_back(String s) {
		Node x = _prev_to_curr;
		_prev_to_curr = _tail;
		insert_at_curr(s);
		_prev_to_curr = x;
		return this;
	}

	public String_List push_front(String s) {
		Node h = _prev_to_curr;
		_prev_to_curr = _head;
		insert_at_curr(s);
		_prev_to_curr = h;
		return this;
	}

	public String_List advance_curr_to_next() {
		if (_prev_to_curr.next == null) {
			return null;
		}
		_prev_to_curr = _prev_to_curr.next;
		return this;
	}

	public String get_current_item() {
		String current = _prev_to_curr.next.data;
		if (_prev_to_curr.next == null) {
			return null;
		}
		return current;
	}

	public String_List remove_at_curr() {
		_prev_to_curr.next = _prev_to_curr.next.next;
		while (_tail.next != null) {
			_tail = _tail.next;
		}
		_size--;
		return this;
	}

	public int get_size() {
		return _size;
	}

	public String_List rewind() {
		_prev_to_curr = _head;
		return this;
	}

	public void clear() {
		_prev_to_curr = _head;
		_tail = _head;
		_head.next = null;
		_size = 0;
	}

	public String find_item(String s) {
		_prev_to_curr = _head;
		if (_head.data.equals(s)) {
			return _head.data;
		}
		for (int i = 0; i < _size; i++) {
			if (get_current_item().equals(s)) {
				return get_current_item();
			}
			advance_curr_to_next();
		}
		return null;
	}

	public String to_string() {
		String start = "String_List: " + _size + " entries total. Starting at cursor:\n";
		_prev_to_curr = _head;
		if (_size > 25) {
			for (int i = 0; i < 25; i++) {
				start += get_current_item() + "\n";
				advance_curr_to_next();
			}
			start += "...";
		} else {
			for (int i = 0; i < _size; i++) {
				start += get_current_item() + "\n";
				advance_curr_to_next();
			}
		}
		return start;
	}
}
