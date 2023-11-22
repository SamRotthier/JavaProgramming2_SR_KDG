import be.kdg.java2.Model.Creature;
import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.Monsters;
import be.kdg.java2.reflection.ReflectionTools;

public class Demo_3 {
    public static void main(String[] args) {
        ReflectionTools.classAnalysis(Creature.class, Monster.class, Monsters.class);
        System.out.println("\nAangemaakt object door runAnnotated:");
        System.out.println(ReflectionTools.runAnnotated(Monster.class));
    }
}
