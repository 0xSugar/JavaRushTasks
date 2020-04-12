package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");       // 1
            steps.add("Сбор ресурсов");     // 2
            steps.add("Рост экономики");    // 3
            steps.add("Убийство врагов");   // 4
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 29);
        protected Gamer gamer2 = new Gamer("Petrov", 71);
        protected Gamer gamer3 = new Gamer("Sidorov", 0);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
        public static synchronized void setWinner(Gamer gamer) {
            if (!isWinnerFound){
                isWinnerFound = true;
                System.out.println(gamer.getName() +":победитель!");
            } else {
                System.out.println(gamer.getName() + ":проиграл");
            }
        }
    }

    public static class Gamer extends Thread {
        private int rating;
        private int total;
        private int numb;
        private boolean step1;
        private boolean step2;
        private boolean step3;
        private boolean step4;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            if (rating == 0) {
                rating = 1;
            }
            try {
                total = rating;
                numb = total % 4;
                while (!step1 || !step2 || !step3 || !step4) {
                    if (numb == 0) {
                        numb = 3;
                    } else {
                        numb--;
                    }
                    System.out.println(getName() + ":" + OnlineGame.steps.get(numb));
                    switch (numb) {
                        case 0:
                            step1 = true;
                            break;
                        case 1:
                            step2 = true;
                            break;
                        case 2:
                            step3 = true;
                            break;
                        case 3:
                            step4 = true;
                            break;
                    }
                    total += rating;
                    numb = total%4;
                    Thread.sleep(1000);
                }
                OnlineGame.setWinner(this);
            } catch (InterruptedException e) {
                System.out.println(getName() + ":проиграл");
            }
        }

        // @Override
        // public String toString() {
        //     return Thread.currentThread().getName() + ":" ;
        // }
    }
}
