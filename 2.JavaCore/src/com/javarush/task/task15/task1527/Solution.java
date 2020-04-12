package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String line = "0";
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            line = rd.readLine();
        } catch (Exception e) {
            
        }
//        String[] no1 = line.split("\\?");
        line = line.substring(36);
        String[] no2 = line.split("\\&");
        System.out.printf("%s%n%s%n", no2[0], no2[1]);
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
