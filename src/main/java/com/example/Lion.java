package com.example;

import java.util.List;

public class Lion {
    private final FelineCharacteristics infoFeline;

    // Основной конструктор – внедрение зависимости (Dependency Injection)
    public Lion(FelineCharacteristics infoFeline) {
        this.infoFeline = infoFeline;
    }

    // Конструктор  создаёт Feline и передаёт его в основной конструктор
    public Lion(String sex) throws Exception {
        boolean hasMane;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        // Создаём конкретную реализацию Feline и внедряем её
        this.infoFeline = new Feline(hasMane);
    }

    // Все методы делегируются внедрённому объекту
    public boolean doesHaveMane() {
        return infoFeline.doesHaveMane();
    }

    public int getKittens() {
        return infoFeline.getKittens();
    }

    public List<String> getFood() throws Exception {
        return infoFeline.getFood();
    }
}