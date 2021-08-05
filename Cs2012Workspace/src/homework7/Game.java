/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 7
 */

package homework7;

public class Game {
	// keep in mind that the max rows and columns will be changed
	private int currentRowLocation=0;
	private int currentColumnLocation=0;

	private int numberOfRows;
	private int numberOfColumns;

	// constructor sets the number of rows and columns
	public Game(int gameRow, int gameColumn) {
		numberOfRows = gameRow;
		numberOfColumns = gameColumn;
	}

	public boolean isValidSquare(int inputRow, int inputColumn) {
		boolean isValidSquare = false;
		boolean nonNegative = false;
		if (inputRow >= 0 && inputColumn >= 0) {
			nonNegative = true;
		}
		boolean inRange = false;
		// if you end up changing the amount of squares in the GUI class
		if ((inputRow < numberOfRows && inputRow >= 0) && (inputColumn < numberOfColumns && inputColumn >= 0)) {
			inRange = true;
		}
		if (nonNegative && inRange) {
			isValidSquare = true;
		}

		return isValidSquare;
	}

	// getters and setters
	public int returnCurrentRow() {
		return currentRowLocation;
	}

	public int returnCurrentColumn() {
		return currentColumnLocation;
	}

	public void setCurrentRow(int inputRow) {
		currentRowLocation = inputRow;
	}

	public void setCurrentColumn(int inputColumn) {
		currentColumnLocation = inputColumn;
	}
}
