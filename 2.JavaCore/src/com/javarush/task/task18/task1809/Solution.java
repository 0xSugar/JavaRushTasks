package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        try (FileInputStream fis = new FileInputStream(file1); FileOutputStream fos = new FileOutputStream(file2)) {
            byte[] buffer = new byte[fis.available()];
            if (fis.available() > 0) {
                fis.read(buffer);
            }
            for (int i = buffer.length-1; i >= 0; i--) {
                fos.write(buffer[i]);
            }
        } catch (IOException e) {}
    }
}
