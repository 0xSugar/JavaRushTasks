package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        // заносим данные первого файла в "буфер"
        FileInputStream fis = new FileInputStream(file1);
        byte[] buf = new byte[fis.available()];
        if (fis.available() > 0) {
            fis.read(buf);
        }
        fis.close();

        // заносим данные второго файла в "буфер"
        fis = new FileInputStream(file2);
        byte[] buf2 = new byte[fis.available()];
        while (fis.available() > 0) {
            fis.read(buf2);
        }
        fis.close();

        // записываем в файл
        FileOutputStream fos = new FileOutputStream(file1, false);
        fos.write(buf2);
        fos.write(buf);
        fos.close();
    }
}
