package com.javarush.task.task26.task2612;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {

        if (lock.tryLock()) {
            try {
                actionIfLockIsFree();
            } finally {
                lock.unlock();

            }
        } else {
            actionIfLockIsBusy();
        }
    }

    public synchronized void actionIfLockIsFree() {

    }

    public synchronized void actionIfLockIsBusy() {

    }
}
