public class LinkedList {
	int size = 0;
	Node previousNode;
	Node firstNode;
	
	
	
	public int size() {
		return size;
	}
	public void add(String string) {
		add(size, string);
	}
	
	public void add(int i, String string) {
		if(i > size || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			if(size == 0) {
				firstNode = new Node(string, null, null);
				previousNode = firstNode;
			}
			else {
				Node targetNode = firstNode;
				for(int j = 0; j < i - 1; j++) {
					targetNode = targetNode.next;
				}
				targetNode.next = new Node(string, targetNode, null);
			}
			size++;
		}
		
	}
	public String toString() {
		String string = "[" + firstNode.value;
		Node targetNode = firstNode.next;
		for (int i = 1; i < size; i++) {
			string +=", " + targetNode.value  ;
			targetNode = targetNode.next; 
		}
		string += "]";
		
		return string;
	}

	public String get(int i) {
		Node targetNode = firstNode;
		for (int j = 0; j < i; j++) {
			targetNode = targetNode.next;
		}
		return targetNode.value;
	}

	public void remove(int i) {
		//removing a node will set the neighbour's pointers to each other
		Node targetNode = firstNode;
		for (int j = 0; j < i; j++) {
			targetNode = targetNode.next;
		}		
		if(targetNode.previous != null) {
			targetNode.previous.next = targetNode.next;
		}
		else {
			firstNode = targetNode.next;
		}
		if(targetNode.next != null) {
			targetNode.next.previous = targetNode.previous;
		}
		size--;
	}

	public void clear() {
		size = 0;
		
	}

	public void set(int i, String string) {
		//This should only have to change the value at the given node not create a new node
	}

	
}
