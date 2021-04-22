/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * tests SortedList
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class SortedListTest {

	/**
	 * tests SortedList
	 */
	@Test
	public void testSortedList() {
		SortedList list = new SortedList();
		assertEquals(0, list.size());
	}

	/**
	 * Test method for add()
	 */
	@Test
	public void testAdd() {
		SortedList list = new SortedList();
		
		//Test adding a null element
		try {
			list.add(null); 
			fail("Cannot add null element to SortedList.");
		} catch (NullPointerException e) {
			assertEquals("Cannot add null element.", e.getMessage());
			assertEquals(0, list.size());
		}
		
		//Test adding a proper TaskList
		TaskList firstElement = new TaskList("First List", 1);
		list.add(firstElement);
		assertEquals(1, list.size());
		assertTrue(list.contains(firstElement));
		
		//Test adding a duplicate TaskList
		TaskList firstElementAgain = new TaskList("First List", 1);
		try {
			list.add(firstElementAgain);
			fail("Cannot add this duplicact TaskList to SortedList.");
		} catch(IllegalArgumentException e) {
			assertEquals("Cannot add duplicate element.", e.getMessage());
			assertEquals(1, list.size());
		}
		
		//Test adding a second and third element in sorted order
		TaskList secondElement = new TaskList("Second List", 2);
		list.add(secondElement);
		assertEquals(2, list.size());
		assertTrue(list.contains(secondElement));
		TaskList thirdElement = new TaskList("Middle List", 3);
		list.add(thirdElement);
		assertEquals(3, list.size());
		assertTrue(list.contains(thirdElement));
		
		//Test adding an element to end of list
		TaskList lastElement = new TaskList("The Last List", 4);
		list.add(lastElement);
		assertEquals(4, list.size());
		assertTrue(list.contains(lastElement));
	}
	
//		@Test 
//		public void testAddAgain() {
//			SortedList<String> fruits = new SortedList<String>();
//			fruits.add("apple");
//			fruits.add("avocado");
//			fruits.add("zebra");
//			fruits.add("grapes");
//			fruits.add("orange");
//			for(int i = 0; i < fruits.size(); i++) {
//				System.out.println(fruits.get(i));
//			}
//		}

	/**
	 * Test method for remove()
	 */
	@Test
	public void testRemove() {
		SortedList list = new SortedList();
		
		//Test adding three elements and removing one
		TaskList firstElement = new TaskList("First List", 1);
		list.add(firstElement);
		assertEquals(1, list.size());
		assertTrue(list.contains(firstElement));
		TaskList secondElement = new TaskList("Second List", 2);
		list.add(secondElement);
		assertEquals(2, list.size());
		assertTrue(list.contains(secondElement));
		TaskList thirdElement = new TaskList("Middle List", 3);
		list.add(thirdElement);
		assertEquals(3, list.size());
		assertTrue(list.contains(thirdElement));
		
		list.remove(1);
		assertEquals(2, list.size());
		assertTrue(list.contains(firstElement));
//		assertTrue(list.contains(thirdElement));
//		
//		list.remove(0);
//		assertEquals(1, list.size());
//		assertTrue(list.contains(thirdElement));
	}

	/**
	 * Test method for contains()
	 */
	@Test
	public void testContains() {
		SortedList list = new SortedList();
		
		//Test adding a couple elements and determining if the list contains one of them
		TaskList firstElement = new TaskList("First List", 1);
		list.add(firstElement);
		assertEquals(1, list.size());
		assertTrue(list.contains(firstElement));
		TaskList secondElement = new TaskList("Second List", 2);
		list.add(secondElement);
		assertEquals(2, list.size());
		assertTrue(list.contains(secondElement));
		
		//Test determining that an element not in the list returns false
		TaskList thirdElement = new TaskList("Third List", 3);
		assertFalse(list.contains(thirdElement));
	}

	/**
	 * Test method for get()
	 */
	@Test
	public void testGet() {
		SortedList list = new SortedList();
		
		//Test adding a couple elements and determining if this method can get one of them
		TaskList firstElement = new TaskList("First List", 1);
		list.add(firstElement);
		assertEquals(1, list.size());
		assertTrue(list.contains(firstElement));
		TaskList secondElement = new TaskList("Second List", 2);
		list.add(secondElement);
		assertEquals(2, list.size());
		assertTrue(list.contains(secondElement));
		
		TaskList gottenElement = (TaskList) list.get(1);
		assertEquals(0, gottenElement.compareTo(secondElement));
	}

}
