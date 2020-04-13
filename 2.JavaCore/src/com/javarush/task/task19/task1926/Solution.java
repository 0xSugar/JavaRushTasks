package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file));
        while(rd.ready()) {
            StringBuilder line = new StringBuilder(rd.readLine());
            line.reverse();
            System.out.println(line);
        }
        rd.close();
    }
}
