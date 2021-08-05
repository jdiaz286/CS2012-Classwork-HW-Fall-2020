/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 3
 */

package homework3;


public class Person {
	private String name;
	private Address address;

	public Person(String personName, Address personAddress) {
		name = personName;
		address = personAddress;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void setAddress(Address newAddress) {
		address = newAddress;
	}

	public String toString() {
		return "Name: " + name + " " + address;
	}
}
