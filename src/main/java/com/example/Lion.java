package com.example;

import java.util.List;

public class Lion {
    private final Family feline; // Объект feline - поле класса Lion
    boolean hasMane;

    // Объект feline  передается в конструктор.
    // Объект создан извне и попадает в переменную класса Lion.
    public Lion(Family feline, String sex) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
