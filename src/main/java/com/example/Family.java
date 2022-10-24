package com.example;

import java.util.List;

// Интерфейс семейства животных
public interface Family {
    int getKittens(); // Метод возвращает количество детенышей

    List<String> getFood(String animalKind) throws Exception; // Метод возвращает еду для типа животного
}
