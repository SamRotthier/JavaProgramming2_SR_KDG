package be.kdg.java2.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonstersTest {
    private Monster m1;
    private Monster m2;
    private Monster m3;
    private Monster m4;
    private Monster m5;
   private Monsters monsters;

    @BeforeEach
    public void setUp() {
        m1 = new Monster("Yoda", 10.2, 2, MonsterType.neutral, LocalDate.of(2021, 6, 10), 5);
        m2 = new Monster("Pikachu", 10.5, 2,MonsterType.earth,LocalDate.of(2022,11,6), 6);
        m3 = new Monster("Ryugu warashi", 100.0, 55,MonsterType.fire,LocalDate.of(2020,5,1), 1000);
        m4 = new Monster("Taira no Masakado", 25.3, 4, MonsterType.water,LocalDate.of(2023, 4,26), 10);
        m5 = new Monster("Umakan", 20.0, 4,MonsterType.neutral,LocalDate.of(2022, 12, 25), 50);
        monsters = new Monsters();
        List<Monster> monstersList = Arrays.asList(m1,m2,m3,m4,m5);
        for (Monster m : monstersList){
            monsters.add(m);
        }
    }

    @Test
    public void testAdd() {
        Monster m6 = new Monster("Shokera", 95.0, 50,MonsterType.fire,LocalDate.of(2023,7,20), 20);

        assertTrue(monsters.add(m6), "Monster is added");
        // Case with error:
        // assertTrue(games.add(m1),"Adding a duplicate is not allowed");
    }

    @Test
    public void testRemove() {
        assertTrue(monsters.remove(m1.getName()));
        assertEquals(monsters.getSize(), 4);

        // error:
        // assertTrue(monsters.remove("Test"));
    }

    @Test
    public void testSortByName() {
        List<Monster> monsterList = monsters.sortedBy(Monster::getName);
        assertAll(
                () -> assertEquals(m3, monsterList.get(1)),
                () -> assertEquals(m4, monsterList.get(2)),
                () -> assertEquals(m5, monsterList.get(3))
        );

        //error:
        //assertAll(
        //        () -> assertEquals(m3, monsterList.get(0)),
        //        () -> assertEquals(m4, monsterList.get(1)),
        //        () -> assertEquals(m5, monsterList.get(2))
        //);
    }

    @Test
    public void testSortByTotalXp() {
        assertArrayEquals(monsters.sortedBy(Monster::getTotalXp).toArray(), Arrays.asList(m1,m2,m5,m4,m3).toArray(),"Sorted List is sorted the same as the Sorted monster list");


        //error:
        //assertArrayEquals(monsters.sortedBy(Monster::getTotalXp).toArray(), Arrays.asList(m1,m2,m3,m4,m5).toArray(), "Sorted List is NOT sorted the same as the Sorted monster list");
    }


}