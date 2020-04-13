package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String f1 = rd.readLine();
        String f2 = rd.readLine();
        rd.close();

        try (FileReader reader = new FileReader(f1); FileWriter writer = new FileWriter(f2)) {
            int count = 1;
            while (reader.ready()) {
                int c = reader.read();
                if (count % 2 == 0) {
                    writer.write(c);
                }
                count++;
            }
        }
    }
}
