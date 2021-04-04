package edu.ncsu.csc216.wolf_tasks.model.tasks;
/**
 * Task class
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
	
	/**
	 * Task constructor
	 * @param taskName the task name
	 * @param taskDescription the task description
	 * @param isRecurring true if recurring
	 * @param isActive true if active
	 */
	public Task(String taskName, String taskDescription, boolean isRecurring, boolean isActive) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * returns the task name
	 * @return String task name
	 */
	public String getTaskName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Sets the name of the task
	 * @param name the new name of the task
	 */
	public void setTaskName(String name) {
		
	}
	
	/**
	 * returns the task description
	 * @return String task description
	 */
	public String getTaskDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Sets the description of the task
	 * @param description the description of the task
	 */
	public void setTaskDescription(String description) {
		
	}
	
	/**
	 * returns true if the task is recurring
	 * @return true if the task is recurring
	 */
	public boolean isRecurring() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets the task to be either recurring or not recurring
	 * @param recurringBool represents whether the task is recurring
	 */
	public void setRecurring(boolean recurringBool) {
		
	}
	
	/**
	 * returns true if the task is active
	 * @return true if the task is active
	 */
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Sets whether the task is active
	 * @param activeBool represents whether the task is active
	 */
	public void setActive(boolean activeBool) {
		
	}
	
	/**
	 * Gets the name of the first AbstractTaskList 
	 */
	public String getTaskListName() {
		return null;
	}
	
	/**
	 * Adds an AbstractTaskList that is associated with this task
	 * @param list the AbstractTaskList being added
	 */
	public void addTaskList(AbstractTaskList list) {
		
	}

	/**
	 * completes the task
	 */
	public void completeTask() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Gets a copy of the task
	 */
	public Object clone() {
		return null;
	}

	/**
	 * Produces a string representation of the task
	 */
	public String toString() {
		return null;
	}
}
