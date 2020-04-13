package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        while (rd.ready()) {
            String line = rd.readLine();
            String[] parts = line.split("\\s");

            for (String part : parts) {
                Pattern pat = Pattern.compile("^\\d+$");
                Matcher mat = pat.matcher(part);

                if (mat.find()) {
                    writer.write(mat.group() + " ");
                }
            }
        }

        rd.close();
        writer.close();

    }
}
