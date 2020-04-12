package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thread5_Reader extends Thread {
    public void run() {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        while (true) {
            try {
                total += Integer.parseInt(rd.readLine());
            } catch (Exception e) {
                break;
            }
        }
        System.out.println(total);
    }
}
