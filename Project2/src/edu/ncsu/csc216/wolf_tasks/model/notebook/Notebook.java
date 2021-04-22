package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;
import java.io.IOException;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * Notebook class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 * 
 *
 */

public class Notebook {

	/** Name of this notebook */
	private String notebookName;

	/**
	 * Boolean variable representing a Notebook's contents have been from their
	 * initial state /** Boolean variable representing a Notebook's contents have
	 * been from their initial state
	 */
	private boolean isChanged;

	/** the list of taskLists */
	private ISortedList<TaskList> taskLists;
	/** the current tasklist */
	private AbstractTaskList currentTaskList;
	/** the active task list */
	private ActiveTaskList activeTaskList;

	/** Active Tasks Name */
	private static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * Notebook constructor
	 * 
	 * @param notebookName The notebook name
	 */
	public Notebook(String notebookName) {
		setNotebookName(notebookName);
		// getActiveTaskList();
		taskLists = new SortedList<TaskList>();
		activeTaskList = new ActiveTaskList();
		currentTaskList = activeTaskList;
		isChanged = true;
	}

	/**
	 * Saves the Notebook to a file
	 * 
	 * @param file The file to save to
	 */
	public void saveNotebook(File file) {
		try {
			NotebookWriter.writeNotebookFile(file, notebookName, taskLists);
		} catch (IOException e) {
			throw new IllegalArgumentException("File unable to be saved");
		}
		isChanged = false;

	}

	/**
	 * returns the notebook name
	 * 
	 * @return notebookName A string of the notebook name
	 */
	public String getNotebookName() {
		// Code and Stuff
		return notebookName;
	}

