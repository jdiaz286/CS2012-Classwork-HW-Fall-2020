/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 8 and 9
 */

package homework8and9;

public class PastureMap {
	public Coordinate[][] arrayOfCoordinates = new Coordinate[21][25];

	public void addCoordinate(Coordinate coorToAdd, int rowOfCurrentCow, int colOfCurrentCow) {
		arrayOfCoordinates[rowOfCurrentCow][colOfCurrentCow]= coorToAdd;
	}
	
}

