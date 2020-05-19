package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);
    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {
        if (index >= 0 && index < students.size()) students.remove(index);
    }

    public static void findDimaOrSasha() {
        for (Student student : students) {
            if (student.getName().equals("Dima") || student.getName().equals("Sasha")) {
                System.out.printf("Студент %s есть в базе.%n", student.getName());
                break;
            }

        }
    }
}