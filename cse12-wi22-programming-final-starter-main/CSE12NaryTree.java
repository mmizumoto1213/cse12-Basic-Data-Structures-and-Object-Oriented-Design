/**
 * TODO: Add file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * File description: This file contains the class CSE12NaryTree with the
 * methods add, contains, and sortTree. All of this together creates a
 * NaryTree.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This class contains the methods for CSE12NaryTree. These methods are add,
 * contains, and sortTree. These methods all help the tree function.
 */
public class CSE12NaryTree<E extends Comparable<E>> {
    
    /**
     * This inner class encapsulates the data and children for a Node.
     * Do NOT edit this inner class.
     */
    protected class Node{
        E data;
        List<Node> children;
    
        /**
         * Initializes the node with the data passed in
         * 
         * @param data The data to initialize the node with
         */
        public Node(E data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    
        /**
         * Getter for data
         * 
         * @return Return a reference to data
         */
        public E getData() {
            return data;
        }

        /**
         * Setter for the data
         * 
         * @param data Data that this node is set to
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Getter for children
         * 
         * @return reference to the list of children
         */
        public List<Node> getChildren() {
            return children;
        }

        /**
         * Returns the number of children
         * 
         * @return number of children
         */
        public int getNumChildren() {
            // assume there are no nulls in list
            return children.size();
        }

        /**
         * Add the given node to this node's list of children
         * 
         * @param node The node to add
         */
        public void addChild(Node node) {
            children.add(node);
        }
    
    }
    
    Node root;
    int size;
    int N;

    /**
     * Constructor that initializes an empty N-ary tree, with the given N
     * 
     * @param N The N the N-tree should be initialized with
     */
    public CSE12NaryTree(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.root = null;
        this.size = 0;
        this.N = N;
    }

    /**
     * This method adds an element to the correct node in the NaryTree
     *
     * @param element - The element the node being added will hold
     */
    public void add(E element) {
        // Throws exception when element is null
        if (element == null) {
            throw new NullPointerException();
        // When the tree is empty it sets the root the the element being added
        } else if (root == null) {
            this.root = new Node(element);
            size++;
        } else {
            Queue<Node> queue = new LinkedList<>();
            Node start = this.root;
            queue.add(start);
            boolean SpaceNotFound = true;
            // Loops until a node with space for children is found
            while (SpaceNotFound) {
                if (queue.peek().getChildren().size() == this.N) {
                    Node withChildren = queue.poll();
                    queue.addAll(withChildren.getChildren());             
                }
                // When a node with space for children is found a new node is
                // added to it containing element
                if (queue.peek().getChildren().size() != this.N) {
                    Node addChild = queue.poll();
                    addChild.addChild(new Node(element));
                    size++;
                    SpaceNotFound = false;
                }
            }
        }
    }

    /**
     * This method will check if a node with the value of element exists 
     * inside the tree
     *
     * @param element - The value being searched for in the tree
     *
     * @return - A boolean based on if the element was in the tree
     */
    public boolean contains(E element) {
        // Throws exception when element is null
        if (element == null) {
            throw new NullPointerException();
        // Checks the root if it is equal to element
        } else if (root.getData() == element) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        Node start = this.root;
        queue.add(start);
        // Loops until the queue is empty
        while (queue.size() > 0) {
            // Adds all the children of an node to the queue if it has
            // children and checks if any of them are equal to element
            Node n = queue.poll();
            queue.addAll(n.getChildren());
            if (n.getData().equals(element)) {
                return true;
            } 
        }
        return false;
    }

    /**
     * This method creates and returns an array with all the values in the
     * tree in ascending order
     *
     * @return - An arraylist containing the values of the nodes in teh tree
     */
    public ArrayList<E> sortTree(){
        ArrayList<E> toReturn = new ArrayList<>();
        Queue<Node> toGet = new LinkedList<>();
        PriorityQueue<E> toSort = new PriorityQueue<>();
        if (this.root != null) {
            toGet.add(this.root);
        }
        boolean hasChildren = true;
        // This loops until every element in the tree has gone through the
        // queue
        while (toGet.size() > 0) {
            Node curr = toGet.poll();
            toSort.add(curr.getData());
            if (curr.getChildren().size() > 0) {
                toGet.addAll(curr.getChildren());
            }
        }
        // Puts all the elements in sorted priority queue into an arraylist
        while (toSort.size() > 0) {
            toReturn.add(toSort.poll());
        }
        return toReturn;
    }
}
