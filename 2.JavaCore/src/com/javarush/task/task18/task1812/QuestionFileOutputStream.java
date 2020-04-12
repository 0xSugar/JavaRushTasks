package com.javarush.task.task18.task1812;

/* 
Расширяем AmigoOutputStream
*/

import java.io.*;

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream aos;

    public QuestionFileOutputStream(AmigoOutputStream aos) {
        this.aos = aos;
    }

    @Override
    public void flush() throws IOException {
        aos.flush();
    }

    @Override
    public void write(int b) throws IOException {
        aos.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        aos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        aos.write(b, off, len);
    }

    @Override
    public void close() {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(System.in))) {
            if (rd.readLine().equals("Д")) {
                aos.close();
            }
        } catch (IOException e) {

        }
    }
}

