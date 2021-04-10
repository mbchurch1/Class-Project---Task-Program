/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests SwapList
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class SwapListTest {

	/** list of generic elements */
	private SwapList testList;
	
	
	/**
	 * Test method for swapList()
	 */
	@Test
	public void testSwapList() {
		//Test the constructor and add methods
		SwapList<Object> list = new SwapList<Object>();
		assertEquals(0, list.size());
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		assertEquals(3, list.size());
		//Test add with a null value
		try {
			list.add(null);
		} catch (NullPointerException e) {
			assertEquals("Cannot add null element.", e.getMessage());
			}
		
		//Constructor should create a list of capacity 10
		//Need to test growArray and checkCapacity
//		testList = new SwapList();
//		assertEquals(10, testList.size());
		
		
	}


	/**
	 * Test method for remove()
	 */
	@Test
	public void testRemove() {
		//Test the remove method
		SwapList<Object> list = new SwapList<Object>();
		assertEquals(0, list.size());
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		assertEquals(3, list.size());
		assertEquals("Test2", list.remove(1));
		assertEquals(2, list.size());
		assertEquals("Test3", list.get(1));
		//Test remove with an invalid index
		SwapList<Object> list2 = new SwapList<Object>();
		try {
			list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			assertEquals("Invalid index.", e.getMessage());
			}
		list2.add("Test");
		try {
			list2.remove(5);
		} catch (IndexOutOfBoundsException e) {
			assertEquals("Invalid index.", e.getMessage());
			}
		
	}

	/**
	 * Test method for moveUp()
	 */
	@Test
	public void testMoveUp() {
		//Test the moveUp method
		SwapList<Object> list = new SwapList<Object>();
		assertEquals(0, list.size());
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		assertEquals(3, list.size());
		list.moveUp(2);
		assertEquals("Test3", list.get(1));
		list.moveUp(1);
		assertEquals("Test3", list.get(0));
	}

	/**
	 * Test method for moveDown()
	 */
	@Test
	public void testMoveDown() {
		//Test the moveDown method
		SwapList<Object> list = new SwapList<Object>();
		assertEquals(0, list.size());
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		assertEquals(3, list.size());
		list.moveDown(0);
		assertEquals("Test", list.get(1));
		list.moveDown(1);
		assertEquals("Test", list.get(2));
		
	}

	/**
	 * Test method for moveToFront()
	 */
	@Test
	public void testMoveToFront() {
		//Test the moveToFront method
		SwapList<Object> list = new SwapList<Object>();
		assertEquals(0, list.size());
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		assertEquals(3, list.size());
		list.moveToFront(2);
		assertEquals("Test3", list.get(0));
		list.moveToFront(2);
		assertEquals("Test2", list.get(0));
	}

	/**
	 * Test method for moveToBack()
	 */
	@Test
	public void testMoveToBack() {
		//Test the moveToFront method
		SwapList<Object> list = new SwapList<Object>();
		assertEquals(0, list.size());
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		assertEquals(3, list.size());
		list.moveToBack(0);
		assertEquals("Test", list.get(2));
		list.moveToBack(0);
		assertEquals("Test2", list.get(2));
	}

	/**
	 * Test method for get()
	 */
	@Test
	public void testGrowArray() {
		SwapList<Object> list = new SwapList<Object>();
		assertEquals(0, list.size());
		list.add("Test");
		list.add("Test2");
		list.add("Test3");
		list.add("Test4");
		list.add("Test5");
		list.add("Test6");
		list.add("Test7");
		list.add("Test8");
		list.add("Test9");
		list.add("Test10");
		list.add("Test11");
		list.add("Test12");
		assertEquals(12, list.size());
	}

}
