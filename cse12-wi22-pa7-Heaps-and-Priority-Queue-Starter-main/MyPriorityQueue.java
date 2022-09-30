/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains the priority queue class. This class creates my version
 * of the priority queue. This priority queue uses a min heap as its base.
 */

import java.util.Collection;

/**
 * This class creates a priority queue using a heap as its base. The heap
 * being used is a generic heap that should helps all the methods in this
 * class to function.
 */
public class MyPriorityQueue<E extends Comparable<E>>
{

    //TODO: Add a public instance variable called "heap"
    //"heap" is of a generic MyMinHeap type
    public MyMinHeap<E> heap;
    
    /**
     * Constructor that creates an empty priority queue
     */
    public MyPriorityQueue(){
        heap = new MyMinHeap<>();
    }

    /**
     * Constructor that creates a priority queue from a collection
     * @param collection The collection used to intialize priority queue
     */
    public MyPriorityQueue(Collection<? extends E> collection){
        heap = new MyMinHeap<>(collection);
    }

    /**
     * Adds an element to the priority queue
     * @param element the element to be added
     */
    public void push(E element){
        heap.insert(element);
    }

    /**
     * Removes the element with the highest priority from the priority queue 
     * @return the element with the highest priority
     */
    public E pop(){
        return heap.remove();
    }

    /**
     * Sees the element with the highest priority from the priority queue
     * @return the element with the highest priority
     */
    public E peek(){
        return heap.getMin();
    }

    /**
     * Finds the number of elements in the priority queue
     * @return the number of elements in the priority queue
     */
    public int getLength(){
        return heap.size();
    }

    /**
     * Remove all the elements from the priority queue.
     */
    public void clear(){
        heap.clear();
    }
}