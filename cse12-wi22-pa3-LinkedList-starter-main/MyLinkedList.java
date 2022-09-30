/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * Email: mmizumoto@ucsd.edu
 * Sources used: None
 * Description: This file contains the class MyLinkedList. This class
 * contains the methods to make MyLinkedList function properly.
 */

import java.util.AbstractList;

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
		Node curr = head;
		for (int i = 0; i <= index; i++) {
			curr = curr.next;
		}
		return curr;
	}
}