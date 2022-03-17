/* 
 * Author: Tristan Dan Le
 * Subjet: assignmen-4
 * 
 * */

package com.codercampus.assignment4;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class FileServiceImpl extends Student implements FileService {

	@Override
	public Student[] readStudentsDataFromFile() throws IOException {
		BufferedReader fileReader = null;

		// count lines in the csv file and return a lines total
		int numberOflines = (int) countLines();
		try {
			// fileName = "student-master-list.csv"
			File file = new File(fileName);
			fileReader = new BufferedReader(new FileReader(fileName));

			String line = null;
			String[] lineData = null;
			// create a students array
			Student[] students = new Student[numberOflines];
			int i = 0;
			// Read each line in the csv file until it's empty
			while ((line = fileReader.readLine()) != null) {
				if (i > 0) {
					lineData = line.split(",");
					Student student = new Student(lineData[0], lineData[1], lineData[2], Integer.valueOf(lineData[3]));
					students[i - 1] = student;
				}
				i++;

			}
			// Eliminate null values and refine a students array
			//return an array of students 
			return eliminateNullValues(students); 

		} finally {
			// validate if the file is closed at the end
			if (fileReader != null) {
				fileReader.close();

			}
		}

	}

	public Student[] eliminateNullValues(Student[] students) {
		Student[] newStudents = new Student[students.length];
		int count = -1;
		// this block of code is for deleting a row that has null in array
			for (Student student : students) {
			if (student != null) {
				newStudents[++count] = student;
			}
		}

		students = Arrays.copyOf(newStudents, count + 1);
		return students;
	}

	// This method is counting a number of lines in the student-master-list.csv file
	public long countLines() {
		Path path = Paths.get(fileName);
		long lines = 0;
		try {
			lines = Files.lines(path).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	@Override
	public void writeStudentsDataToFile(String fileName, String course) throws IOException {

		Student[] students = new Student[readStudentsDataFromFile().length];		
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		// ***** return an array of students after reading a file csv
		students = readStudentsDataFromFile();

     	// Sort students by grade in descending order.
		sortGrade(students);

		try {
			int size = 0;
			// Filter a group of students by course 
			filterStudentsByCourse(course, students, writer, size); // End For
		} finally {
			// System.out.println("The writer is closed successfully");
			if (writer != null)
				writer.close();
		}
	}

	// This method is to filter a group of students by course
	public void filterStudentsByCourse(String course, Student[] students, BufferedWriter writer, int size)
			throws IOException {
		for (int p = 0; p < readStudentsDataFromFile().length; p++) {
			if (students[p].getCourse().split(" ")[0].equals(course)) {
				size++;
			}
		}
		// create an array studentsByCourse for students grouping by course
		Student[] studentsByCourse = new Student[size];		
		// write columns of title on the first line of the csv file
		writer.write("Student ID,Student Name,Course,Grade \n");
		int sbc = 0;  // studentsByCourse counter
		// Loop through an Array Student to select each course that students belong
		// to-Ex: COMPSCI, APMTH, STAT
		for (int i = 0; i < readStudentsDataFromFile().length; i++) {
			if (students[i].getCourse().split(" ")[0].equals(course)) {
				writer.write(students[i].getId() + "," + students[i].getName() + "," + students[i].getCourse() + ","
						+ Integer.valueOf(students[i].getGrade()) + "\n");
				studentsByCourse[sbc] = new Student(students[i].getId(), students[i].getName(), students[i].getCourse(),
						students[i].getGrade());
				sbc++;
			} // End If
		} // End for
	} // End method filterStudentsByCourse

	// This method is sorting students by grade in descending order.
	public void sortGrade(Student[] students) {
		Arrays.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				if (student1.getGrade() == null && student2.getGrade() == null) {
					return 0;
				} else if (student1.getGrade() == null) {
					return -1;
				} else if (student2.getGrade() == null) {
					return 1;
				} else {
					if (student1.getGrade() != student2.getGrade()) {
						return student2.getGrade() - student1.getGrade();
					} else {
						return student1.getName().compareTo(student2.getName());

					}
				}

			}
		});
	}
}
