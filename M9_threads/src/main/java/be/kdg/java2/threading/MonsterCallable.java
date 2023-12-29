package be.kdg.java2.threading;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonsterCallable implements Callable<List<Monster>> {

    private Predicate<Monster> predicate;
    private List<Monster> monsterList;

    public MonsterCallable(Predicate<Monster> predicate) {
        this.predicate = predicate;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    @Override
    public List<Monster> call() throws Exception {
        monsterList = Stream.generate(MonsterFactory::newRandomMonster).filter(predicate).limit(1000).collect(Collectors.toList());
        return monsterList;
    }
}
