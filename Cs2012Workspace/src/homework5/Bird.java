/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 5
 */

package homework5;

public class Bird extends Prey {

	public Bird(double weightIn, String nameIn) {
		this.weight=weightIn;
		this.name=nameIn;
	}

	@Override
	public void flee() {
		System.out.println(name+" has escaped");
	}

	@Override
	public void call() {
		System.out.println(name+" says 'Chirp'");

	}

	@Override
	public String toString() {
		return name+" is a bird weighing "+ weight+" grams.";
	}

}
