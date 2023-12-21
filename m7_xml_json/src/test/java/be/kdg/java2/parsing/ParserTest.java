package be.kdg.java2.parsing;

import be.kdg.java2.Model.Monsters;
import be.kdg.java2.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private Monsters monsters;

    @BeforeEach
    public void init() {
        monsters = new Monsters();
        Data.getData().forEach(monsters::add);
    }

    @Test
    public void testStaxDom() {
        MonstersStaxParser staxParser = new MonstersStaxParser(monsters, "datafiles/staxMonsters.xml");
        staxParser.staxWriteXML();
        Monsters monsters2 = MonstersDomParser.domReadXML("datafiles/staxMonsters.xml");
        assertArrayEquals(monsters.sortedOnName().toArray(), monsters2.sortedOnName().toArray(), "the xml file and list should be the same");
    }

    @Test
    public void testJaxb() throws Exception {
        MonstersJaxbParser.JaxbWriteXml("datafiles/jaxbMonsters.xml", monsters);
        Monsters monsters2 = MonstersJaxbParser.JaxbReadXml("datafiles/jaxbMonsters.xml", Monsters.class);
        assertArrayEquals(monsters.sortedOnName().toArray(), monsters2.sortedOnName().toArray(), "the xml file and list should be the same (Jaxb)");
    }

    @Test
    public void testGson() throws Exception {
        MonstersGsonParser.writeJson(monsters,"datafiles/gsonMonsters.json");
        Monsters monsters2 = MonstersGsonParser.readJson("datafiles/gsonMonsters.json");
        assertArrayEquals(monsters.sortedOnName().toArray(), monsters2.sortedOnName().toArray(), "Write/Read did not match (JAXB).");
    }

}