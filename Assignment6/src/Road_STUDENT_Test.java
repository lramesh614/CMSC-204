import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test all Road methods
 * 
 * @author Lokesh Sankar Ramesh
 *
 */
public class Road_STUDENT_Test {
  private Town t1,
  t2, 
  t3;
  private Road r1, 
  r2, 
  r3;

  @Before
  public void setUp() throws Exception {
    t1 = new Town("Town_1");
    t2 = new Town("Town_2");
    t3 = new Town("Town_3");
    
    r1 = new Road(t1, t2, "Road_1");
    r2 = new Road(t2, t1, "Road_1");
    r3 = new Road(t2, t3, "Road_2");
  }

  @After
  public void tearDown() throws Exception {
    t1 = t2 = t3 = null;
    r1 = r2 = r3 = null;
  }

  @Test
  public void testCompareTo() {
    assertEquals(0, r1.compareTo(r1));
    assertEquals(0, r1.compareTo(r2));
    assertEquals(-1, r2.compareTo(r3));
  }

  @Test
  public void testContains() {
    assertTrue(r1.contains(t1));
    assertTrue(r1.contains(t2));
    assertFalse(r1.contains(t3));
  }

  @Test
  public void testEqualsObject() {
    assertTrue(r1.equals(r1));
    assertTrue(r1.equals(r2));
    assertFalse(r1.equals(r3));
  }

  @Test
  public void testGetSource() {
    assertEquals(t1, r1.getSource());
    assertEquals(t2, r2.getSource());
    assertEquals(t2, r3.getSource());
  }

  @Test
  public void testGetDestination() {
    assertEquals(t2, r1.getDestination());
    assertEquals(t1, r2.getDestination());
    assertEquals(t3, r3.getDestination());
  }

  @Test
  public void testGetName() {
    assertEquals("Road_1", r1.getName());
    assertEquals("Road_1", r2.getName());
    assertEquals("Road_2", r3.getName());
  }

}