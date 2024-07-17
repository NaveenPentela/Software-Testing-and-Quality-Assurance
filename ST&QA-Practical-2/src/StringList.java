/**
 * Class that simulates a list for storing Strings.
 *
 * @version 1.0
 */
public final class StringList {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * The amount to grow this {@code StringList} when {@code grow()} is called.
     */
    private static final int GROW = 5;

    /**
     * The size of the {@code StringList} (the number of elements it contains).
     */
    private int size = 0;

    /**
     * The array buffer into which the elements of the {@code StringList} are stored.
     */
    private String[] elementData;

    /**
     * Default constructor that initializes the list with a default capacity.
     */
    public StringList() {
        elementData = new String[DEFAULT_CAPACITY];
    }

    /**
     * Constructor that initializes the list with a specified capacity.
     *
     * @param initialCapacity the initial capacity of the list.
     */
    public StringList(final int initialCapacity) {
        elementData = new String[initialCapacity];
    }

    /**
     * Increases the capacity of the list by a constant amount.
     */
    private void grow() {
        String[] newElementData = new String[elementData.length + GROW];
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
    }

    /**
     * Appends the specified element to the end of the list.
     *
     * @param element the element to be added.
     * @return {@code true} if the element is added successfully.
     */
    public boolean add(final String element) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = element;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in the list.
     *
     * @param index the index at which the element is to be inserted.
     * @param element the element to be inserted.
     */
    public void add(final int index, final String element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (size == elementData.length) {
            grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * Returns the element at the specified position in the list.
     *
     * @param index the index of the element to be returned.
     * @return the element at the specified position in the list.
     */
    public String get(final int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        return elementData[index];
    }

    /**
     * Replaces the element at the specified position in the list with the specified element.
     *
     * @param index the index of the element to be replaced.
     * @param element the element to be stored at the specified position.
     * @return the element previously at the specified position.
     */
    public String set(final int index, final String element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        String oldElement = elementData[index];
        elementData[index] = element;
        return oldElement;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param element the element whose presence in the list is to be tested.
     * @return {@code true} if the list contains the specified element, {@code false} otherwise.
     */
    public boolean contains(final String element) {
        return indexOf(element) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     *  or -1 if the list does not contain the element.
     *
     * @param element the element to search for.
     * @return the index of the first occurrence of the specified element in the list,
     * or -1 if the list does not contain the element.
     */
    public int indexOf(final String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in the list.
     *
     * @param index the index of the element to be removed.
     * @return the element that was removed from the list.
     */
    public String remove(final int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index");
        }
        String removedElement = elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null; // Clear to let GC do its work
        return removedElement;
    }

    /**
     * Removes the first occurrence of the specified element from the list, if it is present.
     *
     * @param element the element to be removed.
     * @return {@code true} if the list contained the specified element, {@code false} otherwise.
     */
    public boolean remove(final String element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Returns {@code true} if the list contains no elements.
     *
     * @return {@code true} if the list contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the index of the last occurrence of the
     * specified element in the list, or -1 if the list does not contain the element.
     *
     * @param element the element to search for.
     * @return the index of the last occurrence of the specified
     * element in the list, or -1 if the list does not contain the element.
     */
    public int lastIndexOf(final String element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param fromIndex low endpoint (inclusive) of the subList.
     * @param toIndex high endpoint (exclusive) of the subList.
     * @return a view of the specified range within this list.
     */
    public StringList subList(final int fromIndex, final int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("Indices out of order");
        }
        if (fromIndex < 0 || toIndex > size) {
            throw new IllegalArgumentException("Invalid index");
        }
        StringList subList = new StringList(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(elementData[i]);
        }
        return subList;
    }

    /**
     * Removes from this list all the elements whose index is
     * between fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param fromIndex low endpoint (inclusive) of the range.
     * @param toIndex high endpoint (exclusive) of the range.
     */
    public void removeRange(final int fromIndex, final int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("Indices out of order");
        }
        if (fromIndex < 0 || toIndex > size) {
            throw new IllegalArgumentException("Invalid index");
        }
        int numMoved = size - toIndex;
        System.arraycopy(elementData, toIndex, elementData, fromIndex, numMoved);
        for (int i = size - (toIndex - fromIndex); i < size; i++) {
            elementData[i] = null;
        }
        size -= (toIndex - fromIndex);
    }

    /**
     * Compares the specified StringList with this list for equality.
     *
     * @param sl the StringList to be compared for equality with this list.
     * @return {@code true} if the specified StringList is equal to this list.
     */
    public boolean equals(final StringList sl) {
        if (this.size != sl.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.elementData[i].equals(sl.elementData[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns an array containing all the
     * elements in this list in proper sequence (from first to last element).
     *
     * @return an array containing all the elements in this list in proper sequence.
     */
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(elementData, 0, array, 0, size);
        return array;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "List is empty: []";
        }
        StringBuilder sb = new StringBuilder("Printing List: [");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elementData[i]).append(", ");
        }
        sb.append(elementData[size - 1]).append("]");
        return sb.toString();
    }
}
