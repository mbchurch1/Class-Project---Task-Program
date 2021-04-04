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

	public static final String ACTIVE_TASKS_NAME = "Active Tasks";
	
	/**
	 * Constructor for ActiveTaskList
	 * @param taskListName name of the taskList
	 * @param completedCount number of tasks in a TaskList that have been completed 
	 */
	public ActiveTaskList(String taskListName, int completedCount) {
		super(taskListName, completedCount);
	}
	
	/**
	 * Adds a task to the TaskList
	 * @param task being added to the TaskList
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * Sets the name of the TaskList
	 * @param name the new name of the TaskList 
	 */
	public void setTaskListName(String name) {
		
	}
	
	/**
	 * returns the tasks in the active list as a String array
	 * 
	 * @return a String array of active tasks
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Removes all tasks from the TaskList
	 */
	public void clearTasks() {
		
	}
}
