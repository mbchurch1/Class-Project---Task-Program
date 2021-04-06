package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Concrete TaskList Class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class TaskList extends AbstractTaskList {
	
	/**
	 * Task List constructor
	 * 
	 * @param taskListName task list name
	 * @param i the index of the tasklist
	 */
	public TaskList(String taskListName, int i) {
		super(taskListName, i);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Overides the abstract parent method. Returns an array of regular tasks.
	 * @return taskArray  An object array of unactive tasks
	 */
	@Override
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Compares two TaskList objects for alphabetical order
	 * @param list the list to which this TaskList is being compared
	 * @return 0 as a placeholder
	 */
	public int compareTo(TaskList list) {
		return 0;
	}
}
