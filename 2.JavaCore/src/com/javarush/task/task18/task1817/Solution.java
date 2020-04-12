package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(args[0])) {
            int space = 0;
            int other = 0;
            while (fis.available() > 0) {
                char symb = (char) fis.read();
                if (symb == ' ') {
                    space++;
                } else {
                    other++;
                }
            }
            double result = ((double) space / (other + space)) * 100;
            System.out.println(String.format("%.2f", result));
        } catch (Exception e) {}
    }
}
