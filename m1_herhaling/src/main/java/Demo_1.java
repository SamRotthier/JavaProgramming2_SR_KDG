import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.Monsters;
import be.kdg.java2.data.Data;

public class Demo_1 {
    public static void main (String[] args) {
        //System.out.println("Hello Gradle World!");
        Monsters monsters = new Monsters(); // 4.2.a
        for (Monster monster :Data.getData()){ // 4.2.b
            monsters.add(monster);
        }

        monsters.add(Data.getData().get(1)); //4.2.c

        //4.2.d
        System.out.println("search for Yoda: " + monsters.search("Yoda")); //test search
        System.out.println("List size: " + monsters.getSize());
        System.out.println("Remove :" + monsters.remove("Yoda")); // test remove & get size
        System.out.println("List size : " + monsters.getSize());

        System.out.println("Monsters sorted on name: ");
        for (Monster monster : monsters.sortedOnName()) {
            System.out.println(monster);
        }

        System.out.println("Monsters sorted on birthday:");
        for (Monster monster : monsters.sortedOnBirthday()) {
            System.out.println(monster);
        }

        System.out.println("Monsters sorted on total XP:");
        for (Monster monster : monsters.sortedOnTotalXp()) {
            System.out.println(monster);
        }


    }
}
