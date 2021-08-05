/*
 Name:Jonathan Diaz
 CIN:400075634
 Assignment: Homework 1
*/
package homework1;

import java.util.Scanner;

public class Homework1 {
	public static Scanner input = new Scanner(System.in);

	// code that executes the requirements in the sixth bullet point
	public static void main(String[] args) {
		double[] myArray = getPositiveDoubles();
		printArrayOfDoubles(myArray);
		printCubesOfArray(myArray);
		replaceExcess(myArray);
		printArrayOfDoubles(myArray); // print after replacing all values that are greater than 250
		printArrayOfDoubles(returnInverseArray(myArray));
		printArrayOfDoubles(myArray);

	}

	// method to get 10 non-negative doubles(first bullet point)
	public static double[] getPositiveDoubles() {
		double[] tenPositiveDoubles = new double[10];
		for (int counter = 0; counter < tenPositiveDoubles.length; counter++) {
			double initialDouble = -1.0;
			while (initialDouble < 0) {
				System.out.print("Please enter a double greater than or equal to 0, you have " + (10 - counter)
						+ " more spaces to fill: ");
				while (!input.hasNextDouble()) {
					input.nextLine();
					System.out.print("Please type in a double, you have "+ (10 - counter)
							+ " more spaces to fill: ");
				}
				initialDouble = input.nextDouble();
			}
			tenPositiveDoubles[counter] = initialDouble;
		}
		return tenPositiveDoubles;
	}

	// method that prints the cube of a given array of doubles (second bullet point)
	public static void printCubesOfArray(double[] arrayOfDoubles) {
		System.out.print("The cube of values in array: ");
		for (int counter = 0; counter < arrayOfDoubles.length; counter++) {
			double currentCubeOfArray = arrayOfDoubles[counter];
			currentCubeOfArray = Math.pow(currentCubeOfArray, 3);
			System.out.print(currentCubeOfArray + " ");
		}
		System.out.println();
	}

	// method takes an array of doubles replaces any value exceeding 250 with the
	// value 250 (third bullet point)
	public static void replaceExcess(double[] arrayOfDoubles) {
		System.out.print("(After replacing values greater than 250) ");
		for (int counter = 0; counter < arrayOfDoubles.length; counter++) {
			if (arrayOfDoubles[counter] > 250) {
				arrayOfDoubles[counter] = 250;
			}
		}
	}

	// method that takes an array of doubles replaces each value in the old array
	// with its inverse (1/x) (fourth bullet point)
	public static double[] returnInverseArray(double[] arrayOfDoubles) {
		double[] inverseDoublesArray = new double[arrayOfDoubles.length];
		System.out.print("(After getting the inverse) ");
		// copy the values from the old array into a new array
		for (int counter = 0; counter < arrayOfDoubles.length; counter++) {
			inverseDoublesArray[counter] = arrayOfDoubles[counter];
		}
		// get the inverse of each value and set it as the new value
		for (int index = 0; index < inverseDoublesArray.length; index++) {
			double inverseVal = inverseDoublesArray[index];
			inverseVal = 1 / inverseVal;
			inverseDoublesArray[index] = inverseVal;
		}
		return inverseDoublesArray;
	}

	// method that takes an array of doubles as its only parameter and prints out
	// all the values (fifth bullet point)
	public static void printArrayOfDoubles(double[] arrayOfDoubles) {
		System.out.print("Your array: ");
		for (int counter = 0; counter < arrayOfDoubles.length; counter++) {
			System.out.print(arrayOfDoubles[counter] + " ");
		}
		System.out.println();
	}
}

