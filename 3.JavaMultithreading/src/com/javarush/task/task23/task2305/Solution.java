package com.javarush.task.task23.task2305;

import java.util.Arrays;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
//        Solution[] sol = new Solution[2];
//        sol[0] = new Solution();
//        sol[0].innerClasses[0] = sol[0].new InnerClass();
//        sol[0].innerClasses[1] = sol[0].new InnerClass();
//        sol[1] = new Solution();
//        sol[1].innerClasses[0] = sol[1].new InnerClass();
//        sol[1].innerClasses[1] = sol[1].new InnerClass();
//        return sol;
        Solution sol1 = new Solution();
        sol1.innerClasses[0] = sol1.new InnerClass();
        sol1.innerClasses[1] = sol1.new InnerClass();

        Solution sol2 = new Solution();
        sol2.innerClasses[0] = sol1.new InnerClass();
        sol2.innerClasses[1] = sol1.new InnerClass();

        Solution[] solArr = new Solution[2];
        solArr[0] = sol1;
        solArr[1] = sol2;
        return solArr;
    }

    public static void main(String[] args) {
    }

    @Override
    public String toString() {
        return "Solution{" +
                "innerClasses=" + Arrays.toString(innerClasses) +
                '}';
    }
}
