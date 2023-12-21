package be.kdg.java2.parsing;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterType;
import be.kdg.java2.Model.Monsters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.LocalDate;

public class MonstersDomParser {
    public static Monsters domReadXML(String filename) {
        Monsters monsters = new Monsters();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new File(filename));
            Element rootElement = doc.getDocumentElement();
            NodeList monsterNodes = rootElement.getChildNodes();
            for (int i = 0; i < monsterNodes.getLength(); i++) {
                if (monsterNodes.item(i).getNodeType() != Node.ELEMENT_NODE) continue;
                Element e = (Element) monsterNodes.item(i);
                monsters.add(new Monster(
                        e.getAttribute("name"),
                        Double.parseDouble(e.getElementsByTagName("total-xp").item(0).getTextContent()),
                        Integer.parseInt(e.getElementsByTagName("level").item(0).getTextContent()),
                        MonsterType.valueOf(e.getElementsByTagName("type").item(0).getTextContent()),
                        LocalDate.parse(e.getElementsByTagName("birthday").item(0).getTextContent()),
                        Integer.parseInt(e.getElementsByTagName("battles-won").item(0).getTextContent())
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monsters;
    }

}
