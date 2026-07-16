package com.example;

import java.util.List;

public class Feline extends Animal implements Predator, FelineCharacteristics {

            private final boolean hasMane;  // поле, определяющее наличие гривы

        // Конструктор с параметром – основной
        public Feline(boolean hasMane) {
            this.hasMane = hasMane;
        }

        // Конструктор по умолчанию – для удобства (гривы нет)
        public Feline() {
            this(false);
        }

        @Override
        public List<String> eatMeat() throws Exception {
            return getFood("Хищник");
        }

        @Override
        public String getFamily() {
            return "Кошачьи";
        }

        // Теперь возвращаем значение, переданное в конструктор
        @Override
        public boolean doesHaveMane() {
            return hasMane;
        }

        @Override
        public int getKittens() {
            return getKittens(1);
        }

        public int getKittens(int kittensCount) {
            return kittensCount;
        }

        @Override
        public List<String> getFood() throws Exception {
            return getFood("Хищник");
        }
    }