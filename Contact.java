/*
//Assignment:		6-1 Project One
Author Name: 	Ryan DeBraal
Date:			2021-04-11
Course ID:		CS-320-T4220 Software Test Automation& QA 21EW4
Description: 	Class which defines a Contact object

*	The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
*	The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
*	The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
*	The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
*	The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
*/

package main.java.model;

public class Contact {

	private String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	// Constructors
	public Contact(String id, String firstName, String lastName, String phone, String address) {

		// Validate unique ID
		if (id == null || id.length() < 1 || id.length() > 10) {
			throw new IllegalArgumentException("You must specify a valid ID.");
		}

		// Validate first name
		if (firstName == null || firstName.length() < 1 || firstName.length() > 10) {
			throw new IllegalArgumentException("You must specify a valid first name.");
		}

		// Validate last name
		if (lastName == null || lastName.length() < 1 || lastName.length() > 10) {
			throw new IllegalArgumentException("You must specify a valid last name.");
		}

		// Validate phone
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("You must specify a valid phone number.");
		}

		// Validate address
		if (address == null || address.length() < 1 || address.length() > 30) {
			throw new IllegalArgumentException("You must specify a valid address.");
		}

		this.ID = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	public Contact() {
	}

	// Properties
	public String getID() {
		return ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

}
