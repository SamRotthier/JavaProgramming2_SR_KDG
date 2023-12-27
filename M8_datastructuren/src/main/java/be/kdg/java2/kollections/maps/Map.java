package be.kdg.java2.kollections.maps;

import be.kdg.java2.kollections.Collection;
import be.kdg.java2.kollections.sets.Set;

public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    Collection<V> values();
    Set<K> keySet();
    int size();
}
