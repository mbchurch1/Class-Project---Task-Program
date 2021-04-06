package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Abstract class for TaskList
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public abstract class AbstractTaskList {
	
	/** Name of a TaskList */
	private String taskListName;
	
	/** Number of tasks from a TaskList that have been completed */
	private int completedCount;
	
	/**
	 * Constructor for an AbstractTaskList
	 * @param taskListName
	 * @param completedCount
	 */
	public AbstractTaskList(String taskListName, int completedCount) {
		
	}
	
	/**
	 * returns the tasklist name
	 * @return the task list name String
	 */
	public String getTaskListName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Sets the name of the TaskList
	 * @param name the new name of the TaskList
	 */
	public void setTaskListName(String name) {
		
	}
	
	/**
	 * returns the list of tasks
	 * @return the sorted list of tasks
	 */
	public ISwapList<Task> getTasks() {
		return null;
	}
	
	/**
	 * returns the completed tasks count
	 * @return completedCount  The String of completed tasks
	 */
	public String getCompletedCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Adds a task to a TaskList
	 * @param task the task being added to the TaskList
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * removes the selected task
	 * @param idx the index in the list of the task
	 * @return task  The selected task
	 */
	public Task removeTask(int idx) {
		return null;
	}
	
	/**
	 * returns the selected task
	 * @param idx the index of the task in the list
	 * @return task  The selected task
	 */
	public Task getTask(int idx) {
		return null;
	}
	
	/**
	 * completes the selected task
	 * @param task the task to complete
	 */
	public void completeTask(Task task) {

	}

	/**
	 * returns  the tasks in a list as String array
	 * @return tasksArray  The tasks in a list as and string array
	 */
	public abstract String[][] getTasksAsArray();

}
