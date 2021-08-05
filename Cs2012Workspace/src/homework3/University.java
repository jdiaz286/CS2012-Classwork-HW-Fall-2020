/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 3
 */

package homework3;

import java.util.ArrayList;
import java.util.Scanner;

public class University {
	private ArrayList<Course> listOfCourses = new ArrayList<Course>();
	private ArrayList<Student> listOfStudents = new ArrayList<Student>();
	private ArrayList<FacultyMember> listOfFaultyMembers = new ArrayList<FacultyMember>();
	private Scanner input = new Scanner(System.in);

	public void menu() {
		printMenuText();
		int userChoice = input.nextInt();
		executeChoice(userChoice);
		while (userChoice >= 1 && userChoice <= 12) {
			printMenuText();
			userChoice = input.nextInt();
			executeChoice(userChoice);
			
		}
	}

	// all methods can be found below, just to make the menu look better
	public void printMenuText() {
		System.out.println("Menu");
		System.out.println("Choose which of the following options you would like (1-12), press any other key to quit: ");
		System.out.println("1.) Create course(s) and add to list of courses");
		System.out.println("2.) Show list of courses");
		System.out.println("3.) Create student(s) and add to list of students");
		System.out.println("4.) Show list of students");
		System.out.println("5.) Create faculty member(s) list of faculty members");
		System.out.println("6.) Show list of faculty members");
		System.out.println("7.) Delete select student");
		System.out.println("8.) Delete select faculty member");
		System.out.println("9.) Add course for select student");
		System.out.println("10.) Delete course for select student");
		System.out.println("11.) Add course for select faculty member");
		System.out.println("12.) Delete course for select faculty member");
		System.out.println();
	}

	public void createAndAddToListOfCourses() {
		System.out.print("Type in how many courses you would like to add: ");
		int numOfCoursesToAdd = input.nextInt();
		for (int i = 0; i < numOfCoursesToAdd; i++) {
			System.out.println("Course " + (i + 1) + "/" + numOfCoursesToAdd);
			System.out.print("Type in the Course ID: ");
			String courseID = input.next();
			System.out.print("Type in the number of units for the course: ");
			int numOfUnits = input.nextInt();
			System.out.println();
			Course newCourse = new Course(numOfUnits, courseID);
			listOfCourses.add(newCourse);
		}
		System.out.println();
	}

	public void showListOfCourses() {
		System.out.println("Your university's list of courses: ");
		for (Course currentCourse : listOfCourses) {
			System.out.println(currentCourse.toString());
		}
		System.out.println();
	}

	public void createAndAddToListOfStudents() {
		System.out.print("Type in how many students you would like to add: ");
		int numOfStudentsToAdd = input.nextInt();
		for (int i = 0; i < numOfStudentsToAdd; i++) {
			System.out.println("Student " + (i + 1) + "/" + numOfStudentsToAdd+" info");
			System.out.print("Type in the students name: ");
			String studentName = input.next();
			System.out.println("Students address ");
			Address studentAddress = getAddress();
			System.out.print("Type in the students CIN: ");
			int studentCIN = input.nextInt();
			System.out.println();
			Student newStudent = new Student(studentName, studentAddress, studentCIN);
			listOfStudents.add(newStudent);
		}
		System.out.println();
	}

	public void showListOfStudents() {
		System.out.println("Your university's list of students: ");
		for (Student currentStudent : listOfStudents) {
			System.out.println(currentStudent.toString());
		}
		System.out.println();
	}

	public void createAndAddToListOfFaculty() {
		System.out.print("Type in how many faculty members you would like to add: ");
		int numOfCoursesToFaculty = input.nextInt();
		for (int i = 0; i < numOfCoursesToFaculty; i++) {
			System.out.println("Faculty member " + (i + 1) + "/" + numOfCoursesToFaculty);
			System.out.print("Type in the faculty member's name: ");
			String facultyName = input.next();
			System.out.println("Faculty member address ");
			Address facultyAddress = getAddress();
			System.out.print("Type in the faculty member employee ID: ");
			int facultyID = input.nextInt();
			System.out.println();
			FacultyMember newFaculty = new FacultyMember(facultyName, facultyAddress, facultyID);
			listOfFaultyMembers.add(newFaculty);
		}
		System.out.println();
	}

