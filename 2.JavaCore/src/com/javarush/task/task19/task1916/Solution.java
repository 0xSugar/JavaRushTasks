package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        // считываем расположение 2х файлов
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();
        rd.close();

        // Создаем листы и записываем в них значения файлов
        ArrayList<String> list1 = importfiles(file1);
        ArrayList<String> list2 = importfiles(file2);

        // Основная логика, заполняем lines правильными значениями
        joinTheFiles(list1, list2);

        // Проверка для меня (удаляю перед проверкой)
        for (LineItem item : lines) {
            System.out.println(item);
        }

    }

    public static ArrayList<String> importfiles(String file) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();
        return list;
    }

    public static void joinTheFiles(ArrayList<String> list1, ArrayList<String> list2) {
        while(list1.size() > 0 && list2.size() > 0) {
            if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.get(0)));
                list1.remove(0);
                list2.remove(0);
            } else if (list1.get(1).equals(list2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                list1.remove(0);
            } else if (list1.get(0).equals(list2.get(1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }
        }

        if (list1.size() > 0) {
            lines.add(new LineItem(Type.REMOVED, list1.remove(0)));
        } else if (list2.size() > 0) {
            lines.add(new LineItem(Type.ADDED, list2.remove(0)));
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        // Проверка для меня (удаляю перед проверкой)
        @Override
        public String toString() {
            String part = null;
            if (type.equals(Type.ADDED)) part = "ADDED";
            if (type.equals(Type.REMOVED)) part = "REMOVED";
            if (type.equals(Type.SAME)) part = "SAME";
            return part + " " + line;
        }
    }
}
