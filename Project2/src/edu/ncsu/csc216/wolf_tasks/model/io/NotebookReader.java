package edu.ncsu.csc216.wolf_tasks.model.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
/**
 * Reads Notebooks from file
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class NotebookReader {


	/** String representing a recurring task in the notebook file */
	private static final String RECURRING = "recurring"; 
	/** String representing an active task in the notebook file */
	private static final String ACTIVE = "active"; 

//	/**
//	 * Constructs the Notebookreader object
//	 */
//	public NotebookReader() {
//		
//	}
	
	/**
	 * reads a notebook from a file
	 * 
	 * @param file the file to read
	 * @return noteBook A Notebook object
	 */
	public static Notebook readNodebookFile(File file) {
		if (file == null) {
			throw new IllegalArgumentException("File does not exist.");
		} 
		
		String entireFile = "";
		//Notebook notebook = new Notebook("Current Notebook");
		
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file)); 
			while(fileReader.hasNextLine()) {
				entireFile += fileReader.nextLine() + "\n";
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File cannot be read: " + file);
		}
		
		if(entireFile.charAt(0) != '!') {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		Scanner notebookNameScanner = new Scanner(entireFile);
		notebookNameScanner.next();
		String notebookName = "";
		notebookName = notebookNameScanner.nextLine();
		
		String trimmedName = notebookName.trim();
		Notebook notebook = new Notebook(trimmedName);
		
		String notebookMinusName = "";
		while (notebookNameScanner.hasNextLine()) {
			notebookMinusName += notebookNameScanner.nextLine() + "\n";
		}
		
		String taskListToken = "";
		Scanner taskListScanner = new Scanner(notebookMinusName).useDelimiter("\\r?\\n?[#]");
		
		while (taskListScanner.hasNext()) {
			taskListToken = taskListScanner.next();
			TaskList taskList = processTaskList(taskListToken);
			notebook.addTaskList(taskList);
		}
		
		notebookNameScanner.close();
		taskListScanner.close();
		return notebook;
	}
	/**
	 * Processes a TaskList read in from a Notebook file to achieve proper
	 * formatting
	 * 
	 * @param list a TaskList read in from file
	 * @return taskList A TaskList object
	 */
	private static TaskList processTaskList(String list) {
		String listName = "";
		int numCompletedTasks = 0;
		Scanner lineScanner = new Scanner(list);

		String nameAndCompletions = lineScanner.nextLine();
		//String trimmedNameAndCompletions = nameAndCompletions.trim();
		Scanner nameVsCompletionsScanner = new Scanner(nameAndCompletions).useDelimiter(",");
		listName = nameVsCompletionsScanner.next();
		String trimmedName = listName.trim();
		if(nameVsCompletionsScanner.hasNextInt()) {
			numCompletedTasks = nameVsCompletionsScanner.nextInt();
		}
		
		String taskListString = "";
		
		while(lineScanner.hasNextLine()) {
			taskListString += lineScanner.nextLine() + "\n";
		}

		TaskList taskList = new TaskList(trimmedName, numCompletedTasks);

		Scanner taskTokenScanner = new Scanner(taskListString).useDelimiter("\\r?\\n?[*]");
		while (taskTokenScanner.hasNext()) {
			String taskToken = taskTokenScanner.next();
			Task taskForTaskList = processTask(taskList, taskToken);
			taskList.addTask(taskForTaskList);
		}
		
		lineScanner.close();
		nameVsCompletionsScanner.close();
		taskTokenScanner.close();
		
		return taskList;
	}
	/**
	 * Process a Task read in from Notebook file that is part of a particular
	 * TaskList, formatting the task before returning
	 * 
	 * @param taskList       an AbstractTaskList object
	 * @param taskToken a task that is part of the TaskList processed from a
	 *                   Notebook file
	 * @return newTask A Task object
	 */
	private static Task processTask(AbstractTaskList taskList, String taskToken) {
		String taskName = "";
		String taskDescription = ""; 
		boolean isRecurring = false; 
		boolean isActive = false;

		Scanner taskTokenScanner = new Scanner(taskToken);

		String taskNameAndModifiers = taskTokenScanner.nextLine();
		while(taskTokenScanner.hasNextLine()) {
			taskDescription += taskTokenScanner.nextLine() + "\n";
		}

		Scanner taskNameAndModsScanner = new Scanner(taskNameAndModifiers);

		String recurringOrActive1 = "";
		String recurringOrActive2 = "";

		if(taskNameAndModsScanner.hasNext()) {
			taskName = taskNameAndModsScanner.next().trim();
		}
		if(taskNameAndModsScanner.hasNext()) {
			recurringOrActive1 = taskNameAndModsScanner.next();
			if (recurringOrActive1.equals(RECURRING)) {
				isRecurring = true;
			} else if (recurringOrActive1.equals(ACTIVE)) {
				isActive = true;
			} 
		}
		if(taskNameAndModsScanner.hasNext()) {
			recurringOrActive2 = taskNameAndModsScanner.next();
			if (recurringOrActive2.equals(RECURRING)) {
				isRecurring = true;
			} else if (recurringOrActive2.equals(ACTIVE)) {
				isActive = true;
			} 
		}

		Task newTask = new Task(taskName, taskDescription, isRecurring, isActive);

		taskTokenScanner.close();
		taskNameAndModsScanner.close();

		return newTask;
	}
}