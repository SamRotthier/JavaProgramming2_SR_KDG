package java2.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class MonsterFunctions {
    public static <T> List<T> filteredList(List<T> monsterList, Predicate<T> predicate) {
        /*
        List<T> filteredList = new ArrayList<>();

        for (T monster : monsterList) {
            if(predicate.test(monster))
                filteredList.add(monster);
        }
        return filteredList;
         */
        return monsterList.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T> Double average(List<T> monsterList, ToDoubleFunction<T> mapper){
        /*
        double sum = 0;
        for(T monster : monsterList) {
            sum = mapper.applyAsDouble(monster);
        }
        return sum/monsterList.size();
        */
        return monsterList.stream().mapToDouble(mapper).average().orElse(0);
    }

    public static <T> long countIf(List<T> monsterList, Predicate<T> predicate) {
        /*
        long count = 0;
        for(T monster : monsterList) {
            if(predicate.test(monster))
                count++;
        }
        return count;
         */
        return monsterList.stream().filter(predicate).count();
    }
}
