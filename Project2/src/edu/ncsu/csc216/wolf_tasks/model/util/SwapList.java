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
public class SwapList<E> implements ISwapList<E> {

	/** initial capacity of the SwapList */
	private static final int INITIAL_CAPACITY = 10;
	/** list of generic elements */
	private E[] list;
	/** size of the SwapList */
	private int size;

	/**
	 * Constructor for SwapList
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		//E element = (E) new Object();
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}

	/**
	 * Adds an element to the SwapList
	 * 
	 * @param element the element to be added to the SwapList
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element."); 
		}
		//allows duplicate elements --> no check for duplicates
		
		// Grow the array size if array is full
		if (size == list.length) {
			growArray();
		}
		
		//Add element to end of list (per AbstractTaskList implementation and per 
		//lack of index parameter
		list[size] = element;
		size++;
	}

	private void growArray() {
		E[] temp = (E[]) new Object[size *2];
		for (int i = 0; i < size; i++) {
			temp[i] = list[i];
		}
		list = (E[]) new Object[size * 2];
		for (int i = 0; i < size; i++) {
			list[i] = temp[i];
		}
		
	}

	/**
	 * Checks the capacity of the SwapList
	 * 
	 * @return the capacity of the list
	 */
	private int checkCapacity() {
		//size - occupied elements of the swapList array
		int occupiedElements = 0;
		int capacity = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				occupiedElements++;
			}
		}
		
		capacity = size - occupiedElements;
		return capacity;
	}

	/**
	 * Removes the element at the parameter index
	 * 
	 * @param index the index of the element to be removed
	 * @return the element at the index that was removed
	 */
	public E remove(int index) {
		checkIndex(index);
		if (size == 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
		E rtn = list[index];
		for (int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return rtn;
	}

	/**
	 * Checks whether the index is legal for this list
	 * 
	 * @param index the index of an element in the SwapList
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	/**
	 * Moves an element up in priority in the SwapList
	 * 
	 * @param index the index of the element to move
	 */
	public void moveUp(int index) {
		//!!! Probably could've simplified this to be more list moveDown()
		
		E temp = list[index];
		
		//place index element in temp
		//remove index element from list 
		//shift list to right starting at (index - 1)
		//place index element at (index - 1)
		
		remove(index);
		int addIndex = index - 1;
		for (int i = size - 1; i >= addIndex; i--) {
			list[i + 1] = list[i];
		}
		
		list[addIndex] = temp;
		size++;
	}

	/**
	 * Moves an element down in priority in the SwapList
	 * 
	 * @param index the index of the element to move
	 */
	public void moveDown(int index) {
		E tempOriginal = list[index];
		E tempOther = list[index + 1];
		
		list[index] = tempOther;
		list[index + 1] = tempOriginal;
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
		checkIndex(index);
		return list[index];
	}

	/**
	 * Gets the size of the list
	 * 
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}

}
