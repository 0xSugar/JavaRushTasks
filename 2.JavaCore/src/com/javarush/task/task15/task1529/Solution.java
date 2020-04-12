package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/import java.io.*;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            String plane = rd.readLine().toLowerCase();
            if (plane.equals("helicopter")) {
                result = new Helicopter();
            } else if (plane.equals("plane")) {
                result = new Plane(Integer.parseInt(rd.readLine()));
            } else { 
                result = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
