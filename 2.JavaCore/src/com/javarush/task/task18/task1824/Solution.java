package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String path = null;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            path = rd.readLine();
            try {
                FileInputStream stream = new FileInputStream(path);
                stream.close();
            } catch (FileNotFoundException e) {
                System.out.println(path);
                break;
            }
        }
        rd.close();
    }
}
