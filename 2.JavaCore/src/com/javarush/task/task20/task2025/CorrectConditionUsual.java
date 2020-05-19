package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class CorrectConditionUsual {
    private static ArrayList<Long> list = new ArrayList<>();
    private static int[][] buffer;

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

        System.out.println(Arrays.toString(getNumbers(912985153L)));
    }

    public static long[] getNumbers(long N) throws InterruptedException {
        if (N < 0) return new long[]{0};
        initBuffer(N);

        for (long i = 0; i < N; i++) {
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
}
