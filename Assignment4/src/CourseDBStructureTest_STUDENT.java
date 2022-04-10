import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CourseDBStructureTest_STUDENT {
	CourseDBStructure CDS, testStructure;

	@Before
	public void setUp() throws Exception {
		CDS = new CourseDBStructure(20);
		testStructure = new CourseDBStructure("Saad", 20);
	}

	@After
	public void tearDown() throws Exception {
		CDS = testStructure = null;
	}
	
	

	@Test
	public void testHashTable() {

		
		CourseDBElement element1 = new CourseDBElement("MATH181", 19231, 4, "HT100", "Rebin Muhammad");
		CDS.add(element1);  CDS.add(element1);  

		ArrayList<String> courseList = CDS.showAll(); 
		assertTrue(courseList.size() == 1);  
		
		CourseDBElement element2 = new CourseDBElement("MATH241", 314324, 3, "SC450", "Kruskal");
	 
 		try {
			assertEquals(19231, CDS.get(element1.getCRN()).getCRN());  
			CDS.get(element2.getCRN()).getCRN();
		} catch (IOException e) {
			assertTrue("threw Exception successfuly for the course not found", true);
		}
		
 		CDS.add(element2);
 		
 		courseList = CDS.showAll(); 
 		
		assertTrue(courseList.size() == 2);  
		try {
			assertEquals(314324, CDS.get(element2.getCRN()).getCRN());
		} catch (IOException e) {
			fail("Should not throw exception");
		}  
		
		CourseDBElement element1New = new CourseDBElement("MATH181-New", 19231, 4, "HT100", "new");
		CDS.add(element1New);  //Same CRN updated information
 		courseList = CDS.showAll(); 
		assertTrue(courseList.size() == 2);  
		
		try {
			assertEquals(19231, CDS.get(element1New.getCRN()).getCRN());
			assertEquals("MATH181-New", CDS.get(element1New.getCRN()).getID());
		} catch (IOException e) {
			fail("Should not throw exception");
		}  
		
		testStructure.add(element1); 
		courseList = testStructure.showAll(); 
		assertTrue(courseList.size() == 1); 
	}
	

	@Test
	public void testGetTableSize() {
		assertEquals(19, CDS.getTableSize());
		assertEquals(20, testStructure.getTableSize());
	}

}