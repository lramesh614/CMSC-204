import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test all Town methods
 * @author Lokesh Sankar Ramesh
 *
 */
public class Town_STUDENT_Test {
  private Town t1, t2;

  @Before
  public void setUp() throws Exception {
    t1 = new Town("Town_1");
    t2 = new Town("Town_2");
  }

  @After
  public void tearDown() throws Exception {
    t1 = t2 = null;
  }

  @Test
  public void testHashCode() {
    assertEquals(t1.hashCode(), new Town("Town_1").hashCode());
    assertNotEquals(t1.hashCode(), new Town("Town_2").hashCode());
  }

  @Test
  public void testCompareTo() {
    assertEquals(0, t1.compareTo(new Town("Town_1")));
    assertEquals(-1, t1.compareTo(t2));
  }

  @Test
  public void testEqualsObject() {
    assertEquals(true, t1.equals(t1));
    assertEquals(false, t1.equals(t2));
  }

  @Test
  public void testGetName() {
    assertEquals("Town_1", t1.getName());
    assertEquals("Town_2", t2.getName());
  }


}