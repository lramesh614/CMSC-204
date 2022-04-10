import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class which allows the user to enter data or to read courses from a file
 * 
 * @author Lokesh Sankar Ramesh
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure CDS;

	/*
	 * No-arg constructor which initializes a CourseDBStructure object CDS with 20 elements
	 */
	public CourseDBManager() {
		CDS = new CourseDBStructure(20);
	}

	/**
	 * Adds a course (CourseDBElement) with the given information to
	 * CourseDBStructure.
	 * @param id         course id
	 * @param crn        course crn
	 * @param credits    number of credits
	 * @param roomNum    course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		CDS.add(cde);

	}

	/**
	 * finds CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		int crnIndex = crn % CDS.tableSize;
		
		if (!(CDS.hashTable.get(crnIndex).isEmpty())) {
			
			for (int i = 0; i < CDS.hashTable.get(crnIndex).size(); i++) {
				
				if (CDS.hashTable.get(crnIndex).get(i).getCRN() == crn) {
					CourseDBElement c = CDS.hashTable.get(crnIndex).get(i);
					return c;
				}	
			}
		}

		return null;
	}

	/**
	 * Reads the information of courses from a test file and adds them to the
	 * CourseDBStructure data structure
	 * @param input input file
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
    public void readFile(File input) throws FileNotFoundException {
        try {
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(input));
            String s;
            
            while((s=br.readLine())!=null) {
            	
                String[] b = s.split(" ");
                CDS.add(new CourseDBElement(b[0], Integer.parseInt(b[1]), Integer.parseInt(b[2]), b[3], b[4]));
                
            }
            
        } catch(FileNotFoundException e) { 
        	System.out.println(e); 
        }
        
        catch(IOException exception) {
            System.out.println(exception);
        }
        
    }

	
	/**
	 * @return an array list of string representation of each course in the data
	 *         structure separated by a new line.
	 * 
	 */
	@Override
	public ArrayList<String> showAll() {
		return CDS.showAll();
	}

}