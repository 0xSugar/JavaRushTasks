package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args[0].equals("-c")) {     // что бы добавить
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = sdf.parse(args[3]);  // парсим дату по заданному формату 20/12/2000

            if (args[2].equals("м")) {      // добавляем, если м - createMale
                allPeople.add(Person.createMale(args[1], date));
            } else {
                allPeople.add(Person.createFemale(args[1], date));
            }                               // выводим id
            System.out.println(allPeople.size() - 1);


        } else if (args[0].equals("-u")) {  // что бы обновить
            int id = Integer.parseInt(args[1]);     // берем id
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Person person = allPeople.get(id);      // получаем ссылку на человека

            person.setName(args[2]);                // меняем у него имя
            person.setSex((args[3].equals("м")) ? Sex.MALE : Sex.FEMALE); // пол
            person.setBirthDate(sdf.parse(args[4]));    // и дату рож.
            System.out.println(id);                 // выводим id


        } else if (args[0].equals("-d")) {  // что бы удалить
            Person tmp = allPeople.get(Integer.parseInt(args[1]));
            tmp.setBirthDate(null);         // получаем ссылку - все обнуляем
            tmp.setName(null);
            tmp.setSex(null);


        } else if (args[0].equals("-i")) {  // получить инфу
            int id = Integer.parseInt(args[1]); // берем id
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); // правильный формат даты
            Person person = allPeople.get(id);  // получаем ссылку на человека
            String name = person.getName();     // его имя
            String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж"; // пол
            String date = sdf.format(person.getBirthDate());    // дату рож.

            System.out.println(String.format("%s %s %s", name, sex, date)); // выводим в консоль
        } else {
            System.out.println("Wrong command");    // в случае чего - неправ команда.
        }
    }
}
