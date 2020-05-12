package com.javarush.task.task36.task3608.bean;

import java.util.Objects;

public class User implements Cloneable {
    private String name;
    private final long id;
    private int level;

    public static final User NULL_USER = new User();

    public User(String name, long id, int level) {
        this.name = name;
        this.id = id;
        this.level = level;
    }

    public User() {
        this("", 0, 0);
    }


    //methods with logic
    public boolean isNew() {
        return id == 0;
    }

    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException ignored) {
            return NULL_USER;
        }
    }

    public User clone(long newId) {
        if (this == NULL_USER) return NULL_USER;

        return new User(name, newId, level);
    }

    /////  getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getLevel() == user.getLevel() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getLevel());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }
}