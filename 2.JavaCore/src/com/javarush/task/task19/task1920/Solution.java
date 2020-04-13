package com.javarush.task.task19.task1920;

/* 
Самый богатый
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

        ArrayList<String> win = new ArrayList<>();
        double current = 0d;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            double money = entry.getValue();
            if (current == money) {
                win.add(entry.getKey());
            } else if (current < money) {
                win.clear();
                current = money;
                win.add(entry.getKey());
            }
        }

        Collections.sort(win);
        for (String name : win) {
            System.out.println(name);
        }
    }
}