	public void showListOfFaultyMembers() {
		System.out.println("Your university's list of faculty members: ");
		for (FacultyMember currentFacultyMember : listOfFaultyMembers) {
			System.out.println(currentFacultyMember.toString());
		}
		System.out.println();
	}

	public void deleteSelectStudent() {
		showListOfStudents();
		System.out.print("Type in the CIN of the student you would like to delete: ");
		int studentToDeleteCIN = input.nextInt();
		boolean hasNameInList = false;
		Student studentToRemove = null;
		for (Student currentStudent : listOfStudents) {
			int currentStudentCIN = currentStudent.getCIN();
			if (studentToDeleteCIN==currentStudentCIN) {
				studentToRemove=currentStudent;
				hasNameInList = true;
			}
		}
		listOfStudents.remove(studentToRemove);
		if (hasNameInList == false) {
			System.out.println("Student CIN not found");
		}

	}

	public void deleteSelectFacultyMember() {
		showListOfFaultyMembers();
		System.out.print("Type in the employee ID of the faculty member you would like to delete: ");
		int facultyMemberEmployeeIDToDelete = input.nextInt();
		boolean hasNameInList = false;
		FacultyMember facultyToRemove=null;
		for (FacultyMember currentFacultyMember : listOfFaultyMembers) {
			int currentFacultyMemberID = currentFacultyMember.getEID();
			if (currentFacultyMemberID==facultyMemberEmployeeIDToDelete) {
				facultyToRemove=currentFacultyMember;
				hasNameInList = true;
			}
		}
		listOfFaultyMembers.remove(facultyToRemove);
		if (hasNameInList == false) {
			System.out.println("Faculty member name not found");
		}
	}

	public void addCourseForStudent() {
		showListOfStudents();
		System.out.print("Type in the CIN of the student you would like to add a course for: ");
		int studentCIN = input.nextInt();
		boolean hasNameInList = false;
		for (Student currentStudent : listOfStudents) {
			int currentStudentCIN = currentStudent.getCIN();
			if (studentCIN==currentStudentCIN) {
				String studentName=currentStudent.getName();
				hasNameInList = true;
				showListOfCourses();
				System.out.print("Type in the course ID that you would like to add: ");
				input.next();
				String courseID = input.nextLine();
				for (Course currentCourse : listOfCourses) {
					String currentCourseID = currentCourse.getCourseID();
					currentCourseID.toUpperCase();
					if (currentCourseID.equals(courseID)) {
						currentStudent.addStudentCourse(currentCourse);
						System.out.println("Congrats! You have successfully added " + currentCourseID + " to "+ studentName + "'s schedule");
					}
				}
			}
		}
		
		if (hasNameInList == false) {
			System.out.println("Student CIN not found");
		}

	}

	public void deleteCourseForStudent() {
		showListOfStudents();
		System.out.print("Type in the CIN of the student you would like to delete a course for: ");
		int studentCIN = input.nextInt();
		boolean hasNameInList = false;
		for (Student currentStudent : listOfStudents) {
			int currentStudentCIN = currentStudent.getCIN();
			if (studentCIN==currentStudentCIN) {
				System.out.println("Current student's schedule");
				String studentName=currentStudent.getName();
				currentStudent.showStudentSchedule();
				ArrayList<Course> courseSchedule = currentStudent.getCourseSchedule();
				System.out.print("Type in the course ID that you would like to delete from schedule: ");
				input.next();
				String courseID = input.nextLine();
				for (Course currentCourse : courseSchedule) {
					String currentCourseID = currentCourse.getCourseID();
					currentCourseID.toUpperCase();
					if (currentCourseID.equals(courseID)) {
						currentStudent.dropStudentCourse(currentCourse);
						System.out.println("Congrats! You have dropped " + currentCourseID + " from " + studentName + "'s schedule");
						
					}
				}
			}
		}
		if (hasNameInList == false) {
			System.out.println("Student name not found");
		}
	}

