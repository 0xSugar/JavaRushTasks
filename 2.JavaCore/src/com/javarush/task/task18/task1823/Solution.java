package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            String line = rd.readLine();
            if (line.equals("exit")) {
                rd.close();
                break;
            }
            new ReadThread(line).start();
        }

    }

    public static class ReadThread extends Thread {
        private String file;
        public ReadThread(String fileName) {
            super(fileName);
            file = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            byte[] array = new byte[256];
            try {
                FileInputStream fis = new FileInputStream(file);
                while (fis.available() > 0) {
                    array[fis.read()]++;
                }
                int max = 0, index = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > max) {
                        max = array[i];
                        index = i;
                    }
                }
                resultMap.put(file, index);
                fis.close();
            } catch (IOException e) {            }
        }
    }
}
