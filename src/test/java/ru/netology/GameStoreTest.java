package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        //assertTrue(store.games.contains(game));
    }

    @Test
    public void shouldCheckContainsGame() {

        GameStore store = new GameStore();
        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);
        //store.games.Add(game);
        //assertTrue(store.games.contains(game));
    }

     //другие ваши тесты


}


