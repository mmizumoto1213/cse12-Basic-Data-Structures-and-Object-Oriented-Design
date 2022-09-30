/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * Email: mmizumoto@ucsd.edu
 * Sources used:Lecture Videos
 * Description: This file contains the class MyLinkedList. This class
 * contains the methods to make MyLinkedList function properly. It
 * also now contains an iterator class that moves along a the
 * linkedlist.
 */

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** 
 * TODO: This class constructs my version of a LinkedList and extends
 * AbstractList from java. This class overrides many of the AbsractList's
 * methods to function properly in MyLinkedList.
 */

public class MyLinkedList<E> extends AbstractList<E> {

	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class Node {
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element) {
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev) {
			this.prev = prev;		
		}

		/** 
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next) {
			this.next = next;
		}

		/** 
		 * Set the parameter element as the node's data
		 * @param element - new element 
		 */
		public void setElement(E element) {
			this.data = element;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext() {
			return this.next;
		}

		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev() {
			return this.prev;
		}

		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement() {
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** Only 0-argument constructor is defined */
	public MyLinkedList() {
		size = 0;
		head = new Node(null);
		tail = new Node(null);
		head.setNext(tail);
		head.setPrev(null);
		tail.setNext(null);
		tail.setPrev(head); 
	}

	/** 
	 * Accessor to get the size of the LinkedList
	 * @return the size of the LinkedList
	 */
	@Override
	public int size() {
		return size;
	}

	/** 
	 * Gets the data in a node at a certain index
	 * @param index - index of the node
	 * @return the data in the node at the index  
	 */
	@Override
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node curr = getNth(index);
		return curr.getElement();
	}

	/** 
	 * Adds a Node with the given data at the given index
	 * @param index - index of the node
	 * @param data - the data being stored in the Node
	 */
	@Override
	public void add(int index, E data) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (data == null) {
			throw new NullPointerException();
		}
		// Setting up the next and prev pointers for the new Node.
		Node add = new Node(data);
		Node curr = getNth(index);
		add.setNext(curr.getNext());
		add.setPrev(curr);
		curr.setNext(add);
		add.getNext().setPrev(add);
		size++;
	}

	/** 
	 * Adds a Node with the given data at the end of the LinkedList
	 * @param data - the data being stored in the Node
	 * @return returns true but is needed due to method definition
	 */
	public boolean add(E data) {
		if (data == null) {
			throw new NullPointerException();
		}
		// Setting up the next and prev pointers for the new Node.
		Node add = new Node(data);
		add.setNext(tail);
		add.setPrev(tail.getPrev());
		tail.getPrev().setNext(add);
		tail.setPrev(add);
		size++;
		return true;
	}

