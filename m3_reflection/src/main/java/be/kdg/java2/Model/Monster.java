package be.kdg.java2.Model;


import java.time.LocalDate;
import java.util.Objects;

public class Monster extends Creature implements Comparable {
    private double totalXp;
    private int level;
    private int battlesWon;

   // //Default Constructor
   // public Monster() {
   //     this.name = "UnKnown";
   //     this.totalXp = 0.0;
   //     this.level = 0;
   //     this.type = MonsterType.neutral;
   //     this.birthday = LocalDate.of(2000,1,1) ;
   //     this.battlesWon = 0;
   // }

    //Default Constructor
    public Monster() {
        this.name = "Test";
        this.totalXp = 10.0;
        this.level = 2;
        this.type = MonsterType.neutral;
        this.birthday = LocalDate.of(2000,1,1) ;
        this.battlesWon = 10;
    }

    // Constructor
    public Monster(String name, double totalXp, int level, MonsterType type, LocalDate birthday, int battlesWon) {
        setName(name);
        setTotalXp(totalXp);
        setLevel(level);
        setType(type);
        setBirthday(birthday);
        setBattlesWon(battlesWon);
    }

    public double getTotalXp() {
        return totalXp;
    }
    public int getLevel() {
        return level;
    }

    public int getBattlesWon() {
        return battlesWon;
    }

    public void setTotalXp(double totalXp) {
        if (totalXp < 0){
            throw new IllegalArgumentException("Total XP cannot be less then 0 ");
        }
        else {
            this.totalXp = totalXp;
        }
    }
    public void setLevel(int level) {
        if (level < 0){
            throw new IllegalArgumentException("Level has to be above (or equal to) 0 ");
        }
        else {
            this.level = level;
        }
    }

    public void setBattlesWon(int battlesWon) {
        if (battlesWon < 0){
            throw new IllegalArgumentException("Battles won cannot be less then 0");
        }
        else {
            this.battlesWon = battlesWon;
        }
    }

    @Override
    public String toString() {
        return String.format("%s,has %-10f for a level of %-10d",
                super.toString(),getTotalXp(),getLevel());
    }

}
