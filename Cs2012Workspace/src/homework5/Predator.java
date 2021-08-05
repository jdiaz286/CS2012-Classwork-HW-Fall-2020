/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 5
 */

package homework5;

public abstract class Predator extends Animal {
	public void predate(Prey animal) {
		animal.eat(super.weight);
		System.out.println(super.name + " eats " + animal.getName());
	}
}

