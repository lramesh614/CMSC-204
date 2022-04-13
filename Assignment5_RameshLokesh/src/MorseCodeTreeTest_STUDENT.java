/**
 * MorseCodeTreeTest_STUDENT_Test
 * @author Lokesh Sankar Ramesh
 */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeTest_STUDENT {

	MorseCodeTree tree = new MorseCodeTree();

	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}
	@After
	public void tearDown() throws Exception {
		tree = null;
	}
	
	@Test
	public void toArrayListTest() {
		ArrayList<String> list = tree.toArrayList();
		
		assertEquals(list.get(2), "v");
		assertEquals(list.get(10), "p");
		assertEquals(list.get(20), "y");
		assertEquals(list.get(17), "n");
		assertEquals(list.get(13), "");
	}


	@Test
	public void exceptionTest() {
		try {
			tree.update();
		} catch(UnsupportedOperationException e) {
			assertTrue("An exception was thrown", true);
		}
		
		try {
			tree.delete("");
		} catch(UnsupportedOperationException e) {
			assertTrue("An exception was thrown", true);
		}
	}
	
}
