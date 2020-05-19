package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int mediana = getMediana(array);

        compareArr(array, mediana);

        return array;
    }

    private static int getMediana(Integer[] array) {
        int firstNumber = array.length / 2;             // Q Q Q Q <- 2   |   Q Q Q <- 1
        int secondNumber = (array.length / 2) - 1;      // Q Q Q Q <- 1
        if (array.length % 2 == 0) {
            return (array[firstNumber] + array[secondNumber]) / 2;
        } else {
            return array[firstNumber];
        }
    }

    public static void compareArr(Integer[] arr, int mediana) {
        final int MED = mediana;
        Comparator<Integer> comparator = (x, y) -> {
            int x1 = Math.abs(x - MED);
            int y1 = Math.abs(y - MED);
            return x1 - y1;
        };
        Arrays.sort(arr, comparator);
    }
}
