/* 
 * Author: Tristan Dan Le
 * Subjet: assignmen-4
 * 
 * */
package com.codercampus.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService  {
	
	public String fileName = "student-master-list.csv";
	
	// This method is reading  student data lines and and return a students array 
	Student[] readStudentsDataFromFile () throws IOException;
	
	// This method is to save a list of  of students grouping by course into separate csv files  
	void writeStudentsDataToFile(String fileName, String courseName) throws IOException;
    
	// This method count number of lines in the student-master-list.csv
	long countLines();
	
}


