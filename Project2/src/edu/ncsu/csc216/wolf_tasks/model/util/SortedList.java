package edu.ncsu.csc216.wolf_tasks.model.util;



/**
 * SortedList constructor
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 * @param <E> an object to store
 */
public class SortedList<E> {
	
	/** Number of elements in the SortedList */
	private int size;
	/** ListNode for front of the list */
	private ListNode front;
	
	/**
	 * Constructor for SortedList
	 */
	public SortedList() {
		front = null;
		size = 0;
	}
	
	/**
	 * Adds an element to the SortedList
	 * @param object the object being added to the SortedList
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	public void add(E object) {
		ListNode current = front; 
		if(object == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		if(size == 0) {
			front = new ListNode(object, front);
		} else {
			for(int i = 0; i < size; i++) {
				if(current.data.equals(object)) {
					throw new IllegalArgumentException("Cannot add duplicate element");
				}
				current = current.next;
			}
		}
		
//		current = front;
//		for(int i = 0; i < size; i++) {
//			if(((E) current.next.data).comparableTo(object) {
//				
//			}
//		}
//		
//		try {
//			
//		} catch(IllegalArgumentException e) {
//			throw new IllegalArgumentException("")
//		}
		
	}
	
	/**
	 * Returns the element from the given index.  The element is
	 * removed from the list.
	 * @param index index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 * 		for the list
	 */
	public E remove(int index) {
		checkIndex(index);
		
		E value =  null;
		if(index == 0) {
			value = (E) front.data;
			front = front.next;
		} else {
			ListNode current = front;
			for(int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			value = (E) current.next.data;
			current.next = current.next.next;
		}
		size--;
		return value;
	}
	
	/**
	 * Checks if there is an element at the provided index
	 * @param index the index to check
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than size
	 */
	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
	
	/**
	 * Determines whether the SortedList contains the parameterized object
	 * @param object an object that may be contained within the SortedList
	 * @return true or false based on whether the SortedList contains the given object
	 */
	public boolean contains(E object) {
		ListNode current = front;
		for(int i = 0; i < size; i++) {
			if(current.data.equals(object)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gets the object at the parameterized index from the SortedList
	 * @param index the index of the object being returned
	 * @return e  An object at the given index in the SortedList
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 * 		for the list
	 */
	public E get(int index) {
		checkIndex(index);
		ListNode current = front;
		for(int i = 0; i < size; i++) {
			current = current.next;
		}
		
		return (E) current.data;
	}
	
	/**
	 * Gets the size of the list
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}
	
	
	public class ListNode<E> {
		
		/**Private data field for the current ListNode  */
		public E data;
		/** Next node on the list   */
		private ListNode next;
		
		/**
		 * Constructor for the ListNode
		 * @param data  Element data
		 * @param node  ListNode 
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}
}
