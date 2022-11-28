import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList implements ListIterator {
	private int size = 0;
	private int cursor = 0;
	Node firstNode;
	Node lastReturn;
	int index = 0;
	
	
	
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
	
	//iterator interface
	@Override
	public boolean hasNext() {
		return lastReturn.next != null;
	}
	@Override
	public Object next() {
		
		if(cursor < size) {
			
			String next = lastReturn.next.value;
			lastReturn = lastReturn.next;
			cursor++;
			index = cursor -1;
			return next;
		}
		else {throw new NoSuchElementException();}
			
	}
	@Override
	public boolean hasPrevious() {
		
		return lastReturn.previous != null;
	}
	@Override
	public Object previous() {
		String prev = lastReturn.previous.value;
		lastReturn = lastReturn.previous;
		cursor--;
		index = cursor + 1;
		return prev;
	}
	@Override
	public int nextIndex() {
		
		return index + 1;
	}
	@Override
	public int previousIndex() {
		
		return index - 1;
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
		lastReturn = new Node(null,null,firstNode);
		return this;
	}	
}
