package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("Амиго и Диего лучшие"));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        string = string.substring(string.indexOf(" ")+1);
        String[] part = string.split("\\s");
        if (part.length < 4) {
            throw new TooShortStringException();
        }

        return part[0] + " " + part[1] + " " + part[2] + " " + part[3];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
