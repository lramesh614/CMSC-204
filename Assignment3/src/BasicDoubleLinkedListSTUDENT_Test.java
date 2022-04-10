import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BasicDoubleLinkedListSTUDENT_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Fruit> linkedFruit;
	
	StringComparator comparatorS;
	DoubleComparator comparatorD;
	FruitComparator comparatorFruit;
	
	public Fruit f = new Fruit("Fig", "Flax", 20);
	public double a = 45.00,
			b = 65.00, 
			c = 25.00, 
			d = 69.00, 
			e = 58.65;
	public String s1 = "Carrey",
			s2="God",
			s3="Wow",
			s4="Truth",
			s5="James",
			s6="Miguel";
	
	public ArrayList<Double> stringD;
	public ArrayList<String> stringS;
	

	@Before
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<String>();
		linkedString.addToEnd("Hello");
		linkedString.addToEnd("World");
		
		comparatorS = new StringComparator();
		stringS = new ArrayList<String>();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(15.0);
		linkedDouble.addToEnd(100.0);
		
		comparatorD = new DoubleComparator();
		stringD = new ArrayList<Double>();
		
		linkedFruit= new BasicDoubleLinkedList<Fruit>();
		comparatorFruit = new FruitComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedFruit = null;
		comparatorD = null;
		comparatorS = null;
		stringD = null;
		stringS = null;
	}
	
	@Test
	public void testGetFirst() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("New");
		assertEquals("New", linkedString.getFirst());
		
		assertEquals(15.0, linkedDouble.getFirst(),.00);
		linkedDouble.addToFront(b);
		assertEquals(b, linkedDouble.getFirst(),.00);
		
		
	}

	@Test
	public void testGetLast() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("New");
		assertEquals("New", linkedString.getLast());
		
		assertEquals(100.0, linkedDouble.getLast(),.00);
		linkedDouble.addToEnd(e);
		assertEquals(e, linkedDouble.getLast(),.00);
		
		
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedString.addToFront(s4);
		linkedString.addToEnd(s6);
		ListIterator<String> iterator = linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(s4, iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(s6, iterator.next());
		
		linkedDouble.addToFront(e);
		linkedDouble.addToEnd(d);
		ListIterator<Double> iteratorD = linkedDouble.iterator();
		assertEquals(true, iteratorD.hasNext());
		assertEquals(e, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
		assertEquals(d, iteratorD.next(),.0);
		
		
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedString.addToFront(s3);
		linkedString.addToEnd(s5);
		
		ListIterator<String> iterator = linkedString.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(s3, iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(s5, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(s5, iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals(s3, iterator.previous());
		
		linkedDouble.addToFront(a);
		linkedDouble.addToEnd(b);
		
		ListIterator<Double> iteratorD = linkedDouble.iterator();
		
		assertEquals(true, iteratorD.hasNext());
		assertEquals(a, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(b, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasPrevious());
		assertEquals(b, iteratorD.previous(),.0);
		assertEquals(100.0, iteratorD.previous(),.0);
		assertEquals(15.0, iteratorD.previous(),.0);
		assertEquals(a, iteratorD.previous(),.0);
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedDouble.addToFront(c);
		linkedDouble.addToEnd(b);
		
		ListIterator<Double> iteratorD = linkedDouble.iterator();	
		
		assertEquals(true, iteratorD.hasNext());
		assertEquals(c, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
		assertEquals(b, iteratorD.next(),.0);
		
		try{
			//no more elements in list
			iteratorD.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedString.addToFront(s6);
		linkedString.addToEnd(s5);
		ListIterator<String> iterator = linkedString.iterator();		
		assertEquals(true, iterator.hasNext());
		assertEquals(s6, iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(s5, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(s5, iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
		assertEquals(s6, iterator.previous());
		
		try{
			//no more elements in list
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedDouble.addToFront(a);
		linkedDouble.addToEnd(d);
		ListIterator<Double> iteratorD = linkedDouble.iterator();		
		assertEquals(true, iteratorD.hasNext());
		assertEquals(a, iteratorD.next(),.0);
		assertEquals(15.0, iteratorD.next(),.0);
		assertEquals(100.0, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
		assertEquals(d, iteratorD.next(),.0);
		
		try{
			//remove is not supported for the iterator
			iteratorD.remove();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}

	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd("End");
		assertEquals("End", linkedString.getLast());
		
		assertEquals(100.0, linkedDouble.getLast(),.00);
		linkedDouble.addToEnd(90.0);
		assertEquals(90.0, linkedDouble.getLast(),.00);
		
		
	}
	
	@Test
	public void testAddToFront() {
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront("Began");
		assertEquals("Began", linkedString.getFirst());
		
		assertEquals(15.0, linkedDouble.getFirst(),.00);
		linkedDouble.addToFront(d);
		assertEquals(d, linkedDouble.getFirst(),.00);
		
	}
	
	@Test
	public void testRetrieveFirstElement() {
		assertEquals(15.0, linkedDouble.getFirst(),.0);
		linkedDouble.addToFront(a);
		assertEquals(a, linkedDouble.getFirst(),.0);
		assertEquals(a, linkedDouble.retrieveFirstElement(),.0);
		assertEquals(15.0,linkedDouble.getFirst(),.0);
		assertEquals(15.0, linkedDouble.retrieveFirstElement(),.0);
		assertEquals(100.0,linkedDouble.getFirst(),.0);
		
		assertEquals("Hello", linkedString.getFirst());
		linkedString.addToFront(s4);
		assertEquals(s4, linkedString.getFirst());
		assertEquals(s4, linkedString.retrieveFirstElement());
		assertEquals("Hello",linkedString.getFirst());
		assertEquals("Hello", linkedString.retrieveFirstElement());
		assertEquals("World",linkedString.getFirst());
		
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals(100.0, linkedDouble.getLast(),.0);
		linkedDouble.addToEnd(c);
		assertEquals(c, linkedDouble.getLast(),.0);
		assertEquals(c, linkedDouble.retrieveLastElement(),.0);
		assertEquals(100.0,linkedDouble.getLast(),.0);
		
		assertEquals("World", linkedString.getLast());
		linkedString.addToEnd(s2);
		assertEquals(s2, linkedString.getLast());
		assertEquals(s2, linkedString.retrieveLastElement());
		assertEquals("World",linkedString.getLast());
	}
	
	@Test
	public void testRemove() {
		// remove the first
		assertEquals(15.0, linkedDouble.getFirst(),.0);
		assertEquals(100.0, linkedDouble.getLast(),.0);
		linkedDouble.addToFront(b);
		assertEquals(b, linkedDouble.getFirst(),.0);
		linkedDouble.remove(b, comparatorD);
		assertEquals(15.0, linkedDouble.getFirst(),.0);
		
		//remove from the end of the list
		linkedDouble.addToEnd(e);
		assertEquals(e, linkedDouble.getLast(),.0);
		linkedDouble.remove(e, comparatorD);
		assertEquals(100.0, linkedDouble.getLast(),.0);
		
		//remove from middle of list
		linkedString.addToFront(s1);
		assertEquals(s1, linkedString.getFirst());
		assertEquals("World", linkedString.getLast());
		linkedString.remove("Hello", comparatorS);
		assertEquals(s1, linkedString.getFirst());
		assertEquals(2, linkedString.getSize());
		
	}
	
	@Test
	public void testToArrayList()
	{
		linkedDouble.addToFront(d);
		linkedDouble.addToFront(c);
		stringD=linkedDouble.toArrayList();
		
		assertEquals(c,stringD.get(0),.00);
		assertEquals(d,stringD.get(1),.00);
		assertEquals(15.0,stringD.get(2),.00);
		assertEquals(100.0,stringD.get(3),.00);
		
		linkedString.addToFront(s1);
		linkedString.addToFront(s2);
		stringS=linkedString.toArrayList();
		
		assertEquals(s2,stringS.get(0));
		assertEquals(s1,stringS.get(1));
		assertEquals("Hello",stringS.get(2));
		assertEquals("World",stringS.get(3));
		
	}

	
	@Test
	public void testGetSize() {
		assertEquals(2, linkedString.getSize());
		assertEquals(2, linkedDouble.getSize());
	}
	
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}

	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	
	private class FruitComparator implements Comparator<Fruit>
	{
		@Override
		public int compare(Fruit arg0, Fruit arg1) {
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Fruit {
		String name;
		String color;
		int price;
		
		public Fruit(String name, String color, int price){
			this.name = name;
			this.color = color;
			this.price = price;
		}
		
		public String getName(){
			return name;
		}
		public String getColor(){
			return color;
		}
		public int getPrice(){
			return price;
		}
		
		public String toString() {
			return (getName() + " " + getColor() + " " + getPrice());
		}
	}
	
	
}