	/** 
	 * Sets the data of a Node at a given index to data
	 * @param index - index of the node
	 * @param data - the data being stored in the Node
	 * @return returns the data that was previously stored in the Node
	 */
	public E set(int index, E data) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (data == null) {
			throw new NullPointerException();
		}
		// Using getNth to find the Node then update its value.
		Node curr = getNth(index);
		E stored = curr.getElement();
		curr.setElement(data);
		return stored;
	}

	/** 
	 * Removes the Node at the given index
	 * @param index - index of the node
	 * @return returns the data that was stored in the removed Node
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Using getNth to find the Node then remove it.
		Node curr = getNth(index);
		E stored = curr.getElement();
		curr.getPrev().setNext(curr.getNext());
		curr.getNext().setPrev(curr.getPrev());
		size--;
		return stored;
	}

	/** 
	 * Removes all the Nodes from the LinkedList
	 */
	public void clear() {
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;
	}

	/** 
	 * Removes all the Nodes from the LinkedList
	 * @return returns a boolean depending on if the LinkedList is empty
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	/** 
	 * Gets node at a certain index
	 * @param index - index of the node
	 * @return the node at the index  
	 */
	protected Node getNth(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		// Loops through the list until it gets to the searched index.
		Node curr = head;
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
		}
		return curr;
	}

	/** 
	 * Creates a new MyListIterator and returns it
	 * @return a new MyListIterator
	 */
	@Override
	public ListIterator<E> listIterator() {
		MyListIterator toReturn = new MyListIterator();
		return toReturn;
	}

	/** 
	 * Creates a new MyListIterator and returns it
	 * @return a new MyListIterator
	 */
	@Override
	public Iterator<E> iterator() {
		MyListIterator toReturn = new MyListIterator();
		return toReturn;
	}

	/**
	 * An interator class that moves throughout the LinkedList.
	 */
	protected class MyListIterator implements ListIterator<E> {
		Node left;
		Node right;
		int idx;
		boolean forward;
		boolean canRemoveOrSet;
		
		/** 
		 * Constructor to create an Interator 	
		 */
		public MyListIterator() {
			left = head;
			right = head.getNext();
			idx = 0;
			forward = true;
			canRemoveOrSet = false;
		}

		/**
		 * Checks if there is a next value from the current position
		 * @return true or false if there is a next position
		 */
		public boolean hasNext() {
			if (right == tail) {
				return false;
			}
			return true;
		}

		/**
		 * Moves the iterator to the next position
		 * @return the value of the next Node
		 */
		public E next() {
			if (hasNext() == false) {
				throw new NoSuchElementException();
			}
			// Updating position of iterator.
			Node toReturn = right;
			right = right.getNext();
			left = left.getNext();
			forward = true;
			canRemoveOrSet = true;
			idx++;
			return toReturn.getElement();
		}

		/**
		 * Checks if there is a previous value from the current position
		 * @return true or false if there is a previous position
		 */
		public boolean hasPrevious() {
			if (left == head) {
				return false;
			}
			return true;
		}

		/**
		 * Moves the iterator to the previous position
		 * @return the value of the previous Node
		 */
		public E previous() {
			if (hasPrevious() == false) {
				throw new NoSuchElementException();
			}
			// Updating position of iterator.
			Node toReturn = left;
			right = right.getPrev();
			left = left.getPrev();
			forward = false;
			canRemoveOrSet = true;
			idx--;
			return toReturn.getElement();
		}

		/**
		 * Accessor to get the next Index
		 * @return the value of the next Index
		 */
		public int nextIndex() {
			return idx;
		}

		/**
		 * Accessor to get the previous Index
		 * @return the value of the previous Index
		 */
		public int previousIndex() {
			return idx - 1;
		}

		/**
		 * Adds an element in between the interator
		 * @param element - the data being stored in the Node
		 */
		public void add(E element) {
			if (element == null) {
				throw new NullPointerException();
			}
			// Setting up the pointers for the new Node.
			Node add = new Node(element);
			add.setNext(right);
			add.setPrev(left);
			right.setPrev(add);
			left.setNext(add);
			// Updating instance variables.
			left = add;
			idx++;
			canRemoveOrSet = false;
			size++;
		}

		/**
		 * Replaces the data stored in the Node
		 * @param element - the data being stored in the Node
		 */
		public void set(E element) {
			if (element == null) {
				throw new NullPointerException();
			}
			if (canRemoveOrSet == false) {
				throw new IllegalStateException();
			}
			// Creating two cases for if next or previous was most recently called.
			if (forward == true) {
				left.setElement(element);
			}
			if (forward == false) {
				right.setElement(element);
			}
			canRemoveOrSet = false;
		}

		/**
		 * Removes a Node based on the iterator position and direction
		 */
		public void remove() {
			if (canRemoveOrSet == false) {
				throw new IllegalStateException();
			}
			// Creating two cases for if next or previous was most recently called.
			if (forward == true) {
				left = left.getPrev();
				right.setPrev(left);
				left.setNext(right);
				idx--;
			}
			if (forward == false) {
				right = right.getNext();
				left.setNext(right);
				right.setNext(left);
			}
			canRemoveOrSet = false;
			size--;
		}
	}
}