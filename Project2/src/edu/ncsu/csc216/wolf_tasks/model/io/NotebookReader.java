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
		if (file == null) {
			throw new IllegalArgumentException("File does not exist.");
		} 
		
		String entireFile = "";
		Notebook notebook = new Notebook("Current Notebook");
		
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file)); 
			while(fileReader.hasNextLine()) {
				entireFile += fileReader.nextLine() + "\n";
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File cannot be read: " + file);
		}
		
		if(entireFile.charAt(0) != '!') {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		String taskListToken = "";
		Scanner taskListScanner = new Scanner(entireFile).useDelimiter("\\r?\\n?[#]");
		
		while (taskListScanner.hasNext()) {
			taskListToken = taskListScanner.next();
			TaskList taskList = processTaskList(taskListToken);
			notebook.addTaskList(taskList);
		}
		
		taskListScanner.close();

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
		String listName = "";
		int numCompletedTasks = 0;
		Scanner lineScanner = new Scanner(list);
		
		String nameAndCompletions = lineScanner.nextLine();
		String trimmedNameAndCompletions = nameAndCompletions.trim();
		Scanner nameVsCompletionsScanner = new Scanner(trimmedNameAndCompletions).useDelimiter(",");
		listName = nameVsCompletionsScanner.next();
		if(nameVsCompletionsScanner.hasNextInt()) {
			numCompletedTasks = nameVsCompletionsScanner.nextInt();
		}
		
		String taskListString = "";
		
		while(lineScanner.hasNextLine()) {
			taskListString += lineScanner.nextLine() + "\n";
		}
		
		TaskList taskList = new TaskList(listName, numCompletedTasks);
		
		Scanner taskTokenScanner = new Scanner(taskListString).useDelimiter("\\r?\\n?[*]");
		while (taskTokenScanner.hasNext()) {
			String taskToken = taskTokenScanner.next();
			Task taskForTaskList = processTask(taskList, taskToken);
			taskList.addTask(taskForTaskList);
		}
		
		lineScanner.close();
		nameVsCompletionsScanner.close();
		taskTokenScanner.close();
		
		return taskList;
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
		return null;
	}
}
