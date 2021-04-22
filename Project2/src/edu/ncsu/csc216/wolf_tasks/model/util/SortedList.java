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
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

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

	private class ListNode {

		/** Private data field for the current ListNode */
		public E data;
		/** Next node on the list */
		public ListNode next;

		public ListNode(E data) {
			this(data, null);
		}

		/**
		 * Constructor for the ListNode
		 * 
		 * @param data Element data
		 * @param next ListNode
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Returns the element from the given index. The element is removed from the
	 * list.
	 * 
	 * @param index index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the index is out of bounds for the list
	 */
	public E remove(int index) {
		checkIndex(index);

		E value = null;
		if (index == 0) {
			value = (E) front.data;
			front = front.next;
		} else {
			ListNode current = front;
			for (int i = 0; i < index - 1; i++) {
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
	 * 
	 * @param index the index to check
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than
	 *                                   size
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

//	/**
//	 * Determines whether the SortedList contains the parameterized object
//	 * @param object an object that may be contained within the SortedList
//	 * @return true or false based on whether the SortedList contains the given object
//	 */
//	public boolean contains(E object) {
//		ListNode current = front;
//		for(int i = 0; i < size; i++) {
//			if(current.data.equals(object)) {
//				return true;
//			}
//		}
//		return false;
//	}

	/**
	 * Gets the object at the parameterized index from the SortedList
	 * 
	 * @param index the index of the object being returned
	 * @return e An object at the given index in the SortedList
	 * @throws IndexOutOfBoundsException if the index is out of bounds for the list
	 */
	@SuppressWarnings("unchecked")
	public E get(int index) {
		checkIndex(index);
		ListNode current = front;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				return (E) current.data;
			}
			current = current.next;
		}

		return null;
	}

	/**
	 * Gets the size of the list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds an element to the SortedList
	 * 
	 * @param element the generic TaskList element being added to SortedList
	 * @throws NullPointerException     if element is null
	 * @throws IllegalArgumentException if element cannot be added
	 */
	@Override
	public void add(E element) {

		ListNode current = front;
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}

		// !!! Preliminary basic implementation of add
		// !!! Still need to factor in sorting
		// How to Sort:
		// ActiveTaskList always needs to be at top of SortedList (I think this still
		// applies if the ActiveTasks is empty, but not sure yet)
		// All remaining TaskLists are added in alphabetical order following
		// ActiveTaskList

		if (size == 0) {
			// !!!!! Need to figure out how to always add ActiveTaskList to the front of
			// SortedList
			front = new ListNode(element);
		} else {

			// This implementation of checking for duplicates may work, but the below mimics
			// ServiceWolfManager.addServiceGroup implementation in P1 and seems to all be
			// coherent/cohesive
//			//Check for duplicate TaskList objects in SortedList
//			while(current.next != null) {
//				if(current.data.equals(taskListObject)) {
//					throw new IllegalArgumentException("Cannot add duplicate element");
//				}
//			}
//			current = front;

			// while (current.next != null) {
			// since we're keeping track of size in this class, it makes sense that I can
			// just use a for loop here as long as I'm pushing along 'current' during the
			// list traversal - similar to my (WG) implementation of
			// ServiceWolfManager.addServiceGroup implementation in P1
			int prevSize = this.size();
			for (int i = 0; i < prevSize; i++) {

				// Need to ensure that compareTo in TaskList is implemented as
				// compareToIgnoreCase
				if (current.data.compareTo(element) == 0) {
					throw new IllegalArgumentException("Cannot add duplicate element.");
				} else if ((current.data).compareTo(element) > 0) {
					current.next = new ListNode(element, current.next);
					//break;
				} else if ((current.data).compareTo(element) < 0 && i == size - 1) {

					// If reached end of list, i.e. taskListElement is a larger letter
					// than anything else in SortedList, then add taskListElement to the end of
					// SortedList
					// This may need to be executed outside the while loop

					current.next = new ListNode(element, current.next);

				}
				current = current.next;
			}
		}
		size++;

	}

	/**
	 * Determines whether the SortedList contains the parameterized object
	 * 
	 * @param element the generic TaskList element being added to SortedList
	 * @return true or false based on whether the SortedList contains the given
	 *         object
	 */
	@Override
	public boolean contains(E element) {
		ListNode current = front;
		for (int i = 0; i < size; i++) {
			if ((current.data).compareTo(element) == 0) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

}
