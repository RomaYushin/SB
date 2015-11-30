/*
 * %W% %E% Yushin Roman (Юшин Роман)
 *
 * Copyright (c) since 2015 free programm.
 *
 *  Это программное обеспечение находиться в свободном доступе и любой может им воспользоваться. Разработчик
 *  данного программного обеспечения -  Юшин Роман, начинающий Java программист (yushin.khpi@gmail.com).
 *  Данное программное обеспечение разработано с целью самообучения.
 */

package SeaBattle_V25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Описание класса: Данныей класс предназначен для выполнения подготовительных операций перед игрой.
 * А именно: запрос имени у игрока, генерирования поля игрока, генерирования поля компьютера, внесение в поле игрока
 * и компьютера кораблей, границ кораблей, вывод координат кораблей игрока в консоль. А также передача действий классу
 * Gamer, где игрок сможет сделать свой первый ход.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Preparation {

    /** gamerName - статическая переменная типа String, хранящая имя игрока*/
    static String gamerName;

    /**
     * private Map<String, Integer> usedBattlefieldGamer - коллекция, которая хранит координаты (key) и значения (value),
     * по котрым уже делал свой ход КОМПЬЮТЕР. (Т.е. коллекция координат игрока, которые открыл компьютер).
     * Например компьютер делает ход A1. Эта координата заноситься в данную коллекцию, и в следующий ход компьютер
     * не сможет "стрелять" по этой координате. Также в эту коллекцию заносятся значения потопленных кораблей,
     * и их граничных значений.
     */
    private Map<String, Integer> usedBattlefieldGamer;

    /**
     * private Map<String, Integer> usedBattlefieldComp - коллекция, которая хранит координаты (key) и значения (value),
     * по котрым уже делал свой ход ИГРОК. (Т.е. коллекция координат компьютера, которые открыл игрок).
     * Например игрок делает ход B5. Эта координата заноситься в данную коллекцию, и в следующий ход игрок
     * не сможет "стрелять" по этой координате. Также в эту коллекцию заносятся значения потопленных кораблей,
     * и их граничных значений.
     */
    private Map<String, Integer> usedBattlefieldComp;

    /**
     * private ArrayList<String> compInputWound - коллекция, которая хранит координаты (key) и значения (value),
     * подбитых кораблей игрока. Компьютер делает свой ход хаотично. Если он подбивает какой-то из кораблей, то в
     * следующий ход ему необходимо выбрать одну из четырех (трех, двух, в зависимости от расположения) координат ,
     * а не стрелять хаотично. Поэтому координаты подбитых кораблей и заноситься в данную коллекцию. После потопления
     * корабля все пары удаляются.
     */
    private ArrayList<String> compInputWound;

    /**
     * public void preparationGame() - метод, выполняющий подготовку к игре. А именно:
     * - запрос имени игрока;
     * - вызов методов из класса Battlefield, формирующих поле для игры игрока и компьютера
     *   (b.createOfGamerBattlefield(), b.createOfCompBattlefield() соответственно);
     * - случайное формирование координат кораблей, границ кораблей для поля игрока и поля компьютера. Числа,
     *   являющиеся аргументами для конструктов классов Deck1, Deck2, Deck3, Deck4 описаны в классе Main.
     * - передача хода игроку (класс Gamer):
     *   Gamer.gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
     *
     * @throws IOException
     */
    public void preparationGame() throws IOException {

        usedBattlefieldGamer = new HashMap<String, Integer>();
        usedBattlefieldComp = new HashMap<String, Integer>();
        compInputWound = new ArrayList<>();

        System.out.println("-------------------- ИГРА МОРСКОЙ БОЙ ПРИВЕТСТВУЕТ ВАС! -------------------");
        System.out.print("Введите свое имя: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            gamerName = reader.readLine();
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
        }

        // ------------------------------   РАССТАНОВКА КОРАБЛЕЙ ДЛЯ ИГРОКА   ------------------------------
        // + Подготовка к игре. Создание поля для игры. Вывести сообщение об успешном завершении операции.
        Battlefield b = new Battlefield();
        Map battlefieldGamer = b.createOfGamerBattlefield();
        //System.out.println("Поле игры ИГРОКА сформировано.");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на поле для игры 4-х палубный корабль. Вывести сообщение об успешном завершении операции.
        Deck4 deck4Gamer = new Deck4(new int[]{411, 412, 413, 414}, 41); // передача в конструктор значений (value) четырехпалубного корабля.
        battlefieldGamer = deck4Gamer.genCoordDeck4(battlefieldGamer); // установка координат корабля
        battlefieldGamer = deck4Gamer.genLimitCoordDeck4(battlefieldGamer); // установка координат границы корабля
        System.out.print("Координаты Вашего 4-х палубного корабля №1: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(411) || battlefieldGamer.get(s).equals(412) || battlefieldGamer.get(s).equals(413) || battlefieldGamer.get(s).equals(414)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: 4-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 3-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck3 deck3_1Gamer = new Deck3(new int[]{311, 312, 313}, 31, 1);
        battlefieldGamer = deck3_1Gamer.genCoordDeck3(battlefieldGamer);
        battlefieldGamer = deck3_1Gamer.genLimitCoordDeck3(battlefieldGamer);
        System.out.print("Координаты Вашего 3-х палубного корабля №1: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(311) || battlefieldGamer.get(s).equals(312) || battlefieldGamer.get(s).equals(313)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: первый 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck3 deck3_2Gamer = new Deck3(new int[]{321, 322, 323}, 32, 2);
        battlefieldGamer = deck3_2Gamer.genCoordDeck3(battlefieldGamer);
        battlefieldGamer = deck3_2Gamer.genLimitCoordDeck3(battlefieldGamer);
        System.out.print("Координаты Вашего 3-х палубного корабля №2: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(321) || battlefieldGamer.get(s).equals(322) || battlefieldGamer.get(s).equals(323)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: второй 3-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 2-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck2 deck2_1Gamer = new Deck2(new int[]{211, 212}, 21, 1);
        battlefieldGamer = deck2_1Gamer.genCoordDeck2(battlefieldGamer);
        battlefieldGamer = deck2_1Gamer.genLimitCoordDeck2(battlefieldGamer);
        System.out.print("Координаты Вашего 2-х палубного корабля №1: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(211) || battlefieldGamer.get(s).equals(212)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: первый 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck2 deck2_2Gamer = new Deck2(new int[]{221, 222}, 22, 2);
        battlefieldGamer = deck2_2Gamer.genCoordDeck2(battlefieldGamer);
        battlefieldGamer = deck2_2Gamer.genLimitCoordDeck2(battlefieldGamer);
        System.out.print("Координаты Вашего 2-х палубного корабля №2: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(221) || battlefieldGamer.get(s).equals(222)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: второй 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck2 deck2_3Gamer = new Deck2(new int[]{231, 232}, 23, 3);
        battlefieldGamer = deck2_3Gamer.genCoordDeck2(battlefieldGamer);
        battlefieldGamer = deck2_3Gamer.genLimitCoordDeck2(battlefieldGamer);
        System.out.print("Координаты Вашего 2-х палубного корабля №3: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(231) || battlefieldGamer.get(s).equals(232)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: третий 2-х палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        System.out.println("");
        //------------------------------------------------------------------------------------------
        // + расставь на нем 1-оно палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck1 deck1_1Gamer = new Deck1(new int[]{111}, 11, 1);
        battlefieldGamer = deck1_1Gamer.genCoordDeck1(battlefieldGamer);
        battlefieldGamer = deck1_1Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.print("Координаты Вашего 1-но палубного корабля №1: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(111)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: первый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_2Gamer = new Deck1(new int[]{121}, 12, 2);
        battlefieldGamer = deck1_2Gamer.genCoordDeck1(battlefieldGamer);
        battlefieldGamer = deck1_2Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.print("Координаты Вашего 1-но палубного корабля №2: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(121)) {
                    System.out.print(s + " ");
                }
            }
        }

        //System.out.println("Информационное сообщение: второй 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_3Gamer = new Deck1(new int[]{131}, 13, 3);
        battlefieldGamer = deck1_3Gamer.genCoordDeck1(battlefieldGamer);
        battlefieldGamer = deck1_3Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.print("Координаты Вашего 1-но палубного корабля №3: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(131)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: третий 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");

        Deck1 deck1_4Gamer = new Deck1(new int[]{141}, 14, 4);
        battlefieldGamer = deck1_4Gamer.genCoordDeck1(battlefieldGamer);
        battlefieldGamer = deck1_4Gamer.genLimitCoordDeck1(battlefieldGamer);
        System.out.print("Координаты Вашего 1-но палубного корабля №4: ");
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (battlefieldGamer.get(s).equals(141)) {
                    System.out.print(s + " ");
                }
            }
        }
        //System.out.println("Информационное сообщение: четрвертый 1-но палубный корабль ИГРОКА на своей позиции. Готов вести огонь!");
        System.out.println("");
        System.out.println("");

        // ------------------------------   РАССТАНОВКА КОРАБЛЕЙ ДЛЯ КОМПЬЮТЕРА  ------------------------------
        //System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        // + Подготовка к игре. Создание поля для игры. Вывести сообщение об успешном завершении операции.
        Map battlefieldComp = b.createOfCompBattlefield();
        //System.out.println("Поле игры КОМПЬЮТЕРА сформировано.");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на поле для игры 4-х палубный корабль. Вывести сообщение об успешном завершении операции.
        Deck4 deck4Comp = new Deck4(new int[]{451, 452, 453, 454}, 45);
        battlefieldComp = deck4Comp.genCoordDeck4(battlefieldComp); // установка координат корабля
        battlefieldComp = deck4Comp.genLimitCoordDeck4(battlefieldComp); // установка координат границы корабля
        //System.out.println("Информационное сообщение: 4-х палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 3-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck3 deck3_1Comp = new Deck3(new int[]{351, 352, 353}, 35, 1);
        battlefieldComp = deck3_1Comp.genCoordDeck3(battlefieldComp);
        battlefieldComp = deck3_1Comp.genLimitCoordDeck3(battlefieldComp);
        //System.out.println("Информационное сообщение: первый 3-х палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck3 deck3_2Comp = new Deck3(new int[]{361, 362, 363}, 36, 2);
        battlefieldComp = deck3_2Comp.genCoordDeck3(battlefieldComp);
        battlefieldComp = deck3_2Comp.genLimitCoordDeck3(battlefieldComp);
        //System.out.println("Информационное сообщение: второй 3-х палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 2-х палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck2 deck2_1Comp = new Deck2(new int[]{251, 252}, 25, 1);
        battlefieldComp = deck2_1Comp.genCoordDeck2(battlefieldComp);
        battlefieldComp = deck2_1Comp.genLimitCoordDeck2(battlefieldComp);
        //System.out.println("Информационное сообщение: первый 2-х палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck2 deck2_2Comp = new Deck2(new int[]{261, 262}, 26, 2);
        battlefieldComp = deck2_2Comp.genCoordDeck2(battlefieldComp);
        battlefieldComp = deck2_2Comp.genLimitCoordDeck2(battlefieldComp);
        //System.out.println("Информационное сообщение: второй 2-х палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck2 deck2_3Comp = new Deck2(new int[]{271, 272}, 27, 3);
        battlefieldComp = deck2_3Comp.genCoordDeck2(battlefieldComp);
        battlefieldComp = deck2_3Comp.genLimitCoordDeck2(battlefieldComp);
        //System.out.println("Информационное сообщение: третий 2-х палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        System.out.println("");

        //------------------------------------------------------------------------------------------
        // + расставь на нем 1-оно палубные корабли. Вывести сообщение об успешном завершении операции.
        Deck1 deck1_1Comp = new Deck1(new int[]{151}, 15, 1);
        battlefieldComp = deck1_1Comp.genCoordDeck1(battlefieldComp);
        battlefieldComp = deck1_1Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: первый 1-но палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_2Comp = new Deck1(new int[]{161}, 16, 2);
        battlefieldComp = deck1_2Comp.genCoordDeck1(battlefieldComp);
        battlefieldComp = deck1_2Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: второй 1-но палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_3Comp = new Deck1(new int[]{171}, 17, 3);
        battlefieldComp = deck1_3Comp.genCoordDeck1(battlefieldComp);
        battlefieldComp = deck1_3Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: третий 1-но палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        Deck1 deck1_4Comp = new Deck1(new int[]{181}, 18, 4);
        battlefieldComp = deck1_4Comp.genCoordDeck1(battlefieldComp);
        battlefieldComp = deck1_4Comp.genLimitCoordDeck1(battlefieldComp);
        //System.out.println("Информационное сообщение: четрвертый 1-но палубный корабль КОМПЬЮТЕРА на своей позиции. Готов вести огонь!");
        //System.out.println("");

        System.out.println("------------------------------- НАЧАЛО ИГРЫ -------------------------------");
        Gamer.gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
    }
}