package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * tests AbtractTaskList class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class AbstractTaskListTest {

	/**
	 * tests the AbstractTaskList constructor
	 */
	@Test
	public void testAbstractTaskList() {
		try {
			AbstractTaskList aTL1 = new TaskList("", 0);
			// clears CS notif
			aTL1.addTask(null);
			fail("This shouldn't work");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid name.", e.getMessage());
		}
		try {
			AbstractTaskList aTL2 = new TaskList("Name", -1);
			// clears CS notif
			aTL2.addTask(null);
			fail("This shouldn't work");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid completed count.", e.getMessage());
		}
		AbstractTaskList aTL3 = new TaskList("Name", 0);
		assertEquals("Name", aTL3.getTaskListName());
	}

	/**
	 * tests getTaskLisName
	 */
	@Test
	public void testGetTaskListName() {
		AbstractTaskList aTL4 = new TaskList("New Name", 0);
		assertEquals("New Name", aTL4.getTaskListName());
	}

	/**
	 * tests setTaskLisName
	 */
	@Test
	public void testSetTaskListName() {
		AbstractTaskList aTL5 = new TaskList("Math", 0);
		assertEquals("Math", aTL5.getTaskListName());
		aTL5.setTaskListName("Math 236");
		assertEquals("Math 236", aTL5.getTaskListName());
		try {
			aTL5.setTaskListName(null);
			fail("This should throw and exception");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid list name.", e.getMessage());
		}
		try {
			aTL5.setTaskListName("");
			fail("This should throw an exception");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid list name.", e.getMessage());
		}
	}

	/**
	 * tests getTasks
	 */
	@Test
	public void testGetTasks() {
		Task t14 = new Task("Take test", "take math test", false, true);
		Task t14a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		AbstractTaskList tL4 = new TaskList("Math", 0);
		tL4.addTask(t14);
		tL4.addTask(t14a);
		ISwapList<Task> a1 = new SwapList<Task>();
		a1 = tL4.getTasks();
		assertEquals(2, a1.size());
		assertEquals("Take test", a1.get(0).getTaskName());
		assertEquals("Do math homework", a1.get(1).getTaskName());
	}

	/**
	 * tests getCompletedCount
	 */
	@Test
	public void testGetCompletedCount() {
		Task t15 = new Task("Take test", "take math test", false, true);
		Task t15a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		AbstractTaskList tL5 = new TaskList("Math", 0);
		tL5.addTask(t15);
		tL5.addTask(t15a);
		tL5.completeTask(t15);
		assertEquals("1", tL5.getCompletedCount());
		tL5.completeTask(t15a);
		assertEquals("2", tL5.getCompletedCount());
		
	}

	/**
	 * tests addTask
	 */
	@Test
	public void testAddTask() {
		Task t6 = new Task("Take test", "take math test", false, true);
		Task t6a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		AbstractTaskList tL6 = new TaskList("Math", 0);
		tL6.addTask(t6);
		tL6.addTask(t6a);
		assertEquals(t6, tL6.getTask(0));
		assertEquals(t6a, tL6.getTask(1));
	}

	/**
	 * tests removeTask
	 */
	@Test
	public void testRemoveTask() {
		Task t7 = new Task("Take test", "take math test", false, true);
		Task t7a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		AbstractTaskList tL7 = new TaskList("Math", 0);
		tL7.addTask(t7);
		tL7.addTask(t7a);
		assertEquals(t7, tL7.removeTask(0));
		assertEquals(t7a, tL7.removeTask(0));
	}

	/**
	 * tests getTask
	 */
	@Test
	public void testGetTask() {
		Task t8 = new Task("Take test", "take math test", false, true);
		Task t8a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		AbstractTaskList tL8 = new TaskList("Math", 0);
		tL8.addTask(t8);
		tL8.addTask(t8a);
		assertEquals(t8, tL8.getTask(0));
		assertEquals(t8a, tL8.getTask(1));
	}

	/**
	 * tests completeTask
	 */
	@Test
	public void testCompleteTask() {
		Task t9 = new Task("Take test", "take math test", false, true);
		Task t9a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		AbstractTaskList tL9 = new TaskList("Math", 0);
		tL9.addTask(t9);
		tL9.completeTask(t9);
		tL9.addTask(t9a);
		assertEquals("1", tL9.getCompletedCount());
		tL9.completeTask(t9a);
		assertEquals("2", tL9.getCompletedCount());
	}

	/**
	 * tests getTasksAsArray
	 */
	@Test
	public void testGetTasksAsArray() {
		Task t10 = new Task("Take test", "take math test", false, true);
		Task t10a = new Task("Do math homework", "Do even number problems in current chapter", true, false);
		AbstractTaskList tL10 = new TaskList("Math", 0);
		tL10.addTask(t10);
		tL10.addTask(t10a);
		String[][] a1 = new String[2][2];
		a1 = tL10.getTasksAsArray();
		assertEquals("1", a1[0][0]);
		assertEquals("Take test", a1[0][1]);
		assertEquals("2", a1[1][0]);
		assertEquals("Do math homework", a1[1][1]);
	}

}
