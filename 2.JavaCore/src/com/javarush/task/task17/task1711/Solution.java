package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        ArrayList<String> forWork = new ArrayList<>();
        String line = "";
        for (int i = 1; i < args.length; i++) {
            line = line.concat(args[i] + " ");
        }
        Pattern pat = Pattern.compile("[^\\s]\\D+[\\d\\/]?\\s[а-я]\\s\\d+\\/\\d+\\/\\d+");
        Matcher matcher;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    matcher = pat.matcher(line);
                    while (matcher.find()) {                // делим ценую линию на массив по группам
                        forWork.add(matcher.group());       // и добавляем в лист
                    }
                    for (String parts : forWork) {          // для каждой такой группы
                        String[] part = parts.split("\\s"); // делим её на массив отдельных слов
                        doCreate(part);                     // бросаем этот массив методу, что все сделает
                    }
                    forWork.clear();
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    matcher = pat.matcher(line);
                    while (matcher.find()) {                // делим ценую линию на массив по группам
                        forWork.add(matcher.group());       // и добавляем в лист
                    }
                    for (String parts : forWork) {
                        String[] part = parts.split("\\s");
                        doUpdate(part);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        doDelete(Integer.parseInt(args[i]));
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        doInform(Integer.parseInt(args[i]));
                    }
                }
                break;
            default:
                System.out.println("Wrong command");
                break;
        }
    }

    private static void doCreate(String[] args) throws ParseException {
        synchronized (allPeople) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = sdf.parse(args[2]);  // парсим дату по заданному формату 20/12/2000

            if (args[1].equals("м")) {      // добавляем, если м - createMale
                allPeople.add(Person.createMale(args[0], date));
            } else {
                allPeople.add(Person.createFemale(args[0], date));
            }                               // выводим id
            System.out.println(allPeople.size() - 1);
        }
    }

    private static void doUpdate(String[] args) throws ParseException {
        synchronized (allPeople) {
            int id = Integer.parseInt(args[0]);     // берем id
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Person person = allPeople.get(id);      // получаем ссылку на человека

            person.setName(args[1]);                // меняем у него имя
            person.setSex((args[2].equals("м")) ? Sex.MALE : Sex.FEMALE); // пол
            person.setBirthDate(sdf.parse(args[3]));    // и дату рож.
            System.out.println(id);                 // выводим id
        }
    }

    private static void doDelete(int id) throws ParseException {
        synchronized (allPeople) {
            Person tmp = allPeople.get(id);
            tmp.setBirthDate(null);         // получаем ссылку - все обнуляем
            tmp.setName(null);
            tmp.setSex(null);
        }
    }

    private static void doInform(int id) throws ParseException {
        synchronized (allPeople) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); // правильный формат даты
            Person person = allPeople.get(id);  // получаем ссылку на человека
            String name = person.getName();     // его имя
            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж"; // пол
            String date = sdf.format(person.getBirthDate());    // дату рож.

            System.out.println(String.format("%s %s %s", name, sex, date)); // выводим в консоль
        }
    }
}
