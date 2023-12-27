package be.kdg.java2.kollections.lists;

import be.kdg.java2.kollections.Kollections;

public class LinkedList<E> implements List<E> {
    static class Node<V> {
        V value;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    private Node<E> root;
    private int size;

    public LinkedList() {
    }

    @Override
    public void add(int index, E element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        //TO DO: implement this method
        Node<E> nodeAdd = new Node<>(element);
        Node<E> node = root;
        if(index == 0){
            root = nodeAdd;
            root.next = node;
        } else {
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }
            Node<E> temp = node.next;
            node.next = nodeAdd;
            nodeAdd.next = temp;
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
        Node<E> node = root;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.value = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (index == 0) {
            E oldElement = root.value;
            root = root.next;
            size--;
            return oldElement;
        } else {
            Node<E> beforeNode = root;
            for (int i = 1; i < index; i++) {
                beforeNode = beforeNode.next;
            }
            E oldElement = beforeNode.next.value;
            beforeNode.next = beforeNode.next.next;
            size--;
            return oldElement;
        }
    }

    @Override
    public E get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        //TO DO: implement this method!
        //return null;
        Node<E> node = root;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public int indexOf(E element) {
        return Kollections.lineairSearch(this, element);
    }
}
