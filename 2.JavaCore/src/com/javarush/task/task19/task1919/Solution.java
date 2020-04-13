package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String[] ga = reader.readLine().split("\\s");
            if (map.containsKey(ga[0])) {
                map.put(ga[0], Double.parseDouble(ga[1]) + map.get(ga[0]));
            } else {
                map.put(ga[0], Double.parseDouble(ga[1]));
            }
        }
        reader.close();

        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            list.add(pair.getKey());
        }

        Collections.sort(list);

        for (String key : list) {
            System.out.println(key + " " + map.get(key));
        }



    }
}
