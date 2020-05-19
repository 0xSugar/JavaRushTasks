package com.javarush.task.task29.task2909.human;

import java.util.*;

public class Human  implements Alive{
    private static int nextId = 0;

    private int id;
    protected String name;
    protected int age;
    protected Size size;
    private BloodGroup bloodGroup;

    private List<Human> children = new ArrayList<>();

    // конструктор
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
    }

    // геттеры и сетторы
    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    // методы
    public void addChild(Human human) {
        if (!children.contains(human)) {
            children.add(human);
        }
    }
    @Override
    public void live() {

    }
    public void removeChild(Human human) {
        children.remove(human);
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public String getPosition() {
        return "Человек";
    }


    public class Size {
        public int height;
        public int weight;
    }
}