package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fio = new FileInputStream(args[0]);
             FileOutputStream fos = new FileOutputStream(args[1])) {

            byte[] arr = null;

            if (fio.available() > 0) {
                arr = new byte[fio.available()];
                fio.read(arr);
            }

            String line = new String(arr, "Windows-1251");

            byte[] newArr = line.getBytes(StandardCharsets.UTF_8);
            fos.write(newArr);
            fos.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (Exception e) {

        }
    }
}
