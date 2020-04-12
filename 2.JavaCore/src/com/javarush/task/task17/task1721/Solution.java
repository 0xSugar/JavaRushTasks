package com.javarush.task.task17.task1721;

import java.util.*;
import java.io.*;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            String file1 = rd.readLine();
            String file2 = rd.readLine();
            writeTo(allLines,  file1);
            writeTo(forRemoveLines,  file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        for (String g : forRemoveLines) {
            if (!allLines.contains(g)) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
        for (String g : forRemoveLines) {
            allLines.remove(g);
        }

    }

    private static void writeTo (List<String> list, String fileName) {
        try (BufferedReader rd = new BufferedReader(new FileReader(fileName))) {
            while (rd.ready()) {
                list.add(rd.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
