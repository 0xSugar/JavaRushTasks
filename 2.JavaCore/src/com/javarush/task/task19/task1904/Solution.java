package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws ParseException {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            fileScanner = scanner;
        }
        @Override
        public Person read() throws IOException {
            String read = fileScanner.nextLine();
            String[] data = read.split("\\s");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            Date date = null;
            try {
                date = sdf.parse(data[3] + " " + data[4] + " " + data[5]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(data[1], data[2], data[0], date);

        }

        @Override
        public void close() throws IOException {
        fileScanner.close();
        }
    }
}
