/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 5
 */

package homework5;

public class Mouse extends Prey {

	public Mouse(double weightIn, String nameIn) {
		this.weight=weightIn;
		this.name=nameIn;
	} 
	
	@Override
	public void flee() {
		System.out.println(name+" has escaped");
	}

	@Override
	public void call() {
		System.out.println(name+" says 'Squeak'");
		
	}

	@Override
	public String toString() {
		return name+" is a mouse weighing "+ weight+" grams.";
	}

}