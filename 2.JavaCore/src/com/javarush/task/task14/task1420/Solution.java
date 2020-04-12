package com.javarush.task.task14.task1420;

/* 
НОД
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(rd.readLine());
        int num2 = Integer.parseInt(rd.readLine());
        if (num1 <= 0 || num2 <= 0) {
            throw new Exception();
        }

        Set<Integer> flist = fillIt(num1);
        Set<Integer> slist = fillIt(num2);

        int result = giveMeAnswer(flist, slist);
        System.out.println(result);
    }

    static Set<Integer> fillIt(int numb) {
        Set<Integer> set = new HashSet<>();
        int old = numb;
        double copy = Math.sqrt(numb);
        while (!(numb == 1)) {
            for (int i = 2; i <= numb; i++) {
                if (numb % i == 0) {
                    numb /= i;
                    set.add(i);
                    break;
                } else if (i > copy && numb == old) {
                    set.add(1);
                    return set;
                }
            }
        }
        return set;
    }

    static int giveMeAnswer(Set<Integer> first, Set<Integer> second) {
        int result = 1;
        for (Integer n1 : first) {
            for (Integer n2 : second) {
                if (n1.equals(n2)) {
                    result = result * n1;
                }
            }
        }
        return result;
    }

}
