package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

public class printTest {

	public static void main(String[] args) {
//		NotebookReader reader = new NotebookReader();
		File notebook1File = new File("test-files/notebook1.txt");
		NotebookReader.readNodebookFile(notebook1File);

	}

}
