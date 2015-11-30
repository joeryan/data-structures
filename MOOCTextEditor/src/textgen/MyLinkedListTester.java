/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// DONE: Add more tests here
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // DONE: implement this test
		// test adding to the end of an empty list
		emptyList.add(69);
		assertEquals("Verify the size is now 1", 1, emptyList.size());
		assertEquals("Check that the element was added", (Integer)69, (Integer)emptyList.get(0));
		
		// test adding an item to the longer list
		longerList.add(69);
		assertEquals("Verify the size is now 1", (LONG_LIST_LENGTH+1), longerList.size());
		assertEquals("Check that the element was added", 
				(Integer)69, (Integer)longerList.get(LONG_LIST_LENGTH));
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// DONE: implement this test
		int listSize = emptyList.size();
		assertEquals("Size: check empty list is size 0", 0, listSize);
		
		listSize = list1.size();
		assertEquals("Size: check list1 is size 3", 3, listSize);
		
		listSize = longerList.size();
		assertEquals("Size: check longer list is size LONG_LIST_LENGTH", LONG_LIST_LENGTH, listSize);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // DONE: implement this test
		try {
			longerList.add(69, -1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.add(69, LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	
		// test adding to an empty list
		emptyList.add(0, 69);
		assertEquals("test that the element was added", (Integer)69, emptyList.get(0));
		assertEquals("test that the size is correct", 1, emptyList.size());
		
		// test adding to the middle of the list
		longerList.add(5, 69);
		assertEquals("test that the element was added at the right index",
				(Integer)69, longerList.get(5));
		assertEquals("test that the list size is LONG_LIST_SIZE+1", 
				(LONG_LIST_LENGTH+1), longerList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // DONE: implement this test
		// test setting an out of bounds element
		try {
			emptyList.set(69, 0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try {
			longerList.set(69, -1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
		try {
			longerList.set(69, LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
	    
		// test setting the first element
		list1.set(0, 69);
		assertEquals("test the element was set", (Integer)69, list1.get(0));
		assertEquals("test that the size has not changed", 3, list1.size());
		
		// test setting a middle element
		longerList.set(LONG_LIST_LENGTH/2, 69);
		assertEquals("test the element was set", (Integer)69, longerList.get(LONG_LIST_LENGTH/2));
		assertEquals("test that the size has not changed", LONG_LIST_LENGTH, longerList.size());
		
	}
	
	
	// TODO: Optionally add more test methods.
	
}
