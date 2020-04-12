package com.javarush.task.task16.task1615;

/**
 * A little bit updated code from Javarush.ru... just I like it, it's cool.
 */

public class Solution {
    public static volatile Runway RUNWAY_1 = new Runway("Амиго");
    public static volatile Runway RUNWAY_2 = new Runway("Кардес");
    public static volatile Runway RUNWAY_3 = new Runway("Оуверан");


    public static void main(String[] args) throws InterruptedException {
        Plane plane1 = new Plane("Самолет #1");
        Plane plane2 = new Plane("Самолет #2");
        Plane plane3 = new Plane("Самолет #3");
    }

    private static void waiting() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    private static void takingOff() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }

    public static class Plane extends Thread {
        private boolean isAlreadyTakenOff = false;
        public Plane(String name) {
            super(name);
            start();
        }

        public void run() {
            while (!isAlreadyTakenOff) {
                if (RUNWAY_1.trySetTakingOffPlane(this)) {    //если взлетная полоса свободна, занимаем ее
                    this.process(RUNWAY_1);
                } else if (RUNWAY_2.trySetTakingOffPlane(this)) {  //если взлетная полоса занята самолетом
                    this.process(RUNWAY_2);
                } else if (RUNWAY_3.trySetTakingOffPlane(this)) {  //если взлетная полоса занята самолетом
                    this.process(RUNWAY_3);
                } else if (!this.equals(RUNWAY_1.getTakingOffPlane()) && !this.equals(RUNWAY_2.getTakingOffPlane()) && !this.equals(RUNWAY_3.getTakingOffPlane())) {  //если взлетная полоса занята самолетом
                    System.out.println(getName() + " ожидает");
                    waiting(); //ожидает
                } else {
                    run();
                }
            }
        }

        public void process(Runway runway) {
            System.out.println(getName() + " занял свободную полосу " + runway.getName() + ", взлетает");
            takingOff();//взлетает
            System.out.println(getName() + " уже в небе");
            isAlreadyTakenOff = true;
            runway.setTakingOffPlane(null);
        }
    }

    public static class Runway { //взлетная полоса
        private Plane t;
        private String name;

        public Runway (String name) {
            this.name = name;
        }

        public Thread getTakingOffPlane() {
            return t;
        }
        public String getName() {
            return name;
        }

        public void setTakingOffPlane(Plane t) {
            synchronized (this) {
                this.t = t;
            }
        }

        public boolean trySetTakingOffPlane(Plane t) {
            synchronized (this) {
                if (this.t == null) {
                    this.t = t;
                    return true;
                }
                return false;
            }
        }
    }
}