	public void addCourseForFacultyMember() {
		showListOfFaultyMembers();
		System.out.print("Type in the employee ID of the faculty member for whom you would like to add a course: ");
		int facultyEID = input.nextInt();
		boolean hasNameInList = false;
		for (FacultyMember currentFacultyMember : listOfFaultyMembers) {
			int currentFacultyID = currentFacultyMember.getEID();
			if (currentFacultyID==facultyEID) {
				String facultyMemberName=currentFacultyMember.getName();
				showListOfCourses();
				System.out.print("Type in the course ID that you would like to add: ");
				input.next();
				String courseID = input.nextLine();
				for (Course currentCourse : listOfCourses) {
					String currentCourseID = currentCourse.getCourseID();
					currentCourseID.toUpperCase();
					if (currentCourseID.equals(courseID)) {
						currentFacultyMember.addTeacherCourse(currentCourse);
						System.out.println("Congrats! You have successfully added " + currentCourseID + " to "
								+ facultyMemberName + "'s schedule");
					}
				}
			}
		}
		if (hasNameInList == false) {
			System.out.println("Faculty member name not found");
		}
	}

	public void deleteCourseForFacultyMember() {
		showListOfFaultyMembers();
		System.out.print("Type in the name of the faculty member for whom you would like to delete a course: ");
		int facultyEID = input.nextInt();
		boolean hasNameInList = false;
		for (FacultyMember currentFacultyMember : listOfFaultyMembers) {
			int currentFacultyID = currentFacultyMember.getEID();
			if (currentFacultyID==facultyEID) {
				String facultyMemberName=currentFacultyMember.getName();
				currentFacultyMember.showFacultyMemberSchedule();
				ArrayList<Course> courseSchedule = currentFacultyMember.getTeachingSchedule();
				System.out.print("Type in the course ID that you would like to delete from schedule: ");
				input.next();
				String courseID = input.nextLine();
				for (Course currentCourse : courseSchedule) {
					String currentCourseID = currentCourse.getCourseID();
					currentCourseID.toUpperCase();
					if (currentCourseID.equals(courseID)) {
						currentFacultyMember.dropTeacherCourse(currentCourse);
						System.out.println(
								"Congrats! You have dropped " + currentCourseID + " from " + facultyMemberName + "'s schedule");
						
					}
				}
			}
		}
		if (hasNameInList == false) {
			System.out.println("Faculty member name not found");
		}
	}
	
	

	public Address getAddress() {
		System.out.print("Type in the street number: ");
		int streetNum = input.nextInt();
		System.out.print("Type in the street name: ");
		input.next();
		String streetName = input.nextLine();
		System.out.print("Type in the city: ");
		String city = input.nextLine();
		System.out.print("Type in the state: ");
		String state = input.nextLine();
		System.out.print("Type in the province(if null hit enter): ");
		String province = input.nextLine();
		System.out.print("Type in the country: ");
		String country = input.nextLine();
		Address returnedAddress = new Address(streetNum, streetName, city, state, province, country);
		return returnedAddress;
	}
	
	public void executeChoice(int userChoice) {
		switch (userChoice) {
		case 1:
			createAndAddToListOfCourses();
			break;
		case 2:
			showListOfCourses();
			break;
		case 3:
			createAndAddToListOfStudents();
			break;
		case 4:
			showListOfStudents();
			break;
		case 5:
			createAndAddToListOfFaculty();
			break;
		case 6:
			showListOfFaultyMembers();
			break;
		case 7:
			deleteSelectStudent();
			break;
		case 8:
			deleteSelectFacultyMember();
			break;
		case 9:
			addCourseForStudent();
			break;
		case 10:
			deleteCourseForStudent();
			break;
		case 11:
			addCourseForFacultyMember();
			break;
		case 12:
			deleteCourseForFacultyMember();
			break;
		default:
			System.out.println("Thank you! ");
			break;
		}
	}
}
