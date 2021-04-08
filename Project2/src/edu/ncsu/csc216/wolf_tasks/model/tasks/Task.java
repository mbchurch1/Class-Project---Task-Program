package edu.ncsu.csc216.wolf_tasks.model.tasks;



/**
 * Task class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class Task {

	/** name of the task */
	private String taskName;

	/** description of the task */
	private String taskDescription;

	/** boolean variable representing whether a task is recurring */
	private boolean recurring;

	/** boolean variable representing whether a task is active */
	private boolean active;
	/** taskLists associated with the task */
	private AbstractTaskList tasklists;

	/**
	 * Task constructor
	 * 
	 * @param taskName        the task name
	 * @param taskDescription the task description
	 * @param isRecurring     true if recurring
	 * @param isActive        true if active
	 */
	public Task(String taskName, String taskDescription, boolean isRecurring, boolean isActive) {
		// Code
	}

	/**
	 * returns the task name
	 * 
	 * @return taskName String task name
	 */
	public String getTaskName() {
		// Code
		return taskName;
	}

	/**
	 * Sets the name of the task
	 * 
	 * @param name the new name of the task
	 */
	public void setTaskName(String name) {

	}

	/**
	 * returns the task description
	 * 
	 * @return taskDescription String task description
	 */
	public String getTaskDescription() {
		// Code
		return taskDescription;
	}

	/**
	 * Sets the description of the task
	 * 
	 * @param description the description of the task
	 */
	public void setTaskDescription(String description) {

	}

	/**
	 * returns true if the task is recurring
	 * 
	 * @return true if the task is recurring
	 */
	public boolean isRecurring() {
		// Code
		return recurring;
	}

	/**
	 * Sets the task to be either recurring or not recurring
	 * 
	 * @param recurringBool represents whether the task is recurring
	 */
	public void setRecurring(boolean recurringBool) {

	}

	/**
	 * returns true if the task is active
	 * 
	 * @return true if the task is active
	 */
	public boolean isActive() {
		// Code
		return active;
	}

	/**
	 * Sets whether the task is active
	 * 
	 * @param activeBool represents whether the task is active
	 */
	public void setActive(boolean activeBool) {

	}

	/**
	 * Gets the name of the first AbstractTaskList
	 * 
	 * @return taskListName Name of the task list
	 */
	public String getTaskListName() {
		return null;
	}

	/**
	 * Adds an AbstractTaskList that is associated with this task
	 * 
	 * @param list the AbstractTaskList being added
	 */
	public void addTaskList(AbstractTaskList list) {

	}

	/**
	 * completes the task
	 */
	public void completeTask() {
		// Code

	}

	/**
	 * Gets a copy of the task
	 * 
	 * @return clone Clone of the object
	 * @throws CloneNotSupportedException if the clone cannot be cloned
	 */
	public Object clone() throws CloneNotSupportedException {
		if (tasklists == null) {
			throw new CloneNotSupportedException("Cannot Clone.");
		} else {
			return null;
		}
	}

	/**
	 * Produces a string representation of the task
	 * 
	 * @return string String of the task
	 */
	public String toString() {
		return null;
	}
}
