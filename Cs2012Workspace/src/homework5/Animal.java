/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 5
 */

package homework5;

public abstract class Animal {
	protected String name;
	protected double weight;
	
	public void eat(double weightInGrams) {
		weight+=weightInGrams;
	}
	
	abstract public void call();
}
