import java.util.ListIterator;
import java.util.NoSuchElementException;

public class LinkedList implements ListIterator {
	private int size = 0;
	private int cursor = 0;
	private int index = -1;
	private Node firstNode;
	private Node lastReturn;
	
	
	
	
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
			index ++;
			return next;
		}
		else {
			cursor++;
			index ++;
			lastReturn = new Node(null,lastReturn, null);
			throw new NoSuchElementException();
		}
			
	}
	@Override
	public boolean hasPrevious() {
		
		return lastReturn.previous != null;
	}
	@Override
	public Object previous() {
		if (cursor > 1) {		
			String prev = lastReturn.previous.value;
			lastReturn = lastReturn.previous;
			cursor--;
			index --;
			return prev;
		}
		else {
			cursor --;
			index --;
			throw new NoSuchElementException();
		}
		
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
		set(index,(String) e);
	}
	@Override
	public void add(Object e) {
		
	}

	public ListIterator listIterator() {
		lastReturn = new Node(null,null,firstNode);
		return this;
	}	
}
