import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterType;
import be.kdg.java2.Model.Monsters;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.logging.LogManager;
import java.util.logging.FileHandler;

public class Demo_5 {
    public static void main(String[] args) {

        InputStream inputStream = Demo_5.class.getResourceAsStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Monster m1 = new Monster("", 10.2, 2, MonsterType.neutral, LocalDate.of(2021, 6, 10), 5);
        Monster m2 = new Monster("Pikachu", -10.5, 2,MonsterType.earth,LocalDate.of(2022,11,6), 6);
        Monster m3 = new Monster("Ryugu warashi", 100.0, -55,null,LocalDate.of(2099,5,1), -1000);
        Monster m4 = new Monster("Taira no Masakado", 25.3, 4, MonsterType.water,LocalDate.of(2023, 4,26), 10);
        Monster m5 = new Monster("Umakan", 20.0, 4,MonsterType.neutral,LocalDate.of(2022, 12, 25), 50);

        Monsters monsters = new Monsters();
        // Good data
       Monster m6 =(new Monster("Oni hitokuchi", 6.3, 5,MonsterType.water,LocalDate.of(2011, 7 ,20), 7));
       Monster m7 =(new Monster("Mumashika", 5.1, 5,MonsterType.air,LocalDate.of(2020, 3, 30),10));
       Monster m8 =(new Monster("Urashima Taro", 5.6, 5,MonsterType.earth,LocalDate.of(2021, 12,14), 25));

       //monsters.add(m1);
       monsters.add(m6);
       monsters.add(m7);
       monsters.add(m8);
       monsters.remove(m8.getName());



    }
}
