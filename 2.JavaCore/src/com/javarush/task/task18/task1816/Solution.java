package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            int count = 0;
            while (reader.ready()) {
                int numb = reader.read();
                if (String.valueOf((char) numb).matches("[a-zA-Z]")) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {}
    }
}
