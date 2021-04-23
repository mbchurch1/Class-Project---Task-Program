package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

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
	/** list of tasks */
	private ISwapList<Task> tasks;

	/**
	 * Constructor for an AbstractTaskList
	 * 
	 * @param taskListName   the task list name
	 * @param completedCount the count of completed tasks
	 */
	public AbstractTaskList(String taskListName, int completedCount) {
		if (taskListName == null || "".equals(taskListName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		if (completedCount < 0) {
			throw new IllegalArgumentException("Invalid completed count.");
		}
		this.taskListName = taskListName;
		this.completedCount = completedCount;
		tasks = new SwapList<Task>();
	}

	/**
	 * returns the tasklist name
	 * 
	 * @return the task list name String
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**
	 * Sets the name of the TaskList
	 * 
	 * @param name the new name of the TaskList
	 */
	public void setTaskListName(String name) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Invalid list name.");
		}
		this.taskListName = name;
	}

	/**
	 * returns the list of tasks
	 * 
	 * @return the sorted list of tasks
	 */
	public ISwapList<Task> getTasks() {
		return tasks;
	}

	/**
	 * returns the completed tasks count
	 * 
	 * @return completedCount The String of completed tasks
	 */
	public int getCompletedCount() {

		return completedCount;
	}

	/**
	 * Adds a task to a TaskList
	 * 
	 * @param task the task being added to the TaskList
	 */
	public void addTask(Task task) {
		tasks.add(task);
		task.addTaskList(this);
	}

	/**
	 * removes the selected task
	 * 
	 * @param idx the index in the list of the task
	 * @return task The selected task
	 */
	public Task removeTask(int idx) {
		Task returnTask = tasks.get(idx);
		tasks.remove(idx);
		return returnTask;
	}

	/**
	 * returns the selected task
	 * 
	 * @param idx the index of the task in the list
	 * @return task The selected task
	 */
	public Task getTask(int idx) {
		return tasks.get(idx);
	}

	/**
	 * completes the selected task
	 * 
	 * @param task the task to complete
	 */
	public void completeTask(Task task) {
		int idx = -1;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i) == task) {
				idx = i;
			}
		}
		tasks.remove(idx);
		completedCount++;
	}

	/**
	 * returns the tasks in a list as String array
	 * 
	 * @return tasksArray The tasks in a list as and string array
	 */
	public abstract String[][] getTasksAsArray();

}
