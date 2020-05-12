package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        recursion(e);
        t.interrupt();
    }

    private void recursion(Throwable e) {
        if (e.getCause() == null) {
            System.out.println(e.toString());
            return;
        }
        recursion(e.getCause());
        System.out.println(e.toString());
    }

    public static void main(String[] args) {
        new Solution().uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
