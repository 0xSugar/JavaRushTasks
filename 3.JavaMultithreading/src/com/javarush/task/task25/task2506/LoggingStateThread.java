package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        State was = null;

        while (true) {
            State state = thread.getState();
            if (was != state) {
                System.out.println(state);
                was = state;
            }
            if (state == State.TERMINATED) return;
        }
    }
}
