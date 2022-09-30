/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains the edge cases for the methods and constructors that
 * have been implemented. These edge cases often include exceptions that
 * are thrown and cases that are not tested in the public tester.
 */

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * This class contains tests for the edge cases of the methods and
 * constructors that I have implemented. These include cases that were
 * not covered in the public tester, and some exceptions that need to be
 * tested.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    
    /**
     * Test the constructor when the collection is null or contains null.
     */
    @Test
    public void testMyMinHeapConstructor() {
        ArrayList<Integer> inputList1 = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 1, 2, 3, 4, null, 6 }   
            )
        );
        // Testing when input collection contains a null.
        try {
            MyMinHeap<Integer> heap = new MyMinHeap<>(inputList1);
            fail();
            // Should throw NullPointerException
        } catch (NullPointerException e) {
            // Do nothign
        }
        ArrayList<Integer> inputList2 = null;
        // Testing when input collection is null.
        try {
            MyMinHeap<Integer> heap = new MyMinHeap<>(inputList2);
            fail();
            // Should throw NullPointerException
        } catch (NullPointerException e) {
            // Do nothign
        }
    }

    /**
     * Test the getMinChildIdx method when minchild is the right child
     * and when the given index has no child.
     */
    @Test
    public void testGetMinChildIdx() {
        ArrayList<Integer> inputList1 = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 1, 2, 3, 5, 4 }   
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(inputList1);
        assertEquals("Should return the right child", 4, 
            heap.getMinChildIdx(1));
        assertEquals("Should return -1 when there is no child", -1,
            heap.getMinChildIdx(4));
    }

    /**
     * Test the percolateUp method when starting index is the root and when
     * percolating up multiple numbers.
     */
    @Test
    public void testPercolateUp() {
        ArrayList<Integer> inputList = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 4, 3, 2, 1, 0 }   
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        Integer[] expected1 = {4, 3, 2, 1, 0};
        heap.data = inputList;
        // Percolating up from root.
        heap.percolateUp(0);
        for (int i = 0; i < 5; i++) {
            assertEquals(
                    "Nothing should change.",
                    expected1[i],
                    heap.data.get(i));
        }
        // Percolating up from buttom to top.
        heap.percolateUp(4);
        Integer[] expected2 = {0, 4, 2, 1, 3};
        for (int i = 0; i < 5; i++) {
            assertEquals(
                    "Should have brought 0 to the top",
                    expected2[i],
                    heap.data.get(i));
        }
    }

    /**
     * Test the percolateDown method when the starting index is a leaf.
     */
    @Test
    public void testPercolateDown() {
        ArrayList<Integer> inputList = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 4, 3, 2, 1, 0 }   
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        Integer[] expected1 = {4, 3, 2, 1, 0};
        heap.data = inputList;
        // Percolating down from leaf.
        heap.percolateDown(3);
        for (int i = 0; i < 5; i++) {
            assertEquals(
                    "Nothing should change.",
                    expected1[i],
                    heap.data.get(i));
        }
    }

    /**
     * Test the deleteIndex method when deleting the last element.
     */
    @Test
    public void testDeleteIndex() {
        ArrayList<Integer> inputList = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 4, 3, 2, 1, 0 }   
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.data = inputList;
        // Deleting last index
        assertEquals("Should return 0", 0, (int)heap.deleteIndex(4));
        try {
            heap.data.get(4);
            fail();
            // Should throw IndexOutOfBoundsException
        } catch (IndexOutOfBoundsException e) {
            // do nothing
        }
    }

    /**
     * Test the deleteIndex method when an index from the middle of the heap.
     */
    @Test
    public void testDeleteIndex2() {
        ArrayList<Integer> inputList = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 4, 3, 2, 1, 0 }   
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        Integer[] expected1 = {0, 1, 2, 4};
        heap.data = inputList;
        // Deleting last index
        assertEquals("Should return 3", 3, (int)heap.deleteIndex(1));
        heap.percolateDown(3);
        for (int i = 0; i < 4; i++) {
            assertEquals(
                    "Heap should have sorted and removed 3.",
                    expected1[i],
                    heap.data.get(i));
        }
    }

    /**
     * Test the insert method when null is inserted.
     */
    @Test
    public void testInsert(){
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        try {
            heap.insert(null);
            fail();
            // Should throw NullPointerException
        } catch (NullPointerException e) {
            // Do nothing
        }
    }

    /**
     * Test the insert method when inserting the smallest element.
     */
    @Test
    public void testInsert2(){
        ArrayList<Integer> inputList = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 1, 2, 3, 4, 5, 6, 7}   
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(inputList);
        Integer[] expected1 = {0, 1, 3, 2, 5, 6, 7, 4};
        heap.insert(0);
        for (int i = 0; i < 8; i++) {
            assertEquals(
                    "0 should be the new root through percolate up",
                    expected1[i],
                    heap.data.get(i));
        }
    }

   
    /**
     * Test remove when removing from an empty heap.
     */
    @Test
    public void testRemove(){
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        assertEquals("Should return null when removing from empty heap",
            null, heap.remove());
    }

    
    /**
     * Test getMin when the min child is the right child.
     */
    @Test
    public void testGetMin(){
        ArrayList<Integer> inputList = new ArrayList<Integer>(
            Arrays.asList(
                    new Integer[] { 1, 2, 3, 4, 5, 7, 6}   
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.data = inputList;
        assertEquals("Should return index of 6", 6, heap.getMinChildIdx(2));
    }
}