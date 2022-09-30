/**
 * TODO: Add file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * File description: This file contains the tests that test different cases
 * for all the methods in my NaryTree. These include tests for functionality
 * and for edge cases that tests errors and exceptions that should be thrown.
 */
 
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import java.util.ArrayList;

/**
 * This class contains the tests for CSE12NaryTree. It contains the tests for
 * mainly the three methods in the NaryTree which are add, contains, and
 * sortTree.
 */
public class CSE12NaryTreeTester {
    /**
     * This test case tests the add method with a fiveAry tree. This tests if
     * a new child is added properly to the tree.
     */
    @Test
    public void testAdd(){
        CSE12NaryTree<Integer> fiveAry; 
        fiveAry = new CSE12NaryTree<Integer>(5);
        CSE12NaryTree.Node root = fiveAry.new Node(0);
        CSE12NaryTree.Node child1 = fiveAry.new Node(1);
        CSE12NaryTree.Node child2 = fiveAry.new Node(2);
        CSE12NaryTree.Node child3 = fiveAry.new Node(3);
        CSE12NaryTree.Node child4 = fiveAry.new Node(4);
        CSE12NaryTree.Node child5 = fiveAry.new Node(5);
        ArrayList<CSE12NaryTree.Node> children = new ArrayList();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        children.add(child4);
        children.add(child5);
        root.children = children;
        fiveAry.root = root;
        fiveAry.size = 6;
        fiveAry.add(6);
        assertEquals((Integer)6, 
            fiveAry.root.getChildren().get(0).getChildren().get(0).getData());
        assertEquals(7, fiveAry.size);
    }

    /**
     * This test case tests the contains method with a fiveAry tree. This
     * tests if the fiveAry returns false when we search for an element that
     * does not exist in the tree.
     */
    @Test
    public void testContains(){
        CSE12NaryTree<Integer> fiveAry; 
        fiveAry = new CSE12NaryTree<Integer>(5);
        CSE12NaryTree.Node root = fiveAry.new Node(0);
        CSE12NaryTree.Node child1 = fiveAry.new Node(1);
        CSE12NaryTree.Node child2 = fiveAry.new Node(2);
        CSE12NaryTree.Node child3 = fiveAry.new Node(3);
        CSE12NaryTree.Node child4 = fiveAry.new Node(4);
        CSE12NaryTree.Node child5 = fiveAry.new Node(5);
        ArrayList<CSE12NaryTree.Node> children = new ArrayList();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        children.add(child4);
        children.add(child5);
        root.children = children;
        fiveAry.root = root;
        assertFalse(fiveAry.contains(10));
    }

    /**
     * This test case tests the sortTree method with a fiveAry tree. This 
     * tests if a sorted arraylist containing the elements of the nodes is
     * returned when we call sortTree.
     */
    @Test
    public void testSortTree(){
        CSE12NaryTree<Integer> fiveAry; 
        fiveAry = new CSE12NaryTree<Integer>(5);
        CSE12NaryTree.Node root = fiveAry.new Node(0);
        CSE12NaryTree.Node child1 = fiveAry.new Node(1);
        CSE12NaryTree.Node child2 = fiveAry.new Node(5);
        CSE12NaryTree.Node child3 = fiveAry.new Node(3);
        CSE12NaryTree.Node child4 = fiveAry.new Node(2);
        CSE12NaryTree.Node child5 = fiveAry.new Node(4);
        ArrayList<CSE12NaryTree.Node> children = new ArrayList();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        children.add(child4);
        children.add(child5);
        root.children = children;
        fiveAry.root = root;
        ArrayList<Integer> check = new ArrayList();
        check.add(0);
        check.add(1);
        check.add(2);
        check.add(3);
        check.add(4);
        check.add(5);
        assertEquals(check, fiveAry.sortTree());
    }

