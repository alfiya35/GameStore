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

    @Test
    public void getMostPlayerWithNoPlayer() {
        GameStore store = new GameStore();
        String actual = store.getMostPlayer();

        assertNull(actual);
    }

    @Test
    public void getMostPlayerWithOnePlayerSmallTime() {
        GameStore store = new GameStore();
        store.playedTime.put("Ваня", 1);
        String actual = store.getMostPlayer();
        String expected = "Ваня";
        assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerWithOnePlayer() {
        GameStore store = new GameStore();
        store.playedTime.put("Ваня", 4);
        String actual = store.getMostPlayer();
        String expected = "Ваня";
        assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerWithTwoPlayers() {
        GameStore store = new GameStore();
        store.playedTime.put("Ваня", 4);
        store.playedTime.put("Саша", 1);
        String actual = store.getMostPlayer();
        String expected = "Ваня";
        assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerWithSeveralPlayers() {
        GameStore store = new GameStore();
        store.playedTime.put("Ваня", 4);
        store.playedTime.put("Саша", 1);
        store.playedTime.put("Маша", 5);
        store.playedTime.put("Аня", 2);
        store.playedTime.put("Лиза", 2);
        String actual = store.getMostPlayer();
        String expected = "Маша";
        assertEquals(expected, actual);
    }

    @Test
    public void getSumPlayedTimeNoGames() {
        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void getSumPlayedTimeOneGame() {
        GameStore store = new GameStore();
        store.playedTime.put("Ваня", 4);

        int actual = store.getSumPlayedTime();
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    public void getSumPlayedTimeTwoGames() {
        GameStore store = new GameStore();
        store.playedTime.put("Ваня", 4);
        store.playedTime.put("Маша", 5);

        int actual = store.getSumPlayedTime();
        int expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    public void getSumPlayedTimeSeveralGames() {
        GameStore store = new GameStore();
        store.playedTime.put("Ваня", 4);
        store.playedTime.put("Саша", 1);
        store.playedTime.put("Маша", 5);
        store.playedTime.put("Аня", 2);
        store.playedTime.put("Лиза", 2);

        int actual = store.getSumPlayedTime();
        int expected = 14;

        assertEquals(expected, actual);
    }
}



