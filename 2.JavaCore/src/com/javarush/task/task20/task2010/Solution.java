package com.javarush.task.task20.task2010;

import java.io.Serializable;

/*
Как сериализовать что-то свое?
*/
public class Solution {
    public static int stringCount;

    public static void main(java.lang.String[] args) {
        Object object = new Object();
        System.out.println(object.string1);
        System.out.println(object.string2);
        System.out.println(stringCount);
        System.out.println("--");
        object.string1.print();
        object.string2.print();
        System.out.println(object.string1);
        System.out.println(object.string2);
        System.out.println(stringCount);
        System.out.println("--");

    }

    public static class Object implements Serializable {
        private static final long serialVersionUID = 1L;
        public String string1 = new String();
        public String string2 = new String();
    }

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++stringCount;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
