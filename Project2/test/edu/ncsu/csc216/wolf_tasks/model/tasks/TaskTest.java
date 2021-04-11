/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests Task class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class TaskTest {

	/**
	 * tests Task constructor
	 */
	@Test
	public void testTask() {
		Task t1 = new Task("Eat Food", "Eat healthy food at lunch and dinner", true, false);
		assertEquals("Eat Food", t1.getTaskName());
		assertEquals("Eat healthy food at lunch and dinner", t1.getTaskDescription());
		assertTrue(t1.isRecurring());
		assertFalse(t1.isActive());
	}

	/**
	 * tests getTaskName
	 */
	@Test
	public void testGetTaskName() {
		Task t2 = new Task("Do homework", "Get homework done", true, false);
		assertEquals("Do homework", t2.getTaskName());
	}

	/**
	 * Test method for setTaskName()
	 */
	@Test
	public void testSetTaskName() {
		Task t3 = new Task("Take Prescription", "Take allergy meds", true, true);
		assertEquals("Take Prescription", t3.getTaskName());
		t3.setTaskName("Take allergy meds");
		assertEquals("Take allergy meds", t3.getTaskName());
		try {
			t3.setTaskName("");
			fail("This task name should throw an exception.");
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
		}
		try {
			t3.setTaskName(null);
			fail("This name should throw an exception.");
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
		}
	}

	/**
	 * tests getTaskDescription
	 */
	@Test
	public void testGetTaskDescription() {
		Task t4 = new Task("Take Prescription", "Take allergy meds", true, true);
		assertEquals("Take allergy meds", t4.getTaskDescription());
	}

	/**
	 * Test method for setTaskDescription()
	 */
	@Test
	public void testSetTaskDescription() {
		Task t5 = new Task("Take Prescription", "I'm sneezing", true, true);
		assertEquals("Take Prescription", t5.getTaskName());
		t5.setTaskDescription("Take allergy meds");
		assertEquals("Take allergy meds", t5.getTaskDescription());
		try {
			t5.setTaskDescription("");
			fail("This task description should throw an exception.");
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
		}
		try {
			t5.setTaskName(null);
			fail("This description should throw an exception.");
		} catch (IllegalArgumentException e) {
			assertEquals("Incomplete task information.", e.getMessage());
		}
	}

	/**
	 * tests isRecurring
	 */
	@Test
	public void testIsRecurring() {
		Task t6 = new Task("Call mom", "Talk to your mom for an hour or so", true, false);
		assertTrue(t6.isRecurring());
		Task t7 = new Task("Call Dad", "Call dad when I need a cash supplement", false, false);
		assertFalse(t7.isRecurring());
	}

	/**
	 * Test method for setRecurring()
	 */
	@Test
	public void testSetRecurring() {
		Task t8 = new Task("Call Dad", "Call dad when I need a cash supplement", false, false);
		assertFalse(t8.isRecurring());
		t8.setRecurring(true);
		assertTrue(t8.isRecurring());
	}

	/**
	 * tests isActive
	 */
	@Test
	public void testIsActive() {
		Task t9 = new Task("active task", "this task is active", false, true);
		assertTrue(t9.isActive());
		Task t10 = new Task("Not active", "This task is not active", false, false);
		assertFalse(t10.isActive());
	}

	/**
	 * Test method for setActive()
	 */
	@Test
	public void testSetActive() {
		Task t11 = new Task("active task", "this task is active", false, true);
		assertTrue(t11.isActive());
		t11.setActive(false);
		assertFalse(t11.isActive());
	}

	/**
	 * Test method for getTaskListName()
	 */
	@Test
	public void testGetTaskListName() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for addTaskList()
	 */
	@Test
	public void testAddTaskList() {
		//fail("Not yet implemented");
	}

	/**
	 * tests completeTask
	 */
	@Test
	public void testCompleteTask() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for clone()
	 */
	@Test
	public void testClone() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for toString()
	 */
	@Test
	public void testToString() {
		//fail("Not yet implemented");
	}

}
