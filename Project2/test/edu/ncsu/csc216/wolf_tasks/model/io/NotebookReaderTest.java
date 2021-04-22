/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Tests NotebookReader class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class NotebookReaderTest {

	/**
	 * tests readNodebookFile
	 */
	@Test
	public void testReadNodebookFile() {
		NotebookReader reader1 = new NotebookReader();
		
		Notebook notebook1 = null;
		
		File notebook1File = new File("test-files/notebook1.txt");
		
		notebook1 = reader1.readNodebookFile(notebook1File);
		assertTrue(notebook1.isChanged());
		//This should be "Active Tasks" so that's what I'm trying to debug below
		//Notebook should load "Active Tasks" as the currentTaskList even when the file contain
		assertEquals("Active Tasks", notebook1.getCurrentTaskList().getTaskListName());
	}
	
	@Test
	public void testGetActiveTasks() {
		Notebook nB8 = new Notebook("New NotebookForTest");
		TaskList tL4 = new TaskList("TaskList1 ForTest", 0);
		//active task
		Task t10 = new Task("Study", "Study for test", false, true);
		tL4.addTask(t10);
		assertEquals("Study", tL4.getTask(0).getTaskName());
		assertEquals("TaskList1 ForTest", tL4.getTask(0).getTaskListName());
		//not active task
		Task t11 = new Task("Task11", "This is Task11", false, false);
		tL4.addTask(t11);
		assertEquals("Task11", tL4.getTask(1).getTaskName());
		assertEquals("TaskList1 ForTest", tL4.getTask(1).getTaskListName());
		TaskList tL5 = new TaskList("Another TaskList ForTest", 1);
		//not active task
		Task t12 = new Task("Task12", "This is Task12", false, false);
		tL5.addTask(t12);
		assertEquals("Task12", tL5.getTask(0).getTaskName());
		assertEquals("Another TaskList ForTest", tL5.getTask(0).getTaskListName());
		//active task
		Task t13 = new Task("Task13", "This is Active Task13", false, true);
		tL5.addTask(t13);
		assertEquals("Task13", tL5.getTask(1).getTaskName());
		assertEquals("Another TaskList ForTest", tL5.getTask(1).getTaskListName());
		nB8.addTaskList(tL4);
		//nB8.addTaskList(tL5);
//		assertEquals("Another TaskList ForTest", nB8.getCurrentTaskList().getTaskListName());
//		nB8.setCurrentTaskList("TaskList1 ForTest");
//		assertEquals("TaskList1 ForTest", nB8.getCurrentTaskList().getTaskListName());
//		nB8.setCurrentTaskList("Another TaskList ForTest");
//		assertEquals("Another TaskList ForTest", nB8.getCurrentTaskList().getTaskListName());
		
//		//Notebook.setCurrentTaskList() is accurately determining that ActiveTaskList is null
//		nB8.setCurrentTaskList("Not real TaskList");
//		//When Notebook.getCurrentTaskList is attempting to return "Active Tasks" it determines that currentTaskList is null, so this assert fails
//		assertEquals("Active Tasks", nB8.getCurrentTaskList().getTaskListName());
	
		
		nB8.setCurrentTaskList("Active Tasks");
//		try {
//			nB8.setCurrentTaskList("Active Tasks");
//		} catch (NullPointerException ex) {
//			System.out.println(ex.getCause());
//		}
		
		assertEquals("Active Tasks", nB8.getCurrentTaskList().getTaskListName());
	}

}
