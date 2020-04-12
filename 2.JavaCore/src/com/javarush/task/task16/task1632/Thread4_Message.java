package com.javarush.task.task16.task1632;

public class Thread4_Message extends Thread implements Message {

    private boolean ga = false;

    @Override
    public void showWarning() {
        ga = true;
        this.interrupt();
    }

    @Override
    public void run () {
        try {
            while (!ga) {
            }
        } catch (Exception e) {
            return;
        }
    }

}
