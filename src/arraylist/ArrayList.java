/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Enubs
 * @param <E>
 */
public class ArrayList<E> implements List<E> {

    private static final int CAPACITY = 3;//default capacity of array
    private E[] data;
    private int size;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E element) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = element;
        return temp;
    }

    @Override
    public void add(int i, E element) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length) {
            throw new IllegalStateException("Array is full.");
        }

        for (int k = size - 1; k >= i; k--) {
            data[k + 1] = data[k];
        }

        data[i] = element;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) {
            data[k] = data[k + 1];
        }

        data[size - 1] = null;
        size--;
        return temp;
    }

    public class ArrayIterator implements Iterator<E> {

        private int j = 0; //index of the next element to report
        private boolean removable = false; //can remove be called at this time?

        @Override
        public boolean hasNext() {
            return j < size;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (j == size) {
                throw new NoSuchElementException("No next element");
            }

            removable = true;
            return data[j++];
        }

        @Override
        public void remove() throws IllegalStateException {
            if (!removable) {
                throw new IllegalStateException("Nothing to remove");
            }

            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }

        public Iterator<E> iterator() {
            return new ArrayIterator();
        }
    }
}
