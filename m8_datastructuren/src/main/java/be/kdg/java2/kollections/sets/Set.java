package be.kdg.java2.kollections.sets;

import be.kdg.java2.kollections.Collection;
import be.kdg.java2.kollections.lists.List;

public interface Set<E> extends Collection<E> {
    List<E> toList();
}
