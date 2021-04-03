package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Abstract class for TaskList
 * 
 * @author Matthew Church
 *
 */
public abstract class AbstractTaskList {
	
	/**
	 * returns the tasklist name
	 * @return the task list name String
	 */
	public String getTaskListName() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * returns the completed tasks count
	 * @return the String of completed tasks
	 */
	public String getCompletedCount() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * returns the selected task
	 * @param idx the index of the task in the list
	 * @return the selected task
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
	 * removes the selected task
	 * @param idx the index in the list of the task
	 * @return the selected task
	 */
	public Task removeTask(int idx) {
		return null;
	}
	/**
	 * returns the list of tasks
	 * @return the sorted list of tasks
	 */
	public ISwapList<Task> getTasks() {
		return null;
	}
	/**
	 * returns  the tasks in a list as String array
	 * @return the tasks in a list as and string array
	 */
	public abstract String[][] getTasksAsArray();

}
