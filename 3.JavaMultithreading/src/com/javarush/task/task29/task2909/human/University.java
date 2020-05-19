package com.javarush.task.task29.task2909.human;

import java.util.*;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    // конструктор
    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // геттеры и сетторы
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // методы
    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (averageGrade == student.getAverageGrade()) {
                return student;
            }
        }
        throw new NoSuchElementException();
    }

    public Student getStudentWithMaxAverageGrade() {
        return students.stream().max(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream().min(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public void expel(Student student) {
        students.remove(student);
    }
}