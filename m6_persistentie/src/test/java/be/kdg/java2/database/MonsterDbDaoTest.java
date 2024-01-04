package be.kdg.java2.database;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.data.Data;
import org.junit.jupiter.api.*;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // nodig om de init te laten werken
class MonsterDbDaoTest {
    private MonsterDbDao db;

    @BeforeAll
    public void init() {
        db = new MonsterDbDao("db/monsters");
    }

    @AfterAll
    public void closeDb() {
        db.close();
    }

    @BeforeEach
    public void fillDb() {
        Data.getData().forEach(db::insert);
    }

    @AfterEach()
    public void emptyDb() {
        db.delete("*");
    }

    @Test
    public void testInsert() {
        assertEquals(Data.getData().size(), db.sortedOnName().size(),
                "data and database should same size");
    }

    @Test
    public void testRetrieveUpdate() {
        Monster monster = db.retrieve("Yoda");
        monster.setName("changedYoda");
        assertTrue(db.update(monster));
        Monster monsterTest = db.retrieve("changedYoda");
        assertEquals(monster, monsterTest);
    }

    @Test
    public void testDelete() {
        assertTrue(db.delete("Pikachu"));
        assertEquals(db.sortedOnName().size(), Data.getData().size() - 1);
        assertFalse(db.delete("Pikachu"));
    }

    @Test
    public void testSort() {
        List<Monster> sortedList = Data.getData();
        sortedList.sort(Comparator.comparing(Monster::getLevel));
        assertEquals(sortedList, db.sortedOnLevel());
        sortedList.sort(Comparator.comparing(Monster::getName));
        assertArrayEquals(sortedList.toArray(), db.sortedOnName().toArray());
    }



}