package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Алгоритмы-числа
*/
public class Copy2 {

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

    public static long[] getNumbers(long N) {
        long[] result = null;

        analizeAll(N);

        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        Arrays.sort(result);
        return result;
    }

    private static void analizeAll(long N) {
        for (long i = 0; i <= N; i++) {
            String fullNumber = String.valueOf(i);
            int[] arr = new int[fullNumber.length()];

            for (int j = 0; j < arr.length; j++) {
                arr[j] = fullNumber.charAt(j) - '0';
            }
            if (fullNumber.length() > 1 && !workWithIt(arr, fullNumber.length())) continue;
            long fin = 0;
            for (int j = 0; j < arr.length; j++) {
                fin += cash[arr[j]][fullNumber.length()];
            }
            if (fin == i) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {
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
        thread.start();

        System.out.println(Arrays.toString(getNumbers(912985153L)));

        thread.interrupt();
    }

    static boolean workWithIt(int[] arr, int numb) {
        for (int i = 0; i < numb - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                // если все окей - выдаст true
            } else {
                return false; // если нет - false
            }
        }
        return true;
    }
}
