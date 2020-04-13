package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file));

        int count = 0;
        while (rd.ready()) {
            String line = rd.readLine();

            Pattern pat = Pattern.compile("\\bworld\\b");
            Matcher mat = pat.matcher(line);

            while (mat.find()) {
                count++;
            }
        }
        rd.close();
        System.out.println(count);
    }
}
