
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
		if(size == 0) {
			firstNode = new Node("String", null, null);
			previousNode = firstNode;
		}
		else {
			Node targetNode = firstNode;
			for(int j = 0; j < i &&  j < size; j++) {
				targetNode = targetNode.next;
			}
			
		}
		size++;
		//change pointers of neighbour and node being replaced to this node
		
	}

	public String get(int i) {
		return null;
	}

	public void remove(int i) {
		//removing a node will set the neighbour's pointers to each other
		size--;
	}

	public void clear() {
		size = 0;
		
	}

	public void set(int i, String string) {
		//This should only have to change the value at the given node not create a new node
	}

	
}
