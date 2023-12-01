package be.kdg.java2.Model;

import java.util.*;
import java.util.function.Function;

public class Monsters {
    private TreeSet<Monster> monsterTreeSet;

    public Monsters() {
        this.monsterTreeSet = new TreeSet<Monster>();
    }

    public boolean add(Monster monster) {
        for (Monster value : monsterTreeSet)
            if (value.equals(monster))
                return false;
        monsterTreeSet.add(monster);
        return true;
    }

    public boolean remove(String stringName) {
       /*
        Iterator<Monster> it = monsterTreeSet.iterator();
        while (it.hasNext()) {
            if (stringName.equals(it.next().getName())) {
                it.remove();
                return true;
            }
        }
        return false;
        */
        return monsterTreeSet.removeIf(monster -> stringName.equalsIgnoreCase(monster.getName()));
    }

    public Monster search(String stringName) {
        /*
        for (Monster monster : monsterTreeSet)
            if (monster.getName().toLowerCase().equals(stringName.toLowerCase()))
                return monster;
        return null;
         */
        return monsterTreeSet.stream().filter(monster -> monster.getName().equalsIgnoreCase(stringName)).findAny().orElse(null);
    }

    public List<Monster> sortedBy(Function<Monster, Comparable> function){
        List<Monster> monsterList = new ArrayList<>(monsterTreeSet);
        monsterList.sort(Comparator.comparing(function));
        return monsterList;
    }

    public int getSize() {
        return monsterTreeSet.size();
    }
}
