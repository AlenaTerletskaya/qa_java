package com.example;

import java.util.List;

public class Aleks extends Lion {

    // Конструктор Алекса. В конструктор родительского класса всегда передается "Самец".
    public Aleks(Family feline) throws Exception{
        super(feline, "Самец");
    }

    // Метод getFriends() возвращает список имён друзей Алекса: зебры Марти, бегемотихи Глории и жирафа Мелман.
    public List<String> getFriends() {
        return List.of("зебра Марти", "бегемотиха Глория ", "жираф Мелман");
    }

    // Метод getPlaceOfLiving() возвращает место, где живёт Алекс — Нью-Йоркский зоопарк.
    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    // Переопределяем метод getKittens(), потому что у Алекса нет львят.
    @Override
    public int getKittens() {
        return 0;
    }
}
