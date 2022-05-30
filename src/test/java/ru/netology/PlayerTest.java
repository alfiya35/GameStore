package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() { // тест,должен суммировать время игры одного жанра
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        //Создание объекта игры с заданными заголовком и жанром
        //Каждый объект игры помнит объект каталога, которому она принадлежит

        Player player = new Player("Petya");
        player.installGame(game);//добавление игры игроку
        player.play(game, 3); //возвращает суммарное количество часов, проигранное в эту игру.

        int expected = 3;
        int actual = player.sumGenre(game.getGenre()); // суммирует время, проигранное во все игры этого жанра этим игроком
        assertEquals(expected, actual);
    }

    // другие ваши тесты
}
