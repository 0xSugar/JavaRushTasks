package com.javarush.task.task22.task2203;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }
        if (countSign(string, "\t") <= 1) {
            throw new TooShortStringException();
        }

        return string.split("\t")[1];
    }

    private static int countSign(String string, String s) {
        int res = 0;
        Pattern par = Pattern.compile(s);
        Matcher mat = par.matcher(string);
        while (mat.find()) {
            res++;
        }
        return res;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - л\tучший сервис обучения Java.\t"));
    }
}
