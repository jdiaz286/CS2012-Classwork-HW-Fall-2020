/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 3
 */

package homework3;

import java.util.ArrayList;

public class Student extends Person {
	private int CIN;
	private ArrayList<Course> courseSchedule = new ArrayList<Course>();

	public Student(String personName, Address personAddress, int studentCIN) {
		super(personName, personAddress);
		CIN = studentCIN;
	}

	public int getCIN() {
		return CIN;
	}

	public void setCIN(int inCIN) {
		CIN = inCIN;
	}

	public void dropStudentCourse(Course courseToDrop) {
		courseSchedule.remove(courseToDrop);
	}

	public void addStudentCourse(Course courseToAdd) {
		courseSchedule.add(courseToAdd);
	}
	
	//this method just makes it easier for me to access the current students' courseSchedule in later tasks
	public void showStudentSchedule() {
		for(Course currentCourseSchedule: courseSchedule) {
			System.out.println(currentCourseSchedule.toString());
		}
	}
	
	public ArrayList<Course> getCourseSchedule(){
		return courseSchedule;
	}

	public String toString() {
		return super.toString()+" CIN: "+CIN;
	}
}
