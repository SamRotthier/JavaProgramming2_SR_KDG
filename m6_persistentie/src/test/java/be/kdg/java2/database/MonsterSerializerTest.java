package be.kdg.java2.database;

import be.kdg.java2.Model.Monsters;
import be.kdg.java2.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterSerializerTest {
    private Monsters monsters;
    private MonsterSerializer monsterSerializer;

    @BeforeEach
    public void setUp() {
        monsters = new Monsters();
        Data.getData().forEach(game -> monsters.add(game));
        monsterSerializer = new MonsterSerializer("monsters.ser");
    }

    @Test
    public void testSerialize() {
        assertDoesNotThrow(() -> monsterSerializer.serialize(monsters), "The serialization does not throw an exception");
    }

    @Test
    public void testDeserialize() {
        assertEquals(monsters, assertDoesNotThrow(() -> monsterSerializer.deserialize(), "The deserialization does not throw an exception"), "object is the same as the start object");
    }


}