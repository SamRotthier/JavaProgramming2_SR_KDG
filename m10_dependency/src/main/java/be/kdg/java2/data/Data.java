package be.kdg.java2.data;

import be.kdg.java2.Model.Monster;
import be.kdg.java2.Model.MonsterType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Monster> getData() {
        List<Monster> monsters = new ArrayList<>();
        //Monster(name:string, totalXP:double, level:int, type:enum, birthday:LocalDate, battlesWon:int)
        monsters.add(new Monster("Yoda", 10.2, 2, MonsterType.neutral,LocalDate.of(2021, 6, 10), 5,1));
        monsters.add(new Monster("Pikachu", 10.5, 2,MonsterType.earth,LocalDate.of(2022,11,6), 6,2));
        monsters.add(new Monster("Ryugu warashi", 100.0, 55,MonsterType.fire,LocalDate.of(2020,5,1), 1000,3));
        monsters.add(new Monster("Taira no Masakado", 25.3, 4, MonsterType.water,LocalDate.of(2023, 4,26), 10,4));
        monsters.add(new Monster("Umakan", 20.0, 4,MonsterType.neutral,LocalDate.of(2022, 12, 25), 50,5));
        monsters.add(new Monster("Okuri inu", 30.5, 5,MonsterType.air,LocalDate.of(2020, 4,21), 60,6));
        monsters.add(new Monster("Shokera", 95.0, 50,MonsterType.fire,LocalDate.of(2023,7,20), 20,7));
        monsters.add(new Monster("Chimi", 66.6, 45,MonsterType.air,LocalDate.of(2021,9,20), 10,8));
        monsters.add(new Monster("Chopirako", 34.0,40,MonsterType.fire, LocalDate.of(2023,1,25), 5,9));
        monsters.add(new Monster("Yuki onna", 5.24, 2,MonsterType.earth,LocalDate.of(2020,10,15), 2,10));
        monsters.add(new Monster("Biwa bokuboku", 6.5, 2,MonsterType.neutral,LocalDate.of(2021, 4, 5),50,11));
        monsters.add(new Monster("Hamaguri nyobo", 87.5, 49,MonsterType.neutral,LocalDate.of(2022,6,4), 60,15));
        monsters.add(new Monster("Oni hitokuchi", 6.3, 5,MonsterType.water,LocalDate.of(2011, 7 ,20), 7,16));
        monsters.add(new Monster("Mumashika", 5.1, 5,MonsterType.air,LocalDate.of(2020, 3, 30),10,17));
        monsters.add(new Monster("Urashima Taro", 5.6, 5,MonsterType.earth,LocalDate.of(2021, 12,14), 25,18));
        return monsters;
    }


}
