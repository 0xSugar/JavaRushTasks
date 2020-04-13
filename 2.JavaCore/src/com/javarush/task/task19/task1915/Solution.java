package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        PrintStream save = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream me = new PrintStream(baos);
        System.setOut(me);
        testString.printSomething();
        System.setOut(save);
        System.out.println(baos.toString());
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(baos.toByteArray());
        fos.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

