package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream save = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        testString.printSomething();
        System.setOut(save);

        String line = baos.toString();
        line = line.substring(0, line.length()-1);

        Pattern numb = Pattern.compile("\\d+");
        Matcher mat = numb.matcher(line);
        int[] array = new int[10];
        int init = 0;
        while (mat.find()) {
            array[init] = Integer.parseInt(mat.group());
            init++;
        }

        int answer = 0;
        if (line.contains("+")) {
            for (int i = 0; i < init; i++) {
                answer += array[i];
            }
        } else if (line.contains("-")) {
            answer = array[0];
            for (int i = 1; i < init; i++) {
                answer -= array[i];
            }
        } else if (line.contains("*")) {
            answer = array[0];
            for (int i = 1; i < init; i++) {
                answer *= array[i];
            }
        }
        System.out.println(line + answer);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

