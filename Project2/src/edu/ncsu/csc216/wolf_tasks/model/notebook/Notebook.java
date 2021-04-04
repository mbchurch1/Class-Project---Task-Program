package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Notebook class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */

public class Notebook {
	
	/** Name of this notebook */
	private String notebookName;
	
	/** 
	 * Boolean variable representing a Notebook's contents have been 
	 * from their initial state 
	 */
	private boolean isChanged;
	
	/**
	 * Notebook constructor
	 * 
	 * @param notebookName the notebook name
	 */
	public Notebook(String notebookName) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Saves the Notebook to a file
	 * 
	 * @param file the file to save to
	 */
	public void saveNotebook(File file) {
		// TODO Auto-generated method stub

	}

	/**
	 * returns the notebook name
	 * 
	 * @return a string of the notebook name
	 */
	public String getNotebookName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Sets the name of this notebook
	 * @param name the new name of this notebook
	 */
	private void setNotebookName(String name) {
		
	}

	/**
	 * Checks if the notebook is edited
	 * 
	 * @return true if the notebook had been edited
	 */
	public boolean isChanged() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets the status of whether this notebook has been changed
	 * @param changedStatus whether a notebook has been changed
	 */
	public void setChanged(boolean changedStatus) {
		
	}
	
	/**
	 * adds a tasklist to the notebook
	 * 
	 * @param taskList the tasklist to add
	 */
	public void addTaskList(TaskList taskList) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * returns the tasklist names a String array
	 * 
	 * @return aString array of task list names
	 */
	public String[] getTaskListsNames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Gets the TaskList comprised of Active tasks
	 */
	private void getActiveTaskList() {
		
	}

	/**
	 * sets the current task list
	 * 
	 * @param taskListName the task list name chosen
	 */
	public void setCurrentTaskList(String taskListName) {
		// TODO Auto-generated method stub

	}

	/**
	 * returns the current task list
	 * 
	 * @return the current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * sets the tasklist name
	 * 
	 * @param taskListName a String of the new task list name
	 */
	public void editTaskList(String taskListName) {
		// TODO Auto-generated method stub

	}

	/**
	 * removes a task list from the notebook
	 */
	public void removeTaskList() {
		// TODO Auto-generated method stub

	}

	/**
	 * adds a task to the task list
	 * 
	 * @param t the task to add
	 */
	public void addTask(Task t) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}
