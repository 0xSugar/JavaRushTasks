package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String file = rd.readLine();
                FileInputStream fis = new FileInputStream(file);
                if (fis.available() < 1000) {
                    fis.close();
                    throw new DownloadException();
                }
            }
        } catch (IOException e) {}
    }

    public static class DownloadException extends Exception {

    }
}
