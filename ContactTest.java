/*
//Assignment:		6-1 Project One
Author Name: 	Ryan DeBraal
Date:			2021-04-11
Course ID:		CS-320-T4220 Software Test Automation& QA 21EW4
Description: 	Class which defines the JUnit test methods for a Contact object

*	The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
*	The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
*	The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
*	The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
*	The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.
*/

package test;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import main.java.model.Contact;

public class ContactTest {

	// Test data
	final String VALID_ID =  "RYAN.001";
	Contact contact = new Contact(VALID_ID, "Ryan", "DeBraal", "9203764617", "175 E Delaware Place, Chicago");

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	public void testId() {	
		assertTrue(contact != null);
		assertTrue(contact.getID() != null);
		assertTrue(contact.getID().length() > 0);
		assertTrue(contact.getID().length() <= 10);
	}
	
	@Test
	public void testID_TooShort() {	
		exceptionRule.expect(IllegalArgumentException.class);		
		new Contact("", "Ryan", "DeBraal", "9203764617", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testID_TooLong() {	
		exceptionRule.expect(IllegalArgumentException.class);		
		new Contact("12345678910", "Ryan", "DeBraal", "9203764617", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testFirstName() {	
		assertTrue(contact != null);
		assertTrue(contact.getFirstName() != null);
		assertTrue(contact.getFirstName().length() > 0);
		assertTrue(contact.getFirstName().length() <= 10);
	}
	
	@Test
	public void testFirstName_TooShort() {	
		exceptionRule.expect(IllegalArgumentException.class);		
		new Contact(VALID_ID, "", "DeBraal", "9203764617", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testFirstName_TooLong() {	
		exceptionRule.expect(IllegalArgumentException.class);		
		new Contact(VALID_ID, "Rhoshandiatellyneshiaunneveshen", "DeBraal", "9203764617", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testLastName() {	
		assertTrue(contact != null);
		assertTrue(contact.getLastName() != null);
		assertTrue(contact.getLastName().length() > 0);
		assertTrue(contact.getLastName().length() <= 10);
	}
	
	@Test
	public void testLastName_TooShort() {	
		exceptionRule.expect(IllegalArgumentException.class);		
		new Contact(VALID_ID, "Ryan", "", "9203764617", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testLastName_TooLong() {	
		exceptionRule.expect(IllegalArgumentException.class);		
		new Contact(VALID_ID, "Ryan", "Wolfeschlegelsteinhausenbergerdorff", "9203764617", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testPhone() {	
		assertTrue(contact != null);
		assertTrue(contact.getPhone() != null);
		assertTrue(contact.getPhone().length() == 10);
	}
	
	@Test
	public void testPhone_TooShort() {	
		exceptionRule.expect(IllegalArgumentException.class);	
		new Contact(VALID_ID, "Ryan", "DeBraal", "", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testPhone_TooLong() {	
		exceptionRule.expect(IllegalArgumentException.class);	
		new Contact(VALID_ID, "Ryan", "DeBraal", "12345678910", "175 E Delaware Place, Chicago");
	}
	
	@Test
	public void testAddress() {	
		assertTrue(contact != null);
		assertTrue(contact.getAddress() != null);
		assertTrue(contact.getAddress().length() > 0);
		assertTrue(contact.getAddress().length() <= 30);
	}
	
	@Test
	public void testAddress_TooShort() {	
		exceptionRule.expect(IllegalArgumentException.class);	
		new Contact(VALID_ID, "Ryan", "DeBraal", "9203764617", "");
	}
	
	@Test
	public void testAddress_TooLong() {	
		exceptionRule.expect(IllegalArgumentException.class);	
		new Contact(VALID_ID, "Ryan", "DeBraal", "9203764617", "175 East Delaware Place, Chicago, IL 60611");
	}

}
