package com.javarush.task.task14.task1419;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            FileInputStream fis = new FileInputStream("path to file");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            Solution car = null;
            System.out.println(car.clone());

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] e = new int[0];
            System.out.println(e[1]);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] r = new int[-1];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NumberFormatException();
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException();
        } catch (ClassNotFoundException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalAccessException();
        } catch (IllegalAccessException e) {
            exceptions.add(e);
        }
        try {
            throw new NoSuchFieldException();
        } catch (NoSuchFieldException e) {
            exceptions.add(e);
        }
        try {
            throw new NoSuchMethodException();
        } catch (NoSuchMethodException e) {
            exceptions.add(e);
        }

    }
}
