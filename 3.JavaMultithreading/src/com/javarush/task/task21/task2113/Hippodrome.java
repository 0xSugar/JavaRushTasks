package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("\uD83C\uDFC7", 3, 0));
        horses.add(new Horse("\uD83D\uDC0E", 3, 0));
        horses.add(new Horse("\uD83D\uDC34", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        horses.forEach(Horse::move);
    }
    public void print() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        horses.forEach(Horse::print);
    }

    public Horse getWinner() {
        return horses.stream()
                .sorted((h1, h2) -> (int) (h2.getDistance() - h1.getDistance()))
                .findFirst()
                .get();
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }


}
