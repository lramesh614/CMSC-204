import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;
/**
 * MorseCodeConverter class
 * @author Lokesh Sankar Ramesh
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree tree = new MorseCodeTree();
	
	
	public MorseCodeConverter() {}
	
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * 
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws java.io.FileNotFoundException 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner s = new Scanner(codeFile);
		String english = "";
		
		while(s.hasNext()) {
			english += convertToEnglish(s.nextLine());
		}
		
		s.close();
		return english;
	}
	
	
	/**
	 * Converts a Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’
	 * 
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code) {
		String[] words, letters;
		String english = "";
		
		words = code.split("/");
		
		for(int i=0; i<words.length; i++) {
			//words[i] = words[i].trim();
			letters = words[i].trim().split(" ");
			
			for(int j=0; j<letters.length; j++) {
				english += tree.fetch(letters[j]);
			}
			
			english += " ";
		}
		
		//english = english.trim();
		return english.trim();
	}
	
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them
	 * 
	 * @return the data in the tree in LNR order separated by a space between each element
	 */
	public static String printTree() {
		String s = "";
		
		for (String t : tree.toArrayList()) {
			s += t + " "; 
			System.out.print(t);
		}
		
		return s.trim();
	}

	
	


}
