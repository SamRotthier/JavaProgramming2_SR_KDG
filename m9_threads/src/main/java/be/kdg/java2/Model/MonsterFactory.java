package be.kdg.java2.Model;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MonsterFactory {

    private MonsterFactory() {
    }

    public static Monster newEmptyMonster() {
        return new Monster();
    }

    public static Monster newFilledMonster(String name, double totalXp, int Level, MonsterType type, LocalDate birthday, int battlesWon) {
        return new Monster(name, totalXp, Level, type, birthday, battlesWon);
    }

    public static Monster newRandomMonster() {
        Random r = new Random();

        //https://stackoverflow.com/questions/40253332/generating-random-date-in-a-specific-range-in-java
        //https://stackoverflow.com/questions/34051291/generate-a-random-localdate-with-java-time#:~:text=A%20simple%20way%20is%20to,01%2D01%20(ISO).
        long start = LocalDate.of(2000, 1, 1).toEpochDay();
        long end = LocalDate.now().toEpochDay();

        return new Monster(
                generateString(5, 2, false),
                r.nextDouble(1,1000000),
                r.nextInt(0,100),
                MonsterType.values()[r.nextInt(MonsterType.values().length)],
                LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(start, end)),
                r.nextInt(0,5000000));
    }


    private static String generateString(int maxWordLength, int wordCount, boolean camelCase) {
        StringBuilder sb = new StringBuilder(maxWordLength);
        Random r = new Random();
        Random chance = new Random();
        String vowel = "aeiou";
        String consonant = "bcdfghjklmnpqrstvwxyz";
        char character;
        for(int i = 0; i < wordCount; i++){ //aantal woorden

            for (int j = 0; j < maxWordLength; j++){ //aantal letters
                if(chance.nextInt(3)+1 == 1){ //chance out of 3
                    character = vowel.charAt(r.nextInt(vowel.length()));
                }
                else{
                    character = consonant.charAt(r.nextInt(consonant.length()));
                }

                // Camel case is in mijn opdracht niet nodig, wel gevraagd in de opgave.
                //if (i != 0 && j == 0 && camelCase){
                //    Character.toUpperCase(character);
                //}
                // In mijn opdracht moet elke eerste letter van een woord een hooftletter krijgen
                if (j == 0 ){
                    sb.append(Character.toUpperCase(character));
                }
                else {
                    sb.append(character);
                }
            }
            if (i == 0 ){
                sb.append(" ");;
            }
        }
        return sb.toString();
    }
}
