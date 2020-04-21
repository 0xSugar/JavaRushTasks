package com.javarush.task.task20.task2022;

import java.io.*;
/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("file");
        sol.writeObject("Some data");
        sol.close();

        FileOutputStream fos = new FileOutputStream("save");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sol);
        oos.close();

        FileInputStream fis = new FileInputStream("save");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution somethingNew = (Solution) ois.readObject();

        somethingNew.writeObject("Another Something");

    }
}
