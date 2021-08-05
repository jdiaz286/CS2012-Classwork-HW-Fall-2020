/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 8 and 9
 */

package homework8and9;


public class Cow {

	public Coordinate pickRandomStartingPoint() {
		Coordinate startingCowCoor=new Coordinate();
		int rangeOfRows = (int) ((Math.random() * (20 - 1)) + 1);
		int rangeOfCols = (int) ((Math.random() * (26 - 1)) + 1);
		if ((rangeOfRows <= 16 && rangeOfRows >= 5) && (rangeOfCols <= 19 && rangeOfCols >= 6)) {
			startingCowCoor.setRow(rangeOfRows);
			startingCowCoor.setColumn(rangeOfRows);
		}
		return startingCowCoor;
	}
}

