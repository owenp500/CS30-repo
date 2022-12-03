import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.swing.LayoutStyle;

public class LinkedList implements ListIterator {
	private int size = 0;	
	private Node firstNode;
	
	//ListIterator
	private int index = -1;
	private int cursor = 0;
	private Node lastReturn;
	private boolean lastResultNext = true;
	
	
	
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
				if(i == size) {
					targetNode.next = new Node(string, targetNode, null);
				}
				else {
					targetNode.next.previous = new Node(string, targetNode, targetNode.next);
					targetNode.next = targetNode.next.previous;
				}
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
		if(lastResultNext) {
			if(cursor < size) {		
				String next = lastReturn.next.value;
				lastReturn = lastReturn.next;
				cursor++;
				index ++;
			
				return next;
			}
			else {	
				throw new NoSuchElementException();
			}
		}
		else { 
			cursor++;
			lastResultNext = true;			
			return lastReturn;
		}
		
			
	}
	@Override
	public boolean hasPrevious() {
		return lastReturn.previous != null;
	}
	@Override
	public Object previous() {
		if(!lastResultNext) {
			lastResultNext = false;
			if (cursor > 0) {		
				String prev = lastReturn.previous.value;
				lastReturn = lastReturn.previous;
				cursor--;
				index --;
				return prev;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		else {
			cursor--;
			lastResultNext = false;
			return lastReturn.value;	
		}
	}
	@Override
	public int nextIndex() {
		return cursor;
	}
	@Override
	public int previousIndex() {		
		return cursor - 1;
	}
	@Override
	public void remove() {
		remove(index);
		cursor --;
		index --;
	}
	@Override
	public void set(Object value ) {
		set(index,(String) value);
	}
	@Override
	public void add(Object value) {
		add(cursor, (String) value);
		lastReturn = lastReturn.next;
		index += (lastResultNext) ? 1: 0;
		lastResultNext =  true;
		cursor++;
	}

	@SuppressWarnings("rawtypes")
	public ListIterator listIterator() {
		lastReturn = new Node(null,null,firstNode);
		return this;
	}	
}
