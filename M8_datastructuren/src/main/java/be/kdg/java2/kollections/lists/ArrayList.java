package be.kdg.java2.kollections.lists;

import be.kdg.java2.kollections.Kollections;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public ArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    //This is for the hashmap values method, otherwise there is an error.
    public ArrayList(int givenSize) {
        elements = new Object[givenSize];
        size = 0;
    }

    private void expand() {
        //TO DO: implement this method
        Object[] doubleElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, doubleElements, 0, elements.length);
        elements = doubleElements;
        /*
        Object[] doubleElements = new Object[elements.length*2];
        for (int i = 0; i < elements.length; i++) {
            doubleElements[i] = elements[i];
        }
        elements = doubleElements;
        */
    }

    @Override
    public void add(int index, E element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (size == elements.length)
            expand();
        if (index == size)
            elements[index] = element;
        else {
            Object[] tempArr = new Object[size - index];
            System.arraycopy(elements, index, tempArr, 0, size - index);
            elements[index] = element;
            System.arraycopy(tempArr, 0, elements, 1 + index, tempArr.length);
        }
        size++;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public boolean remove(E element) {
        return remove(indexOf(element)) != null;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public void set(int index, E element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        elements[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        E oldValue = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return oldValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        //TO DO: implement this method!
        return (E) elements[index];
        //return null;
    }

    @Override
    public int indexOf(E element) {
        return Kollections.lineairSearch(this,element);
    }


}
