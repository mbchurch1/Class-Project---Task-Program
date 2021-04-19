/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * tests ActiveTaskList class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class ActiveTaskListTest {

	/**
	 * Test method for setTaskListName()
	 */
	@Test
	public void testSetTaskListName() {
		ActiveTaskList aTL2 = new ActiveTaskList();
		assertEquals("Active Tasks", aTL2.getTaskListName());
		try {
			aTL2.setTaskListName("Cool Tasks");
			fail("This should throw an exception");
		} catch (IllegalArgumentException e) {
			assertEquals("The Active Tasks list may not be edited.", e.getMessage());
		}
		aTL2.setTaskListName("Active Tasks");
		assertEquals("Active Tasks", aTL2.getTaskListName());
	}

	/**
	 * Test method for addTask()
	 */
	@Test
	public void testAddTask() {
		Task t10 = new Task("Take test", "take math test", false, true);
		Task t10a = new Task("Do math homework", "Do even number problems in current chapter", true, true);
		ActiveTaskList aTL10 = new ActiveTaskList();
		aTL10.addTask(t10);
		aTL10.addTask(t10a);
		assertEquals("Take test", aTL10.getTask(0).getTaskName());
		assertEquals("Do math homework", aTL10.getTask(1).getTaskName());
		Task t10b = new Task("Call dad", "Call pops for cash", false, false);
		try {
			aTL10.addTask(t10b);
			fail("This task should throw an exception when trying to add");
		} catch (IllegalArgumentException e) {
			assertEquals("Cannot add task to Active Tasks.", e.getMessage());
		}
	}

	/**
	 * Test method for getTasksAsArray
	 */
	@Test
	public void testGetTasksAsArray() {
		Task t10 = new Task("Take test", "take math test", false, true);
		Task t10a = new Task("Do math homework", "Do even number problems in current chapter", true, true);
		ActiveTaskList tL10 = new ActiveTaskList();
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
	 * Test method for activeTaskList()
	 */
	@Test
	public void testActiveTaskList() {
		ActiveTaskList aTL1 = new ActiveTaskList();
		assertEquals("Active Tasks", aTL1.getTaskListName());
		assertEquals(0, aTL1.getCompletedCount());
	}

	/**
	 * Test method for clearTasks()
	 */
	@Test
	public void testClearTasks() {
		Task t10 = new Task("Take test", "take math test", false, true);
		Task t10a = new Task("Do math homework", "Do even number problems in current chapter", false, true);
		ActiveTaskList tL10 = new ActiveTaskList();
		tL10.addTask(t10);
		tL10.addTask(t10a);
		ISwapList<Task> aTL1 = new SwapList<Task>();
		aTL1 = tL10.getTasks();
		assertEquals(2, aTL1.size());
		tL10.clearTasks();
		ISwapList<Task> aTL2 = new SwapList<Task>();
		aTL2 = tL10.getTasks();
		assertEquals(0, aTL2.size());
		
	}

}
