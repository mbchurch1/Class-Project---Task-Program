package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Concrete TaskList Class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	/**
	 * Task List constructor
	 * 
	 * @param taskListName task list name
	 * @param i            the amount of completed tasks
	 */
	public TaskList(String taskListName, int i) {
		super(taskListName, i);
	}

	/**
	 * Overides the abstract parent method. Returns an array of regular tasks.
	 * 
	 * @return taskArray An object array of unactive tasks
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] tasksArray = new String[super.getTasks().size()][2];
		for (int i = 0; i < super.getTasks().size(); i++) {
			tasksArray[i][0] = Integer.toString(i + 1);
			tasksArray[i][1] = super.getTasks().get(i).getTaskName();
		}
		return tasksArray;
	}

	/**
	 * Compares two TaskList objects for alphabetical order
	 * 
	 * @param list the list to which this TaskList is being compared
	 * @return 0 as a placeholder
	 */
	@Override
	public int compareTo(TaskList list) {
		return list.getTaskListName().compareToIgnoreCase(this.getTaskListName());
	}
}
