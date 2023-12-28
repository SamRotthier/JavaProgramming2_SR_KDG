package be.kdg.java2.Model;


import java.time.LocalDate;
import java.util.Objects;

public final class Monster implements Comparable {
    private final String name;
    private final double totalXp;
    private final int level;
    private final MonsterType type;
    private final LocalDate birthday;
    private final int battlesWon;

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
        this.name = name;
        this.totalXp = totalXp;
        this.level = level;
        this.type = type;
        this.birthday = birthday;
        this.battlesWon = battlesWon;
    }

    //getters
    public String getName() {
        return name;
    }
    public double getTotalXp() {
        return totalXp;
    }
    public int getLevel() {
        return level;
    }
    public MonsterType getType() {
        return type;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public int getBattlesWon() {
        return battlesWon;
    }


// checkes if object is unique (name)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return getName().equals(monster.getName());
    }

    // creates unique key (with name)
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        Monster monster = (Monster) o;
        return this.getName().compareTo(monster.getName());
    }

    @Override
    public String toString() {
        return String.format("%-35s has %-10f for a level of %-10d, type: %-22s,  born on monthly %10s",
                getName(),getTotalXp(),getLevel(),getType(),getBirthday());
    }

}
