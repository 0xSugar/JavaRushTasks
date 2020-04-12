package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter wr1 = new BufferedWriter(new FileWriter(reader.readLine(), true));
             BufferedReader rd2 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader rd3 = new BufferedReader(new FileReader(reader.readLine()))) {
            while (rd2.ready()) {
                wr1.write(rd2.readLine());
            }
            while (rd3.ready()) {
                wr1.write(rd3.readLine());
            }
             } catch (IOException e) {}


    }
}
