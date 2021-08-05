/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 3
 */
package homework3;

import java.util.ArrayList;

public class FacultyMember extends Person {
	private int employeeID;
	private ArrayList<Course> teachingSchedule = new ArrayList<Course>();

	public FacultyMember(String personName, Address personAddress, int inEID) {
		super(personName, personAddress);
		employeeID = inEID;
	}

	public void setEID(int inEID) {
		employeeID = inEID;
	}

	public int getEID() {
		return employeeID;
	}

	public void dropTeacherCourse(Course courseToDrop) {
		teachingSchedule.remove(courseToDrop);
	}

	public void addTeacherCourse(Course courseToAdd) {
		teachingSchedule.add(courseToAdd);
	}
	
	//this method just makes it easier for me to access the current faculty members' teachingSchedule in later tasks
	public void showFacultyMemberSchedule() {
		for(Course currentCourseSchedule: teachingSchedule) {
			System.out.println(currentCourseSchedule.toString());
		}
	}
	
	public ArrayList<Course> getTeachingSchedule(){
		return teachingSchedule;
	}

	public String toString() {
		return super.toString() + " employee ID: " + employeeID;
	}
}
