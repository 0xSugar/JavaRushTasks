package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file));
        ArrayList<String> list = new ArrayList<>();
        while (rd.ready()) {
            String[] parts = rd.readLine().split("\\s");
            list.addAll(Arrays.asList(parts));
        }

        for (int i = 0; i < list.size(); i++) {
            for (int l = i+1; l < list.size(); l++) {
                String first = list.get(i);
                String second = list.get(l);
                if (first.contentEquals(new StringBuilder(second).reverse())) {
                    if (!result.contains(new Pair(first, second)) && !result.contains(new Pair(second, first))) {
                        result.add(new Pair(first, second));
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
