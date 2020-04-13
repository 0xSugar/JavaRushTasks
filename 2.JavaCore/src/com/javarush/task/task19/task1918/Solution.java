package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

//        ArrayList<String> list = new ArrayList<>();
        StringBuilder string = new StringBuilder("");
        rd = new BufferedReader(new FileReader(file));
        while (rd.ready()) {
//            list.add(rd.readLine());
            string.append(rd.readLine());
        }
        rd.close();

        String key = args[0];
        String patternFirst = "<" + key + " [a-zA-Z:=\"\\s><\\n]+<\\/" + key + ">";
        String patternSecond ="<" + key + ">[a-zA-Z\\s]+<\\/" + key + ">";

//        for (String line : list) {

            Pattern pat = Pattern.compile(patternFirst);
            Matcher mat = pat.matcher(string);
            while (mat.find()) {
                System.out.println(mat.group());
            }
            pat = Pattern.compile(patternSecond);
            mat = pat.matcher(string);
            while (mat.find()) {
                System.out.println(mat.group());
            }
//        }

    }
}
