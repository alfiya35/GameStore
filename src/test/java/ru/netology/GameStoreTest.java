package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGameToEmptyList() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.games.contains(game));
    }

    @Test
    public void shouldAddGameToNotEmptyList() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология курсовая", "Ужасы");

        assertTrue(store.games.contains(game1) && store.games.contains(game1));
    }

    @Test
    public void shouldCheckContainsGameAndGameExists() {

        GameStore store = new GameStore();
        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);
        store.games.add(game);
        assertTrue(store.games.contains(game));
    }

    @Test
    public void shouldCheckContainsGameAndGameDoesntExist() {

        GameStore store = new GameStore();
        Game game = new Game("Нетология Баттл Онлайн", "Аркады", store);

        assertFalse(store.games.contains(game));
    }

    @Test
    public void shouldAddPlayTimeFirstPlay() {
        GameStore store = new GameStore();
        Player firstPlayer = new Player("First");
        store.addPlayTime(firstPlayer.getName(), 3);

        int actual = store.playedTime.get(firstPlayer.getName());
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAddPlayTimeNotFirstPlay() {
        GameStore store = new GameStore();
        Player firstPlayer = new Player("First");
        store.addPlayTime(firstPlayer.getName(), 3);
        store.addPlayTime(firstPlayer.getName(), 4);

        int actual = store.playedTime.get(firstPlayer.getName());
        int expected = 7;

        assertEquals(expected, actual);
    }
}


