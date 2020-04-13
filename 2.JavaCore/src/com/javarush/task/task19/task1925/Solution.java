package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedWriter;
import java.io.*;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new FileReader(args[0]));
        BufferedWriter wr = new BufferedWriter(new FileWriter(args[1]));

        StringBuilder sb = new StringBuilder("");

        while(rd.ready()) {
            String line = rd.readLine();
            String[] words = line.split("\\s");
            for (String word : words) {
                if (word.length() > 6) {
                    sb.append(word).append(",");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        wr.write(sb.toString());

        rd.close();
        wr.close();
    }
}
