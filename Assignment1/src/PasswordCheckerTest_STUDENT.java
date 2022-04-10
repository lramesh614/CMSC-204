

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Lokesh Sankar Ramesh
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String firstPass, secondPass;
	
	@Before
	public void setUp() throws Exception {
		String[] p = {"1234567A^", 
				"asdf1movi3XXX#", 
				"aO?1", 
				"lokesh17", 
				"asdfmovie1", 
				"OSu26", 
				"abcdeFGhij%", 
				"s3xyF2F", 
				"ProjectileMotion", 
				"XXXoo@123"
				};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcde"));
		} catch(LengthException e) {
			assertTrue("Successfully threw lengthException", true);
		} catch(Exception e) {
			assertTrue("Threw another exception apart from lengthException", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("asdfmov123$4"));
		} catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaExcepetion", true);
		} catch(Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("ADFSJKL123!"));
 
			assertTrue("Did not throw NoLowerAlphaException", false);
		} catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
		} catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
	}
	
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			PasswordCheckerUtility.isWeakPassword("1234@aAf");
		} catch(WeakPasswordException e) {
			assertTrue("Successfully threw WeakPasswordException", true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true, PasswordCheckerUtility.isValidPassword("85y4ghJKDFn^#&ooo"));
		} catch(InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			PasswordCheckerUtility.hasDigit("abcdefNEMGN&$^#*");
		} catch(NoDigitException e) {
			assertTrue("Successfully threw an NoDigitException", true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides a NoDigitException", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("jfgmgn8765745NEMGN&$^#*"));
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw exception", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "1234567A^");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(1));  
		assertEquals(scan.next(), "asdf1movi3XXX#");
		nextResults = scan.nextLine().toLowerCase(); 
		assertTrue(nextResults.contains("sequence"));
		
		 
		scan = new Scanner(results.get(2));  
		assertEquals(scan.next(), "aO?1");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long"));
		
		scan = new Scanner(results.get(3));  
		assertEquals(scan.next(), "lokesh17");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		scan = new Scanner(results.get(4));  
		assertEquals(scan.next(), "asdfmovie1");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") );
		
		 
		
		scan = new Scanner(results.get(5));  
		assertEquals(scan.next(), "OSu26");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("long") );
		
		scan = new Scanner(results.get(6));  
		assertEquals(scan.next(), "abcdeFGhij%");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(results.get(7));  
		assertEquals(scan.next(), "s3xyF2F");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special") );
		
		
		scan = new Scanner(results.get(8)); 
		assertEquals(scan.next(), "ProjectileMotion");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit") );
		
		scan = new Scanner(results.get(9));  
		assertEquals(scan.next(), "XXXoo@123");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("sequence") );
		
		//scan.close();
 
	}
}