/**
 * TODO: Add your file header
 * Name: Matthew Mizumoto
 * ID: A16907397
 * Email: mmizumoto@ucsd.edu
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * This file contains the min heap class. This class creates my version of the
 * min heap. This impletements all the methods in the MinHeapInterface and
 * also some helper methods.
 */

// Your import statements
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * This class is my version of a min heap. This class contains the methods
 * from the MinHeapInterface, and also many helper methods that helped to
 * create those methods.
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{
    public ArrayList<E> data;

    /**
     * This constructor constructs a min heap with no parameters.
     */
    public MyMinHeap() {
        data = new ArrayList<E>(0);
    }

    /**
     * This constructor constructs a min heap with a collection and also
     * sorts the elements in the collection.
     */
    public MyMinHeap(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        data = new ArrayList<>(collection);
        if (data.contains(null)) {
            throw new NullPointerException();
        }
        for (int i = data.size() - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    /**
     * This method inserts an element into the min heap and sorts it into
     * the right position.
     * @param element - the element being inserted.
     */
    public void insert(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        data.add(element);
        percolateUp(data.size() - 1);        
    }

    /**
     * This method gets the smallest element in the min heap.
     * @return - returns the smallest element in the min heap.
     */
    public E getMin() {
        if (data.size() == 0) {
            return null;
        }
        return data.get(0);
    }

    /**
     * This method removes the root of the min heap and returns that
     * element.
     * @return - returns the element that was removed.
     */
    public E remove() {
        if (data.size() == 0) {
            return null;
        }
        return deleteIndex(0);
    }

    /**
     * This method returns the size of the min heap.
     * @return - the size of the min heap.
     */
    public int size() {
        return data.size();
    }

    /**
     * This method clears all the values in min heap.
     */
    public void clear() {
        data.clear();
    }

    /**
     * This helper method swaps two values in the min heap.
     * @param from - The first element being swapped.
     * @param to - The other element that from is being swapped with.
     */
    protected void swap(int from, int to) {
        E holder = data.get(from);
        data.set(from, data.get(to));
        data.set(to, holder);
    }

    /**
     * This helper method gets the parent index of a given index.
     * @param index - The index of the element that the parent is being
     * searched for.
     * @return - The index of the parent.
     */
    protected int getParentIdx(int index) {
        return (index - 1) / 2;
    }

    /**
     * This helper method gets the left child of a given index.
     * @param index - The index of the element that the left child is being
     * searched for.
     * @return - The index of the left child.
     */
    protected int getLeftChildIdx(int index) {
        return (index + 1) * 2 - 1;
    }

    /**
     * This helper method gets the right child of a given index.
     * @param index - The index of the element that the right child is being
     * searched for.
     * @return - The index of the right child.
     */
    protected int getRightChildIdx(int index) {
        return (index + 1) * 2;
    }

    /**
     * This helper method gets the smallest child of a given index.
     * @param index - The index of the element that the smallest child is
     * being searched for.
     * @return - The index of the smallest child.
     */
    protected int getMinChildIdx(int index) {
        if (getLeftChildIdx(index) > data.size()) {
            return -1;
        }
        if (getLeftChildIdx(index) == data.size() - 1) {
            return getLeftChildIdx(index);
        }
        if (getRightChildIdx(index) < data.size()) {
            if (data.get(getLeftChildIdx(index)).compareTo(
                data.get(getRightChildIdx(index))) <= 0) {
                return getLeftChildIdx(index);
            }
        }
        return getRightChildIdx(index);
    }

    /**
     * This helper method sorts all the values above this element in the heap.
     * @param index - The index the swapping upwards from starts at.
     */
    protected void percolateUp(int index) {
        while (index > 0) {
            if (data.get(index).compareTo(data.get(getParentIdx(index)))>=0) {
                break;
            } else {
                swap(index, getParentIdx(index));
                index = getParentIdx(index);
            }
        }
    }

    /**
     * This helper method sorts all the values below this element in the heap.
     * @param index - The index the swapping downwards from starts at.
     */
    protected void percolateDown(int index) {
        if (getMinChildIdx(index) < 0) {
            return;
        }
        while (getMinChildIdx(index) < data.size() &&
         data.get(getMinChildIdx(index)).compareTo(data.get(index)) < 0) {
            int holderindex = getMinChildIdx(index);
            swap(index, getMinChildIdx(index));
            index = holderindex;
            if (getMinChildIdx(index) < 0) {
                return;
            }
        }
    }

    /**
     * This helper method deletes and returns the element at the index and
     * replaces it with the last element.
     * @param index - The index of the element being removed.
     * @return - The element that was removed
     */
    protected E deleteIndex(int index) {
        E toReturn = data.get(index);
        if (index == data.size() - 1) {
            data.remove(index);
        }
        else {
            data.set(index, data.get(data.size() - 1));
            data.remove(data.size() - 1);
        }
        for (int i = data.size() - 1; i >= 0; i--) {
            percolateDown(i);
        }
        return toReturn;
    }

}