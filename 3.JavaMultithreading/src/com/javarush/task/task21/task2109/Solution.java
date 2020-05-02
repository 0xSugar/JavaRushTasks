package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof A)) return false;

            A a = (A) o;

            if (getI() != a.getI()) return false;
            return getJ() == a.getJ();
        }

        @Override
        public int hashCode() {
            int result = getI();
            result = 31 * result + getJ();
            return result;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof B)) return false;
            if (!super.equals(o)) return false;

            B b = (B) o;

            return getName() != null ? getName().equals(b.getName()) : b.getName() == null;
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (getName() != null ? getName().hashCode() : 0);
            return result;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return new C(this.getI(), this.getJ(), this.getName());
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

    }
}
