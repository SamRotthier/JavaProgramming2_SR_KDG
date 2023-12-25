package be.kdg.java2;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterFactory;
import be.kdg.java2.kollections.ArrayList;
import be.kdg.java2.kollections.Kollections;
import be.kdg.java2.kollections.LinkedList;
import be.kdg.java2.kollections.List;

import java.util.Random;

public class PerformanceTester {

    //TO DO: change this method for own use
    public static List<Monster> randomList(int n) {
        //List<Monster> myList = new ArrayList<>();
        List<Monster> myList = new LinkedList<>();
        new Random().ints(n).forEach(i -> myList.add(MonsterFactory.newRandomMonster()));
        return myList;
    }

    public static void compareArrayListAndLinkedList(int n) {
        List<Monster> arrayList = new ArrayList<>();
        List<Monster> linkedList = new LinkedList<>();
        //add at beginning
        //TO DO: use System.currentTimeMillis to compare performance of ArrayList en LinkedList
        long startArray = System.currentTimeMillis();
        new Random().ints(n).forEach(i -> arrayList.add(0,MonsterFactory.newRandomMonster()));
        long endArray = System.currentTimeMillis();
        long elapsedArray = endArray - startArray;
        System.out.printf("Adding %d to ArrayList: %d ms.%n",n,elapsedArray);
        long startLinked = System.currentTimeMillis();
        new Random().ints(n).forEach(i -> linkedList.add(0,MonsterFactory.newRandomMonster()));
        long endLinked = System.currentTimeMillis();
        long elapsedLinked = endLinked - startLinked;
        System.out.printf("Adding %d to LinkedList: %d ms.%n",n,elapsedLinked);

        //get at end
        //TO DO: use System.currentTimeMillis to compare performance of ArrayList en LinkedList
        startArray = System.currentTimeMillis();
        new Random().ints(n).forEach(i -> arrayList.get(arrayList.size()-1));
        endArray = System.currentTimeMillis();
        elapsedArray = endArray - startArray;
        System.out.printf("Getting %d to ArrayList: %d ms.%n",n,elapsedArray);
        startLinked = System.currentTimeMillis();
        new Random().ints(n).forEach(i -> linkedList.get(linkedList.size()-1));
        endLinked = System.currentTimeMillis();
        elapsedLinked = endLinked - startLinked;
        System.out.printf("Getting %d to LinkedList: %d ms.%n",n,elapsedLinked);

    }

    public static void testSelectionSort() {
        //TO DO: test selectionsort for (int n = 1000; n < 20000; n += 1000)
        Monster.compareCounter = 0;
        System.out.println("testSelectionSort");
        for (int n = 1000; n < 20000; n += 1000) {
            List<Monster> monsters = randomList(n);
            Kollections.selectionSort(monsters);
            System.out.println(n + ";" + Monster.compareCounter);
        }
    }

    public static void testMergeSort() {
        //TO DO: test mergesort for (int n = 1000; n < 200000; n += 1000)
        Monster.compareCounter = 0;
        System.out.println("testMergeSort");
        for (int n = 1000; n < 20000; n += 1000) {
            List<Monster> monsters = randomList(n);
            Kollections.mergeSort(monsters);
            System.out.println(n + ";" + Monster.compareCounter);
        }
    }
}
