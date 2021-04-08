package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Implements the ISwapList interface
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 * @param <E> element of the SwapList
 *
 */
public class SwapList<E> {

	/** initial capacity of the SwapList */
	private static final int INITIAL_CAPACITY = 10;
	/** list of generic elements */
	private E[] list;
	/** size of the SwapList */
	private int size;

	/**
	 * Constructor for SwapList
	 */
	public SwapList() {
		//empty constructor
	}

	/**
	 * Adds an element to the SwapList
	 * 
	 * @param element the element to be added to the SwapList
	 */
	public void add(E element) {
		//empty method
	}

	/**
	 * Checks the capacity of the SwapList
	 * 
	 * @param cap the capacity of the list
	 */
	private void checkCapacity(int cap) {
		//empty method
	}

	/**
	 * Removes the element at the parameter index
	 * 
	 * @param index the index of the element to be removed
	 * @return the element at the index that was removed
	 */
	public E remove(int index) {
		return null;
	}

	/**
	 * Checks whether the index is legal for this list
	 * 
	 * @param index the index of an element in the SwapList
	 */
	private void checkIndex(int index) {
		//empty method
	}

	/**
	 * Moves an element up in priority in the SwapList
	 * 
	 * @param index the index of the element to move
	 */
	public void moveUp(int index) {
		//empty method
	}

	/**
	 * Moves an element down in priority in the SwapList
	 * 
	 * @param index the index of the element to move
	 */
	public void moveDown(int index) {
		//empty method
	}

	/**
	 * Moves an element to front of list
	 * 
	 * @param index the index of the element to move
	 */
	public void moveToFront(int index) {
		//empty method
	}

	/**
	 * Moves an element to back of list
	 * 
	 * @param index the index of the element to move
	 */
	public void moveToBack(int index) {
		//empty method
	}

	/**
	 * Gets an element in the list
	 * 
	 * @param index the index of the element to get
	 * @return Element at the given index
	 */
	public E get(int index) {
		return null;
	}

	/**
	 * Gets the size of the list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return 0;
	}

}
