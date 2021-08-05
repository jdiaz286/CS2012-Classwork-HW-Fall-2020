/*
 * Name: Jonathan Diaz
 * CIN: 400075634
 * Assignment: Homework 3
 */
package homework3;

public class Address {
	private int streetNumber;
	private String streetName;
	private String city;
	private String state;
	private String province;
	private String country;

	public Address(int sNum, String sName, String typedCity, String typedState, String typedProv, String typedCountry) {
		streetNumber = sNum;
		streetName = sName;
		city = typedCity;
		state = typedState;
		province = typedProv;
		country = typedCountry;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int inputStreetNum) {
		streetNumber = inputStreetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String inputStreetName) {
		streetName = inputStreetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String inputCity) {
		city = inputCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String inputState) {
		state = inputState;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String inputProvince) {
		province = inputProvince;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String inputCountry) {
		country = inputCountry;
	}

	public String toString() {
		return "Address: " + streetNumber + " " + streetName + ", " + city + ", " + state + ", " + province + " "
				+ country;
	}
}
