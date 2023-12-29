package be.kdg.java2.kollections.lists;

import be.kdg.java2.kollections.Collection;

public interface List<E> extends Collection<E> {
    void add(int index, E element);
    void add(E element);
    void set(int index, E element);
    int size();
    E remove(int index);
    E get(int index);
    int indexOf(E element);
}

//in deel 1
/*
public interface List<T> {
    void add(int index, T element);
    void add(T element);
    void set(int index, T element);
    int size();
    T remove(int index);
    T get(int index);
}
 */
