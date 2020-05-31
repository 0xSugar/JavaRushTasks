package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
Пишем свою ThreadFactory
*/
public class Solution {
    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        public static AtomicInteger groupID = new AtomicInteger();
        private AtomicInteger threadID = new AtomicInteger(1);
        private int startPoint;

        public AmigoThreadFactory() {
            startPoint = groupID.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {
            StringBuilder builder = new StringBuilder();
            int number = (int) (Thread.currentThread().getId() - 12);
            builder
                    .append(Thread.currentThread().getThreadGroup().getName())
                    .append("-pool-")
                    .append(startPoint)
                    .append("-thread-")
                    .append(threadID.getAndIncrement());
            Thread thread = new Thread(r, builder.toString());
            thread.setDaemon(false);
            thread.setPriority(Thread.NORM_PRIORITY);
            return thread;
        }
    }
}
