/**
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: None
 * 
 * This file contains the class MyDeque which implements the given
 * deque interface. It contains the constructor along with some
 * methods.
 */

/**
 * This class contains contents of MyDeque. This includes the constructor
 * and the methods that are in the DequeInterface.
 */
public class MyDeque<E> implements DequeInterface<E> {
    Object[] data;
    int size;
    int rear;
    int front;
    private static final int DEFAULT_CAPCITY = 10;
    private static final int CAPCITY_MULTIPLIER = 2;

    /**
     * Constructor to create new MyDeque. This constructor sets all the 
     * instance variables.
     * 
     * @param initialCapacity The max amount of elements this data 
     * structure can hold.
     */
    public MyDeque(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
        size = 0;
        rear = 0;
        front = 0;
    }

    /**
     * This method returns the size of MyDeque.
     *
     * @return - the size of MyDeque.
     */
    public int size() {
        return size;
    }

    /**
     * This method expands the capacity of MyDeque.
     */
    public void expandCapacity() {
        // When data's capacity is 0 it defaults to setting capacity to 10
        if (data.length == 0) {
            data = new Object[DEFAULT_CAPCITY];
        } else {
            Object[] holder = data;
            data = new Object[data.length * CAPCITY_MULTIPLIER];
            // These for loops ensure that the elements in the deque are
            // contiguous
            for (int i = front; i < holder.length; i++) {
                data[i - front] = holder[i];
            }
            for (int i = 0; i < front; i++) {
                data[i + (holder.length - front)] = holder[i];
            }
            front = 0;
            rear = size - 1;
        }
    }

    /**
     * This method adds an element to the front of the deque.
     *
     * @param element - the element that is trying to be added.
     */
    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (size == data.length) {
            expandCapacity();
        }
        // Two cases for when front = 0 and when front is not
        if (front == 0 && size != 0) {
            front = data.length - 1;
        } else if (front != 0 && size != 0) {
            front = front - 1;
        }
        data[front] = element;
        size++;
    }

    /**
     * This method adds an element to the rear of the deque.
     *
     * @param element - the element that is trying to be added.
     */
    public void addLast(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (size == data.length) {
            expandCapacity();
        }
        // Two cases for when rear = back of the array and when rear is not
        if (rear == data.length - 1 && size != 0) {
            rear = 0;
        } else if (rear != data.length - 1 && size != 0) {
            rear = rear + 1;
        }
        data[rear] = element;
        size++;
    }

    /**
     * This method removes an element from the front of the deque.
     *
     * @return - the element that is being removed or null if size is 0.
     */
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        Object holder = data[front];
        data[front] = null;
        size--;
        front = front + 1;
        return (E)holder;
    }

    /**
     * This method removes an element from the rear of the deque.
     *
     * @return - the element that is being removed or null if size is 0.
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        Object holder = data[rear];
        data[rear] = null;
        size--;
        rear = rear - 1;
        return (E)holder;
    }

    /**
     * This method looks at the element at the front of the deque.
     *
     * @return - the element that is at the front or null if size is 0.
     */
    public E peekFirst() {
        if (size == 0) {
            return null;
        }
        return (E)data[front];
    }

    /**
     * This method looks at the element at the rear of the deque.
     *
     * @return - the element that is at the rear or null if size is 0.
     */
    public E peekLast() {
        if (size == 0) {
            return null;
        }
        return (E)data[rear];
    }
}