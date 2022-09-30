/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: Piazza
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file implements and tests the hidden tests in MyArrayList.
 * We are mainly testing cases that would result in an error or a case where we
 * want our methods to call other methods.
 */

 //IMPORTANT: Do not change the headers!

import static org.junit.Assert.*;

import org.junit.*;

public class MyArrayListHiddenTester {

    static final int MY_CAPACITY = 3;

    Integer[] arrInts1 = { 1, 2, 3 };
    Integer[] arrInts2 = { 4, 5, 6 };
    Integer[] arrNulls = { null, null, null };

    private MyArrayList listWithInt1, listWithInt2, nullArgumentInitialization, listFullOfNulls, listCustomCapacity;

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test */
    @Before
    public void setUp() throws Exception {
        listWithInt1 = new MyArrayList<Integer>(arrInts1);
        listWithInt2 = new MyArrayList<Integer>(arrInts2);
        nullArgumentInitialization = new MyArrayList(null);
        listFullOfNulls = new MyArrayList<Integer>(arrNulls);
        listCustomCapacity = new MyArrayList(MY_CAPACITY);
    }

    /**
     * Aims to test the capacity argument constructor when the input
     * is not valid
     */
    @Test
    public void testConstructorInvalidArg(){
        boolean exceptionThrown = false;
        MyArrayList invalidArrayList;
        int invalidSize = -1;
        try {
            invalidArrayList = new MyArrayList(invalidSize);
        }
        catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("Exception thrown when initial capacity is negative", exceptionThrown);
    }

    /**
     * Aims to test the Array argument constructor when the input
     * is null
     */
    @Test
    public void testConstructorNullArg(){
        assertEquals("Check size for null argument constructor", 0, nullArgumentInitialization.size);
        assertEquals("Check capacity for null argument constructor", 5, nullArgumentInitialization.data.length);
    }

    /**
     * Aims to test the append method when an element is added to a full list
     * Check reflection on size and capacity
     */
    @Test
    public void testAppendAtCapacity(){
        listWithInt1.append(4);

        assertEquals("Check that append increments size", 4, listWithInt1.size);
        assertEquals("Check that if the capacity is updated", 6, listWithInt1.data.length);
        assertEquals("check the correct element", 4, listWithInt1.data[3]);
    }

    /**
     * Aims to test the prepend method when a null element is added
     * Checks reflection on size and capacity
     * Checks whether null was added successfully
     */
    @Test
    public void testPrependNull(){
        listWithInt2.prepend(null);

        assertEquals("Check that prepend increments size", 4, listWithInt2.size);
        assertEquals("Check that if the capacity is updated", 6, listWithInt2.data.length);
        assertEquals("Check the correct element", null, listWithInt2.data[0]);
        assertEquals("Check the correct element", 6, listWithInt2.data[3]);
    }
    
    /**
     * Aims to test the insert method when input index is out of bounds
     */
    @Test
    public void testInsertOutOfBound(){
        int invalidIndex1 = 100;
        int invalidIndex2 = -100;
        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;
        try {
            listFullOfNulls.insert(invalidIndex1, null);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown1 = true;
        }
        assertTrue("Exception thrown when index is greater than size", exceptionThrown1);
        try {
            listFullOfNulls.insert(invalidIndex2, null);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown2 = true;
        }
        assertTrue("Exception thrown when index is negative", exceptionThrown2);
    }

    /**
     * Insert multiple (eg. 1000) elements sequentially beyond capacity -
     * Check reflection on size and capacity
     * Hint: for loop could come in handy
     */
    @Test
    public void testInsertMultiple(){
        listCustomCapacity.insert(0, Integer.valueOf(1));
        listCustomCapacity.insert(0, 2);
        listCustomCapacity.insert(0, 3);
        listCustomCapacity.insert(0, 4);

        assertEquals("Check that insert increments size", 4, listCustomCapacity.size);
        assertEquals("Check that if the capacity is updated", 6, listCustomCapacity.data.length);
    }

    /**
     * Aims to test the get method when input index is out of bound
     */
    @Test
    public void testGetOutOfBound(){
        int invalidIndex1 = 100;
        int invalidIndex2 = -100;
        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;
        try {
            listFullOfNulls.get(invalidIndex1);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown1 = true;
        }
        assertTrue("Exception thrown when index is greater than size", exceptionThrown1);
        try {
            listFullOfNulls.get(invalidIndex2);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown2 = true;
        }
        assertTrue("Exception thrown when index is negative", exceptionThrown2);
    }

    /**
     * Aims to test the set method when input index is out of bound
     */
    @Test
    public void testSetOutOfBound(){
        int invalidIndex1 = 100;
        int invalidIndex2 = -100;
        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;
        try {
            listFullOfNulls.set(invalidIndex1, null);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown1 = true;
        }
        assertTrue("Exception thrown when index is greater than size", exceptionThrown1);
        try {
            listFullOfNulls.set(invalidIndex2, null);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown2 = true;
        }
        assertTrue("Exception thrown when index is negative", exceptionThrown2);
    }


    /**
     * Aims to test the remove method when input index is out of bound
     */
    @Test
    public void testRemoveOutOfBound(){
        int invalidIndex1 = 100;
        int invalidIndex2 = -100;
        boolean exceptionThrown1 = false;
        boolean exceptionThrown2 = false;
        try {
            listFullOfNulls.remove(invalidIndex1);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown1 = true;
        }
        assertTrue("Exception thrown when index is greater than size", exceptionThrown1);
        try {
            listFullOfNulls.remove(invalidIndex2);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown2 = true;
        }
        assertTrue("Exception thrown when index is negative", exceptionThrown2);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is strictly less than the current capacity
     */
    @Test
    public void testExpandCapacitySmaller(){
       int smallerSize = 1;
       boolean exceptionThrown = false;
       try {
           listWithInt1.expandCapacity(smallerSize);
       }
       catch (IllegalArgumentException e) {
           exceptionThrown = true;
       }
       assertTrue("Exception thrown when input capacity is smaller than capacity", exceptionThrown);
    }

    /**
     * Aims to test the expandCapacity method when 
     * requiredCapacity is greater than double(2x) the current capacity
     */
    @Test
    public void testExpandCapacityExplode(){
        listWithInt2.expandCapacity(100);
        assertEquals("Check that if the capacity is updated", 100, listWithInt2.data.length);
    }

}
