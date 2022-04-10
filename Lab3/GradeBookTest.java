/*
 * Class: CMSC204-38176
 * Instructor: Farnaz Eivazi
 * Assignment: JUnit Lab
 * Due: 2/15/2022
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Lokesh Sankar Ramesh
*/

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GradeBookTest {
	private GradeBook g1;
	private GradeBook g2;
	
	@Before
	public void setUp() {
		g1 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(75);
		g1.addScore(100);
		g1.addScore(90);
		
		g2 = new GradeBook(5);
		g2.addScore(10);
		g2.addScore(25);
		g2.addScore(50);
		g2.addScore(75);
	}

	
	@After
	public void tearDown() {
		g1 = null;
		g2 = null;
	}

	
	@Test
	public void testAddScore() {

		g1 = new GradeBook(3);
		g2 = new GradeBook(3);
		
		
		//g1
		assertEquals(0, g1.getScoreSize());
		assertEquals(0, g1.sum(), 0.0001);

		g1.addScore(99);

		assertEquals(1, g1.getScoreSize());
		assertEquals(99, g1.sum(), 0.0001);

		g1.addScore(25);

		assertEquals(2, g1.getScoreSize());
		assertEquals(99 + 25, g1.sum(), 0.0001);

		g1.addScore(77);

		assertEquals(3, g1.getScoreSize());
		assertEquals(99 + 25 + 77, g1.sum(), 0.0001);
		assertFalse(g1.addScore(87));
		assertEquals(3, g1.getScoreSize());
		assertEquals(99 + 25 + 77, g1.sum(), 0.0001);
		
		
		//g2
		assertEquals(0, g2.getScoreSize());
		assertEquals(0, g2.sum(), 0.0001);

		g2.addScore(99);

		assertEquals(1, g2.getScoreSize());
		assertEquals(99, g2.sum(), 0.0001);

		g2.addScore(25);

		assertEquals(2, g2.getScoreSize());
		assertEquals(99 + 25, g2.sum(), 0.0001);

		g2.addScore(77);

		assertEquals(3, g2.getScoreSize());
		assertEquals(99 + 25 + 77, g2.sum(), 0.0001);
		assertFalse(g1.addScore(87));
		assertEquals(3, g1.getScoreSize());
		assertEquals(99 + 25 + 77, g2.sum(), 0.0001);

	}

	@Test

	public void testSum() {
		assertEquals(50 + 75 + 100 + 90, g1.sum(), 0.0001);
		g1.addScore(55);
		assertEquals(50 + 75 + 100 + 90 + 55, g1.sum(), 0.0001);
		
		assertEquals(10 + 25 + 50 + 75, g2.sum(), 0.0001);
		g2.addScore(55);
		assertEquals(10 + 25 + 50 + 75 + 55, g2.sum(), 0.0001);

	}

	@Test

	public void testMinimum() {

		assertEquals(50, g1.minimum(), 0.0001);
		g1.addScore(22);
		assertEquals(22, g1.minimum(), 0.0001);
		
		assertEquals(10, g2.minimum(), 0.0001);
		g2.addScore(5);
		assertEquals(5, g2.minimum(), 0.0001);

	}

	@Test

	public void testFinalScore() {

		assertEquals(75 + 100 + 90, g1.finalScore(), 0.0001);
		g1.addScore(22);
		assertEquals(50 + 75 + 100 + 90, g1.finalScore(), 0.0001);
		g1 = new GradeBook(2);
		assertEquals(0, g1.finalScore(), 0.0001);
		
		assertEquals(25 + 50 + 75, g2.finalScore(), 0.0001);
		g2.addScore(5);
		assertEquals(10 + 25 + 50 + 75, g2.finalScore(), 0.0001);
		g2 = new GradeBook(2);
		assertEquals(0, g2.finalScore(), 0.0001);

	}

	@Test

	public void testGetScoreSize() {

		assertEquals(4, g1.getScoreSize());
		g1.addScore(22);
		assertEquals(5, g1.getScoreSize());
		g1.addScore(76);
		assertEquals(5, g1.getScoreSize());
		
		assertEquals(4, g2.getScoreSize());
		g2.addScore(22);
		assertEquals(5, g2.getScoreSize());
		g2.addScore(76);
		assertEquals(5, g2.getScoreSize());

	}

	@Test

	public void testToString() {
		assertTrue(g1.toString().equals("50.0 75.0 100.0 90.0"));
		g1.addScore(22);
		assertTrue(g1.toString().equals("50.0 75.0 100.0 90.0 22.0"));
		g1.addScore(80);
		assertTrue(g1.toString().equals("50.0 75.0 100.0 90.0 22.0"));
		
		assertTrue(g2.toString().equals("10.0 25.0 50.0 75.0"));
		g2.addScore(22);
		assertTrue(g2.toString().equals("10.0 25.0 50.0 75.0 22.0"));
		g2.addScore(80);
		assertTrue(g2.toString().equals("10.0 25.0 50.0 75.0 22.0"));

	}

}