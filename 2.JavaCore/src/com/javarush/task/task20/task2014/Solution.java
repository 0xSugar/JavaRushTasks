package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileInputStream fis = new FileInputStream("file.txt");

        Solution sol = new Solution(15);
        System.out.println(sol);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sol);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution copy = (Solution) ois.readObject();
        System.out.println(copy);
        System.out.println(copy.equals(sol));

    }

    @Override
    public String toString() {
        return this.string;
    }
}
