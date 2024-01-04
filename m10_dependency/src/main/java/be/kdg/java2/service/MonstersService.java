package be.kdg.java2.service;

import be.kdg.java2.Model.Monster;

import java.util.List;

public interface MonstersService {
    List<Monster> getAllMonsters();
    void AddMonster(Monster monster);
}
