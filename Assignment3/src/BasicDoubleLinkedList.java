import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *  BasicDoubleLinkedList class
 * @author Lokesh Sankar Ramesh
 *
 * @param <T> type arameter
 */
public class BasicDoubleLinkedList<T> {
	
	protected Node first;
	protected Node last;
	
	protected int sizeOfList = 0;
	
	/**
	 * Default Constructor - Initalizes firstLink and lastLink to null
	 */
	public BasicDoubleLinkedList() {
		first = null;
		last = null;
	}
	
	/**
	 * Adds element to front of list
	 * 
	 * @param data - Node to add to front of list
	 * 
	 * @return - Current object reference
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node temp = new Node(data);
				
		if(!isEmpty()) {
			temp.next = first;
			first.previous = temp;	
		} else {
			last = temp;
		}
		
		first = temp;
		sizeOfList++;
		
		return this;
	}
	
	/**
	 * Adds an element to the back the list 
	 * 
	 * @param data -  Node to add to back of list
	 * 
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node temp = new Node(data);
		
		if(!isEmpty()) {
			last.next = temp;
			temp.previous = last;	
		} else {
			first = temp;	
		}
		
		last = temp;
		sizeOfList++;
		
		return this;
	}
	
	
	/**
	 * Returns first element of the list
	 * 
	 * @return data
	 * @return null
	 */
	public T getFirst() {
		if (!isEmpty()) {
			return first.data;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns last element of the list
	 * 
	 * @return data
	 * @return null
	 */
	public T getLast() {
		if (!isEmpty()) {
			return last.data;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the number of elements in the list
	 * 
	 * @return sizeOfList
	 */
	public int getSize() {
		return sizeOfList;
	}
	
	/**
	 * Returns if list is empty
	 * 
	 * @return true if empty
	 * @return false if not empty
	 */
	public boolean isEmpty() {
		if (sizeOfList == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Removes the first element of list and returns it
	 * 
	 * @return firstElement
	 * @return null
	 */
	public T retrieveFirstElement() {
		if(isEmpty()) {
			return null;
		} else if(sizeOfList == 1) {
			T firstElement = getFirst();
			
			first = null;
			last = null;
			sizeOfList--;
			
			return firstElement;
		} else {
			T firstElement = getFirst();
			
			first.next.previous = null;
			first = first.next;
			sizeOfList--;
			
			return firstElement;
		}	
		
	}
	
	
	/**
	 * Removes last element of list and returns it
	 * @return last data element or null
	 */
	public T retrieveLastElement() {
		if(isEmpty()) {
			return null;
			
		} else if(sizeOfList == 1) {
			T lastElement = getLast();
			
			first = null;
			last = null;
			sizeOfList--;
			
			return lastElement;
		} else {
			T lastElement = getLast();
			
			last.previous.next = null;
			last = last.previous;
			sizeOfList--;
			
			return lastElement;
		}
	}
	
	
	/**
	 * Removes first instance of targetData in the list
	 * 
	 * @param targetData data element to be removed
	 * @param comparator comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T>comparator){
		Node current = first;
				
		while(!isEmpty()) {
			if(comparator.compare(targetData, current.data) == 0) {
				if(sizeOfList == 1) {					
					first = null;
					last = null;
				
					sizeOfList--;
					
					break;
				} else if(current == first) {					
					first.next.previous = null;
					first = first.next;
					
					sizeOfList--;
					
					break;
				} else if(current == last){
					
					last.previous.next = null;
					last = last.previous;
					
					sizeOfList--;
					
					break;
				} else {
					current.previous.next = current.next;
					current.next.previous = current.previous;
					
					sizeOfList--;
					
					break;
				}
			}
			
			current = current.next;
		}

		return this;
	}
	
	
	/**
	 * Returns ArrayList of items in list
	 * 
	 * @return arraylist of items in the list
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> l = new ArrayList<T>();
		ListIterator<T> itr = iterator();
		
		while(itr.hasNext()) {
			l.add(itr.next());
		}
		
		return l;
	}
	
	
	/**
	 * Creates new iterator object and returns it
	 * 
	 * @return iterator object
	 * 
	 * @throws UnsupportedOperationException if call to wrong method
	 * @throws NoSuchElementException if no element found
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new DoubleLinkedListIterator();
	}
	
	
	
	/**
	 * Node class
	 * @author Lokesh Sankar Ramesh
	 *
	 */
	protected class Node {
		public Node next; public Node previous; public T data;
		
		/**
		 * Default Constructor
		 */
		Node() {
			previous = null;
			next = null;
			data = null;
		}
		
		/**
		 * Constructor
		 * 
		 * @param data
		 */
		Node(T data){
			this.data=data;
		}
	}
	
	
	
	/**
	 * DoubleLinkedListIterator class
	 * @author Lokesh Sankar Ramesh
	 *
	 */
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		private Node previous;
		private Node current;
		
		/**
		 * Default constructor - Initializes previous node and current node
		 */
		DoubleLinkedListIterator() {
			previous = null;
			current = first;
		}
		
		@Override
		/**
		 * @throws  UnsupportedOperationException when called
		 */
		public void add(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		
		
		/**
		 * @return next data element
		 */
		@Override
		public T next() throws UnsupportedOperationException {		
			if (hasNext()) {
				previous = current;
				current = current.next;
				return previous.data;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		/**
		 *  @return next data element
		 */
		@Override
		public T previous() throws NoSuchElementException {
			if (hasPrevious()) {
				current=previous;
				previous=previous.previous;
				return current.data;			
			} else {
				throw new NoSuchElementException();
			}

		}

		@Override
		/**
		 * Checks if current node is null
		 * 
		 * @return true if not null
		 * @return false if null
		 */
		public boolean hasNext() {
			return current != null;
		}
		
		/**
		 * Checks if previous node is null
		 * 
		 * @return true if not null
		 * @return false it null
		 */
		@Override
		public boolean hasPrevious() {
			return previous != null;
		}
		
		/**
		 * @throws  UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * @throws  UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		/**
		 * @throws  UnsupportedOperationException when called
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		/**
		 * @throws  UnsupportedOperationException when called
		 */
		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}
		
	}

}