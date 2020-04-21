package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Алгоритмы-числа
*/
public class Solution {

    private static int[][] cash;
    private static ArrayList<Long> list = new ArrayList<>();

    static {
        cash = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cash[i][j] = (int) (Math.pow(i, j));
            }
        }
    }

    public static long[] getNumbers(long N) throws InterruptedException {
        long[] result;

        if (N < 0) throw new RuntimeException();

        long a1 = 0L;
        long a2 = N / 3L;
        long b1 = a2;
        long b2 = (N * 2) / 3;
        long c1 = b2;
        long c2 = N;

        MyThread myThread1 = new MyThread(a1, a2);
        MyThread myThread2 = new MyThread(b1, b2);
        MyThread myThread3 = new MyThread(c1, c2);
        myThread1.join();
        myThread2.join();
        myThread3.join();

        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Arrays.toString(getNumbers(912_985_153L)));
    }

    public static class MyThread extends Thread {

        long point1;
        long point2;

        public MyThread(long point1, long point2) {
            this.point1 = point1;
            this.point2 = point2;
            start();
        }

        public void run() {
            for (long i = point1; i <= point2; i++) {
                String fullNumber = String.valueOf(i);
                int[] arr = new int[fullNumber.length()];

                for (int j = 0; j < arr.length; j++) {
                    arr[j] = fullNumber.charAt(j) - '0';
                }

                long fin = 0;
                for (int j = 0; j < arr.length; j++) {
                    try {
                        fin += cash[arr[j]][fullNumber.length()];
                    } catch (Exception e) {}
                }
                if (fin == i) {
                    addToList(i);
                }
            }
        }
    }

    synchronized public static void addToList(long number) {
        list.add(number);
    }
}
