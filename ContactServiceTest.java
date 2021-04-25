/*
Assignment:		6-1 Project One
Author Name: 	Ryan DeBraal
Date:			2021-04-11
Course ID:		CS-320-T4220 Software Test Automation& QA 21EW4
Description: 	Class which defines the JUnit test methods for a ContactService object

*	The contact service shall be able to add contacts with a unique ID.
*	The contact service shall be able to delete contacts per contact ID.
*	The contact service shall be able to update contact fields per contact ID. 
*	The following fields are updatable: firstName, lastName, phone, address
*/

package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.model.Contact;
import main.java.model.ContactService;

public class ContactServiceTest {

	// Test data
	final String VALID_ID = "RYAN.001";
	ContactService cs = new ContactService();
	Contact contact = new Contact(VALID_ID, "Ryan", "DeBraal", "9203764617", "175 E Delaware Pl, Chicago");

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testAdd() {
		cs.add(contact);
		assertTrue(cs.exists(VALID_ID));
	}

	@Test
	public void testAdd_IsNull() {
		exceptionRule.expect(IllegalArgumentException.class);
		cs.add(null);
	}

	@Test
	public void testDelete() {
		if (!cs.exists(VALID_ID))
			cs.add(contact);

		cs.delete(VALID_ID);

		assertTrue(!cs.exists(VALID_ID));
	}

	@Test
	public void testDelete_IsNull() {
		exceptionRule.expect(IllegalArgumentException.class);
		cs.delete(null);
	}

	@Test
	public void testUpdate() {
		if (!cs.exists(VALID_ID))
			cs.add(contact);

		final String NEW_FIRST_NAME = "John";
		final String NEW_LAST_NAME = "Doe";
		final String NEW_PHONE = "5555555555";
		final String NEW_ADDRESS = "NEW ADDRESS";

		// Update entry
		cs.update(VALID_ID, NEW_FIRST_NAME, NEW_LAST_NAME, NEW_PHONE, NEW_ADDRESS);

		// Verify updated entry
		Contact updated = cs.get(VALID_ID);
		assertTrue(updated != null);
		assertTrue(updated.getFirstName().equals(NEW_FIRST_NAME));
		assertTrue(updated.getLastName().equals(NEW_LAST_NAME));
		assertTrue(updated.getPhone().equals(NEW_PHONE));
		assertTrue(updated.getAddress().equals(NEW_ADDRESS));

	}

	@Test
	public void testUpdate_IsNull() {
		exceptionRule.expect(IllegalArgumentException.class);
		cs.update(null, null, null, null, null);
	}

}
