package com.codercampus.assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountLines {

	public static void main(String[] args) {
		Path path = Paths.get("student-master-list.csv");

	      long lines = 0;
	      try {

	          // much slower, this task better with sequence access
	          //lines = Files.lines(path).parallel().count();

	          lines = Files.lines(path).count();
             System.out.println( lines);
	      } catch (IOException e) {
	          e.printStackTrace();
	      }

	      

	}

}
