
/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: Lecture Videos
 * Description: This is a custom tester file for PA4. It contains the 
 * possible edge edge cases of the methods in MyLinkedList's Iterator.
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.util.NoSuchElementException;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method headers and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class MyLinkedListCustomTester {
    private MyLinkedList emptyList, elemList;
    private MyLinkedList.MyListIterator emptyListIter, elemListIter;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    @Before
    public void setUp() throws Exception {
        emptyList = new MyLinkedList();
        emptyListIter = emptyList.new MyListIterator();
        elemList = new MyLinkedList();
        elemList.add("One");
        elemList.add("Two");
        elemListIter = elemList.new MyListIterator();
    }

    /**
     * TODO: test the hasNext method when [list is empty]
     */
    @Test
    public void testHasNext() {
        assertFalse("Empty List should not have next",
                emptyListIter.hasNext());
    }

    /**
     * TODO: test the next method when [list is empty]
     */
    @Test
    public void testNext() {
        try {
            emptyListIter.next(); // Should throw NoSuchElementException
            fail();
        } catch (NoSuchElementException e) {
            // do nothing
        }
    }

    /**
     * TODO: test the hasPrevious method when [list is empty]
     */
    @Test
    public void testHasPrevious() {
        assertFalse("Empty List should not have previous",
                emptyListIter.hasPrevious());
    }

    /**
     * TODO: test the previous method when [list is empty]
     */
    @Test
    public void testPrevious() {
        try {
            emptyListIter.previous(); // Should throw NoSuchElementException
            fail();
        } catch (NoSuchElementException e) {
            // do nothing
        }
    }

    /**
     * TODO: test the nextIndex method when [list is empty]
     */
    @Test
    public void testNextIndex() {
        assertEquals("Empty List index should be 0", 0,
                emptyListIter.nextIndex());
    }

    /**
     * TODO: test the previousIndex method when [list is empty]
     */
    @Test
    public void testPreviousIndex() {
        assertEquals("Empty List previous index should be -1", -1,
                emptyListIter.previousIndex());
    }

    /**
     * TODO: test the set method when [setting null and when 
     * canRemoveOrSet is equal to false]
     */
    @Test
    public void testSet() {
        // Manually doing elemListIter.next();
        elemListIter.left = elemList.head.getNext();
        elemListIter.right = elemList.head.getNext().getNext();
        elemListIter.idx = 1;
        elemListIter.forward = true;
        elemListIter.canRemoveOrSet = true;
        try {
            elemListIter.set(null); // Should throw NullPointerException
            fail();
        } catch (NullPointerException e) {
            // do nothing
        }
        elemListIter.canRemoveOrSet = false;
        try {
            elemListIter.set("Something"); 
            // Should throw IllegalStateException
            fail();
        } catch (IllegalStateException e) {
            // do nothing
        }
    }

    /**
     * TODO: test the remove method when [remove is called twice]
     */
    @Test
    public void testRemoveTestOne() {
        // equivalent to 2 next()
        elemListIter.left = elemList.head.getNext().getNext();
        elemListIter.right = elemList.head.getNext().getNext().getNext();
        elemListIter.idx = 2;
        elemListIter.forward = true;
        elemListIter.canRemoveOrSet = true;
        elemListIter.remove();
        try {
            elemListIter.remove(); // Should throw IllegalStateException
            fail();
        } catch (IllegalStateException e) {
            // do nothing
        }
    }

    /**
     * TODO: test the remove method when [removing without calling
     * next or previus]
     */
    @Test
    public void testRemoveTestTwo() {
        try {
            elemListIter.remove(); // Should throw IllegalStateException
            fail();
        } catch (IllegalStateException e) {
            // do nothing
        }
    }

    /**
     * TODO: test the add method when [adding null]
     */
    @Test
    public void testAdd() {
        // Manually doing elemListIter.next();
        elemListIter.left = elemList.head.getNext();
        elemListIter.right = elemList.head.getNext().getNext();
        elemListIter.idx = 1;
        elemListIter.forward = true;
        elemListIter.canRemoveOrSet = true;
        try {
            elemListIter.add(null); // Should throw NullPointerException
            fail();
        } catch (NullPointerException e) {
            // do nothing
        }
    }

}