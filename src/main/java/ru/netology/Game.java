package ru.netology;

import java.util.Objects;

public class Game { //Дата класс Игра. Хранит значения
    private final String title;//название игры
    private final String genre;//жанр игры
    private final GameStore store;//магазин игры

    public Game(String title, String genre, GameStore store) { //конструктор с параметрами
        this.title = title;
        this.genre = genre;
        this.store = store;
    }

    public String getTitle() { //геттер д/названия игры
        return title;
    }

    public String getGenre() { //геттер д/жанра игры
        return genre;
    }

    public GameStore getStore() { //геттер д/магазина
        return store;
    }

    @Override //иколс и хешкод д/сравнения
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title) &&
                Objects.equals(genre, game.genre) &&
                Objects.equals(store, game.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, store);
    }
}
