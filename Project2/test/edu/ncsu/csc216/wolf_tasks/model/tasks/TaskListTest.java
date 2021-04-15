package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests TaskList class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class TaskListTest {

	/**
	 * tests TaskList constructor
	 */
	@Test
	public void testTaskList() {
		try {
			TaskList tL1 = new TaskList("", 0);
			Task t10 = new Task("Take test", "take math test", false, true);
			// clears CS notif
			tL1.addTask(t10);
			fail("This shouldn't work");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		try {
			TaskList tL2 = new TaskList("Name", -1);
			Task t10 = new Task("Take test", "take math test", false, true);
			// clears CS notif
			tL2.addTask(t10);
			fail("This shouldn't work");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid completed count.", e.getMessage());
		}
		AbstractTaskList tL3 = new TaskList("Name", 0);
		assertEquals("Name", tL3.getTaskListName());
	}

	/**
	 * tests getTasksAsArray
	 */
	@Test
	public void testGetTasksAsArray() {
		Task t10 = new Task("Take test", "take math test", false, true);
		Task t10a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		TaskList tL10 = new TaskList("Math", 0);
		tL10.addTask(t10);
		tL10.addTask(t10a);
		String[][] a1 = new String[2][2];
		a1 = tL10.getTasksAsArray();
		assertEquals("1", a1[0][0]);
		assertEquals("Take test", a1[0][1]);
		assertEquals("2", a1[1][0]);
		assertEquals("Do math homework", a1[1][1]);
	}

	/**
	 * tests compareTo
	 */
	@Test
	public void testCompareTo() {
		TaskList tL11 = new TaskList("Algebra", 0);
		TaskList tL11a = new TaskList("Zoology", 0);
		assertEquals(25, tL11.compareTo(tL11a));
	}

}
