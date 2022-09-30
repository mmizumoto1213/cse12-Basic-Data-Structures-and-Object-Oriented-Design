/**
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: None
 * 
 * This file contains the test cases for MyBST, MyCalendar, and MyBSTIterator.
 * This file tests for edge cases and for some cases that were not covered in
 * the public tester.
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;

/**
 * This class tests for different cases in MyBST, MyCalendar, and 
 * MyBSTIterator. These tests include test cases and cases that were not
 * covered in the public tester.
 */
public class CustomTester {
    MyBST<Integer, Integer> bsttree;
    ArrayList<MyBST.MyBSTNode<Integer, Integer>> order;

    /**
     * The setup method creates tree with height four. This tree will be used
     * in our test cases.
     */
    @Before
    public void setup() {
        bsttree = new MyBST();
        bsttree.insert(7, 7);
        bsttree.insert(5, 5);
        bsttree.insert(4, 4);
        bsttree.insert(6, 6);
        bsttree.insert(12, 12);
        bsttree.insert(10, 10);
        bsttree.insert(11, 11);
        bsttree.insert(9, 9);
        bsttree.insert(13, 13);
        bsttree.insert(14, 14);
        order = bsttree.inorder();
    }

    /**
     * This test case tests for when a null key is inserted.
     */
    @Test
    public void testInsert1() {
        MyBST.MyBSTNode<Integer, Integer> root = bsttree.root;
        try {
            bsttree.insert(null, 0);
            fail();
        } catch (NullPointerException e) {
            // Do nothing
        }
    }

    /**
     * This test case tests for when a the tree is empty and something is
     * inserted.
     */
    @Test
    public void testInsert2() {
        MyBST<Integer, Integer> empty = new MyBST();
        assertNull(empty.insert(0, 0));
        assertEquals("Size should be 1", 1, empty.size());
        assertEquals("Value of key 0 is 0", (Integer) 0, empty.search(0));
    }

    /**
     * This test case tests for when we insert a value into a key that already
     * exists.
     */
    @Test
    public void testInsert3() {
        assertEquals((Integer) 7, bsttree.insert(7, 8));
        assertEquals((Integer) 8, bsttree.search(7));
    }

    /**
     * This test case tests for when a null key is searched.
     */
    @Test
    public void testSearch1() {
        assertEquals(null, bsttree.search(null));
    }

    /**
     * This test case tests for when we search for a key that is bigger than
     * the largest key and a key that is smaller than our smallest key.
     */
    @Test
    public void testSearch2() {
        assertEquals(null, bsttree.search(100));
        assertEquals(null, bsttree.search(-100));
    }

    /**
     * This test case tests for when we remove a node with two children.
     */
    @Test
    public void testRemove1() {
        MyBST.MyBSTNode<Integer, Integer> replaced = 
            bsttree.root.getRight().getLeft().getLeft();
        assertEquals(10, bsttree.size());
        assertEquals((Integer) 7, bsttree.remove(7));
        assertEquals((Integer) 9, bsttree.root.getValue());
        assertEquals(9, bsttree.size());
    }

    /**
     * This test case tests for when we remove a node a right child.
     */
    @Test
    public void testRemove2() {
        MyBST.MyBSTNode<Integer, Integer> replaced = 
            bsttree.root.getRight().getLeft().getLeft();
        assertEquals((Integer) 13, bsttree.remove(13));
        assertEquals(null, bsttree.root.getRight().getRight().getRight());
    }

    /**
     * This test case tests for when we remove a from a parent node then
     * remove the parent of that.
     */
    @Test
    public void testRemove3() {
        MyBST.MyBSTNode<Integer, Integer> replaced = 
            bsttree.root.getRight().getLeft().getLeft();
        assertEquals((Integer) 10, bsttree.remove(10));
        assertEquals((Integer) 12, bsttree.remove(12));
        assertEquals(8, bsttree.size());
        assertEquals((Integer) 14, 
            bsttree.search(bsttree.root.getRight().getRight().getKey()));
        assertEquals((Integer) 13, 
            bsttree.search(bsttree.root.getRight().getKey()));
        assertEquals((Integer) 11, 
            bsttree.search(bsttree.root.getRight().getLeft().getKey()));
        assertEquals(null, bsttree.root.getRight().getRight().getRight());
        assertEquals(null, bsttree.root.getRight().getLeft().getRight());
    }

    /**
     * This test case tests for when we call nextNode, but the next node
     * is null.
     */
    @Test
    public void testIterator() {
        MyBSTIterator<Integer, Integer> iter = new MyBSTIterator();
        // Last node
        iter.root = bsttree.root.getRight().getRight().getRight();
        MyBSTIterator<Integer, Integer>.MyBSTValueIterator it = 
            iter.new MyBSTValueIterator(iter.root);
        try {
            // Advances to the last node
            it.nextNode();
            // Tries to advance but next node is null
            it.nextNode();
            fail();
        } catch (NoSuchElementException e) {
            // Do nothing
        }
    }

    /**
     * This test case tests for when we call book between two events that
     * have already been booked.
     */
    @Test
    public void testCalender(){
        MyCalendar cal = new MyCalendar();
        // check MyTreeMap is initialized
        assertNotNull(cal.getCalendar());
        // Booking an event
        assertTrue(cal.book(20, 40));
        // Booking before the last event
        assertTrue(cal.book(0, 10));
        // Booking between two events
        assertTrue(cal.book(10, 20));
        // Conflicting with two events
        assertFalse(cal.book(25, 35));
    }
}
