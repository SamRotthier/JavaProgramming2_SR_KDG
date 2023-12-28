package be.kdg.java2.threading;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonsterRunnable implements Runnable{

    private Predicate<Monster> predicate;
    private List<Monster> monsterList;

    public MonsterRunnable(Predicate<Monster> predicate) {
        this.predicate = predicate;
    }

    @Override
    public void run() {
        monsterList = Stream.generate(MonsterFactory::newRandomMonster).filter(predicate).limit(1000).collect(Collectors.toList());
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }
}
