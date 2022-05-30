package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.games.contains(game));
    }
    @Test
    public void shouldAddPlayTimeFirstPlay() {

        GameStore store = new GameStore();
        Player firstPlayer = new Player("Ferst");

        store.addPlayTime(firstPlayer.getName(),3);

        int actual = store.playedTime.get(firstPlayer.getName());
        int expected = 3;

        assertEquals(expected,actual);
    }


     //другие ваши тесты


}


