/**
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: None
 * 
 * This file contains the test cases for edge cases of the methods and
 * constructors of mydeque, mystack, and myqueue. It also tests the 
 * expandcapacity method in different situations.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class contains all the test cases for mydeque, mystack, and myqueue.
 * It also tests expandcapcity for different situations that were not covered
 * in the public tester.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    // ----------------MyDeque class----------------
    /**
     * Test the constructor when initial capacity is negative
     */
    @Test
    public void testMyDequeConstructor() {
        try {
            MyDeque<Integer> deque = new MyDeque<>(-1);
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }

    /**
     * Test the expandCapacity method when initialcapcity is 0 and when
     * the capacity expands
     */
    @Test
    public void testMyDequeExpandCapacity() {
        // Checks when initialcapcity is 0 and expandCapacity is called
        MyDeque<Integer> deque = new MyDeque<>(0);
        deque.front = 0;
        deque.rear = 0;
        deque.size = 0;
        deque.expandCapacity();
        assertEquals("Deque expands to a capacity to 10", 10,
            deque.data.length);
        // Checks when size = capacity and expandCapacity is called
        MyDeque<Integer> deque2 = new MyDeque<>(0);
        Integer[] cont = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        deque2.data = cont;
        deque2.front = 1;
        deque2.rear = 0;
        deque2.size = 10;
        deque2.expandCapacity();
        // Checking all the values are correct
        assertEquals("Deque doubles capacity to 20", 20,
            deque2.data.length);
        assertEquals("Front updates to 0", 0, deque2.front);
        assertEquals("Rear updates to 9", 9, deque2.rear);
        assertEquals("Index 0 is the value of front", 1, deque2.data[0]);
        assertEquals("Index 9 is the value of rear", 10, deque2.data[9]);
    }

    /**
     * Test the addFirst method when we try to add null
     */
    @Test
    public void testAddFirst() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        try {
            deque.addFirst(null);
            fail();
        } catch (NullPointerException e) {
            //do nothing
        }
    }

    /**
     * Test the addLast method when we try to add null
     */
    @Test
    public void testAddLast() {
        MyDeque<Integer> deque = new MyDeque<>(10);
        try {
            deque.addLast(null);
            fail();
        } catch (NullPointerException e) {
            //do nothing
        }
    }

    /**
     * Test the removeFirst method when size = 0
     */
    @Test
    public void testRemoveFirst() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertEquals("Should return null", null, deque.removeFirst());
    }

    /**
     * Test the removeLast method when size = 0
     */
    @Test
    public void testRemoveLast() {
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertEquals("Should return null", null, deque.removeLast());
    }

    /**
     * Test the peekFirst method when size = 0
     */
    @Test
    public void testPeekFirst(){
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertEquals("Should return null", null, deque.peekFirst());
    }

    /**
     * Test the peekLast method when size = 0
     */
    @Test
    public void testPeekLast(){
        MyDeque<Integer> deque = new MyDeque<>(0);
        assertEquals("Should return null", null, deque.peekLast());
    }

    // ----------------MyStack class----------------
    /**
     * Test MyStack when initial capacity is negative
     */
    @Test
    public void testMyStack(){
        try {
            MyStack<Integer> stack = new MyStack<>(-1);
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }

    // ----------------MyQueue class----------------
    /**
     * Test MyQueue when [TODO]
     */
    @Test
    public void testMyQueue(){
        try {
            MyQueue<Integer> queue = new MyQueue<>(-1);
            fail();
        } catch (IllegalArgumentException e) {
            // do nothing
        }
    }
}
