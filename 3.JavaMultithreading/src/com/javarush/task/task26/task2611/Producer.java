package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int count = 1;
        try {
            while (!currentThread.isInterrupted()) {
                map.put(String.valueOf(count), "Some text for " + count);
                count++;
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println( currentThread.getName() + " thread was terminated");
        }

    }
}
