package com.javarush.task.task25.task2502;

import java.util.ArrayList;
import java.util.List;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            String[] arrOfWeels = loadWheelNamesFromDB();
            if (arrOfWeels == null || arrOfWeels.length != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<>();
            for (String wheel : arrOfWeels) {
                if (wheels.contains(Wheel.valueOf(wheel))) throw new IllegalArgumentException("Не может у машины быть 2 одинаковых колеса");
                wheels.add(Wheel.valueOf(wheel));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
//        Car car = new Car();
//        car.wheels.forEach(System.out::println);
    }
}
