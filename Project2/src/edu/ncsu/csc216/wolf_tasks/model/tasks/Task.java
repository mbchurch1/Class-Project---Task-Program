package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * Task class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class Task implements Cloneable {

	/** name of the task */
	private String taskName;

	/** description of the task */
	private String taskDescription;

	/** boolean variable representing whether a task is recurring */
	private boolean recurring;

	/** boolean variable representing whether a task is active */
	private boolean active;
	/** taskLists associated with the task */
	private ISwapList<AbstractTaskList> tasklists;

	/**
	 * Task constructor
	 * 
	 * @param taskName        the task name
	 * @param taskDescription the task description
	 * @param isRecurring     true if recurring
	 * @param isActive        true if active
	 */
	public Task(String taskName, String taskDescription, boolean isRecurring, boolean isActive) {
		setTaskName(taskName);
		setTaskDescription(taskDescription);
		setActive(isActive);
		setRecurring(isRecurring);
		tasklists = new SwapList<AbstractTaskList>();
	}

	/**
	 * returns the task name
	 * 
	 * @return taskName String task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the name of the task
	 * 
	 * @param name the new name of the task
	 * @throws IllegalArgumentException if the name is blank or null
	 */
	public void setTaskName(String name) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = name;
	}

	/**
	 * returns the task description
	 * 
	 * @return taskDescription String task description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Sets the description of the task
	 * 
	 * @param description the description of the task
	 * @throws IllegalArgumentException if the description is blank or null
	 */
	public void setTaskDescription(String description) {
		if (description == null /**|| "".equals(description) */) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDescription = description;
	}

	/**
	 * returns true if the task is recurring
	 * 
	 * @return true if the task is recurring
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**
	 * Sets the task to be either recurring or not recurring
	 * 
	 * @param recurringBool represents whether the task is recurring
	 */
	public void setRecurring(boolean recurringBool) {
		this.recurring = recurringBool;
	}

	/**
	 * returns true if the task is active
	 * 
	 * @return true if the task is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets whether the task is active
	 * 
	 * @param activeBool represents whether the task is active
	 */
	public void setActive(boolean activeBool) {
		this.active = activeBool;
	}

	/**
	 * Gets the name of the first AbstractTaskList
	 * 
	 * @return taskListName Name of the task list
	 */
	public String getTaskListName() {
		if (tasklists == null || tasklists.size() == 0) {
			return "";
		}
		return tasklists.get(0).getTaskListName();
	}

	/**
	 * Adds an AbstractTaskList that is associated with this task
	 * 
	 * @param list the AbstractTaskList being added
	 */
	public void addTaskList(AbstractTaskList list) {
		if (tasklists == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		tasklists.add(list);

	}

	/**
	 * completes the task
	 */
	public void completeTask() {
		try {
			for (int i = 0; i < tasklists.size(); i++) {
				tasklists.get(i).completeTask(this);
				if (this.isRecurring()) {
					tasklists.get(i).addTask(this.clone());
				}
			}
		} catch (CloneNotSupportedException e) {
			throw new IllegalArgumentException("This recurring task cannot be cloned.");
		}

	}

	/**
	 * Gets a copy of the task
	 * 
	 * @return clone Clone of the object
	 * @throws CloneNotSupportedException if the clone cannot be cloned
	 */
	public Task clone() throws CloneNotSupportedException {
		if (tasklists.size() == 0) {
			throw new CloneNotSupportedException("Cannot clone.");
		}
		Task copiedTask = (Task) super.clone();

		return copiedTask;

	}

	/**
	 * Produces a string representation of the task. Overrides the basic Java
	 * toString.
	 * 
	 * @return string String of the task
	 */
	@Override
	public String toString() {
		String taskToken = "* ";
		taskToken += getTaskName();
		if (recurring) {
			taskToken += ",recurring";
		}
		if (active) {
			taskToken += ",active";
		}
		taskToken += "\n";
		taskToken += getTaskDescription();
		return taskToken;
	}
}
