package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;
import java.io.IOException;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
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
 */
public class Notebook {

	/** Name of this notebook */
	private String notebookName;

	/**
	 * Boolean variable representing a Notebook's contents have been from their
	 * initial state
	 */
	private boolean isChanged;

	/** the list of taskLists */
	private ISortedList<TaskList> taskLists;
	/** the current tasklist */
	private AbstractTaskList currentTaskList;

	/**
	 * Notebook constructor
	 * 
	 * @param notebookName The notebook name
	 */
	public Notebook(String notebookName) {
		setNotebookName(notebookName);
		getActiveTaskList();
		taskLists = new SortedList<TaskList>();
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
		taskLists.add(taskList);
		currentTaskList = taskList;

	}

	/**
	 * returns the tasklist names a String array
	 * 
	 * @return aString Array of task list names
	 */
	public String[] getTaskListsNames() {
		// Code and Stuff
		return null;
	}

	/**
	 * Gets the TaskList comprised of Active tasks
	 */
	private void getActiveTaskList() {
		// Code
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
