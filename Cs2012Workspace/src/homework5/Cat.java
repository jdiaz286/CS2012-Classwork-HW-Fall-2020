/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 5
 */

package homework5;

public class Cat extends Predator {

	public Cat(String nameIn, double weightIn) {
		this.name=nameIn;
		this.weight=weightIn;
	}
	
	@Override
	public void call() {
		System.out.println(name+" says 'Meow'");
	}
	
	@Override 
	public String toString() {
		return name+" is a cat weighing "+ weight+" grams.";
		
	}

}