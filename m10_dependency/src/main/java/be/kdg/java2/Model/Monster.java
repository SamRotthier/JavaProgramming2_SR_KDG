package be.kdg.java2.Model;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Monster implements Comparable, Serializable {
    private String name;
    private transient double totalXp;
    private int level;
    private transient MonsterType type;
    private LocalDate birthday;
    private transient int battlesWon;

    @Serial
    private static final long serialVersionUID = 1L;

    private int id; // pk for db

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
        this.id = -1;
    }

    // Constructor
    public Monster(String name, double totalXp, int level, MonsterType type, LocalDate birthday, int battlesWon, int id) {
        setName(name);
        setTotalXp(totalXp);
        setLevel(level);
        setType(type);
        setBirthday(birthday);
        setBattlesWon(battlesWon);
        setId(id);
    }

    public Monster(String name, int level, LocalDate birthday) {
        this.name = name;
        this.totalXp = 0.0;
        this.level = level;
        this.type = MonsterType.neutral;
        this.birthday = birthday;
        this.battlesWon = 0;
        this.id = -1;
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
    public int getId() {
        return id;
    }

    //setters
    public void setName(String name) {
        if (name == null || name.equals("")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        else {
            this.name = name;
        }
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
    public void setType(MonsterType type) {
        if (type == null){
            throw new IllegalArgumentException("Monster type cannot be nothing");
        }
        else {
            this.type = type;
        }
    }
    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now().plusDays(1))){
            throw new IllegalArgumentException("Date of birth cannot be after today");
        }
        else {
            this.birthday = birthday;
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

    public void setId(int id) {
        this.id = id;
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
