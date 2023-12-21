package be.kdg.java2.parsing;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.Monsters;
import com.sun.xml.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class MonstersStaxParser {
    private Monsters monsters;
    private XMLStreamWriter xmlWriter;

    public MonstersStaxParser(Monsters monsters, String path) {
        this.monsters = monsters;
        try {
            this.xmlWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter(path));
            this.xmlWriter = new IndentingXMLStreamWriter(this.xmlWriter);
        } catch (IOException | XMLStreamException ignored) {
        }
    }

    public void staxWriteXML() {
        try {
            xmlWriter.writeStartDocument();
            xmlWriter.writeStartElement("monsters"); // <monsters>
            monsters.sortedOnName().forEach(this::writeElement);
            xmlWriter.writeEndElement(); // </monsters>
            xmlWriter.writeEndDocument();
            xmlWriter.close();
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }

    }

    private void writeElement(Monster monster) {
        try {
            xmlWriter.writeStartElement("monster"); // <monster>

            xmlWriter.writeAttribute("name", monster.getName());
            //xmlWriter.writeStartElement("name");
            //xmlWriter.writeCharacters(monster.getName());

            xmlWriter.writeStartElement("total-xp"); // <totalXp>
            xmlWriter.writeCharacters(String.valueOf(monster.getTotalXp()));
            xmlWriter.writeEndElement(); // </totalXp>

            xmlWriter.writeStartElement("level"); // <level>
            xmlWriter.writeCharacters(String.valueOf(monster.getLevel()));
            xmlWriter.writeEndElement(); // </level>

            xmlWriter.writeStartElement("type"); // <type>
            xmlWriter.writeCharacters(monster.getType().toString());
            xmlWriter.writeEndElement(); // </type>

            xmlWriter.writeStartElement("birthday"); // <birthDay>
            xmlWriter.writeCharacters(monster.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            xmlWriter.writeEndElement(); // </birthDay>

            xmlWriter.writeStartElement("battles-won"); // <battlesWon>
            xmlWriter.writeCharacters(String.valueOf(monster.getBattlesWon()));
            xmlWriter.writeEndElement(); // </battlesWon>



            xmlWriter.writeEndElement(); // </monster>
        } catch (XMLStreamException e) {
            System.out.println(e.getMessage());
        }
    }
}
