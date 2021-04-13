package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * Notebook class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 * @param <E>
 *
 */
public class Notebook<E> {
	
	/** Name of this notebook */
	private String notebookName;
	/** 
	 * Boolean variable representing a Notebook's contents have been 
	 * from their initial state 
	 */
	private boolean isChanged;
	
	private SortedList<TaskList> taskLists;
	
	private ActiveTaskList activeTaskList;
	
	private AbstractTaskList currentTaskList;
	
	/** Active Tasks Name */
	private static final String ACTIVE_TASKS_NAME = "Active Tasks";
	
	/**
	 * Notebook constructor
	 * 
	 * @param notebookName  The notebook name
	 */
	public Notebook(String notebookName) {
		setNotebookName(notebookName);
		taskLists = new SortedList<TaskList>();
		activeTaskList = getActiveTaskList();
		currentTaskList = activeTaskList;
		isChanged = true;
	}
	
	/**
	 * Saves the Notebook to a file
	 * 
	 * @param file  The file to save to
	 */
	public void saveNotebook(File file) {
		// Code and stuff

	}

	/**
	 * returns the notebook name
	 * 
	 * @return notebookName  A string of the notebook name
	 */
	public String getNotebookName() {
		// Code and Stuff
		return notebookName;
	}
	
	/**
	 * Sets the name of this notebook
	 * @param name  The new name of this notebook
	 */
	private void setNotebookName(String name) {
		if (name == null || name == "" || name.equals(ACTIVE_TASKS_NAME)) {
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
	 * @param changedStatus whether a notebook has been changed
	 */
	public void setChanged(boolean changedStatus) {
		//Code
	}
	
	/**
	 * adds a tasklist to the notebook
	 * 
	 * @param taskList  The tasklist to add
	 */
	public void addTaskList(TaskList taskList) {
		// Code and Stuff

	}
	
	/**
	 * returns the tasklist names a String array
	 * 
	 * @return aString  Array of task list names
	 */
	public String[] getTaskListsNames() {
		// Code and Stuff
		return null;
	}
	
	/**
	 * Gets the TaskList comprised of Active tasks
	 */
	private ActiveTaskList getActiveTaskList() {
		//Code
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
	 * @return taskList  The current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		// Code
		return null;
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
		// Code

	}

	/**
	 * edits the selected task
	 * @param idx the task index in the list
	 * @param taskName the task name
	 * @param taskDescription the task description
	 * @param isRecurring true if the task is recurring
	 * @param isActive true if the task is active
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean isRecurring, boolean isActive) {
		// Code

	}

}
