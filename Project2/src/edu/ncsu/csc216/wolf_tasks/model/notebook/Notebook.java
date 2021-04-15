package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;
import java.io.IOException;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * Notebook class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 * 
 *
 */

public class Notebook {

	/** Name of this notebook */
	private String notebookName;

	/**
	 * Boolean variable representing a Notebook's contents have been from their
	 * initial state /** Boolean variable representing a Notebook's contents have
	 * been from their initial state
	 */
	private boolean isChanged;

	/** the list of taskLists */
	private ISortedList<TaskList> taskLists;
	/** the current tasklist */
	private AbstractTaskList currentTaskList;
	/** the active task list */
	private ActiveTaskList activeTaskList;

	/** Active Tasks Name */
	private static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * Notebook constructor
	 * 
	 * @param notebookName The notebook name
	 */
	public Notebook(String notebookName) {
		setNotebookName(notebookName);
		// getActiveTaskList();
		taskLists = new SortedList<TaskList>();
		// activeTaskList = getActiveTaskList();
		currentTaskList = activeTaskList;
		isChanged = true;
	}

	/**
	 * Saves the Notebook to a file
	 * 
	 * @param file The file to save to
	 */
	public void saveNotebook(File file) {
		try {
			NotebookWriter.writeNotebookFile(file, notebookName, taskLists);
		} catch (IOException e) {
			throw new IllegalArgumentException("File unable to be saved");
		}
		isChanged = false;

	}

	/**
	 * returns the notebook name
	 * 
	 * @return notebookName A string of the notebook name
	 */
	public String getNotebookName() {
		// Code and Stuff
		return notebookName;
	}

	/**
	 * Sets the name of this notebook
	 * 
	 * @param name The new name of this notebook
	 */
	private void setNotebookName(String name) {
		this.notebookName = name;
		if (name == null || "".equals(name) || name.equals(ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		} else {
			notebookName = name;
		}
	}

	/**
	 * Checks if the notebook is edited
	 * 
	 * @return true if the notebook had been edited
	 */
	public boolean isChanged() {

		return isChanged;
	}

	/**
	 * Sets the status of whether this notebook has been changed
	 * 
	 * @param changedStatus whether a notebook has been changed
	 */
	public void setChanged(boolean changedStatus) {
		// Code
	}

	/**
	 * adds a tasklist to the notebook
	 * 
	 * @param taskList The tasklist to add
	 */
	public void addTaskList(TaskList taskList) {
		if (taskList.getTaskListName().equals(ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		// Need to traverse the SortedList, comparing taskList to each TaskList name in
		// SortedList while Ignoring case
		// CompareToIgnoreCase is a part of TaskList, but not SortedList
		for (int i = 0; i < taskLists.size(); i++) {
			TaskList current = taskLists.get(i);
			if (current.compareTo(taskList) == 0) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}

		taskLists.add(taskList);
		currentTaskList = taskList;
		isChanged = true;
	}

	/**
	 * returns the tasklist names a String array
	 * 
	 * @return aString Array of task list names
	 */
	public String[] getTaskListsNames() {
		String[] taskListNames = new String[taskLists.size()];
		taskListNames[0] = ACTIVE_TASKS_NAME;
		for (int i = 0; i < taskLists.size(); i++) {
			taskListNames[i + 1] = taskLists.get(i).getTaskListName();
		}
		return taskListNames;
	}

	private ActiveTaskList getActiveTaskList() {
		activeTaskList.clearTasks();
		// building the ActiveTaskList each time there’s a change can be easier since
		// you iterate through all the TaskLists and add each active Task
		for (int i = 0; i < taskLists.size(); i++) {
			String[][] currentList = taskLists.get(i).getTasksAsArray();
			for (int j = 0; j < currentList.length; j++) {
				// Task currentTask = currentList[j][1];
			}
		}
		return null;
	}

	/**
	 * sets the current task list
	 * 
	 * @param taskListName the task list name chosen
	 */
	public void setCurrentTaskList(String taskListName) {
		// Code

	}

	/**
	 * returns the current task list
	 * 
	 * @return taskList The current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		// Code
		return currentTaskList;
	}

	/**
	 * sets the tasklist name
	 * 
	 * @param taskListName a String of the new task list name
	 */
	public void editTaskList(String taskListName) {
		// Code

	}

	/**
	 * removes a task list from the notebook
	 */
	public void removeTaskList() {
		// Code

	}

	/**
	 * adds a task to the task list
	 * 
	 * @param t the task to add
	 */
	public void addTask(Task t) {
		currentTaskList.addTask(t);

	}

	/**
	 * edits the selected task
	 * 
	 * @param idx             the task index in the list
	 * @param taskName        the task name
	 * @param taskDescription the task description
	 * @param isRecurring     true if the task is recurring
	 * @param isActive        true if the task is active
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean isRecurring, boolean isActive) {
		// Code

	}
}
