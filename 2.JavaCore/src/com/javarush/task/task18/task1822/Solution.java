package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file = rd.readLine();
        rd.close();

        BufferedReader scan = new BufferedReader(new FileReader(file));
        while (scan.ready()) {
            String line = scan.readLine();

            if (line.startsWith(args[0] + " ")) {
                System.out.println(line);
            }
//            // идет сколько угодно цифер(\\d+), потом пробел (\\s), потом буквы+пробел сколько угодно([..]+) потом цифры (\\d+) -> точка & запятая [.,] -> цифры (\\d+) -> один пробел (\\s) -> цифры (\\d+) -> дальше Нет пробела (Т.е. конец)
//            Pattern pat = Pattern.compile("(\\d+)\\s[a-zA-Zа-яА-Я\\s]+\\d+[,.]\\d+\\s\\d+[^\\s]");
//            Matcher mat = pat.matcher(line);
//
//            while (mat.find()) {
//                if (mat.group(1).equals(args[0])) {
//                    System.out.println(mat.group());
//                }
//            }
        }
        scan.close();



    }
}
