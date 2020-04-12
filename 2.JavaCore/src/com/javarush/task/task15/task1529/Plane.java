package com.javarush.task.task15.task1529;


public class Plane implements CanFly {
    private int passegerCapacity;
    
    public Plane(int passegerCapacity) {
        this.passegerCapacity = passegerCapacity;
    }
    
    public void fly() {
        System.out.println("Летим на Самолете");
    }
}