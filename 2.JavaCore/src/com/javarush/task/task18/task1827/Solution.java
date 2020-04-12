package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        if (args[0].equals("-c")) {
            create(args);
        }
    }

    public static void create(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        while (rd.ready()) {
            list.add(rd.readLine());
        }
        rd.close();

        int maxID = getMaxID(list) + 1;
        BufferedWriter wr = new BufferedWriter(new FileWriter(file, true));
        String id = correctLength(String.valueOf(++maxID), 8);
        String name = correctLength(args[1], 30);
        String price = correctLength(args[2], 8);
        String quantity = correctLength(args[3], 4);
//        String id = String.format("%-8.8d", maxID);
//        String name = String.format("%-30.30s", args[1]);
//        String price = String.format("%-8.2f", Double.parseDouble(args[2]));
//        String quantity = String.format("%-4.4d", Integer.parseInt(args[3]));
        wr.write("\n" + id + name + price + quantity);
        wr.close();
    }

    public static int getMaxID(ArrayList<String> list) {
        Pattern pat = Pattern.compile("^(\\d+).+$");
        Matcher mat;
        int maxID = 0;
        for (String line : list) {
            mat = pat.matcher(line);
            if (mat.find()) {
                int id = Integer.parseInt(mat.group(1));
                if (maxID < id) {
                    maxID = id;
                }
            }
        }
        return maxID;
    }

    public static String correctLength(String line, int correctLength) {
        int length = line.length();

        if (length == correctLength) {
            return line;
        } else if (length > correctLength) {
            return line.substring(0, correctLength);
        } else {
            String space = " ";
            StringBuilder build = new StringBuilder(line);
            int times = correctLength - length;
            for (int i = 0; i < times; i++) {
                build.append(space);
            }
            return build.toString();
        }
    }
}
