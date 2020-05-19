package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Неправильное условие
 */
public class Copy {

    private static int[][] cash;
    private static ArrayList<Long> list = new ArrayList<>();

    static {                            // заполнения матрицы чисел в виде таблицы умножения
        cash = new int[10][10];         // что бы каждый раз высчитывать, а брать от сюда
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cash[i][j] = (int) (Math.pow(i, j));
            }
        }
    }

    private static long[] getNumbers(long N) {
        long[] result;

        cycle((int) N);

        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }


        Arrays.sort(result);
        System.out.println(result.length);
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
        main: for (; start < end; start++) {                  // сначала нужно целое число разделить на цифры 213 -> 2, 1 и 3
            int[] arr = new int[numb];                  // массив, где будут числа
            String fullNumber = String.valueOf(start);  // текстовый вид числа

            for (int i = 0; i < numb; i++) {                // по каждому символу, берем 1й символ и отнимаем
                arr[i] = fullNumber.charAt(i) - '0';        // текстовый 0, что бы символ перевести в число
            }


            int fin = 0;
            for (int i = 0; i < arr.length; i++) {          // теперь получаем число, при возведении в степень из длины
                fin += cash[arr[i]][numb];                  // кажой цифры
            }                                       // (3 для 213, 5 для 92401)

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
        thread.setDaemon(true);
        thread.start();
        System.out.println(Arrays.toString(getNumbers(9)));
    }
}
