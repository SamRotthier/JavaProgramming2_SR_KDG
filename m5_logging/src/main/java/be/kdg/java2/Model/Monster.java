package be.kdg.java2.Model;


import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Monster implements Comparable {
    private String name;
    private double totalXp;
    private int level;
    private MonsterType type;
    private LocalDate birthday;
    private int battlesWon;
    private  final Logger logger = Logger.getLogger(Monster.class.getName());

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
        if (name == null || name.equals("")){
            //throw new IllegalArgumentException("Name cannot be empty");
            logger.log(Level.SEVERE, "ERROR - Name cannot be empty for a monster");
        }
        else {
            this.name = name;
        }
    }
    public void setTotalXp(double totalXp) {
        if (totalXp < 0){
            //throw new IllegalArgumentException("Total XP cannot be less then 0 ");
            logger.log(Level.SEVERE, String.format("ERROR - Given Total xp ( %s ) is not allowed for Monster %s. (TIP: total xp can not be less then zero)",totalXp, getName()));
        }
        else {
            this.totalXp = totalXp;
        }
    }
    public void setLevel(int level) {
        if (level < 0){
            //throw new IllegalArgumentException("Level has to be above (or equal to) 0 ");
            logger.log(Level.SEVERE, String.format("ERROR - Given Level ( %s ) is not allowed for Monster %s. (TIP: level can not be less then zero)",level, getName()));
        }
        else {
            this.level = level;
        }
    }
    public void setType(MonsterType type) {
        if (type == null){
            //throw new IllegalArgumentException("Monster type cannot be nothing");
            logger.log(Level.SEVERE, String.format("ERROR - Given type ( %s ) is not allowed for Monster %s. (TIP: type must be filled in)",type, getName()));
        }
        else {
            this.type = type;
        }
    }
    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now().plusDays(1))){
            //throw new IllegalArgumentException("Date of birth cannot be after today");
            logger.log(Level.SEVERE, String.format("ERROR - Given Date of birth ( %s ) is not allowed for Monster %s. (TIP: given date can not be in the future)",birthday, getName()));
        }
        else {
            this.birthday = birthday;
        }
    }
    public void setBattlesWon(int battlesWon) {
        if (battlesWon < 0){
            //throw new IllegalArgumentException("Battles won cannot be less then 0");
            logger.log(Level.SEVERE, String.format("ERROR - Given amount of battles won ( %s ) is not allowed for Monster %s. (TIP: amount of battles won can not be less then zero)",battlesWon, getName()));
        }
        else {
            this.battlesWon = battlesWon;
        }
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
