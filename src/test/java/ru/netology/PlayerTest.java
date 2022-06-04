package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    //
    @Test
    public void shouldSumGenreIfOneGame() { //суммирует часы, если играет одну игра
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);//добавление игры игроку
        player.play(game, 3); //возвращает суммарное количество часов, проигранное в эту игру.

        int expected = 3;
        int actual = player.sumGenre(game.getGenre()); // суммирует время, проигранное во все игры этого жанра этим игроком
        assertEquals(expected, actual);
    }
    @Test
    public void shouldSumGenreIfTwoGame() { //суммирует часы если играет две игры
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Бравар страр", "Аркады");


        Player player = new Player("Petya");
        player.installGame(game);//добавление игры игроку
        player.installGame(game1);
        player.play(game, 3);//возвращает суммарное количество часов, проигранное в эту игру.
        player.play(game1, 4);


        int expected = 7;
        int actual = player.sumGenre(game.getGenre()); // суммирует время, проигранное во все игры этого жанра этим игроком
        assertEquals(expected, actual);
    }
    @Test
    public void shouldSumGenreIfGameNotInstalled() { //исключение,если игру не добавили
        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Бравар страр", "Аркады");
        Game game2 = store.publishGame("Игра", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);//добавление игры игроку
        player.installGame(game1);

        player.play(game, 3);//возвращает суммарное количество часов, проигранное в эту игру.
        player.play(game1, 4);

        assertThrows(RuntimeException.class, () -> {player.play(game2,5);});
    }

//    @Test
//    public void shouldInstallGame() { //добавление игры игроку
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        Player player = new Player("Petya");
//        player.installGame(game);//добавление игры игроку
//
//        assertTrue(store.games.contains(game));
//    }



//    @Test
//    public void shouldPlayGameIfOneGame() { //тест-м метод play
//        GameStore store = new GameStore();
//        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
//
//        Player player = new Player("Petya");
//        player.installGame(game);//добавление игры игроку
//
//        int expected = 4;
//        int actual = player.play(game, 4); // суммирует время, проигранное во все игры этого жанра этим игроком
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldReturnGame() { //возвращает игру однгого жанра, в которую играли больше всего
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Бравар страр", "Аркады");
        Game game2 = store.publishGame("Игра", "Аркады");


        Player player = new Player("Petya");
        player.installGame(game);//добавление игры игроку
        player.installGame(game1);
        player.installGame(game2);

        player.play(game, 3);//возвращает суммарное количество часов, проигранное в эту игру.
        player.play(game1, 4);
        player.play(game2, 8);


        Game actual = player.mostPlayerByGenre(game.getGenre());
        assertEquals(actual,game2);
    }

    @Test
    public void shouldReturnGameIfAnotherGenre() { //возвращает игру однгого жанра, в которую играли больше всего
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Бравар страр", "Аркады");
        Game game2 = store.publishGame("Игра", "Аркады");
        Game game3= store.publishGame("Игра1", "Жанр");


        Player player = new Player("Petya");
        player.installGame(game);//добавление игры игроку
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game, 3);//возвращает суммарное количество часов, проигранное в эту игру.
        player.play(game1, 4);
        player.play(game2, 8);
        player.play(game3, 10);


       Game actual = player.mostPlayerByGenre(game.getGenre());
       assertEquals(actual,game2);
    }
}


