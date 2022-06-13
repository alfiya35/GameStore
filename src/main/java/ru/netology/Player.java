package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;  //Имя игрока

    /**
     * информация о том, в какую игру сколько часов было сыграно
     * ключ - игра
     * значение - суммарное количество часов игры в эту игру
     */
    public Map<Game, Integer> playedTime = new HashMap<>();

    public Player(String name) { //Конструктор игрока, принимающий в значения имя игрока
        this.name = name;
    }

    public String getName() { //Геттер, примиает имя игрока
        return name;
    }

    /**
     * добавление игры игроку
     * если игра уже была, никаких изменений происходить не должно
     */

    public void installGame(Game game) {
        if (!playedTime.containsKey(game)) {
            playedTime.put(game, 0);
        }
    }

    /**
     * игрок играет в игру game на протяжении hours часов
     * об этом нужно сообщить объекту-каталогу игр, откуда была установлена игра
     * также надо обновить значения в мапе игрока, добавив проигранное количество часов
     * возвращает суммарное количество часов, проигранное в эту игру.
     * если игра не была установлена, то надо выкидывать RuntimeException
     */

    public int play(Game game, int hours) {
        game.getStore().addPlayTime(name, hours);
        if (playedTime.containsKey(game)) {
            playedTime.put(game, playedTime.get(game) + hours);
        } else {
            throw new RuntimeException("Игра не установлена");
        }
        return playedTime.get(game);
    }

    /**
     * Метод принимает жанр игры (одно из полей объекта игры) и
     * суммирует время, проигранное во все игры этого жанра этим игроком
     */
    public int sumGenre(String genre) {
        int sum = 0;
        for (Game game : playedTime.keySet()) {
            if (game.getGenre().equals(genre)) {
                sum += playedTime.get(game);
            }
        }
        if (sum == 0) { // не играл в игры этого жанра
            throw new RuntimeException("Игрок не играл в игры этого жанра");
        } else {
            return sum;
        }
    }

    /**
     * Метод принимает жанр и возвращает игру этого жанра, в которую играли больше всего
     * Если в игры этого жанра не играли, возвращается null
     */
    public Game mostPlayerByGenre(String genre) {
        Game mostPlayedGame = null;
        int time = 0;
        for (Game game : playedTime.keySet()) {
            if (game.getGenre().equals(genre)) {
                if (playedTime.get(game) >= time){
                    mostPlayedGame = game;
                    time = playedTime.get(game);
                }
            }
        }
        return mostPlayedGame;
    }
}