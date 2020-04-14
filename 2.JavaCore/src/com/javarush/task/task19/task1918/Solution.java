package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        rd = new BufferedReader(new FileReader(file));
        StringBuilder string = new StringBuilder("");
        while (rd.ready()) {
            string.append(rd.readLine());
        }
        rd.close();

//        String patternFirst = "<" + key + " [a-zA-Z:=\"\\s><\\n]+<\\/" + key + ">";
//        String patternSecond = "<" + key + ">[a-zA-Z\\s]+<\\/" + key + ">";
//
//
//        Pattern pat = Pattern.compile(patternFirst);
//        Matcher mat = pat.matcher(string);
//        while (mat.find()) {
//            System.out.println(mat.group());
//        }
//        pat = Pattern.compile(patternSecond);
//        mat = pat.matcher(string);
//        while (mat.find()) {
//            System.out.println(mat.group());
//        }

        Document doc = Jsoup.parse(string.toString()," ", Parser.xmlParser());

        Elements els = doc.getElementsByTag(args[0]);

        for (Element el : els) {
            System.out.println(el.toString());
        }
    }
}
