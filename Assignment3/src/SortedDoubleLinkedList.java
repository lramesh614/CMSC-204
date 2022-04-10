import java.util.Comparator;
import java.util.ListIterator;


/**
 * SortedDoubleLinkedList class
 * @author Lokesh Sankar Ramesh
 *
 * @param <T> type parameter
 */
public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T> {
	
	@SuppressWarnings({ "unused", "rawtypes" })
	private Comparator c;
	
	
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * 
	 * @param comparator2 Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> c2) {
		c = c2;
	}
	
	
	/**
	 * Inserts given element at correct position
	 * 
	 * @param data - Data to add to end of list
	 * 
	 * @return Current object reference
	 */
	@SuppressWarnings("unchecked")
	public SortedDoubleLinkedList<T> add(T data) {
 		Node temp = new Node(data);
		Node current = first;
		Node previous;
		
		if(sizeOfList == 0) {
			first = temp;
			last = temp;
			
			sizeOfList++;
			
			return this;
		}
		
		if(sizeOfList == 1) {
			if(c.compare(data, current.data) < 0 || c.compare(data, current.data) == 0) {
				super.addToFront(data);
				return this;
			} else {
				super.addToEnd(data);
				return this;
			}
			
		} else {
			while(c.compare(current.data, data) < 0) {
				
				previous = current;
				current = current.next;
				
				if (current == null) {
					current=temp;
					
					temp.previous=previous;
					previous.next=temp;
					
					last=temp;
					
					sizeOfList++;
					
					return this;
				}
			}
			
			if(current == first) {
				if(c.compare(data, current.data)<0) {
					super.addToFront(data);
				}
				
			} else if(current == last) {
				current.previous.next=temp;
				
				temp.next = current;
				temp.previous = current.previous;
				
				current.previous=temp;
				
				sizeOfList++;
			} else {
				current.previous.next=temp;
				
				temp.next = current;
				temp.previous = current.previous; 
				
				current.previous = temp;
				
				sizeOfList++;
			}
			
			return this;
		
		
		}
		
	}
	
	
	@Override
	/**
	 * Implements superclass remove method
	 * @Overrides remove from superclass BasicDoubleLinkedList<T>

	 * @returns Current object reference or null
	 */
	public SortedDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		super.remove(targetData, comparator);
		return this;
	}
	
	
	@Override
	/**
	 * Calls superclass iterator method
	 * 
	 * @Overrides iterator from superclass BasicDoubleLinkedList<T>
	 * 
	 * @returns iterator at position front of list
	 */
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	
	
	@Override
	/**
	 * Invalid Operation for sorted list
	 * 
	 * @Override addToEnd from BasicDoubleLinkedList<T>
	 * 
	 * @returns Current object reference
	 * 
	 * @throws UnsupportedOperationException
	 */
	public SortedDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	
	@Override
	/**
	 * Invalid Operation for sorted list
	 * 
	 * @Override addToFront from superclass BasicDoubleLinkedList<T>
	 * 
	 * @returns Current object reference
	 * 
	 * @throws UnsupportedOperationException 
	 */
	public SortedDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	
}