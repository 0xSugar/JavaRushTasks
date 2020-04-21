package com.javarush.task.task20.task2011;

import java.io.*;
import java.util.Objects;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */

        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
            out.flush();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Apartment)) return false;
            Apartment apartment = (Apartment) o;
            return year == apartment.year &&
                    address.equals(apartment.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(address, year);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment one = new Apartment("Вселенная", 9999999);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(one);
        oos.flush();
        baos.flush();
        oos.close();
        baos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Apartment two = (Apartment) ois.readObject();

        System.out.println(one);
        System.out.println(two);
        System.out.println("one is two? - " + one.equals(two));
        System.out.println(one.hashCode());
        System.out.println(two.hashCode());
    }
}
