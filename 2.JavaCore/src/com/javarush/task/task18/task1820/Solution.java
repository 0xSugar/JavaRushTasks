package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader readone = new BufferedReader(new FileReader(rd.readLine()));
             BufferedWriter writetwo = new BufferedWriter(new FileWriter(rd.readLine()))) {
            while (readone.ready()) {
                String[] array = readone.readLine().split("\\s");
                for (String numb : array) {
                    writetwo.write(Math.round(Double.parseDouble(numb)) + " ");
                }
            }
        } catch (Exception e) {
        }
    }
}
