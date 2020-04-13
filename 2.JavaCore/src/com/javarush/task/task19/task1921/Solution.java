package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String name = null;
        String dateLine = null;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()) {
            String[] arr = reader.readLine().split("\\s");
            if (arr.length == 6) {
                name = arr[0] + " " + arr[1] + " " + arr[2];
                dateLine = arr[3] + " " + arr[4] + " " + arr[5];
            } else if (arr.length == 4) {
                name = arr[0];
                dateLine = arr[1] + " " + arr[2] + " " + arr[3];
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            Date date = sdf.parse(dateLine);
            PEOPLE.add(new Person(name, date));
        }
        reader.close();
    }
}
