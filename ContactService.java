/*
//Assignment:		6-1 Project One
Author Name: 	Ryan DeBraal
Date:			2021-04-11
Course ID:		CS-320-T4220 Software Test Automation& QA 21EW4
Description: 	Class which defines a ContactService object

*	The contact service shall be able to add contacts with a unique ID.
*	The contact service shall be able to delete contacts per contact ID.
*	The contact service shall be able to update contact fields per contact ID. 
*	The following fields are updatable: firstName, lastName, phone, address
*/

package main.java.model;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

	private Map<String, Contact> contacts = new HashMap<String, Contact>();

	// Constructors
	public ContactService() {
	}

	// Properties
	public boolean exists(String id) {
		if (id == null)
			throw new IllegalArgumentException("You must specify a valid ID.");

		return (this.contacts.containsKey(id));
	}

	public Contact get(String id) {
		if (id == null)
			throw new IllegalArgumentException("You must specify a valid ID.");

		if (this.contacts.containsKey(id))
			return this.contacts.get(id);

		return null;
	}

	public void add(Contact contact) {
		if (contact != null && contact.getID() != null && !this.contacts.containsKey(contact.getID()))
			this.contacts.put(contact.getID(), contact);
		else
			throw new IllegalArgumentException("You must specify a new valid entry.");
	}

	public void delete(String id) {
		if (id != null && this.contacts.containsKey(id))
			this.contacts.remove(id);
		else
			throw new IllegalArgumentException("You must specify a valid ID.");
	}

	public void update(String id, String firstName, String lastName, String phone, String address) {

		// Validate unique ID
		if (id == null || id.length() < 1 || id.length() > 10) {
			throw new IllegalArgumentException("You must specify a valid ID.");
		}

		if (!this.contacts.containsKey(id)) {
			throw new IllegalArgumentException("You must specify an existing contact ID.");
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

		// Assign updated contact entry
		Contact contact = new Contact(id, firstName, lastName, phone, address);

		// Overwrite existing contact entry: https://stackoverflow.com/a/7212364
		this.contacts.put(id, contact);

	}

}
