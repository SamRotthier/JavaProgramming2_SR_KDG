package be.kdg.java2.threading;

import be.kdg.java2.Model.Monster;

import java.util.List;
import java.util.function.Predicate;

public class MonsterAttacker implements Runnable {
    private final List<Monster> monsterList;
    private final Predicate<Monster> predicate;

    public MonsterAttacker(List<Monster> monsterList, Predicate<Monster> predicate) {
        this.monsterList = monsterList;
        this.predicate = predicate;
    }

    @Override
    public void run() {
        synchronized (monsterList) {
            monsterList.removeIf(predicate);
        }
    }
}
