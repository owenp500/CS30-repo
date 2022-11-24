import java.util.ListIterator;
public class LinkedList implements ListIterator {
	private int size = 0;
	private int cursor = 0;
	Node firstNode;
	Node lastReturn;
	boolean x = true;
	
	
	
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
				lastReturn = firstNode;
			}
			else if (i == 0) {
				Node node = new Node(string, null, firstNode);
				firstNode.previous = node;
				firstNode = node;
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
		String string = "[";
		if(firstNode != null) {
			string+= firstNode.getValue();
			Node targetNode = firstNode.next;
			for (int i = 1; i < size; i++) {
				string +=", " + targetNode.value  ;
				targetNode = targetNode.next; 
			}
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
		firstNode = null;
		size = 0;
		
	}

	public void set(int i, String string) {
		Node targetNode = firstNode;
		for(int j = 0; j < i; j++) {
			targetNode = targetNode.next;
		}
		targetNode.value = string;
	}
	@Override
	public boolean hasNext() {
		
		return false;
	}
	@Override
	public Object next() {
		Node node;
		if(x) {
			node = lastReturn.previous;
		}
		else {
		node = lastReturn;
		}
		cursor++;
		return node;
	}
	@Override
	public boolean hasPrevious() {
		
		return false;
	}
	@Override
	public Object previous() {
		Node node;
		if(x) {
			node = lastReturn ;
		}
		return null;
	}
	@Override
	public int nextIndex() {
		
		return 0;
	}
	@Override
	public int previousIndex() {
		
		return 0;
	}
	@Override
	public void remove() {
		
		
	}
	@Override
	public void set(Object e) {
		set((String) e);
	}
	@Override
	public void add(Object e) {
		
	}

	public ListIterator listIterator() {
		return this;
	}	
}
