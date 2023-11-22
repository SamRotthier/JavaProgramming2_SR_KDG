package be.kdg.java2.Model;

import be.kdg.java2.reflection.CanRun;

import java.time.LocalDate;
import java.util.Objects;

public class Creature {
    protected String name;
    protected MonsterType type;
    protected LocalDate birthday;

    //getters
    public String getName() {
        return name;
    }

    public MonsterType getType() {
        return type;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @CanRun("Creature Name")
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    public void setType(MonsterType type) {
        if (type == null) {
            throw new IllegalArgumentException("Monster type cannot be nothing");
        } else {
            this.type = type;
        }
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isBefore(LocalDate.now().plusDays(1))) {
            throw new IllegalArgumentException("Date of birth cannot be after today");
        } else {
            this.birthday = birthday;
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

    public int compareTo(Object o) {
        Monster monster = (Monster) o;
        return this.getName().compareTo(monster.getName());
    }

    @Override
    public String toString() {
        return String.format("%-35s, type: %-22s,  born on monthly %10s",
                getName(), getType(), getBirthday());
    }
}
