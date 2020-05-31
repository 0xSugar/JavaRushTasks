package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
*/
public class Solution {

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.countDown();
        latch.await();
        retrieveValue();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                solution.latch.countDown();
            }
        }).start();

        solution.someMethod();
    }
}
