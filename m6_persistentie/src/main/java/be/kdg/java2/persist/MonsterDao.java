package be.kdg.java2.persist;

import be.kdg.java2.Model.Monster;

import java.util.List;

public interface MonsterDao {
    boolean insert(Monster monster);
    boolean delete(String name);
    boolean update(Monster monster);
    Monster retrieve(String name);
    List<Monster> sortedOn(String query);

}
