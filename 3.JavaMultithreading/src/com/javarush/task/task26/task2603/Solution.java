package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>...comparators) {
            if (comparators == null) throw new IllegalArgumentException();
            this.comparators = comparators;
        }

        public int compareIt(T o1, T o2, Comparator<T> comparator) {
            return comparator.compare(o1, o2);
        }

        @Override
        public int compare(T o1, T o2) {
            for (int i = 0; i < comparators.length; i++) {
                int res = compareIt(o1, o2, comparators[i]);
                if (res != 0) {
                    return res;
                }
            }
            return 0;
        }
    }
}
