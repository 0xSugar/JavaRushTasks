package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String line = rd.readLine();
            if (line.equals("end")) {
                break;
            }
            list.add(line);
        }
        rd.close();
        Collections.sort(list);

        // Отбирает все англ буквы вместе со словами и цифрами и '/' и помечает в группу один
        // полное совпадение - первая часть + ".part" + число
        Pattern pat = Pattern.compile("(^[a-zA-Z.\\-_0-9/]+)\\.part\\d");
        Matcher mat = pat.matcher(list.get(0));
        String name = null;
        if (mat.find()) {
            // группа 1 - строка от начала до .partN (N - цифра)
            name = mat.group(1);
        }

        // открываем буфер на запись
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(name));


        for (int i = 0; i < list.size(); i++) {
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(list.get(i)));
            while (reader.available() > 0) {
                writer.write(reader.read());
            }
            reader.close();
        }
        writer.close();


//        // проходим циклом по всем элементам листа
//        for (int i = 1; i <= list.size(); i++) {
//            // находим индекс первого файла (под номером 1)
//            int index = list.indexOf(name + ".part" + i);
//            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(list.get(index)));
//            while (reader.available() > 0) {
//                writer.write(reader.read());
//            }
//            reader.close();
//        }
    }
}