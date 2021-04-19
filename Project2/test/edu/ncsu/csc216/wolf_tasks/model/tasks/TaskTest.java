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
		Task t12 = new Task("Read Lord of the Flies", "Read chapter 8 of LOTF", false, false);
		TaskList tL2 = new TaskList("English 236", 0);
		tL2.addTask(t12);
		assertEquals("English 236", t12.getTaskListName());
	}

	/**
	 * Test method for addTaskList()
	 */
	@Test
	public void testAddTaskList() {
		Task t13 = new Task("Read Dracula", "Read chapter 2 of Dracula", false, false);
		TaskList tL1 = new TaskList("English 236", 0);
		tL1.addTask(t13);
		assertEquals("English 236", t13.getTaskListName());
	}

	/**
	 * tests completeTask
	 */
	@Test
	public void testCompleteTask() {
		Task t14 = new Task("Take test", "take math test", false, true);
		Task t14a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		TaskList tL4 = new TaskList("Math", 0);
		tL4.addTask(t14);
		tL4.addTask(t14a);
		tL4.completeTask(t14);
		assertEquals(1, tL4.getCompletedCount());
		tL4.completeTask(t14a);
		assertEquals(2, tL4.getCompletedCount());
		//TODO bug when adding task back to lists
		//assertEquals("Do math homework", tL4.getTask(0).getTaskName());
		
	}

	/**
	 * Test method for clone()
	 */
	@Test
	public void testClone() {
		Task t15 = new Task("Pick up books", "Get books from store", false, false);
		TaskList tL3 = new TaskList("Prep", 0);
		tL3.addTask(t15);
		Task t15a = null;
		try {
			t15a = t15.clone();
		} catch (CloneNotSupportedException e) {
			fail("Didn't clone" + e.getMessage());
		}
		assertEquals(t15.getTaskName(), t15a.getTaskName());
		assertEquals(t15.getTaskDescription(), t15a.getTaskDescription());
		assertEquals(t15.getTaskListName(), t15a.getTaskListName());
	}

	/**
	 * Test method for toString()
	 */
	@Test
	public void testToString() {
		Task t16 = new Task("Make Brunch",
				"Scientists say cook food", true, true);
		assertEquals(
				"* Make Brunch,recurring,active\nScientists say cook food",
				t16.toString());
		Task t17 = new Task("Read textbook", "Read chapter 17", false, false);
		assertEquals("* Read textbook\nRead chapter 17", t17.toString());
	}

}
