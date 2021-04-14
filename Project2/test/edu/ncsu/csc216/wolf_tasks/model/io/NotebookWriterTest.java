package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * tests NotebookWriter class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class NotebookWriterTest {
	/** expected file name */
	private String expFile = "test-files/exp_notebook_a.txt";
	/** actual file name */
	private File actFile = new File("test-files/act_notebook_a.txt");
	/** actual file String */
	private String actString = "test-files/act_notebook_a.txt";

	/**
	 * tests NotebookWriter
	 */
	@Test
	public void testWriteNotebookFile() {
		Notebook a = new Notebook("Daily Stuff");
		TaskList tL1 = new TaskList("CSC 216", 0);
		a.addTaskList(tL1);
		a.addTask(new Task("Write Design writeup", "Write a convincing design writeup for my design for P1", false,
				true));
		a.addTask(new Task("Design UML diagram", "Design a UML based on P1 problem", true, false));
		TaskList tL2 = new TaskList("Hygiene", 0);
		a.addTaskList(tL2);
		a.addTask(new Task("Brush teeth", "Brush those teeth, yo, you don't want cavities, man", true, true));
		try {
			a.saveNotebook(actFile);
		} catch (IllegalArgumentException e) {
			fail("File was not saved: " + e.getMessage());
		}
		checkFiles(expFile, actString);

	}

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
