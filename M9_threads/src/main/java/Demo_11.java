import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterType;
import be.kdg.java2.threading.MonsterCallable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo_11 {
    private static int TEST_COUNT = 0;

    public static void main(String[] args) throws Exception {
        List<Long> threadTimes = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(3);

        while (TEST_COUNT < 100) {
            MonsterCallable c1 = new MonsterCallable(monster -> monster.getName().charAt(0) == 'S');
            MonsterCallable c2 = new MonsterCallable(monster -> monster.getBirthday().isAfter(LocalDate.of(2020,1,1)));
            MonsterCallable c3 = new MonsterCallable(monster -> monster.getType()== MonsterType.earth);

            List<Future<List<Monster>>> futures = new ArrayList<>();
            long start = System.currentTimeMillis();

            futures.add(pool.submit(c1));
            futures.add(pool.submit(c2));
            futures.add(pool.submit(c3));

            for (var f : futures) {
                f.get();
            }

            TEST_COUNT++;
            threadTimes.add(System.currentTimeMillis() - start);
        }
        pool.shutdown();
        System.out.printf("\n3 Futures verzamelen elk 1000 Monsters (gemiddelde uit %d runs): %.2f ms",TEST_COUNT,
                threadTimes.stream().mapToDouble(Long::doubleValue).average().getAsDouble());
    }
}

