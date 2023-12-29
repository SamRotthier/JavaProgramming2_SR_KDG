import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterFactory;
import be.kdg.java2.Model.MonsterType;
import be.kdg.java2.threading.MonsterAttacker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo_10 {
    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsterList = new ArrayList<>();
        Stream.generate(MonsterFactory::newRandomMonster).limit(1000).forEach(monsterList::add);

        MonsterAttacker r1 = new MonsterAttacker(monsterList, monster -> monster.getName().charAt(0) == 'S');
        MonsterAttacker r2 = new MonsterAttacker(monsterList, monster -> monster.getBirthday().isAfter(LocalDate.of(2020,1,1)));
        MonsterAttacker r3 = new MonsterAttacker(monsterList, monster -> monster.getType()== MonsterType.earth);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Na uitzuivering:");
        System.out.println("aantal monsters beginnend met de letter S : " + (int) monsterList.stream().filter(monster -> monster.getName().charAt(0) == 'S').count());
        System.out.println("aantal monsters geboren na 2020           : " + (int) monsterList.stream().filter(monster -> monster.getBirthday().isAfter(LocalDate.of(2020, 1, 1))).count());
        System.out.println("aantal monsters van type earth            : " + (int) monsterList.stream().filter(monster -> monster.getType() == MonsterType.earth).count());
    }
}
