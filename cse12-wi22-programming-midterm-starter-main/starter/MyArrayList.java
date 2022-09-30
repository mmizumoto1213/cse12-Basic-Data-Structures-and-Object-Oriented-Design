/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * File description: 
 * This file contains the MyArrayList class with the method reverseRegion.
 * This method reverses all the elements in the arraylist from the fromIndex
 * to the toIndex.
 */

/**
 * TODO: Add class header
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
     * A method that reverses the elements within the arraylist from the
     * fromIndex until the toIndex.
     * @param fromIndex - the index where we start from
     * @param toIndex - the index where we end at
     */
    public void reverseRegion(int fromIndex, int toIndex){
        //Checking parameters to see if index is out of bounds
        if (fromIndex > size() || fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (toIndex > size() || toIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        // Loops from fromIndex until half way through toIndex
        // This swaps the first and last values of the elements within
        // fromIndex and toIndex
        Object holder;
        for (int i = fromIndex; 
                i < (((toIndex - fromIndex) + 1) / 2) + fromIndex; i++) {
            holder = get(i);
            data[i] = data[toIndex - (i - fromIndex)];
            data[toIndex - (i - fromIndex)] = holder;
        }
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
