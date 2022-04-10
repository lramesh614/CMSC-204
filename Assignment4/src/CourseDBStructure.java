import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Math;

/**
 * Used to create a hash table that has CDE's in it.
 * @author Lokesh Sankar Ramesh
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	protected int tableSize;
	protected ArrayList<LinkedList<CourseDBElement>> hashTable;
	private final double loadFactor = 1.5;

	/*
	 * Constructor which takes in num
	 */
	public CourseDBStructure(int num) {
		
		int i = (int) (num / loadFactor);
		
		for (int j = 0; j < i; j++) {
			
			if (((4 * j) + 3) > i) {
				
				if (isPrime(4 * j + 3)) {
					
					int size = 4 * j + 3;
					tableSize = size;
					break;
				}
			}
		}

		hashTable = new ArrayList<LinkedList<CourseDBElement>>(tableSize);
		
		for (int x = 0; x < tableSize; x++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}

	/*
	 * Constructor which takes in string and int
	 */
	public CourseDBStructure(String s, int i) {
		tableSize = i;
		hashTable = new ArrayList<LinkedList<CourseDBElement>>(tableSize);
		
		for (int j = 0; j < tableSize; j++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}
	
	
	/**
	 * Find a courseDatabaseElement based on the crn of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * @param crn - crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	public CourseDBElement get(int crn) throws IOException {
		int i = crn % tableSize;
		
		if (!(hashTable.get(i).isEmpty())) {
			
			for (int j = 0; j < hashTable.get(i).size(); j++) {
				
				if (((CourseDBElement) hashTable.get(i).get(j)).getCRN() == crn) {
					
					return ((CourseDBElement) hashTable.get(i).get(j));
				}
			}
		}
		throw new IOException();

	}
	
	/**
	 * Method that returns the size of the table
	 * @return tableSize
	 */
	public int getTableSize() {
		// TODO Auto-generated method stub
		return tableSize;
	}

	
	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	public void add(CourseDBElement c) {
		int i = Integer.parseInt(c.getHash()) % tableSize;

		if (!(hashTable.get(i).contains(c))) {
			hashTable.get(i).add(c);
		}

		for (int j = 0; j < hashTable.get(i).size(); j++) {
			
			if (!((CourseDBElement) hashTable.get(i).get(j)).getID().equals(c.getID())) {
				
				if (((CourseDBElement) hashTable.get(i).get(j)).getCRN() == c.getCRN()) {
					
					hashTable.get(i).remove(j);
					hashTable.get(i).add(c);
				}	
			}
		}
		

	}


	/**
	 * Method that shows all of the elements in the hash table
	 * @return all - an ArrayList of all the elements in the hash table
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> allElements = new ArrayList<String>(tableSize);

		for (int i = 0; i < tableSize; i++) {
			
			if (!(hashTable.get(i).isEmpty())) {
				
				allElements.add(hashTable.get(i).toString().replace("]", "").replace("[", ""));
			}
		}
		
		return allElements;
	}



	public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int x = 2; x <= Math.sqrt(num); x++) {
            if (num % x == 0) {
                return false;
            }
        }
        return true;
 }

}