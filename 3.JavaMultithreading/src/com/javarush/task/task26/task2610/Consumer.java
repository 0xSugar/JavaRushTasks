package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(queue.poll(300, TimeUnit.MILLISECONDS));
            }
        } catch (InterruptedException e) {

        }
    }
}
