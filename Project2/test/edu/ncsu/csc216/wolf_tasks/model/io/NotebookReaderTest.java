/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;

/**
 * Tests NotebookReader class
 * 
 * @author Matthew Church
 * @author Will Goodwin
 * @author John Firlet
 *
 */
public class NotebookReaderTest {

	/**
	 * tests readNodebookFile
	 */
	@Test
	public void testReadNodebookFile() {
		NotebookReader reader1 = new NotebookReader();
		
		Notebook notebook1 = null;
		
		File notebook1File = new File("test-files/notebook1.txt");
		
		notebook1 = reader1.readNodebookFile(notebook1File);
		assertTrue(notebook1.isChanged());
	}

}