    /**
     * This test checks for when we try adding null, for when we try seeing
     * if our tree contains null, for when we sort an empty tree, for when we
     * add to an empty tree, and for when we check if the tree contains an
     * element that does exit in the tree. This test also checks if the tree
     * works with a size other than five, unlike the previous test cases.
     */
    @Test
    public void testCustom(){
        // Setup
        CSE12NaryTree<Integer> sixAry; 
        sixAry = new CSE12NaryTree<Integer>(6);
        CSE12NaryTree.Node root = sixAry.new Node(0);
        CSE12NaryTree.Node child1 = sixAry.new Node(1);
        CSE12NaryTree.Node child2 = sixAry.new Node(5);
        CSE12NaryTree.Node child3 = sixAry.new Node(3);
        CSE12NaryTree.Node child4 = sixAry.new Node(2);
        CSE12NaryTree.Node child5 = sixAry.new Node(4);
        ArrayList<CSE12NaryTree.Node> children = new ArrayList();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        children.add(child4);
        children.add(child5);
        root.children = children;
        sixAry.root = root;
        // Testing when adding null
        try {
            sixAry.add(null);
            fail();
        } catch (NullPointerException e) {
            // Do nothing
        }
        // Testing when searching for null in the tree
        try {
            sixAry.contains(null);
            fail();
        } catch (NullPointerException e) {
            // Do nothing
        }
        CSE12NaryTree<Integer> empty;
        empty = new CSE12NaryTree<Integer>(1);
        // Testing when sorting an empty tree
        ArrayList<Integer> emptyArr = new ArrayList<>();
        assertEquals(emptyArr, empty.sortTree());
        // Testing when adding to an empty tree
        empty.add(0);
        assertEquals((Integer)0, empty.root.getData());
        // Testing when searching for an element that does exist in the tree
        assertTrue(sixAry.contains(4));
        // Testing with an oneAry tree
        CSE12NaryTree<Integer> oneAry; 
        oneAry = new CSE12NaryTree<Integer>(1);
        CSE12NaryTree.Node oneRoot = oneAry.new Node(1);
        CSE12NaryTree.Node oneChild1 = oneAry.new Node(0);
        ArrayList<CSE12NaryTree.Node> child = new ArrayList();
        child.add(oneChild1);
        oneRoot.children = child;
        oneAry.root = oneRoot;
        oneAry.size = 2;
        oneAry.add(5);
        // Testing add with an oneAry tree
        assertEquals((Integer)5, 
            oneAry.root.getChildren().get(0).getChildren().get(0).getData());
        assertEquals(3, oneAry.size);
        // Testing contains with an oneAry tree
        assertTrue(oneAry.contains(5));
        // Testing sortTree with an oneAry tree
        ArrayList<Integer> check = new ArrayList();
        check.add(0);
        check.add(1);
        check.add(5);
        assertEquals(check, oneAry.sortTree());
        // Testing with a twoAry tree
        CSE12NaryTree<Integer> twoAry; 
        twoAry = new CSE12NaryTree<Integer>(2);
        CSE12NaryTree.Node twoRoot = sixAry.new Node(0);
        CSE12NaryTree.Node twoChild1 = sixAry.new Node(1);
        CSE12NaryTree.Node twoChild2 = sixAry.new Node(5);
        CSE12NaryTree.Node twoChild3 = sixAry.new Node(3);
        CSE12NaryTree.Node twoChild4 = sixAry.new Node(2);
        CSE12NaryTree.Node twoChild5 = sixAry.new Node(4);
        ArrayList<CSE12NaryTree.Node> children1 = new ArrayList();
        children1.add(twoChild1);
        children1.add(twoChild2);
        ArrayList<CSE12NaryTree.Node> children2 = new ArrayList();
        children2.add(twoChild3);
        children2.add(twoChild4);
        ArrayList<CSE12NaryTree.Node> children3 = new ArrayList();
        children3.add(twoChild5);
        twoRoot.children = children1;
        twoChild1.children = children2;
        twoChild2.children = children3;
        twoAry.root = twoRoot;
        // Testing add when it is to the most right leaf node in a tree
        twoAry.add(8);
        assertEquals((Integer)8, 
            twoAry.root.getChildren().get(1).getChildren().get(1).getData());
    }
}
