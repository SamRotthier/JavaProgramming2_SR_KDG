package be.kdg.java2.Model;

import java.util.*;

public class Monsters {
    private TreeSet<Monster> monsterTreeSet;

    public Monsters() {
        this.monsterTreeSet = monsterTreeSet;
    }

    public boolean add(Monster monster) {
        for (Monster value : monsterTreeSet)
            if (value.equals(monster))
                return false;
        monsterTreeSet.add(monster);
        return true;
    }

    public boolean remove(String stringName) {
        Iterator<Monster> it = monsterTreeSet.iterator();
        while (it.hasNext()) {
            if (stringName.equals(it.next().getName())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Monster search(String stringName) {
        for (Monster monster : monsterTreeSet)
            if (monster.getName().toLowerCase().equals(stringName.toLowerCase()))
                return monster;
        return null;
    }

    public List<Monster> sortedOnName() {
        List<Monster> sortedMonsters = new ArrayList<>(monsterTreeSet);
        sortedMonsters.sort(new CompareByName());
        return sortedMonsters;
    }

    private static class CompareByName implements Comparator<Monster> {
        @Override
        public int compare(Monster o1, Monster o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public List<Monster> sortedOnBirthday() {
        List<Monster> sortedMonsters = new ArrayList<>(monsterTreeSet);
        sortedMonsters.sort(new CompareByBirthday());
        return sortedMonsters;
    }

    private static class CompareByBirthday implements Comparator<Monster> {
        @Override
        public int compare(Monster o1, Monster o2) {
            return o1.getBirthday().compareTo(o2.getBirthday());
        }
    }

    public List<Monster> sortedOnTotalXp() {
        List<Monster> sortedMonsters = new ArrayList<>(monsterTreeSet);
        sortedMonsters.sort(new CompareByTotalXp());
        return sortedMonsters;
    }

    private static class CompareByTotalXp implements Comparator<Monster> {
        @Override
        public int compare(Monster o1, Monster o2) {
            return Double.compare(o1.getTotalXp(), o2.getTotalXp());
        }
    }

    public int getSize() {
        return monsterTreeSet.size();
    }

}
