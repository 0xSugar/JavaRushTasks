package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.*;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable  {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age)  {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }
        public Person () {}

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(firstName);
            out.writeUTF(lastName);
            out.writeObject(father);
            out.writeObject(mother);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readUTF();
            lastName =  in.readUTF();
            father = (Person) in.readObject();
            mother = (Person) in.readObject();
            age = in.readInt();
            children = (ArrayList<Person>) in.readObject();
        }
        public String toString() {
            String line = "Name: " + firstName + " " + lastName + " (age: " + age + ")" + "\n" +
                    "mother: " + (mother != null ? mother.firstName : "none") + ", " +
                    "father: " + (father != null ? father.firstName : "none") + ".\n" +
                    "childs: ";
            if (children == null) {
                line = line + "none";
            } else {
                if (children.size() != 0) {
                    String add = "";
                    for (Person child : children) {
                        add = add + child.firstName + " " + child.lastName + ", ";
                    }
                    line = line + add.substring(0, add.length()-2);
                }
            }
            return line;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(firstName, person.firstName) &&
                    Objects.equals(lastName, person.lastName) &&
                    Objects.equals(mother, person.mother) &&
                    Objects.equals(father, person.father) &&
                    Objects.equals(children, person.children);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, age, mother, father, children);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Петя", "Дудки", 13);
        ArrayList<Person> list = new ArrayList<>();
        Collections.addAll(list, new Person("ребенок", "первый", 8),
                new Person("ребенок", "второй", 10));
        person.setChildren(list);
        System.out.println(person);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        oos.flush();
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Person copy = (Person) ois.readObject();
        System.out.println();
        System.out.println(person.equals(copy));
        System.out.println();
        System.out.println(copy);

    }
}
