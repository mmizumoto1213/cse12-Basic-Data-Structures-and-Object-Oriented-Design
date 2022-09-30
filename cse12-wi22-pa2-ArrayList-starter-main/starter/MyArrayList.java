/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: Wk2ArrayListWorksheet from lecture
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file creates a simplified version of ArrayList that can be used.
 * This ArrayList implements the interface MyList.
 */ 

 /**
 * This class creates an ArrayList and contains all the methods that can be used.
 * There are the instance variable data contains the ArrayList and manages its capacity,
 * size measures how many elements are actually in the ArrayList, and DEFAULT_CAPACITY is
 * just a constant for the default capacity that is used when a capacity is not initialized.
 */

 public class MyArrayList<E> implements MyList<E> {
    Object data[];
    private static final int DEFAULT_CAPACITY = 5;
    int size;

    /*
    * These 3 constructors creates an arraylist of default capacity when no argument,
    * creates an arralist of input capacity when integer argument, 
    * creates an arraylist that contains the array when the input is an array.
    * Some exceptions are when a negative integer is given an exception is thrown and
    * When null is given as argument the default capacity arraylist is created
    */
    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        data = new Object[initialCapacity];
        size = 0;
    }

    public MyArrayList(E[] arr) {
        if (arr == null) {
            data = new Object[DEFAULT_CAPACITY];
        size = 0;
        } else {
            data = arr;
            size = arr.length;
        }
    }

    /*
    * Increase the capacity of the underlying array
    */
    public void expandCapacity(int requiredCapacity) {
        if (requiredCapacity < data.length) {
            throw new IllegalArgumentException();
        }
        Object temp[];
        if (data.length == 0) {
            temp = new Object[DEFAULT_CAPACITY];
            data = temp;
        } else if (data.length * 2 >= requiredCapacity) {
            temp = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        } 
        if (data.length < requiredCapacity) {
            temp = new Object[requiredCapacity];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
    }

    /*
    * Get the amount of elements arraylist can hold 
    * @return Number of elements an arraylist can hold - length of the array
    */
    public int getCapacity() {
        return data.length;
    }

    /*
    * Add an element at the specified index
    * @param index - position in the array to insert the element
    * @param element - the element to be inserted 
    */
    public void insert(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            expandCapacity(size + 1);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    /*
    * Add an element to the end of the list 
    * @param element - the element to be added 
    */
    public void append(E element) {
        if (size == data.length) {
            expandCapacity(size + 1);
        }
        data[size] = element;
        size++;
    }

    /*
    * Add an element to the beginning of the list
    * @param element - the element to be added
    */
    public void prepend(E element) {
        if (size == data.length) {
            expandCapacity(size + 1);
        }
        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = element;
        size++;
    }

    /*
    * Get the element at the given index 
    * @param index - position in the arraylist
    * @return element present in the given index
    */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        E toReturn = (E)data[index];
        return toReturn;
    }

    /*
    * Replaces an element at the specified index with a new element and return the original elements
    * @param index - position of the element to be replaced
    * @param element - new element replacing the old element
    * @return original element present in the index before replacement
    */
    public E set(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        E toReturn = (E)data[index];
        data[index] = element;
        return toReturn;
    }

    /*
    * Remove the element at the specified index and return the removed element
    * @param index - position of the element to be removed
    * @return element in that index
    */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        E toReturn = (E)data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return toReturn;
    }

    /*
    * Get the number of elements in the list
    * @return number of elements present in the list
    */
    public int size() {
        return size;
    }

 }
