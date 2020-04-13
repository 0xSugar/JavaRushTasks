package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file));
        while(rd.ready()) {
            String sentence = rd.readLine();
            String[] lines = sentence.split("\\s");
            int count = 0;
            for (String line : lines) {
                if (words.contains(line)) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(sentence);
            }
        }
        rd.close();

    }
}
