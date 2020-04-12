package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]));
        int[] array = new int[256];
        while (bis.available() > 0) {
            array[bis.read()]++;
        }
        bis.close();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
            System.out.println((char) i + " " + array[i]);
        }
    }
}
