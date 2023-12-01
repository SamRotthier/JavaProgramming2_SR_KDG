import java2.Model.Monster;
import java2.Model.MonsterType;
import java2.Model.Monsters;
import java2.data.Data;
import java2.util.MonsterFunctions;


import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Demo_4 {
    public static void main(String[] args) {

        Monsters monsters = new Monsters();
        for (Monster monster : Data.getData()){
            monsters.add(monster);
        }

        //2.2
        System.out.println("\nMonster gesorteerd op naam:");
        for (Monster monster : monsters.sortedBy(Monster::getName)) {
            System.out.println(monster);
        }

        System.out.println("\nMonster gesorteerd op geboorte datum:");
        for (Monster monster : monsters.sortedBy(Monster::getBirthday)) {
            System.out.println(monster);
        }

        System.out.println("\nMonster gesorteerd op level:");
        for (Monster monster : monsters.sortedBy(Monster::getLevel)) {
            System.out.println(monster);
        }

        //2.4
        List<Monster> monsterList = Data.getData();
        monsterList = MonsterFunctions.filteredList(monsterList, monster -> monster.getLevel() >= 50);
        monsterList = MonsterFunctions.filteredList(monsterList, monster -> monster.getBirthday().isAfter(LocalDate.of(2022, 1, 1)));
        monsterList = MonsterFunctions.filteredList(monsterList, monster -> monster.getType()== MonsterType.fire);
        System.out.println("\nAll monsters with a level above (or equal to) 50, is born after newyear of 2022 and has the fire type:");
        monsterList.forEach(System.out::println);

        //2.6
        monsterList = Data.getData();
        System.out.printf("\nGemiddeld level van de monsters: %.1f", MonsterFunctions.average(monsterList, Monster::getLevel));
        System.out.printf("\nGemiddeld aantal xp de monsters hebben verzameld: %.2f", MonsterFunctions.average(monsterList, Monster::getTotalXp));

        //2.8
        System.out.printf("\nAantal monsters met een level hoger dan 50: %d", MonsterFunctions.countIf(monsterList, monster -> monster.getLevel() > 50));
        System.out.printf("\nAantal monsters geboren na 2022: %d \n", MonsterFunctions.countIf(monsterList, monster -> monster.getBirthday().isAfter(LocalDate.of(2022, 1, 1))));

        //3
        monsterList = Data.getData();
        System.out.printf("\nAmount monsters born in 2022: %d", monsterList.stream().filter(monster -> monster.getBirthday().isBefore(LocalDate.of(2022, 1, 1))).count());
        System.out.println("\nAll games sorted by category and name:");
        monsterList.stream().sorted(Comparator.comparing(Monster::getName).thenComparing(Monster::getLevel)).forEach(System.out::println);
        System.out.println("\nAll monsters in capital letters, no doubles, reverse sorted, in 1 string, seperated by commas:");
        System.out.println(monsterList.stream().map(Monster::getName).map(String::toUpperCase).distinct().sorted(Collections.reverseOrder()).collect(Collectors.joining(", ")));
        System.out.println("\nFind random air monster:");
        monsterList.stream().filter(monster -> monster.getType() == MonsterType.air).findAny().ifPresent(System.out::println);
        System.out.println("\nMonster with the highest level: ");
        monsterList.stream().max(Comparator.comparing(Monster::getLevel)).ifPresent(g -> System.out.println(g.getName()));
        System.out.println("\nOldest monster: ");
        monsterList.stream().min(Comparator.comparing(Monster::getBirthday)).ifPresent(g -> System.out.println(g.getName()));
        System.out.println("\nList of sorted games that contain 'u':");
        System.out.println(monsterList.stream().map(Monster::getName).filter(game -> game.toLowerCase().contains("u")).sorted().collect(Collectors.toList()));
        Map<Boolean, List<Monster>> map = monsterList.stream().collect(Collectors.partitioningBy(monster -> monster.getBirthday().isAfter(LocalDate.of(2022, 1, 1))));
        System.out.println("\nMonsters born before 2022:");
        map.get(false).forEach(System.out::println);
        System.out.println("\nMonsters born after 2022:");
        map.get(true).forEach(System.out::println);

        System.out.println("Monsters sorted in category and by name:");
        Map<MonsterType, List<Monster>> categoryMap = monsterList.stream().collect(Collectors.groupingBy(Monster::getType));
        categoryMap.forEach((type, monster) -> System.out.printf("%8s%-20s: %s\n", "", type,monster.stream().map(Monster::getName).sorted().collect(Collectors.joining(", "))));

    }
}