	/**
	 * Sets the name of this notebook
	 * 
	 * @param name The new name of this notebook
	 */
	private void setNotebookName(String name) {
		if (name == null || "".equals(name) || name.equals(ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		} else {
			notebookName = name;
		}
		this.notebookName = name;
	}

	/**
	 * Checks if the notebook is edited
	 * 
	 * @return true if the notebook had been edited
	 */
	public boolean isChanged() {
		return isChanged;
	}

	/**
	 * Sets the status of whether this notebook has been changed
	 * 
	 * @param changedStatus whether a notebook has been changed
	 */
	public void setChanged(boolean changedStatus) {
		isChanged = changedStatus;
	}

	/**
	 * adds a tasklist to the notebook
	 * 
	 * @param taskList The tasklist to add
	 */
	public void addTaskList(TaskList taskList) {
		if (taskList.getTaskListName().equals(ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		// Need to traverse the SortedList, comparing taskList to each TaskList name in
		// SortedList while Ignoring case
		for (int i = 0; i < taskLists.size(); i++) {
			TaskList current = taskLists.get(i);
			if (current.compareTo(taskList) == 0) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}

		taskLists.add(taskList);
		currentTaskList = taskList;
		isChanged = true;
	}

	/**
	 * returns the tasklist names a String array
	 * 
	 * @return aString Array of task list names
	 */
	public String[] getTaskListsNames() {
		if (taskLists.size() == 0) {
			String[] activeTaskListName = new String[1];
			activeTaskListName[0] = ACTIVE_TASKS_NAME;
			return activeTaskListName;
		}
		//taskLists.size()+1 now accounts for ActiveTasks - temporarily deleting the +1 to see 
		//if it gets rid of NPE
		String[] taskListNames = new String[taskLists.size()];
		taskListNames[0] = ACTIVE_TASKS_NAME;
		for (int i = 1; i <= taskLists.size(); i++) {
			taskListNames[i] = taskLists.get(i).getTaskListName();
		}
		return taskListNames;
	}

	private ActiveTaskList getActiveTaskList() {
		if (activeTaskList != null) {
			activeTaskList.clearTasks();
		}
		// building the ActiveTaskList each time there’s a change can be easier since
		// you iterate through all the TaskLists and add each active Task
		for (int i = 0; i < taskLists.size(); i++) {
			TaskList currentList = taskLists.get(i);
			ISwapList<Task> taskSwapList = currentList.getTasks();
			for (int j = 0; j < taskSwapList.size(); j++) {
				Task currentTask = taskSwapList.get(j);
				if (currentTask.isActive()) {
					activeTaskList.addTask(currentTask);
				}
			}
		}
		return activeTaskList;
	}

	/**
	 * sets the current task list
	 * 
	 * @param taskListName the task list name chosen
	 */
	public void setCurrentTaskList(String taskListName) {
		if (taskListName.equals(ACTIVE_TASKS_NAME)) {
			currentTaskList = this.getActiveTaskList();
		} else {
			AbstractTaskList listToBeCurrent = null;
			for (int i = 0; i < taskLists.size(); i++) {
				currentTaskList = taskLists.get(i);
				String currentListName = currentTaskList.getTaskListName();
				if(currentListName.equals(taskListName)) {
					listToBeCurrent = currentTaskList;
				}
			}
			if (listToBeCurrent == null) {
				currentTaskList = activeTaskList;
			} else {
				currentTaskList = listToBeCurrent;
			}
		}
	}

	/**
	 * returns the current task list
	 * 
	 * @return taskList The current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}

	/**
	 * sets the tasklist name
	 * 
	 * @param taskListName a String of the new task list name
	 */
	public void editTaskList(String taskListName) {
		if (currentTaskList == activeTaskList) {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
		if (taskListName == ACTIVE_TASKS_NAME) {
			throw new IllegalArgumentException("Cannot create new Active Task List.");
		}
		for (int i = 0; i < taskLists.size(); i++) {
			currentTaskList = taskLists.get(i);
			String currentListName = currentTaskList.getTaskListName();
			if(currentListName.equalsIgnoreCase(taskListName)) {
				throw new IllegalArgumentException("Cannot create duplicate Task List name.");
			}
		}
		
		String currentName = currentTaskList.getTaskListName();
		TaskList removedCurrentTask = null;
		
		for (int i = 0; i < taskLists.size(); i++) {
			currentTaskList = taskLists.get(i);
			String currentListName = currentTaskList.getTaskListName();
			if(currentListName.equalsIgnoreCase(currentName)) {
				removedCurrentTask = taskLists.remove(i);
			}
		}
		
		removedCurrentTask.setTaskListName(taskListName);
		
		this.addTaskList(removedCurrentTask);
	}

	/**
	 * removes a task list from the notebook
	 */
	public void removeTaskList() {
		if (currentTaskList == activeTaskList) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}
		
		String currentTaskListName = currentTaskList.getTaskListName();
		
		for (int i = 0; i < taskLists.size(); i++) {
			currentTaskList = taskLists.get(i);
			String currentListName = currentTaskList.getTaskListName();
			if(currentListName.equals(currentTaskListName)) {
				taskLists.remove(i);
			}
		}
		
		currentTaskList = activeTaskList;
		isChanged = true;
	}

	/**
	 * adds a task to the task list
	 * 
	 * @param task the task to add
	 */
	public void addTask(Task task) {
		
		if(currentTaskList != activeTaskList && currentTaskList != null) {
			currentTaskList.addTask(task);
			if (task.isActive()) {
				this.getActiveTaskList();
			}
			isChanged = true;
		}
		
		
		
//		if(currentTaskList == activeTaskList || currentTaskList == null) {
//			
//		} else {
//			currentTaskList.addTask(task);
//			if (task.isActive()) {
//				this.getActiveTaskList();
//			}
//			isChanged = true;
//		}
		
	}

	/**
	 * edits the selected task
	 * 
	 * @param idx             the task index in the list
	 * @param taskName        the task name
	 * @param taskDescription the task description
	 * @param isRecurring     true if the task is recurring
	 * @param isActive        true if the task is active
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean isRecurring, boolean isActive) {
		if(taskName == null || taskDescription == null) {
			throw new NullPointerException("Cannot edit task.");
		}
		
		
		if(currentTaskList != activeTaskList && currentTaskList != null) {
			Task taskBeingEdited = currentTaskList.getTask(idx);
			taskBeingEdited.setTaskName(taskName);
			taskBeingEdited.setTaskDescription(taskDescription);
			taskBeingEdited.setRecurring(isRecurring);
			taskBeingEdited.setActive(isActive);
			if (taskBeingEdited.isActive()) {
				this.getActiveTaskList();
			}
			isChanged = true;
		}
		
		
		
		
		
//		if(currentTaskList == activeTaskList || currentTaskList == null) {
//			
//		} else {
//			Task taskBeingEdited = currentTaskList.getTask(idx);
//			taskBeingEdited.setTaskName(taskName);
//			taskBeingEdited.setTaskDescription(taskDescription);
//			taskBeingEdited.setRecurring(isRecurring);
//			taskBeingEdited.setActive(isActive);
//			if (taskBeingEdited.isActive()) {
//				this.getActiveTaskList();
//			}
//			isChanged = true;
//		}

	}
}


