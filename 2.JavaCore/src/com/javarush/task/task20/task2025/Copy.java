package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Алгоритмы-числа
*/
public class Copy {

    private static int[][] cash;
    private static ArrayList<Long> list = new ArrayList<>();

    private static long[] getNumbers(long N) {
        long[] result = null;
        cash = new int[10][(int) N + 1];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < (int) N + 1; j++) {
                cash[i][j] = (int) (Math.pow(i, j));
            }
        }
        cycle((int) N);

        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }


        Arrays.sort(result);
        return result;
    }

    private static void cycle(int numb) {
        if (numb == 1) {
            for (int i = 0; i < 10; i++) {
                list.add((long) i);
            }
            return;
        }
        cycle(numb - 1);
        System.out.println("Число из " + numb + " цифр");

        StringBuilder len = new StringBuilder("1");
        for (int i = 0; i < numb - 1; i++) {
            len.append("0");
        }

        int start = Integer.parseInt(len.toString());
        int end = Integer.parseInt(len.toString() + "0");

        search(start, end, numb);

    }

    private static void search(int start, int end, int numb) {
        for (; start < end; start++) {
            int[] arr = new int[numb];
            String fullNumber = String.valueOf(start);

            for (int i = 0; i < numb; i++) {
                arr[i] = fullNumber.charAt(i) - '0';
            }

//            if (!isOkay(arr, numb)) continue; - работает 1долго и 2неправильно

            int fin = 0;
            for (int i = 0; i < arr.length; i++) {
                fin += cash[arr[i]][numb];
            }
            if (fin == start) {
                list.add((long) start);
            }
        }
    }

    private static boolean isOkay(int[] arr, int numb) {
        for (int i = 1; i < numb - 1; i++) {
            if (arr[i - 1] < arr[i] || arr[i] < arr[i + 1]) {

            } else {
                return false;
            }
        }
        return true;
    }

    static void main(String[] args) {
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
        System.out.println(Arrays.toString(getNumbers(9)));
        thread.interrupt();
    }
}
