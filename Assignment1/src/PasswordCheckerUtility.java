



/**
 * 
 * Class: CMSC204
 * Instructor: Prof. Eivazi
 * Description: Checks for valid passwords by checking if a password contains a lower case alphabet, 
 * upper case alphabet, number, and special character and if password is of valid length or if password is weak.
 * Due: 2/8/2022
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Lokesh Sankar Ramesh
   @author Lokesh Sankar Ramesh
*/
import java.util.ArrayList;
import java.util.regex.*;

public class PasswordCheckerUtility {
	public PasswordCheckerUtility() {}

	/**
	 * Compare equality of two passwords
	 * 
	 * @param password        - password string to be checked for
	 * @param passwordConfirm - passwordConfirm string to be checked against
	 *                        password for
	 * @throws UnmatchedException - thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!(password.equals(passwordConfirm))) {
			throw new UnmatchedException();
		}
	}

	/**
	 * Compare equality of two passwords
	 * 
	 * @param password        - password string to be checked for
	 * @param passwordConfirm - passworConfirm string to be checked against password
	 *                        for
	 * @return true if both same (case sensitive), false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (!(password.equals(passwordConfirm))) {
			return false;
		}
		return true;
	}
	
	/**
	 * Checks the password length requirement - The password must be at least 6
	 * characters long
	 * 
	 * @param password - password string to be checked for length
	 * 
	 * @return true if meets minimum length requirement
	 * 
	 * @throws LengthException - thrown if does not meet minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (!(password.length() >= 6))
			throw new LengthException();
		return true;
	}
	
	
	/**
	 * Checks the password alpha character requirement - Password must contain an
	 * uppercase alpha character
	 * 
	 * @param password - password string to be checked for alpha character
	 *                   requirement
	 *                   
	 * @return true if meet alpha character requirement
	 * 
	 * @throws NoUpperAlphaException - thrown if does not meet alpha character
	 *                                 requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		Pattern pattern = Pattern.compile("[A-Z]");
		return checkForChar(password, pattern, new NoUpperAlphaException());
	}
	
	
	/**
	 * Checks the password lowercase requirement - Password must contain at least
	 * one lowercase alpha character
	 * 
	 * @param password - password string to be checked for lowercase requirement
	 * 
	 * @return true if meets lowercase requirement
	 * 
	 * @throws NoLowerAlphaException - thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		Pattern p = Pattern.compile("[a-z]");
		return checkForChar(password, p, new NoLowerAlphaException());
	}
	
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric
	 * character
	 * 
	 * @param password - password string to be checked for Digit requirement
	 * 
	 * @return true if meet Digit requirement
	 * 
	 * @throws NoDigitException - thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		Pattern p = Pattern.compile("[0-9]");
		return checkForChar(password, p, new NoDigitException());
	}
	
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a
	 * Special Character
	 * 
	 * @param password - password string to be checked for SpecialCharacter
	 *                 requirement
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException - thrown if does not meet
	 *                                     SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern p = Pattern.compile("[a-zA-Z0-9]");
		for (int i = 0; i < password.length(); i++) {
			Matcher matcher = p.matcher(Character.toString(password.charAt(i)));
			if (matcher.matches())
				continue;
			return true;
		}
		throw new NoSpecialCharacterException();
	}
	
	
	/**
	 * Checks the password Sequence requirement - Password should not contain more
	 * than 2 of the same character in sequence
	 * 
	 * @param password - password string to be checked for Sequence requirement
	 * @return false if does NOT meet Sequence requirement
	 * @throws WeakPasswordException - thrown if meets Sequence requirement
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		int index = 0;
		while (index < password.length() - 2) {
			if (password.charAt(index) != password.charAt(index + 1) || 
					password.charAt(index) != password.charAt(index + 2)) {
				index++; continue;
			} else {
				throw new InvalidSequenceException();
			}
		}
		
		return true;
		
	}
	
	

	/**
	 * Return true if valid password (follows all the following rules), returns
	 * false if an invalid password 1. At least 6 characters long - 2. At least 1
	 * numeric character- 3. At least 1 uppercase alphabetic character - 4. At least
	 * 1 lowercase alphabetic character - 5. At least 1 special character - 6. No
	 * more than 2 of the same character in a sequence - Hello@123 – OK AAAbb@123 –
	 * not OK Aaabb@123 – OK
	 * 
	 * @param password - string to be checked for validity
	 * @return true if valid password (follows all rules from above), false if an
	 *         invalid password
	 * @throws LengthException             - thrown if length is less than 6
	 *                                     characters
	 * @throws NoUpperAlphaException       - thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException       - thrown if no lowercase alphabetic
	 * @throws NoDigitException            - thrown if no digit
	 * @throws NoSpecialCharacterException - thrown if does not meet
	 *                                     SpecialCharacter requirement
	 * @throws InvalidSequenceException    - thrown if more than 2 of same character
	 */
	public static boolean isValidPassword(String password) throws 
	LengthException, 
	NoUpperAlphaException,
	NoLowerAlphaException, 
	NoDigitException, 
	NoSpecialCharacterException, 
	InvalidSequenceException {
		if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password)
			&& hasSpecialChar(password) && NoSameCharInSequence(password)) {
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Checks if the password contains 6 to 9 characters
	 * 
	 * @param password - password string to be checked for
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}
		return false;
	}
	
	

	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * 
	 * @param password - string to be checked if weak password
	 * @return false if the password is valid and the length of password is NOT
	 *         between 6 and 9 (inclusive)
	 * @throws WeakPasswordException - if length of password is between 6 and 9
	 *                               (inclusive), ALTHOUGH the password may be VALID
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		if (isValidPassword(password) && hasBetweenSixAndNineChars(password)) {
			throw new WeakPasswordException();
		}
		
		return false;
	}


	
	

	/**
	 * This method will accept an ArrayList of passwords as the parameter and return
	 * an ArrayList with the status of any invalid passwords (weak passwords are not
	 * considered invalid). The ArrayList of invalid passwords will be of the
	 * following format: password BLANK message of the exception thrown
	 * 
	 * @param passwords - lists of passwords
	 * @return ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String password : passwords) {
			try {
				isValidPassword(password);
			} catch (RuntimeException e) {
				invalidPasswords.add(password + " -> " + e.getMessage());
			}
		}
		return invalidPasswords;
	}



	
	/**
	 * Used to determine if a password contains a certain character pattern
	 * 
	 * @param password - password string to be checked against
	 * @param pattern  - pattern used to check against the password
	 * @param e        - exception that is thrown when the password does not match
	 *                 the patter
	 *                 
	 * @return true if the password matches the pattern
	 * 
	 * @throws LengthException             - thrown if length is less than 6
	 *                                       characters
	 * @throws NoUpperAlphaException       - thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException       - thrown if no lowercase alphabetic
	 * @throws NoDigitException            - thrown if no digit
	 * @throws NoSpecialCharacterException - thrown if does not meet
	 *                                     SpecialCharacter requirement
	 * @throws InvalidSequenceException    - thrown if more than 2 of same character
	 */
	private static boolean checkForChar(String password, Pattern pattern, RuntimeException E) throws 
	LengthException,
	NoUpperAlphaException, 
	NoLowerAlphaException, 
	NoDigitException, 
	InvalidSequenceException {
		for (int i = 0; i < password.length(); i++) {
			Matcher matcher = pattern.matcher(Character.toString(password.charAt(i)));
			if (matcher.matches()) {
				return true;
			}
		}
		throw E;
	}
}
