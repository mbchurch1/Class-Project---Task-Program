/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;

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
	}
	
	@Test
	public void testGetActiveTasks() {
		Notebook nB8 = new Notebook("New NotebookForTest");
		TaskList tL4 = new TaskList("TaskList ForTest", 0);
		//active task
		Task t10 = new Task("Study", "Study for test", false, true);
		tL4.addTask(t10);
		//not active task
		Task t11 = new Task("Task11", "This is Task11", false, false);
		tL4.addTask(t11);
		TaskList tL5 = new TaskList("Another TaskList ForTest", 1);
		//not active task
		Task t12 = new Task("Task12", "This is Task12", false, false);
		tL5.addTask(t12);
		//active task
		Task t13 = new Task("Task13", "This is Active Task13", false, true);
		tL5.addTask(t13);
		nB8.addTaskList(tL4);
		nB8.addTaskList(tL5);
		
		nB8.setCurrentTaskList("Active Tasks");
		assertEquals("Active Tasks", nB8.getCurrentTaskList().getTaskListName());
	}

}
