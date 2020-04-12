package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Movie movie;
        while (true) {
            String line = rd.readLine();
            movie = MovieFactory.getMovie(line);
            if (line.equals("soapOpera") || line.equals("cartoon") || line.equals("thriller")) {
                System.out.println(movie.getClass().getSimpleName());
            } else {
                break;
            }
        }

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if (key.equals("cartoon")) {
                movie = new Cartoon();
            } else if (key.equals("thriller")) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Thriller extends Movie {

    }
    static class Cartoon extends Movie {

    }
}
