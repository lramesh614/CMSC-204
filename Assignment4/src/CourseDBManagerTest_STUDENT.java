import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBManagerTest_STUDENT {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204",30142 , 4 , "PS123" , "Lokesh");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 123456 4 HT105 Lokesh");
			inFile.print("CMSC204 30523 3 HT300 Jordon");
			
			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC204",dataMgr.get(123456).getID());
			assertEquals("CMSC204",dataMgr.get(30523).getID());
			assertEquals("HT300",dataMgr.get(30523).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}