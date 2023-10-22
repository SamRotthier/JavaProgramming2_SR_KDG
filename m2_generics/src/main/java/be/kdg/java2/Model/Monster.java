package be.kdg.java2.Model;


import java.time.LocalDate;
import java.util.Objects;

/**
 * Monster is the base class for this project.
 * @author Sam Rotthier
 * @version 1.0
 * @see <a href="https://nl.wikipedia.org/wiki/Monster">Monster wiki - placeholder</a>
 * This is based on one of my gamedevelopment projects, there is no website yet to link
 */
public class Monster implements Comparable {
    private String name;
    private double totalXp;
    private int level;
    private MonsterType type;
    private LocalDate birthday;
    private int battlesWon;


    /**
     * Default Constructor with default empty values
     */
    public Monster() {
        this.name = "UnKnown";
        this.totalXp = 0.0;
        this.level = 0;
        this.type = MonsterType.neutral;
        this.birthday = LocalDate.of(2000,1,1) ;
        this.battlesWon = 0;
    }


    /**
     * Constructor for Monster
     * @param name name of the monster
     * @param totalXp total aquired xp
     * @param level level of the monster
     * @param type the monster type
     * @param birthday the date of birth of the monster
     * @param battlesWon total amount of battles won
     */
    public Monster(String name, double totalXp, int level, MonsterType type, LocalDate birthday, int battlesWon) {
        setName(name);
        setTotalXp(totalXp);
        setLevel(level);
        setType(type);
        setBirthday(birthday);
        setBattlesWon(battlesWon);
    }

    /**
     * Getter for the name
     * @return returns the name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the total xp
     * @return returns the total xp
     */
    public double getTotalXp() {
        return totalXp;
    }

    /**
     * Getter for the level
     * @return returns the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter for the type
     * @return returns the type
     */
    public MonsterType getType() {
        return type;
    }

    /**
     * Getter for the birthday
     * @return returns the birtday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Getter for the battles won
     * @return returns the battles won
     */
    public int getBattlesWon() {
        return battlesWon;
    }

    /**
     * Setter for the name
     * @param name Monster name
     * @throws IllegalArgumentException name cannot be empty
     */
    public void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        else {
            this.name = name;
        }
    }

    /**
     * Setter for the total xp
     * @param totalXp Monster total Xp
     * @throws IllegalArgumentException total xp cannot be under 0
     */
    public void setTotalXp(double totalXp) {
        if (totalXp < 0){
            throw new IllegalArgumentException("Total XP cannot be less then 0 ");
        }
        else {
            this.totalXp = totalXp;
        }
    }

    /**
     * Setter for the level
     * @param level Monster level
     * @throws IllegalArgumentException level cannot be under 0
     */
    public void setLevel(int level) {
        if (level < 0){
            throw new IllegalArgumentException("Level has to be above (or equal to) 0 ");
        }
        else {
            this.level = level;
        }
    }

    /**
     * Setter for the type
     * @param type Monster level
     * @throws IllegalArgumentException Monster has to have a type
     * @see MonsterType
     */
    public void setType(MonsterType type) {
        if (type == null){
            throw new IllegalArgumentException("Monster type cannot be nothing");
        }
        else {
            this.type = type;
        }
    }

    /**
     * Setter for the birthday
     * @param birthday Monsters birthday
     * @throws IllegalArgumentException Birthday cannot be in the future
     */
    public void setBirthday(LocalDate birthday) {
        if (birthday.isBefore(LocalDate.now().plusDays(1))){
            throw new IllegalArgumentException("Date of birth cannot be after today");
        }
        else {
            this.birthday = birthday;
        }
    }

    /**
     * Setter for the battles won
     * @param battlesWon Monster battles won
     * @throws IllegalArgumentException cannot be less than 0
     */
    public void setBattlesWon(int battlesWon) {
        if (battlesWon < 0){
            throw new IllegalArgumentException("Battles won cannot be less then 0");
        }
        else {
            this.battlesWon = battlesWon;
        }
    }

    /**
     * Checks if an object is equal to the current object
     * @param o object to test
     * @return if equals return true
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return getName().equals(monster.getName());
    }

    /**
     * Creates a hashcode for the object
     * @return returns the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Compares an object to the current object by name
     * @param o the object to be compared.
     * @return returns 1 if currecnt object comes before the given object, 0 is equals and -1 if its in front
     */
    @Override
    public int compareTo(Object o) {
        Monster monster = (Monster) o;
        return this.getName().compareTo(monster.getName());
    }

    /**
     * Makes a representation in string format of the object
     * @return returns a formatted string
     */
    @Override
    public String toString() {
        return String.format("%-35s has %-10f for a level of %-10d, type: %-22s,  born on monthly %10s",
                getName(),getTotalXp(),getLevel(),getType(),getBirthday());
    }

}
