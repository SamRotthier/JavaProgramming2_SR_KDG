package be.kdg.java2.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    private Monster m1;
    private Monster m2;

    @BeforeEach
    public void setUp() {
        m1 = new Monster("Yoda", 10.2, 2, MonsterType.neutral, LocalDate.of(2021, 6, 10), 5);
        m2 = new Monster("Pikachu", 10.5, 2,MonsterType.earth,LocalDate.of(2022,11,6), 6);
    }


    @Test
    public void testEquals() {
        Monster m3 = new Monster("Yoda", 10.2, 8, MonsterType.neutral, LocalDate.of(2022, 7, 10), 10);

        assertNotEquals(m1, m2, "Monsters are different");
        assertEquals(m1, m3, "Monsters have the same name: m1 " + m1.getName() + " & m3 " + m3.getName());

        //error:
        //assertEquals(m1, m2, "These are not equal");
    }

    @Test
    public void testIllegalName() {
        assertThrows(IllegalArgumentException.class, () -> m1.setName(""), "Name was empty => Exception.");

        //error:
        //assertThrows(IllegalArgumentException.class, () -> m1.setName("test"), "Name was filled in => No Exception was thrown");
  }

    @Test
    public void testLegalName() {
        assertDoesNotThrow(() -> m1.setName("Sam"), "Name filled in correctly => No Exception.");

        //error:
        //assertDoesNotThrow(() -> m1.setName(""), "Name is not filled in correctly => Exception.");
    }


    @Test
    public void testCompareTo() {
        Monster m4 = new Monster("Yoda", 10.2, 8, MonsterType.neutral, LocalDate.of(2022, 7, 10), 10);
        List<Monster> monsterList = List.of(m1, m2);
        List<Monster> sortedList = List.of(m2, m1);

        assertArrayEquals(monsterList.stream().sorted(Monster::compareTo).toArray(), sortedList.toArray(), "Sorted list is equal to the sorted monster list");

        monsterList = List.of(m1, m2, m4);
        sortedList = List.of(m2, m1, m4);
        assertArrayEquals(monsterList.stream().sorted(Monster::compareTo).toArray(), sortedList.toArray(), "Sorted list is equal to the sorted monster list");

        //Case with errors:
        //sortedList = List.of(m1, m2, m4);
        //assertArrayEquals(monsterList.stream().sorted(Monster::compareTo).toArray(), sortedList.toArray(), "Sorted list is not equal to the sorted monster list");
    }


    @Test
    public void testTotalXp() {
        //Error:
        //m2.setTotalXp(2000.0);

        assertEquals(m1.getTotalXp(), m2.getTotalXp(), 1.0, "The Total xp should be equal with a maragin of 1.0");

    }

}