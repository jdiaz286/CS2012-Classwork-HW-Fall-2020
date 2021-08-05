/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 5
 */

package homework5;

public abstract class Prey extends Animal{
	abstract public void flee();
	abstract public String toString();
	public String getName() {
		return name;
	}
}
