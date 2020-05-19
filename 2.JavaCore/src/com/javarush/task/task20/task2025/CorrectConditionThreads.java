package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Правильное условие
 */

public class CorrectConditionThreads {

    private static int[][] buffer;
    private static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 600; i++) {
                        System.out.println(i);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println(Arrays.toString(getNumbers(10_000_000_000L)));
    }


    public static long[] getNumbers(long N) throws InterruptedException {
        if (N < 1) return new long[]{0};
        initBuffer(N);
        if (N < 1000) return for1000(N);
//        N -= 1;

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

        long[] arr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        return arr;
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
                if (getSum(i) == i) list.add(i);
            }
        }
    }

    synchronized public static void addToList(long number) {
        list.add(number);
    }

    private static void initBuffer(long n) {
        int count = 1;

        while (n > 0) {
            count++;
            n /= 10;
        }

        buffer = new int[10][count];
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < count; j++) {
                buffer[i][j] = (int) (Math.pow(i, j));
            }
        }
    }

    private static long[] for1000(long n) {
        for (long i = 0; i < n; i++) {
            if (getSum(i) == i) list.add(i);
        }

        long[] arr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
    private static long getSum(long i) {
        int res = 0;
        int length = getLength(i);

        while (i != 0) {
            res += buffer[(int) i % 10][length];
            i /= 10;
        }
        return res;
    }

    private static int getLength(long numb) {
        int res = 0;
        while (numb != 0) {
            numb /= 10;
            ++res;
        }
        return res;
    }
}