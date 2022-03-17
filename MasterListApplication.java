/* 
 * Author: Tristan Dan Le
 * Subjet: assignmen-4
 * */
package com.codercampus.assignment4;

import java.io.IOException;

public class MasterListApplication {

	public static void main(String[] args) throws IOException {
		
		FileService fileService = new FileServiceImpl();
		fileService.readStudentsDataFromFile();
		fileService.writeStudentsDataToFile("course1.csv", "COMPSCI");
		fileService.writeStudentsDataToFile("course2.csv", "STAT");
		fileService.writeStudentsDataToFile("course3.csv", "APMTH");
        
	} // End main
} // End Class



