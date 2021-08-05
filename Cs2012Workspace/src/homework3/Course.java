/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 3
 */

package homework3;

public class Course {
	private int units;
	private String courseID;

	public Course(int numOfUnits, String myCourseID) {
		units = numOfUnits;
		courseID = myCourseID.toUpperCase();
	}

	public void setCourseID(String userCourseID) {
		courseID = userCourseID.toUpperCase();
	}

	public String getCourseID() {
		return courseID.toUpperCase();
	}

	public void setUnits(int inputUnits) {
		units = inputUnits;
	}

	public int getUnits() {
		return units;
	}

	public String toString() {
		return "Course: " + courseID.toUpperCase() + " Units: " + units;
	}
}
