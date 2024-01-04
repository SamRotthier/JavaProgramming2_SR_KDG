package be.kdg.java2.database;

import be.kdg.java2.Model.Monster;

import java.util.List;

public interface MonsterDao {
    boolean insert(Monster monster);
    boolean delete(String name);
    boolean update(Monster monster);
    Monster retrieve(String name);
    List<Monster> sortedOn(String query);
    List<Monster> getAllMonsters();
}
