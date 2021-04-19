package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Active Task List constructor
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class ActiveTaskList extends AbstractTaskList {

	/** Active Tasks Name */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * Constructor for ActiveTaskList
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	/**
	 * Adds a task to the TaskList
	 * 
	 * @param task being added to the TaskList
	 * @throws IllegalArgumentException if the task is not active
	 */
	public void addTask(Task task) {
		if (task.isActive()) {
			super.addTask(task);
		} else {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}

	}

	/**
	 * Sets the name of the TaskList
	 * 
	 * @param name the new name of the TaskList
	 * @throws IllegalArgumentException if the new name does not match the set name
	 */
	public void setTaskListName(String name) {
		if (ACTIVE_TASKS_NAME.equals(name)) {
			super.setTaskListName(name);
		} else {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
	}

	/**
	 * returns the tasks in the active list as a String array
	 * 
	 * @return tasksArray A String array of active tasks
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] tasksArray = new String[this.getTasks().size()][2];
		for (int i = 0; i < this.getTasks().size(); i++) {
			tasksArray[i][0] = ACTIVE_TASKS_NAME;
			tasksArray[i][1] = this.getTasks().get(i).getTaskName();
		}
		return tasksArray;
	}

	/**
	 * Removes all tasks from the TaskList
	 */
	public void clearTasks() {
		int idx = this.getTasks().size() - 1;
		while (idx != -1) {
			this.removeTask(idx);
			idx--;
		}
	}
}
