package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Runnable, Serializable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        try {
            int count = 0;
            while (true) {
                System.out.println(count++);
                Thread.sleep(1000 / speed);
            }
        } catch (InterruptedException e) {

        }
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        runner.interrupt();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        System.out.println("Начали");
        Solution sol = new Solution(10);
        System.out.println("Запустили нить, спим 1с");
        Thread.sleep(1000);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        System.out.println("Сохранили объект, спим 2с");
        sol.writeObject(oos);

        oos.flush();
        oos.close();
        Thread.sleep(2000);

        System.out.println("Выгрузили объект");
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream bis = new ObjectInputStream(bais);
        sol.readObject(bis);

        System.out.println("Enter - что бы остановить");
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        rd.readLine();

    }
}
