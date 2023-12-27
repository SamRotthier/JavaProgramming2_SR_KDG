import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterFactory;
import be.kdg.java2.Model.MonsterType;
import be.kdg.java2.kollections.lists.ArrayList;
import be.kdg.java2.kollections.Kollections;
import be.kdg.java2.kollections.lists.LinkedList;
import be.kdg.java2.kollections.lists.List;
import be.kdg.java2.kollections.maps.HashMap;
import be.kdg.java2.kollections.maps.ListMap;
import be.kdg.java2.kollections.maps.Map;
import be.kdg.java2.kollections.sets.ArraySet;
import be.kdg.java2.kollections.sets.Set;
import be.kdg.java2.kollections.sets.TreeSet;
import be.kdg.java2.kollections.trees.Tree;

import java.time.LocalDate;
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

    public static void compareListMapToHashMap(int n) {

        ListMap<Monster, String> listMap = new ListMap<>();
        HashMap<Monster, String> hashMap= new HashMap<>(n);
        fillMap(listMap, n);
        fillMap(hashMap, n);

        Monster.equalsCounter = 0;
        Monster.compareCounter = 0;
        long startTime = System.nanoTime();
        getMap(listMap,n);
        long endTime = System.nanoTime();
        System.out.printf("Listmap: n = %5d, equalscount = %7d, nanosec = %15d\n",n,Monster.equalsCounter,endTime-startTime);

        Monster.equalsCounter = 0;
        Monster.compareCounter = 0;
        startTime = System.nanoTime();
        getMap(hashMap, n);
        endTime = System.nanoTime();
        System.out.printf("Hashmap: n = %5d, equalscount = %7d, nanosec = %15d\n",n,Monster.equalsCounter,endTime-startTime);
    }

    private static void fillMap(Map<Monster, String> map, int n) {
        for (int i = 0; i < n; i++) {

            map.put(MonsterFactory.newFilledMonster("Monster"+i, 99.9, 99, MonsterType.neutral, LocalDate.of(2023, 12, 26), 99),
                    "Ik ben de waarde Monster"+i);
        }
    }

    private static void getMap(Map<Monster, String> map, int n) {
        for (int i = 0; i< n; i++) {
            map.get(MonsterFactory.newFilledMonster("Monster"+i, 99.9, 99, MonsterType.neutral, LocalDate.of(2023, 12, 26), 99));
        }
    }

    public static void compareArraySetToTreeSet(int n) {
        Set<Monster> arraySet = new ArraySet<>();
        Set<Monster> treeSet= new TreeSet<>();

        Monster.equalsCounter = 0;
        Monster.compareCounter = 0;
        long startTime = System.nanoTime();
        fillSet(arraySet,n);
        long endTime = System.nanoTime();
        System.out.printf("ArraySet, n = %5d: equalscount : %-7d\n",n, Monster.equalsCounter);
        System.out.printf("ArraySet, n = %5d: comparecount: %-7d\n",n, Monster.compareCounter);
        System.out.printf("ArraySet, n = %5d: nanosec     : %-7d\n",n, endTime-startTime);

        Monster.equalsCounter = 0;
        Monster.compareCounter = 0;
        startTime = System.nanoTime();
        fillSet(treeSet,n);
        endTime = System.nanoTime();
        System.out.printf("TreeSet,  n = %5d: equalscount : %-7d\n",n, Monster.equalsCounter);
        System.out.printf("TreeSet,  n = %5d: comparecount: %-7d\n",n, Monster.compareCounter);
        System.out.printf("TreeSet,  n = %5d: nanosec     : %-7d\n",n, endTime-startTime);
    }

    private static void fillSet(Set<Monster> set, int n) {
        for (int i = 0; i < n; i++) {
            set.add(MonsterFactory.newRandomMonster());
        }
    }
}
