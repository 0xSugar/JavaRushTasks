package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1_Eternity());
        threads.add(new Thread2_InterruptException());
        threads.add(new Thread3_Cheer());
        threads.add(new Thread4_Message());
        threads.add(new Thread5_Reader());
    }

    public static void main(String[] args) throws InterruptedException {
    }
}