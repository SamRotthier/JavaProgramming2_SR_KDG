package be.kdg.java2.generics;
import java.util.*;

public class PriorityQueue<T> implements FIFOQueue<T>{
    private TreeMap<Integer, LinkedList<T>> queue = new TreeMap<>(Comparator.reverseOrder());

    @Override
    public boolean enqueue(T element, int priority) {
        for (Map.Entry<Integer, LinkedList<T>> entry : queue.entrySet()){
            if (entry.getValue().contains(element)){
                return false;
            }
        }
        if (queue.containsKey(priority)){
            queue.get(priority).add(element);
        }
        else {
            queue.put(priority, new LinkedList<T>(List.of(element)));
        }
        return true;
    }

    @Override
    public T dequeue() {
        int highestPriority = 0;
        for( Map.Entry<Integer, LinkedList<T>> entry : queue.entrySet()) {
            if (entry.getKey() > highestPriority && entry.getValue().size() > 0) {
                highestPriority = entry.getKey();
            }
        }
        T element = queue.get(highestPriority).getFirst();
        queue.get(highestPriority).remove(element);
        return element;
    }

    @Override
    public int search(T element) {
        int positionInQueue = 0;
        for( Map.Entry<Integer, LinkedList<T>> entry : queue.entrySet()) {
            if (entry.getValue().contains(element)){
                return positionInQueue + entry.getValue().indexOf(element) +1;
            }
            else {
                positionInQueue += entry.getValue().size();
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        int size = 0;
        for( Map.Entry<Integer, LinkedList<T>> entry : queue.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for( Map.Entry<Integer, LinkedList<T>> entry : queue.entrySet()) {
            for (T object : entry.getValue())
                stringBuilder.append(String.format("%d: %s\n", entry.getKey(),object));
        }
        return stringBuilder.toString();
    }

}
