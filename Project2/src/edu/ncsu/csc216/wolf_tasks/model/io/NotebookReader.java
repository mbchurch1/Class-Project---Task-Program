package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

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
		// Code
		processTaskList(null);
		processTask(null, null);
		return null;
	}

	/**
	 * Processes a TaskList read in from a Notebook file to achieve proper
	 * formatting
	 * 
	 * @param list a TaskList read in from file
	 * @return taskList A TaskList object
	 */
	private static TaskList processTaskList(String list) {
		return null;
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
