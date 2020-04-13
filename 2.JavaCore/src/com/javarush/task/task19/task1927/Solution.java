package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream save = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        testString.printSomething();
        System.setOut(save);
        String[] lines = baos.toString().split("\n");
        for (int i = 0; i < lines.length; i++) {
            if (i % 2 == 0 && i != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            System.out.println(lines[i]);
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
