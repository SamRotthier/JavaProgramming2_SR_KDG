package be.kdg.java2.service;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.database.MonsterDbDao;

import java.util.List;

public class MonstersServiceImpl implements MonstersService{

    private MonsterDbDao monsterDb;

    public MonstersServiceImpl(MonsterDbDao monsterDb) {
        this.monsterDb = monsterDb;
    }

    @Override
    public List<Monster> getAllMonsters() {
        return monsterDb.getAllMonsters();
    }

    @Override
    public void AddMonster(Monster monster) {
        monsterDb.insert(monster);
    }
}

