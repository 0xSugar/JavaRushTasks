package com.javarush.task.task24.task2407;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }


    public Sayable toSayable(final int i) {
        class CatPet implements Sayable {
            @Override
            public String say() {
                if (i < 1) {
                    return name + " спит.";
                } else {
                    StringBuilder builder = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        builder.append("я");
                    }
                    return name + " говорит м" + builder.toString() + "у!";
                }
            };
        }
        return new CatPet();
    }
}