import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListSTUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Fruit> sortedLinkedFruit;
	
	StringComparator comparator;
	DoubleComparator comparatorD;
	FruitComparator comparatorFruit;
	
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
		
	public Fruit f1 = new Fruit("Fig", "Flax", 20),
			f2 = new Fruit("Jackfruit", "Red", 20),
			f3 = new Fruit("Honeydew", "Charcoal", 20),
			f4 = new Fruit("Starfruit", "Orange", 20),
			f5 = new Fruit("Cherry", "Silverado", 20),
			f6 = new Fruit("Chestnut", "Purple", 20); 
	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorFruit = new FruitComparator();
		sortedLinkedFruit = new SortedDoubleLinkedList<Fruit>(comparatorFruit);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorFruit = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedFruit = null;
	}
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class FruitComparator implements Comparator<Fruit>
	{

		@Override
		public int compare(Fruit arg0, Fruit arg1) {
			return arg0.getName().compareTo(arg1.getName());
		}		
	}

	@Test
	public void testIteratorSuccessfulNext() {
		sortedLinkedDouble.add(a);
		sortedLinkedDouble.add(e);
		sortedLinkedDouble.add(c);
		sortedLinkedDouble.add(b);
		ListIterator<Double> iteratorD = sortedLinkedDouble.iterator();
		assertEquals(true, iteratorD.hasNext());
		assertEquals(c, iteratorD.next(),.0);
		assertEquals(a, iteratorD.next(),.0);
		assertEquals(e, iteratorD.next(),.0);
		assertEquals(true, iteratorD.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add(s1);
		sortedLinkedString.add(s4);
		sortedLinkedString.add(s2);
		sortedLinkedString.add(s6);
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(s1, iterator.next());
		assertEquals(s2, iterator.next());
		assertEquals(s6, iterator.next());
		assertEquals(s4, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(s4, iterator.previous());
		assertEquals(s6, iterator.previous());
		assertEquals(s2, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulFruitPrevious() {
		sortedLinkedFruit.add(f5);
		sortedLinkedFruit.add(f3);
		sortedLinkedFruit.add(f2);
		sortedLinkedFruit.add(f4);

		ListIterator<Fruit> iterator = sortedLinkedFruit.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(f5, iterator.next());
		assertEquals(f3, iterator.next());
		assertEquals(f2, iterator.next());
		assertEquals(f4, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(f4, iterator.previous());
		assertEquals(f2, iterator.previous());
		assertEquals(f3, iterator.previous());
	}
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		sortedLinkedDouble.add(c);
		sortedLinkedDouble.add(e);
		sortedLinkedDouble.add(d);
		sortedLinkedDouble.add(a);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(c, iterator.next(),.0);
		assertEquals(a, iterator.next(),.0);
		assertEquals(e, iterator.next(),.0);
		assertEquals(true, iterator.hasNext());	
	}
	
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		sortedLinkedDouble.add(e);
		sortedLinkedDouble.add(d);
		sortedLinkedDouble.add(c);
		sortedLinkedDouble.add(b);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(c, iterator.next(),.0);
		assertEquals(e, iterator.next(),.0);
		assertEquals(b, iterator.next(),.0);
		assertEquals(true, iterator.hasPrevious());
		assertEquals(b, iterator.previous(),.0);
		assertEquals(true, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedString.add(s4);
		sortedLinkedString.add(s1);
		sortedLinkedString.add(s5);
		sortedLinkedString.add(s3);
		
		ListIterator<String> iteratorS = sortedLinkedString.iterator();
		
		assertEquals(true, iteratorS.hasNext());
		assertEquals(s1 ,iteratorS.next());
		assertEquals(s5, iteratorS.next());
		assertEquals(s4, iteratorS.next());
		assertEquals(true, iteratorS.hasNext());
		assertEquals(s3, iteratorS.next());
		try{
			iteratorS.next();
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
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedString.add(s3);
		sortedLinkedString.add(s1);
		
		ListIterator<String> iteratorS = sortedLinkedString.iterator();
		
		try{
			iteratorS.remove();
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
		try {
			sortedLinkedString.addToEnd(s1);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			sortedLinkedDouble.addToFront(a);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}


	@Test
	public void testAddDouble() {
		//order: r p t q s
		sortedLinkedDouble.add(a);
		sortedLinkedDouble.add(e);
		sortedLinkedDouble.add(b);
		assertEquals(a, sortedLinkedDouble.getFirst(),.0);
		assertEquals(b, sortedLinkedDouble.getLast(),.0);
		sortedLinkedDouble.add(c);
		sortedLinkedDouble.add(d);
		assertEquals(c, sortedLinkedDouble.getFirst(),.0);
		assertEquals(d, sortedLinkedDouble.getLast(),.0);
		
		assertEquals(d,sortedLinkedDouble.retrieveLastElement(),.0);
		assertEquals(b, sortedLinkedDouble.getLast(),.0);
	}

	@Test
	public void testRemoveFirstString() {
		sortedLinkedString.add(s5);
		sortedLinkedString.add(s2);
		assertEquals(s2, sortedLinkedString.getFirst());
		assertEquals(s5, sortedLinkedString.getLast());
		sortedLinkedString.add(s1);
		assertEquals(s1, sortedLinkedString.getFirst());
		sortedLinkedString.remove(s1, comparator);
		assertEquals(s2, sortedLinkedString.getFirst());
	}
	
	@Test
	public void testRemoveEndFruit() {
		sortedLinkedFruit.add(f2);
		sortedLinkedFruit.add(f6);
		assertEquals(f6, sortedLinkedFruit.getFirst());
		assertEquals(f2, sortedLinkedFruit.getLast());
		sortedLinkedFruit.add(f4);
		assertEquals(f4, sortedLinkedFruit.getLast());
		//remove from the end of the list
		sortedLinkedFruit.remove(f4, comparatorFruit);
		assertEquals(f2, sortedLinkedFruit.getLast());
	}

	@Test
	public void testRemoveMiddleFruit() {
		sortedLinkedFruit.add(f3);
		sortedLinkedFruit.add(f6);
		assertEquals(f6, sortedLinkedFruit.getFirst());
		assertEquals(f3, sortedLinkedFruit.getLast());
		sortedLinkedFruit.add(f5);
		assertEquals(f5, sortedLinkedFruit.getFirst());
		assertEquals(f3, sortedLinkedFruit.getLast());
		
		sortedLinkedFruit.remove(f6, comparatorFruit);
		assertEquals(f5, sortedLinkedFruit.getFirst());
		assertEquals(f3, sortedLinkedFruit.getLast());
		assertEquals(2, sortedLinkedFruit.getSize());
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