/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements

import static org.junit.Assert.*;
import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseArrayListTester {
    private MyArrayList alist;
    private MyLinkedList llist;
    private String[] strData = {"zero", "first", "second", "third", "fourth"};

    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        alist = new MyArrayList(strData);
        llist = new MyLinkedList(strData);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        // Testing IndexOutOfBounds Exception for arraylist
        try {
            alist.reverseRegion(0, 10); 
            // Should throw IndexOutOfBoundsException
            fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing
        }
        // Testing IndexOutOfBounds Exception for linkedlist
        try {
            llist.reverseRegion(0, 10); 
            // Should throw IndexOutOfBoundsException
            fail();
        } catch (IndexOutOfBoundsException e) {
            // do nothing
        }
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        // Tests for when fromIndex is greater than toIndex for arraylist
        alist.reverseRegion(3, 1);
        assertEquals("Nothing should change", "first", alist.get(1));
        assertEquals("Nothing should change", "second", alist.get(2));
        assertEquals("Nothing should change", "third", alist.get(3));
        // Tests for when fromIndex is greater than toIndex for linkedlist
        llist.reverseRegion(3, 1);
        assertEquals("Nothing should change", "first", llist.get(1));
        assertEquals("Nothing should change", "second", llist.get(2));
        assertEquals("Nothing should change", "third", llist.get(3));
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        // Testing arraylist with odd number of elements
        alist.reverseRegion(1, 3);
        assertEquals("Swap from 1", "third", alist.get(1));
        assertEquals("Swap from 2", "second", alist.get(2));
        assertEquals("Swap from 3", "first", alist.get(3));
        //Tests linkedlist with odd number of elements
        llist.reverseRegion(1, 3);
        assertEquals("Swap from 1", "third", llist.get(1));
        assertEquals("Swap from 2", "second", llist.get(2));
        assertEquals("Swap from 3", "first", llist.get(3));
    }

    /**
     * Custom test
    */
    @Test
    public void testReverseCustom(){
        //Tests linkedlist with even number of elements
        llist.reverseRegion(0, 1);
        assertEquals("Swap from 0", "first", llist.get(0));
        assertEquals("Swap from 1", "zero", llist.get(1));
        // Testing arraylist with even number of elements
        alist.reverseRegion(0, 1);
        assertEquals("Swap from 0", "first", alist.get(0));
        assertEquals("Swap from 1", "zero", alist.get(1));

    }


}
