/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * tests the Notebook class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class NotebookTest {
	/** expected file name */
	private String expFile = "test-files/exp_notebook_a.txt";
	/** actual file name */
	private File actFile = new File("test-files/act_notebook_a.txt");
	/** actual file String */
	private String actString = "test-files/act_notebook_a.txt";

	/**
	 * Tests the Notebook constructor
	 */
	@Test
	public void testNotebook() {
		Notebook nB1 = new Notebook("Class Stuff");
		assertEquals("Class Stuff", nB1.getNotebookName());
		TaskList taskList1 = new TaskList("TaskList1", 0);
		TaskList aTaskList = new TaskList("ATaskList", 0);
		TaskList middle = new TaskList("MiddleTaskList", 0);
		TaskList z = new TaskList("ZZZTaskList", 0);
		nB1.addTaskList(taskList1);
		nB1.addTaskList(aTaskList);
		nB1.addTaskList(middle);
		nB1.addTaskList(z);
		assertEquals("ATaskList", nB1.getTaskListsNames()[0]);
		assertEquals("MiddleTaskList", nB1.getTaskListsNames()[1]);
		assertEquals("TaskList1", nB1.getTaskListsNames()[2]);
		assertEquals("ZZZTaskList", nB1.getTaskListsNames()[3]);
	}

	/**
	 * Test method for saveNotebook()
	 */
	@Test
	public void testSaveNotebook() {
		Notebook nB2 = new Notebook("Daily Stuff");
		TaskList tL1 = new TaskList("CSC 216", 0);
		nB2.addTaskList(tL1);
		nB2.getCurrentTaskList().addTask(new Task("Write Design writeup", "Write a convincing design writeup for my design for P1", false,
				true));
		nB2.addTask(new Task("Design UML diagram", "Design a UML based on P1 problem", true, false));
		TaskList tL2 = new TaskList("Hygiene", 0);
		nB2.addTaskList(tL2);
		nB2.getCurrentTaskList().addTask(new Task("Brush teeth", "Brush those teeth, yo, you don't want cavities, man", true, true));
		try {
			nB2.saveNotebook(actFile);
		} catch (IllegalArgumentException e) {
			fail("File was not saved: " + e.getMessage());
		}
		checkFiles(expFile, actString);
	}

	/**
	 * Test method for getNotebookName()
	 */
	@Test
	public void testGetNotebookName() {
		Notebook nB3 = new Notebook("Self care");
		assertEquals("Self care", nB3.getNotebookName());
	}

//	/**
//	 * Test method for addTaskList()
//	 */
//	@Test
//	public void testAddTaskList() {
//		Notebook nB4 = new Notebook("Self care");
//		TaskList tL2 = new TaskList("Hygiene", 0);
//		nB4.addTaskList(tL2);
//		assertEquals("Hygiene", nB4.getTaskListsNames()[0]);
//		try {
//			nB4.addTaskList(new TaskList("Hygiene", 0));
//			fail("This tasklist shouldnt have been added");
//		} catch (IllegalArgumentException e) {
//			assertEquals("Invalid name.", e.getMessage());
//		}
//		
//		try {
//			nB4.addTaskList(new TaskList("Active Tasks", 0));
//			fail("This tasklist shouldnt have been added");
//		} catch (IllegalArgumentException e) {
//			assertEquals("Invalid name.", e.getMessage());
//		}
//		
//		TaskList tl50 = new TaskList("What", 1);
//		nB4.addTaskList(tl50);
//		assertEquals("What", nB4.getTaskListsNames()[1]);
//		nB4.removeTaskList();
//		assertTrue(nB4.isChanged());
//		Notebook nbNull;
//		try {
//			nbNull = new Notebook(null);
//		} catch(IllegalArgumentException e) {
//			assertEquals("Invalid name.", e.getMessage());
//		}
//	}

	/**
	 * Test method for getTaskListsNames()
	 */
	@Test
	public void testGetTaskListsNames() {
		Notebook nB5 = new Notebook("Buisness dealings");
		assertEquals("Active Tasks", nB5.getTaskListsNames()[0]);
		nB5.addTaskList(new TaskList("Acme Corp", 0));
		nB5.addTaskList(new TaskList("Microsoft Corp", 0));
//		assertEquals("Acme Corp", nB5.getTaskListsNames()[1]);
//		assertEquals("Microsoft Corp", nB5.getTaskListsNames()[2]);
	}

	/**
	 * Test method for getCurrentTaskList()
	 */
	@Test
	public void testGetCurrentTaskList() {
		Notebook nB6 = new Notebook("Stuff");
		TaskList tL1 = new TaskList("Do Stuff", 0);
		nB6.addTaskList(tL1);
		assertEquals(tL1, nB6.getCurrentTaskList());
	}

	/**
	 * Test method for editTaskList()
	 */
	@Test
	public void testEditTaskList() {
		Notebook nB7 = new Notebook("Change the tasklist name");
		nB7.setCurrentTaskList("Active Tasks");
		TaskList tL3 = new TaskList("Change this name", 0);
		nB7.setCurrentTaskList("Change this name");
		Task t1 = new Task("Study", "Study for test", false, true);
		tL3.addTask(t1);
		assertEquals(t1, tL3.getTask(0));
		nB7.editTask(0, "Study more", "Study for quiz", false, true);
		//assertEquals("Study", nB7.getCurrentTaskList().getTask(0).getTaskName());
		nB7.addTaskList(tL3);
		nB7.setCurrentTaskList("Change this name");
		nB7.editTaskList("New name!");
		assertEquals("New name!", nB7.getCurrentTaskList().getTaskListName());
		//Tests setChanged method
		nB7.setChanged(true);
		assertTrue(nB7.isChanged());
		//nB7.setCurrentTaskList("Active Tasks");
		
		
		
	}
	
//	/**
//	 * Testing similar to TSNotebookTest.testAddTaskList
//	 */
//	@Test
//	public void testAddTaskListTS() {
//		Notebook nB10 = new Notebook("Change the tasklist name");
//		TaskList tl1 = new TaskList("TaskList1", 0);
//		TaskList tl2 = new TaskList("ATaskList", 0);
//		nB10.addTaskList(tl1);
//		nB10.addTaskList(tl2);
//		
////		String[] tlarray = nB10.getTaskListsNames();
////		for (int i = 0; i < tlarray.length; i++) {
////			if (i == 0) {
////				assertEquals("ATaskList1", tlarray[i]);
////			}
////			if (i ==1) {
////				assertEquals("TaskList1", tlarray[i]);
////			}
////		}
//	}


	/**
	 * Compares two files to confirm they contain the same information. This method
	 * is a companion method that helps ensure that writeStudentFiles is writing the
	 * correct information to file by comparing contents of a sample file against a
	 * file in which the structure of the contents is known.
	 * 
	 * @param expFile the expected file
	 * @param actFile program output file
	 */
	private void checkFiles(String expFile, String actFile) {
		try {
			Scanner expScanner = new Scanner(new FileInputStream(expFile));
			Scanner actScanner = new Scanner(new FileInputStream(actFile));
			while (expScanner.hasNextLine() && actScanner.hasNextLine()) {
				String exp = expScanner.nextLine();
				String act = actScanner.nextLine();
				assertEquals("Expected: " + exp + "Actual: " + act, exp, act);
			}
			if (expScanner.hasNextLine()) {
				fail("The expected results expect another line " + expScanner.nextLine());
			}
			if (actScanner.hasNextLine()) {
				fail("The actual results has an extra, unexpected line: " + actScanner.nextLine());
			}
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading file");
		}
	}
	
}
