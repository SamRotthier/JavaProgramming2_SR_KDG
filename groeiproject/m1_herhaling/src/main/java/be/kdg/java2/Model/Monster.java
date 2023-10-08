package be.kdg.java2.Model;

import java.time.LocalDate;

public class Monster {
    private String name;
private double totalXp;
private int level;
private MonsterType type;
private LocalDate birthday;
private int battlesWon;

//Default Constructor
    public Monster() {
        this.name = "UnKnown";
        this.totalXp = 0.0;
        this.level = 0;
        this.type = MonsterType.neutral;
        this.birthday = LocalDate.of(2000,1,1) ;
        this.battlesWon = 0;
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

    //setters
    public void setName(String name) {
        if (name == null){
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
            throw new IllegalArgumentException();
        }
        else {
            this.type = type;
        }
    }
    public void setBirthday(LocalDate birthday) {
        if (birthday.isBefore(LocalDate.now())){
            throw new IllegalArgumentException();
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

}
