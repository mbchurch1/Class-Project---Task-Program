package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

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

	public static void writeNotebookFile(File outputFile, String notebookName, ISortedList<TaskList> sortedList)
			throws IOException {
		PrintStream fileWriter = new PrintStream(outputFile);
		fileWriter.println("! " + notebookName);
		for (int i = 0; i < sortedList.size(); i++) {
			fileWriter
					.println("# " + sortedList.get(i).getTaskListName() + ", " + sortedList.get(i).getCompletedCount());
			for (int j = 0; j < sortedList.get(i).getTasks().size(); j++) {
				fileWriter.print(sortedList.get(i).getTasks().get(j).toString());
			}
		}
		fileWriter.close();
	}
}
