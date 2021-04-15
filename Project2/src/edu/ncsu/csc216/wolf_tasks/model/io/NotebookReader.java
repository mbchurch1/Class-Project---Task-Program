package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;



import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Reads Notebooks from file
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class NotebookReader {

	/**
	 * reads a notebook from a file
	 * 
	 * @param file the file to read
	 * @return noteBook A Notebook object
	 */
	public static Notebook readNodebookFile(File file) {
		Notebook notebook = null;
		String nbReader = "";
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));
			if(fileReader.next() != "!") {
				throw new IllegalArgumentException("Unable to load file.");
			}
			
			while(fileReader.hasNextLine()) {
				nbReader += fileReader.nextLine() + "\n";
			}
			fileReader.close();
		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
	
		Scanner notebookReader = new Scanner(nbReader);
		notebookReader.useDelimiter("\\r?\\n?[#]");
		String noteBook = null;
		while(notebookReader.hasNext()) {
			noteBook = notebookReader.next();
			notebook = new Notebook(noteBook);
			notebook.addTaskList(processTaskList(notebookReader.next()));
		}
		
		notebookReader.close();
		return notebook;
	}

	/**
	 * Processes a TaskList read in from a Notebook file to achieve proper
	 * formatting
	 * 
	 * @param list a TaskList read in from file
	 * @return taskList A TaskList object
	 */
	private static TaskList processTaskList(String list) {
		Scanner taskListReader = new Scanner(list);
		String taskListName = taskListReader.nextLine().trim();
		
		TaskList newTaskList = new TaskList(taskListName, 0);
		taskListReader.useDelimiter("\\r?\\n?[*]");
		while(taskListReader.hasNext()) {
			newTaskList.addTask(processTask(newTaskList, taskListReader.next().trim()));
		}
		taskListReader.close();
		return newTaskList;
	}

	/**
	 * Process a Task read in from Notebook file that is part of a particular
	 * TaskList, formatting the task before returning
	 * 
	 * @param list       an AbstractTaskList object
	 * @param taskString a task that is part of the TaskList processed from a
	 *                   Notebook file
	 * @return task A Task object
	 */
	private static Task processTask(AbstractTaskList list, String taskString) {
		Scanner taskReader = new Scanner(taskString);
		String task = taskReader.nextLine();
		Scanner taskScanner = new Scanner(task);
		taskScanner.useDelimiter(",");
		Task newTask = null;
		String taskName = null;
		String taskDescription = null;
		String isRecurring = null;
		String isActive = null;
		while(taskScanner.hasNext()) {
			taskName = taskScanner.next();
			isRecurring = taskScanner.next();
			isActive = taskScanner.next();
		}
		while(taskReader.hasNext()) {
			taskDescription += taskReader.next();
		}
		newTask = new Task(taskName, taskDescription, Boolean.parseBoolean(isRecurring), Boolean.parseBoolean(isActive));
		
		
		taskReader.close();
		taskScanner.close();
		return newTask;
	}
}
