package com.javarush.task.task16.task1632;

public class Thread2_InterruptException extends Thread {
    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(10000000);
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}
