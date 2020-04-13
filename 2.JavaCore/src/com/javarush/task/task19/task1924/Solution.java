package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.*;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        while (rd.ready()) {
            list.add(rd.readLine());
        }
        rd.close();

        for (String l : list) {
            String[] array = l.split("\\s");
            StringBuilder answer = new StringBuilder("");
            for (String part : array) {
                for (int i = 0; i < 13; i++) {
                    if (part.equals(String.valueOf(i))) {
                        part = String.valueOf(map.get(i));
                    }
                }
                answer.append(part).append(" ");
            }
            System.out.println(answer);
        }

    }
}
