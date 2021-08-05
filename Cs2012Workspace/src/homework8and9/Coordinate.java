/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 8 and 9
 */

package homework8and9;

public class Coordinate {
	int row;
	int column;
	char valOfCoordinate;
	/*
	 * valOfCoordinate has 4 options: blank (' '), 'F' for fence, 'S' for start, 'E'
	 * for exit
	 */
	public Coordinate(int inRow, int inCol) {
		row=inRow;
		column=inCol;
	}
	public Coordinate() {
		row=0;
		column=1;
		valOfCoordinate=' ';
	}

	// getters and setters
	public void setRow(int inRow) {
		row = inRow;
	}

	public int getRow() {
		return row;
	}

	public void setColumn(int inColumn) {
		column = inColumn;
	}

	public int getColumn() {
		return column;
	}

	public void setValOfCoor(char inValOfCoor) {
		valOfCoordinate = inValOfCoor;
	}

	public char getValOfCoor() {
		return valOfCoordinate;
	}
	
	public boolean isInRange(int row, int col) {
		boolean inRange=false;
		if ((row <= 20 && row >= 1) && (col <= 25 && col >= 1)) {
			inRange = true;
		}
		return inRange;
	}
}
