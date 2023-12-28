
import be.kdg.java2.Model.MonsterType;
import be.kdg.java2.threading.MonsterRunnable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Demo_9 {
    public static  int TESTCOUNT = 0;

    public static void main(String[] args) throws Exception {
        long startTime;
        List<Long> threadTimes = new ArrayList<>();

        while(TESTCOUNT < 100) {
            MonsterRunnable r1 = new MonsterRunnable(monster -> monster.getName().charAt(0) == 'S');
            MonsterRunnable r2 = new MonsterRunnable(monster -> monster.getBirthday().isAfter(LocalDate.of(2020,1,1)));
            MonsterRunnable r3 = new MonsterRunnable(monster -> monster.getType()== MonsterType.earth);

            Thread t1 = new Thread(r1);
            Thread t2 = new Thread(r2);
            Thread t3 = new Thread(r3);

            startTime = System.currentTimeMillis();

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            System.out.println("List of Monsters where the name starts with S:");
            r1.getMonsterList().stream().limit(5).forEach(System.out::println);
            System.out.println("List of Monsters that is born after 2020/01/01:");
            r2.getMonsterList().stream().limit(5).forEach(System.out::println);
            System.out.println("List of Monsters with the earth type:");
            r3.getMonsterList().stream().limit(5).forEach(System.out::println);

            TESTCOUNT++;
            threadTimes.add(System.currentTimeMillis()-startTime);
        }
        System.out.printf("\n3 threads verzamelen elk 1000 Monsters (gemiddelde uit %d runs): %.2f ms",TESTCOUNT,
                threadTimes.stream().mapToDouble(Long::doubleValue).average().getAsDouble());
    }
}
