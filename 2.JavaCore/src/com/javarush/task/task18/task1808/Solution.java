package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        String file3 = rd.readLine();
        rd.close();

        try (FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos1 = new FileOutputStream(file2);
        FileOutputStream fos2 = new FileOutputStream(file3)) {

            int first = (fis.available() % 2 == 0) ? fis.available() / 2 : (fis.available() + 1) / 2;
            int second = (fis.available() % 2 == 0) ? fis.available() / 2 : (fis.available() - 1) / 2;

            if (fis.available() > 0) {
                byte[] buffer2 = new byte[first];
                byte[] buffer3 = new byte[second];
                fis.read(buffer2, 0, first);
                fis.read(buffer3, 0, second);
                fos1.write(buffer2);
                fos2.write(buffer3);
            }
        } catch (Exception e) {}
    }
}
