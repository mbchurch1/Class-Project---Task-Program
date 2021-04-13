package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;


/**
 * Writes Notebooks to a file
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class NotebookWriter {

	/**
	 * Writes a notebook of TaskLists and Tasks to file
	 * 
	 * @param outputFile   name of the file to which the notebook is being written
	 * @param notebookName Name of the notebook being written to file
	 * @param sortedList   a sorted list of TaskLists
	 */
	public static void writeNotebookFile(File outputFile, String notebookName, SortedList<TaskList> sortedList) {
		//Code
		// NOTE: Changed sortedList to TaskList for now, to pass SA, Change back Later
	}
}
