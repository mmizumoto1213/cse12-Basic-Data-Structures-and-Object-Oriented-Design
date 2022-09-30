/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * Email: mmizumoto@ucsd.edu
 * Sources used: None
 * Description: This is a custom tester file for PA3. It contains tests
 * for the possible edge cases in the methods in MyLinkedList.
 */

import static org.junit.Assert.*;
import org.junit.*;

/**
 * TODO: This class contains all the test cases that will be used to
 * test the edge cases in MyLinkedList. These tests will cover the
 * the test cases that were not covered in MyLinkedListPublicTester.
 * 
 * IMPORTANT: Do not change the method headers and points are awarded 
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
	private MyLinkedList<Double> emptyDoubleList;
	private MyLinkedList<String> fourStringList;
	private String[] strData = {"first", "second", "third", "fourth"};

	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		emptyDoubleList = new MyLinkedList<Double>();
		fourStringList = new MyLinkedList<String>();
		fourStringList.add(strData[0]);
		fourStringList.add(strData[1]);
		fourStringList.add(strData[2]);
		fourStringList.add(strData[3]);
	}

	/**
	 * TODO: test the add method when [a null is added]
	 */
	@Test
	public void testAdd() {
		try {
			this.emptyDoubleList.add(null);
			fail();
		} catch (NullPointerException e) {
			// Exception is successfully caught. Passing the test case.
		}
	}

	/**
	 * TODO: test the add with index method when [index is less than 0]
	 */
	@Test
	public void testAddWithIndexTestOne() {
		try {
			this.emptyDoubleList.add(-1, 1.1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
	}

	/**
	 * TODO: test the add with index method when [a null is added]
	 */	
	@Test
	public void testAddWithIndexTestTwo() {
		try {
			this.emptyDoubleList.add(0, null);
			fail();
		} catch (NullPointerException e) {
			// Exception is successfully caught. Passing the test case.
		}
	}

	/**
	 * TODO: test the get method when [index is less than 0 or when index
	 * is greater than size]
	 */
	@Test
	public void testGet() {
		try {
			this.fourStringList.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
		try {
			this.fourStringList.get(5);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
	}

	/**
	 * TODO: test the getNth method when [index is less than 0 or when index
	 * is greater than size]
	 */
	@Test
	public void testGetNth() {
		try {
			this.fourStringList.getNth(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
		try {
			this.fourStringList.getNth(5);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
		assertEquals("Getting Nth element", fourStringList.tail.prev, fourStringList.getNth(3));
	}

	/**
	 * TODO: test the set method when [index is less than 0 or when index
	 * is greater than size]
	 */
	@Test
	public void testSet() {
		try {
			this.fourStringList.set(-1, "one");
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
		try {
			this.fourStringList.set(5, "one");
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
	}

	/**
	 * TODO: test the remove method when [index is less than 0 or when index
	 * is greater than size]
	 */
	@Test
	public void testRemoveTestOne() {
		try {
			this.fourStringList.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
		try {
			this.fourStringList.remove(5);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
	}
	
	/**
	 * TODO: test the remove method when [mylinklist is empty]
	 */
	@Test
	public void testRemoveTestTwo() {
		try {
			this.emptyDoubleList.remove(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			// Exception is successfully caught. Passing the test case.
		}
	}

	/**
	 * TODO: test the clear method when [mylinklist is empty]
	 */
	@Test
	public void testClear() {
		emptyDoubleList.clear();
		assertEquals("Size should be updated", 0, emptyDoubleList.size());
		assertTrue("LinkedList should be empty", emptyDoubleList.isEmpty());
	}

	/**
	 * TODO: test the size method when [size is no 0]
	 */
	@Test
	public void testSize() {
		assertEquals("LinkedList should have a size of 4", 
			4, fourStringList.size());
	}
}