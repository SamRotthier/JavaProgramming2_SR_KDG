import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterFactory;
import be.kdg.java2.Model.MonsterType;
import be.kdg.java2.PerformanceTester;
import be.kdg.java2.kollections.Kollections;
import be.kdg.java2.kollections.List;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo_8 {
    public static void main (String[] args) {
        //Test new empty monster from factory
        System.out.println("Empty Monster test:\n" + MonsterFactory.newEmptyMonster());

        //Test new filled in monster from factory
        System.out.println("Filled Monster test:\n" + MonsterFactory.newFilledMonster("Test", 12.3, 3, MonsterType.neutral, LocalDate.of(2023, 11, 11), 500));

        //Test new random monsters, 30 of them
        System.out.println("30 random monsters sorted by name test:");
        Stream.generate(MonsterFactory::newRandomMonster).limit(30).sorted(Comparator.comparing(Monster::getName)).forEach(System.out::println);

        // Preformance tester 30 random monsters in a list
        System.out.println("Preformance tester 30 random monsters in a list:");
        List<Monster> monsterList = PerformanceTester.randomList(30);
        for (int i = 0; i < monsterList.size(); i++) {
            System.out.printf("%2d) %s%n", i + 1, monsterList.get(i));
        }

        //Testing the compare between array list and linked list
        System.out.println("Testing the compare between array list and linked list:");
        PerformanceTester.compareArrayListAndLinkedList(20000);
        //Adding 20000 to ArrayList: 320 ms.
        //Adding 20000 to LinkedList: 20 ms.
        //Getting 20000 to ArrayList: 2 ms.
        //Getting 20000 to LinkedList: 3148 ms.

        //Testing of the selectionSort
        System.out.println("Testing of the selectionSort:");
        List<Monster> monsterList2 = PerformanceTester.randomList(30);
        Kollections.selectionSort(monsterList2);
        for (int i = 0; i < monsterList2.size(); i++) {
            System.out.printf("%2d) %s%n", i + 1, monsterList2.get(i));
        }

        //Testing of the mergeSort
        System.out.println("Testing of the mergeSort:");
        List<Monster> monsterList3 = PerformanceTester.randomList(30);
        Kollections.mergeSort(monsterList3);
        for (int i = 0; i < monsterList2.size(); i++) {
            System.out.printf("%2d) %s%n", i + 1, monsterList2.get(i));
        }

        //Testing of the testSelectionSort and testMergeSort
        System.out.println("Testing of testSelectionSort and testMergeSort:");
        //PerformanceTester.testSelectionSort();
        //PerformanceTester.testMergeSort();

        //testing quicksort
        System.out.println("Testing of the quicksort:");
        List<Monster> monsterList4 = PerformanceTester.randomList(30);
        Kollections.quickSort(monsterList4);
        for (int i = 0; i < monsterList2.size(); i++) {
            System.out.printf("%2d) %s%n", i + 1, monsterList2.get(i));
        }

        Monster unknownMonster = MonsterFactory.newEmptyMonster();
        Random random = new Random();
        int index = random.nextInt(monsterList4.size());
        System.out.printf("Index Monster %-20s: %d",monsterList4.get(index).getName(),Kollections.lineairSearch(monsterList4, monsterList4.get(index)));
        System.out.printf("%nIndex Monster %-20s: %d",monsterList4.get(index).getName(),Kollections.binarySearch(monsterList4, monsterList4.get(index)));
        System.out.printf("%nIndex Monster %-20s: %d",unknownMonster.getName(),Kollections.lineairSearch(monsterList4, unknownMonster));
        System.out.printf("%nIndex Monster %-20s: %d",unknownMonster.getName(),Kollections.binarySearch(monsterList4, unknownMonster));
    }
}
