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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * Comp - компьютер
 * Описание класса: данный класс предназначен для выполнения хода компьютера, передаче хода игроку в случае промаха
 * или передаче хода классу EndGame в случае победы компьютера. В классе есть методы compMove,
 * compDeck1SinkOrWound, createRandomCoordForWoundShip.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Comp {

    /**
     * static private Map <String, Integer> limitCoordDeck1 - вспомогательня коллекция в ключах (key) которой
     * храняться координаты границ однопалубных кораблей. В значениях (value) храняться соответствующие числа.
     * После того, как топиться однопалубный корабль, вызывается метод генерации границ однопалубного корабля, чтобы
     * полученные значения могли внести в коллекцию коллекцию уже открытых (использованных) координат
     * Map usedBattlefieldGamer. Данная коллекция перезаписывается при каждом новом потоплении однопалубного корабля.
     */
    static private Map <String, Integer> limitCoordDeck1;

    /**
     * static private Map <String, Integer> limitCoordDeck2 - см комментарий к коллекции limitCoordDeck1, отличие
     * только в том, что это относиться к двухпалубным кораблям.
     */
    static private Map <String, Integer> limitCoordDeck2;

    /**
     * static private Map <String, Integer> limitCoordDeck3 - см комментарий к коллекции limitCoordDeck1, отличие
     * только в том, что это относиться к трехпалубным кораблям.
     */
    static private Map <String, Integer> limitCoordDeck3;

    /**
     * static private Map <String, Integer> limitCoordDeck4 - см комментарий к коллекции limitCoordDeck1, отличие
     * только в том, что это относиться к четырехпалубному кораблю.
     */
    static private Map <String, Integer> limitCoordDeck4;

    /**
     * int valueOfBattlefieldGamer - хранит в себе число, характерезующее координату, по которой "стрельнул" корабль
     * Компьютер генерирует случайную координату, например B3. Как узнать находиться ли там корабль, либо компьютер
     * промахнулся. Для этого смотрим, какое же число находиться в коллекции battlefieldGamer (value) по координате B3.
     * Там 411. Вот это число мы заносим в данную переменную. Дополнительную информацию можно получить в описании класса
     * Main.
     */
    static private int valueOfBattlefieldGamer;

    /**
     * String randomCompCoord - переменная, хранящая в себе случайно сгенерированную координату - ход компьютера.
     * Например A1, G5...
     */
    static private String randomCompCoord;

    /**
     * int limitDeck1 - вспомогательная переменная, хранящая в себе число - границу однопалубного корабля.
     * Используется в качестве аргумента метода compDeck1SinkOrWound.
     */
    static private int limitDeck1;

    /**
     * int serialNumberOfDeck1 - переменная, хранящая в себе число - порядковый номер однопалубного корабля.
     * Т.к. однопалубных кораблей - четыре.
     */
    static private int serialNumberOfDeck1;


    /**
     * compMove - основной метод для данного класса. В нем компьютер генерирует случайную координату, проверяет
     * ноходиться ли по этой координате корабль игрока, либо компьютер промахнулся. В зависимости от этого производяться
     * дальнейшие действия: передача хода игроку, либо повторный ход, либо вывод сообщения о победе и передача
     * действий методу EndGame. Состоит из четырех подчастей разделенных условием if else. Необходимый блок кода
     * выбирается в зависимости от того, какое количество координат находиться в коллекции compInputWound: 0, 2, 3, 4.
     *
     * !! В данной версии программы разработчик так и не смог объеденить все в один код, чтобы не разделять на четыре
     * участка. Уверен, в будущих версиях программы логика будет изменена на более универсальную.
     *
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении кораблей игрока
     * @param battlefieldComp - коллекция, хранящая информацию о расположении кораблей компьютера
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже использованных ("стреляных")
     *                               координатах КОМПЬЮТЕРА
     * @param usedBattlefieldComp - коллекция, хранящая информацию об уже использованных ("стреляных")
     *                              координатах ИГРОКА
     * @param compInputWound - коллекция, хранящая информацию о раненом корабле.
     * @throws IOException
     */
    public static void compMove (Map battlefieldGamer, Map battlefieldComp, Map usedBattlefieldGamer, Map usedBattlefieldComp, ArrayList <String> compInputWound) throws IOException {

        //System.out.println("usedBattlefieldComp" + usedBattlefieldComp.size()); // для отладки
        //System.out.println("usedBattlefieldGamer" + usedBattlefieldGamer.size()); // для отладки
        //System.out.println("compInputWound.size()" + compInputWound.size()); // для отладки

        if (       usedBattlefieldGamer.containsValue(111)
                && usedBattlefieldGamer.containsValue(121)
                && usedBattlefieldGamer.containsValue(131)
                && usedBattlefieldGamer.containsValue(141)
                && usedBattlefieldGamer.containsValue(211)
                && usedBattlefieldGamer.containsValue(212)
                && usedBattlefieldGamer.containsValue(221)
                && usedBattlefieldGamer.containsValue(222)
                && usedBattlefieldGamer.containsValue(231)
                && usedBattlefieldGamer.containsValue(232)
                && usedBattlefieldGamer.containsValue(311)
                && usedBattlefieldGamer.containsValue(312)
                && usedBattlefieldGamer.containsValue(313)
                && usedBattlefieldGamer.containsValue(321)
                && usedBattlefieldGamer.containsValue(322)
                && usedBattlefieldGamer.containsValue(323)
                && usedBattlefieldGamer.containsValue(411)
                && usedBattlefieldGamer.containsValue(412)
                && usedBattlefieldGamer.containsValue(413)
                && usedBattlefieldGamer.containsValue(414)) {

            System.out.println("Игра закончена!");
            System.out.println("ПОБЕДИЛ КОМПЬЮТЕР!!!");
            EndGame eGC = new EndGame();
            eGC.endGame();
        }
        // следующая строка для помощи в ориентировании, в какой части метода находимся
        // compInputWound.size() == 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
        if (compInputWound.size() == 0) {
            try {
                //System.out.println("usedBattlefieldComp" + usedBattlefieldComp.size()); // для отладки
                //System.out.println("usedBattlefieldGamer" + usedBattlefieldGamer.size()); // для отладки
                Ships ships = new Ships();
                randomCompCoord = Character.toString((char) ships.mFirstRandomNumberForLetter()) + ships.mFirstRandomNumberForNumber();

                //System.out.println("Компьютер, сделай свой ход: "); // для отладки
                //randomCompCoord = reader.readLine(); // для отладки

                if (battlefieldComp.containsKey(randomCompCoord)) {
                } else {
                    //System.out.println("Компьютер ввел недопустимое значение!");
                    System.out.println("");
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

            if (usedBattlefieldGamer.containsKey(randomCompCoord)) {
                //System.out.println("Компьютер уже стреляли по этой координате!");
                compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
            }

            try {
                System.out.println("Компьютер думает...");
                Thread.sleep(1500); // Задержка в 1.5 сек для имитации обдумывания компьютером следубщего хода
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.print("Компьютер сделал свой ход: " + randomCompCoord);
            System.out.println("");

            valueOfBattlefieldGamer = (int) battlefieldGamer.get(randomCompCoord);
            usedBattlefieldGamer.put(randomCompCoord, valueOfBattlefieldGamer);
            //System.out.println(usedBattlefieldGamer.keySet()); // для отладки
            //System.out.println(valueOfBattlefieldGamer); // для отладки
            switch (valueOfBattlefieldGamer) {
                case 0:
                case 11:
                case 12:
                case 13:
                case 14:
                case 21:
                case 22:
                case 23:
                case 31:
                case 32:
                case 41:

                    System.out.println("Компьютер, МИМО!"/*  +  compInputWound.size() == "*/);
                    System.out.println("");

                    Gamer.gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 111:
                case 121:
                case 131:
                case 141:
                    switch (valueOfBattlefieldGamer) {
                        case 111:
                            limitDeck1 = 11;
                            serialNumberOfDeck1 = 1;
                            break;
                        case 121:
                            limitDeck1 = 12;
                            serialNumberOfDeck1 = 2;
                            break;
                        case 131:
                            limitDeck1 = 13;
                            serialNumberOfDeck1 = 3;
                            break;
                        case 141:
                            limitDeck1 = 14;
                            serialNumberOfDeck1 = 4;
                            break;
                    }
                    usedBattlefieldGamer = compDeck1SinkOrWound(usedBattlefieldGamer, battlefieldGamer, limitDeck1, serialNumberOfDeck1);
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 211:
                case 212:
                case 221:
                case 222:
                case 231:
                case 232:
                    switch (valueOfBattlefieldGamer) {
                        case 211:
                        case 212:
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                            break;
                        case 221:
                        case 222:
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                            break;

                        case 231:
                        case 232:
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                            break;
                    }

                    compInputWound.add(0, randomCompCoord);
                    compInputWound = createRandomCoordForWoundShip(randomCompCoord, compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);

                    break;
                case 311:
                case 312:
                case 313:
                case 321:
                case 322:
                case 323:
                    switch (valueOfBattlefieldGamer) {
                        case 311:
                        case 312:
                        case 313:
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                            break;
                        case 321:
                        case 322:
                        case 323:
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                            break;
                    }
                    compInputWound.add(0, randomCompCoord);
                    compInputWound = createRandomCoordForWoundShip(randomCompCoord, compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 411:
                case 412:
                case 413:
                case 414:
                    System.out.println("ПОДБИТ КОРАБЛЬ!");
                    System.out.println("");

                    compInputWound.add(0, randomCompCoord);
                    compInputWound = createRandomCoordForWoundShip(randomCompCoord, compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                default:
                    System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 0!!!");
            }
        // следующая строка для помощи в ориентировании, в какой части метода находимся
        // compInputWound.size() == 2   22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
        } else if (compInputWound.size() == 2) {

            try {
                System.out.println("Компьютер думает...");
                Thread.sleep(1500); // Задержка в 1.5 сек для имитации обдумывания компьютером следубщего хода
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.print("Компьютер сделал свой ход после единожды подбитого корабля: " + compInputWound.get(1));
            System.out.println("");
            valueOfBattlefieldGamer = (int) battlefieldGamer.get(compInputWound.get(1));
            //System.out.println(valueOfBattlefieldGamer);
            usedBattlefieldGamer.put(compInputWound.get(1), valueOfBattlefieldGamer);
            //System.out.println(usedBattlefieldGamer.keySet());
            switch (valueOfBattlefieldGamer) {
                case 0:
                case 11:
                case 12:
                case 13:
                case 14:
                case 21:
                case 22:
                case 23:
                case 31:
                case 32:
                case 41:
                    System.out.println("Компьютер, МИМО!" /* +  compInputWound.size() == 2"*/);
                    System.out.println("");
                    compInputWound.remove(1);
                    //usedBattlefieldGamer.put(compInputWound.get(0), valueOfBattlefieldGamer);
                    compInputWound = createRandomCoordForWoundShip(compInputWound.get(0), compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    Gamer.gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 211:
                case 212:
                case 221:
                case 222:
                case 231:
                case 232:
                    switch (valueOfBattlefieldGamer) {
                        case 211:
                        case 212:
                            System.out.println("ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ №1!");
                            //System.out.println("Выводим границы корабля: ");
                            Deck2 deck2_1 = new Deck2(21, 1);
                            limitCoordDeck2 = deck2_1.genLimitCoordDeck2(battlefieldGamer);

                            // добавляем границы корабля в массив usedBattlefieldGamer
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck2.get(s) == 21) {
                                        usedBattlefieldGamer.put(s, 21);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldGamer.values());
                            System.out.println("");
                            compInputWound.clear();
                            break;
                        case 221:
                        case 222:
                            // выводим сообщение на экран и
                            System.out.println("ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ №2!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck2 deck2_2 = new Deck2(22, 2);
                            limitCoordDeck2 = deck2_2.genLimitCoordDeck2(battlefieldGamer);

                            // добавляем границы корабля в массив usedBattlefieldGamer
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck2.get(s) == 22) {
                                        usedBattlefieldGamer.put(s, 22);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldGamer.values());
                            System.out.println("");
                            compInputWound.clear();

                            break;
                        case 231:
                        case 232:
                            // выводим сообщение на экран и
                            System.out.println("ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ №3!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck2 deck2 = new Deck2(23, 3);
                            limitCoordDeck2 = deck2.genLimitCoordDeck2(battlefieldGamer);

                            // добавляем границы корабля в массив usedBattlefieldGamer
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck2.get(s) == 23) {
                                        usedBattlefieldGamer.put(s, 23);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldGamer.values());
                            System.out.println("");
                            compInputWound.clear();

                            break;
                    }
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 311:
                case 312:
                case 313:
                case 321:
                case 322:
                case 323:
                    switch (valueOfBattlefieldGamer) {
                        case 311:
                        case 312:
                        case 313:
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                            break;
                        case 321:
                        case 322:
                        case 323:
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                            break;
                    }
                    compInputWound = createRandomCoordForWoundShip(compInputWound.get(1), compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 411:
                case 412:
                case 413:
                case 414:
                    System.out.println("ПОДБИТ КОРАБЛЬ!");
                    System.out.println("");
                    compInputWound = createRandomCoordForWoundShip(compInputWound.get(1), compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                default:
                    System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 2!!!");
            }
            // следующая строка для помощи в ориентировании, в какой части метода находимся
            // compInputWound.size() == 3   333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
        } else if (compInputWound.size() == 3) {

            try {
                System.out.println("Компьютер думает...");
                Thread.sleep(1500);  // Задержка в 1.5 сек для имитации обдумывания компьютером следубщего хода
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.print("Компьютер сделал свой ход после дважды подбитого корабля: " + compInputWound.get(2));
            System.out.println("");
            valueOfBattlefieldGamer = (int) battlefieldGamer.get(compInputWound.get(2));
            //System.out.println(valueOfBattlefieldGamer);
            usedBattlefieldGamer.put(compInputWound.get(2), valueOfBattlefieldGamer);
            //System.out.println(usedBattlefieldGamer.keySet());
            switch (valueOfBattlefieldGamer) {
                case 0:
                case 11:
                case 12:
                case 13:
                case 14:
                case 21:
                case 22:
                case 23:
                case 31:
                case 32:
                case 41:
                    System.out.println("Компьютер, МИМО!"  /*+  compInputWound.size() == 3"*/);
                    System.out.println("");
                    compInputWound.remove(2);
                    compInputWound = createRandomCoordForWoundShip(compInputWound.get(1), compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    Gamer.gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;

                case 311:
                case 312:
                case 313:
                case 321:
                case 322:
                case 323:
                    switch (valueOfBattlefieldGamer) {
                        case 311:
                        case 312:
                        case 313:
                            // выводим сообщение на экран и записываем в
                            System.out.println("ПОТОПЛЕН ТРЕХПАЛУБНЫЙ КОРАБЛЬ №1!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck3 deck3_1 = new Deck3(31, 1);
                            limitCoordDeck3 = deck3_1.genLimitCoordDeck3(battlefieldGamer);

                            // добавляем границы корабля в массив usedBattlefieldGamer
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck3.get(s) == 31) {
                                        usedBattlefieldGamer.put(s, 31);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldGamer.values());
                            System.out.println("");
                            compInputWound.clear();

                            break;
                        case 321:
                        case 322:
                        case 323:
                            usedBattlefieldGamer.put(randomCompCoord, battlefieldGamer.get(randomCompCoord));
                            // выводим сообщение на экран и записываем в
                            System.out.println("ПОТОПЛЕН ТРЕХПАЛУБНЫЙ КОРАБЛЬ №2!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck3 deck3_2 = new Deck3(32, 2);
                            limitCoordDeck3 = deck3_2.genLimitCoordDeck3(battlefieldGamer);

                            // добавляем границы корабля в массив usedBattlefieldGamer
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck3.get(s) == 32) {
                                        usedBattlefieldGamer.put(s, 32);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldGamer.values());
                            System.out.println("");
                            compInputWound.clear();
                            break;
                    }
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 411:
                case 412:
                case 413:
                case 414:
                    System.out.println("ПОДБИТ КОРАБЛЬ!");
                    System.out.println("");
                    compInputWound = createRandomCoordForWoundShip(compInputWound.get(2), compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                default:
                    System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 3!!!");
            }
            // следующая строка для помощи в ориентировании, в какой части метода находимся
            // compInputWound.size() == 4    44444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
        } else if (compInputWound.size() == 4) {

            try {
                System.out.println("Компьютер думает...");
                Thread.sleep(1500); // Задержка в 1.5 сек для имитации обдумывания компьютером следубщего хода
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.print("Компьютер сделал свой ход после трижды подбитого корабля: " + compInputWound.get(3));
            System.out.println("");
            valueOfBattlefieldGamer = (int) battlefieldGamer.get(compInputWound.get(3));
            //System.out.println(valueOfBattlefieldGamer);
            usedBattlefieldGamer.put(compInputWound.get(3), valueOfBattlefieldGamer);
            //System.out.println(usedBattlefieldGamer.keySet());
            switch (valueOfBattlefieldGamer) {
                case 0:
                case 11:
                case 12:
                case 13:
                case 14:
                case 21:
                case 22:
                case 23:
                case 31:
                case 32:
                case 41:
                    System.out.println("Компьютер, МИМО!" /* +  compInputWound.size() == 4*/);
                    System.out.println("");
                    compInputWound.remove(3);
                    compInputWound = createRandomCoordForWoundShip(compInputWound.get(2), compInputWound, battlefieldGamer, usedBattlefieldGamer);
                    Gamer.gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                case 411:
                case 412:
                case 413:
                case 414:
                    // выводим сообщение на экран и
                    System.out.println("ПОТОПЛЕН ЧЕТЫРЕХПАЛУБНЫЙ КОРАБЛЬ!");
                    //System.out.println("Выводим границы корабля: ");
                    // выводим границы корабля на экран
                    Deck4 deck4 = new Deck4(41);
                    limitCoordDeck4 = deck4.genLimitCoordDeck4(battlefieldGamer);
                    // добавляем границы корабля в массив usedBattlefieldGamer
                    for (char i = 65; i < 75; i++) {
                        for (int j = 1; j <= 10; j++) {
                            String s = String.valueOf(i) + j;
                            if (limitCoordDeck4.get(s) == 41) {
                                usedBattlefieldGamer.put(s, 41);
                            }
                        }
                    }

                    //System.out.println(usedBattlefieldGamer.values());
                    System.out.println("");
                    compInputWound.clear();
                    compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                    break;
                default:
                    System.out.println("ОШИБКА в определении значения переменной valueOfBattlefieldGamer для Gamer, compInputWound.size() == 4!!!");
            }
        }
    }
    // *************************************************************************************************************************************************************************************************************

    /**
     * compDeck1SinkOrWound - метод необходимый для: вывода сообщения об потоплении одного из однопалубных кораблей
     * ИГРОКА, вызова метода, который генерирует границы корабля, добавлении этих границ в коллекцию usedBattlefieldGamer,
     * чтобы исключить возможность повторного выстрела по использованной границе корабля.
     *
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже использованных ("стреляных")
     *                               координатах КОМПЬЮТЕРА
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении кораблей игрока
     * @param limitDeck1 - вспомогательная коллекция, хранящая информацию о граничных координатах однопалубных кораблей.
     * @param serialNumberOfDeck1 - порядковый номер однопалубного корабля.
     * @return - метод возвращает дополненную новыми значениями коллекцию usedBattlefieldGamer.
     *
     */
    public static Map compDeck1SinkOrWound (Map usedBattlefieldGamer, Map battlefieldGamer, int limitDeck1, int serialNumberOfDeck1 ) {


        System.out.println("ПОТОПЛЕН ОДНОПАЛУБНЫЙ КОРАБЛЬ!");
        //System.out.println("Выводим границы корабля: ");
        // выводим границы корабля на экран
        Deck1 deck1 = new Deck1(limitDeck1, serialNumberOfDeck1);
        limitCoordDeck1 = deck1.genLimitCoordDeck1(battlefieldGamer);

        // добавляем границы корабля в массив usedBattlefieldGamer
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (limitCoordDeck1.get(s) == limitDeck1) {
                    usedBattlefieldGamer.put(s, limitDeck1);
                }
            }
        }
        System.out.println("");

        return usedBattlefieldGamer;
    }

    /**
     * createRandomCoordForWoundShip - метод, генерирующий случайную координату после того, как один из кораблей ранен.
     * Метод разделен на три части оператором switch, если корабль подбит один раз, два раза, три раза соответственно.
     * От этого будет зависеть следующая случайная координата. Внутри выполняет проверки, на повторность хода.
     * Недопускает выпадания недопустимой или уже "стреляной" координаты.
     *
     * @param randomCompCoord - переменная, хранящая в себе случайно сгенерированную координату - ход компьютера.
     * @param compInputWound - коллекция, хранящая информацию раненом корабле.
     * @param battlefieldGamer - коллекция, хранящая информацию о расположении кораблей игрока
     * @param usedBattlefieldGamer - коллекция, хранящая информацию об уже использованных ("стреляных")
     *                               координатах КОМПЬЮТЕРА
     * @return - возвращает коллекцию с координатами подбитого корабля и новую случайно сгенерированную координату.
     */

    public static ArrayList <String> createRandomCoordForWoundShip (String randomCompCoord, ArrayList<String > compInputWound, Map battlefieldGamer, Map usedBattlefieldGamer) {

        /** String _1successfulCoord - переменная, хранящая координату, когда в первый раз корабль был ранен. */
        String _1successfulCoord;

        /** String _2successfulCoord - переменная, хранящая координату, когда во второй раз корабль был ранен. */
        String _2successfulCoord;

        /** String _3successfulCoord - переменная, хранящая координату, когда в третий раз корабль был ранен. */
        String _3successfulCoord;

        /**
         * String _1CoordForWoundShip - переменная, хранящая значение первой из четырех случайно сгенерированных
         * координат для следующего хода применяется только в case 1.
         */
        String _1CoordForWoundShip;

        /**
         * String _2CoordForWoundShip - переменная, хранящая значение второй из четырех случайно сгенерированных
         * координат для следующего хода применяется только в case 1.
         */
        String _2CoordForWoundShip;

        /**
         * String _3CoordForWoundShip - переменная, хранящая значение третий из четырех случайно сгенерированных
         * координат для следующего хода применяется только в case 1.
         */
        String _3CoordForWoundShip;

        /**
         * String _4CoordForWoundShip - переменная, хранящая значение четвертой из четырех случайно сгенерированных
         * координат для следующего хода применяется только в case 1.
         */
        String _4CoordForWoundShip;

        /**
         * int randomN - вспомогательная переменная, хранящая одно из четырех случайно выбранных чисел: 1, 2, 3, 4.
         * В зависимости от метода Math.random будет выбрана одна случайная координата из этих четырех чисел.
         */
        int randomN;

        /**
         * int letter1 - число, соответствующее по таблице Unicode букве первой координаты раненого корабля
         * (ведь координата соостоит из буквы и цифры). Например, если координата подбитого корабля A1, то число letter1
         * будет хранить значение 65 и т.д. для остальных букв. Это вспомогательная переменная, помогающая понять,
         * находиться ли корабль по вертикали или по горизонатли, и от этого формировать следующие возможные координаты.
         */
        int letter1;

        /**
         * int letter2 - число, соответствующее по таблице Unicode букве второй координаты раненого корабля
         * (ведь координата соостоит из буквы и цифры). Например, если координата подбитого корабля С1, то число letter2
         * будет хранить значение 67 и т.д. для остальных букв. Это вспомогательная переменная, помогающая понять,
         * находиться ли корабль по вертикали или по горизонатли, и от этого формировать следующие возможные координаты.
         */
        int letter2;

        /**
         * int letter3 - число, соответствующее по таблице Unicode букве третей координаты раненого корабля
         * (ведь координата соостоит из буквы и цифры). Например, если координата подбитого корабля D1, то число letter3
         * будет хранить значение 68 и т.д. для остальных букв. Это вспомогательная переменная, помогающая понять,
         * находиться ли корабль по вертикали или по горизонатли, и от этого формировать следующие возможные координаты.
         */
        int letter3;

        /**
         * int number1 - число, соответствующее цифре первой координаты раненого корабля.
         * (ведь координата соостоит из буквы и цифры). Это вспомогательная переменная, помогающая понять,
         * находиться ли корабль по вертикали или по горизонатли, и от этого формировать следующие возможные
         * координаты.
         */
        int number1;

        /**
         * int number2 - число, соответствующее цифре второй координаты раненого корабля.
         * (ведь координата соостоит из буквы и цифры). Это вспомогательная переменная, помогающая понять,
         * находиться ли корабль по вертикали или по горизонатли, и от этого формировать следующие возможные
         * координаты.
         */
        int number2;

        /**
         * int number3 - число, соответствующее цифре третей координаты раненого корабля.
         * (ведь координата соостоит из буквы и цифры). Это вспомогательная переменная, помогающая понять,
         * находиться ли корабль по вертикали или по горизонатли, и от этого формировать следующие возможные
         * координаты.
         */
        int number3;
        /*
        char [] charsArray;
        char n11;
        char n12;
        char n13;

        char n21;
        char n22;
        char n23;

        char n31;
        char n32;
        char n33;
        */

        /**
         * int previousLetter1 - вспомогательная переменная, показывающая предыдущую букву (в соответствии с Unicode)
         * относительно буквы координаты раненого корабля. Необходима для формирования одной из координат
         * для следующего хода компьютера.
         */
        int previousLetter1 = 0;

        /**
         * int nextLetter1 - вспомогательная переменная, показывающая следующую букву (в соответствии с Unicode)
         * относительно буквы координаты раненого корабля. Необходима для формирования одной из координат
         * для следующего хода компьютера.
         */
        int nextLetter1 = 0;

        /**
         * int previousNumber1 - вспомогательная переменная, показывающая предыдущую цифру
         * относительно цифры координаты раненого корабля. Необходима для формирования одной из координат
         * для следующего хода компьютера.
         */
        int previousNumber1 = 0;

        /**
         * int nextNumber1 - вспомогательная переменная, показывающая следующую цифру
         * относительно цифры координаты раненого корабля. Необходима для формирования одной из координат
         * для следующего хода компьютера.
         */
        int nextNumber1 = 0;


        /**
         * String randomCoordForWoundShip - итоговая сгенерировання случайным образом координата для следующего хода
         * компьютера. Заноситься в коллекцию compInputWound
         */
        String randomCoordForWoundShip = null;

        switch (compInputWound.size()) {
            // case 1   111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
            case 1:
                do {
                    if (       randomCompCoord.equals("A10")
                            || randomCompCoord.equals("B10")
                            || randomCompCoord.equals("C10")
                            || randomCompCoord.equals("D10")
                            || randomCompCoord.equals("E10")
                            || randomCompCoord.equals("E10")
                            || randomCompCoord.equals("F10")
                            || randomCompCoord.equals("G10")
                            || randomCompCoord.equals("H10")
                            || randomCompCoord.equals("I10")
                            || randomCompCoord.equals("J10")) {

                        letter1 = randomCompCoord.charAt(0);
                        number1 = 10;
                        //letter1 = randomCompCoord.charAt(0);
                        //n11 = randomCompCoord.charAt(1);
                        //n12 = randomCompCoord.charAt(2);
                        //n13 = (char) (n11 + n12);
                        //number1 = Character.getNumericValue(n13);

                    } else {
                        letter1 = randomCompCoord.charAt(0);
                        number1 = Character.getNumericValue(randomCompCoord.charAt(1));
                    }
                    previousLetter1 = letter1 - 1;
                    nextLetter1 = letter1 + 1;

                    previousNumber1 = number1 - 1;
                    nextNumber1 = number1 + 1;

                    _1CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(previousNumber1);
                    _2CoordForWoundShip = Character.toString((char) nextLetter1) + Integer.toString(number1);
                    _3CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(nextNumber1);
                    _4CoordForWoundShip = Character.toString((char) previousLetter1) + Integer.toString(number1);

                    /*System.out.println("Четыре новых координаты: ");
                    System.out.println(_1CoordForWoundShip);
                    System.out.println(_2CoordForWoundShip);
                    System.out.println(_3CoordForWoundShip);
                    System.out.println(_4CoordForWoundShip);*/

                    randomN = (int) (Math.random() * 4 + 1);

                    switch (randomN) {
                        case 1:
                            randomCoordForWoundShip = _1CoordForWoundShip;
                            break;
                        case 2:
                            randomCoordForWoundShip = _2CoordForWoundShip;
                            break;
                        case 3:
                            randomCoordForWoundShip = _3CoordForWoundShip;
                            break;
                        case 4:
                            randomCoordForWoundShip = _4CoordForWoundShip;
                            break;
                    }
                    //System.out.println("Выбранная случайно одна: " + randomCoordForWoundShip);
                } while ( battlefieldGamer.containsKey(randomCoordForWoundShip) == false || usedBattlefieldGamer.containsKey(randomCoordForWoundShip) == true);
                compInputWound.add(1, randomCoordForWoundShip);
                //System.out.println(compInputWound.size() + "внутри метода генерации координат!!!");
                break;
            // если два попадания удачны
            // case 2   22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
            case 2:
                do {
                    _1successfulCoord = compInputWound.get(0);
                    _2successfulCoord = compInputWound.get(1);

                    /*System.out.println("Входные координаты для случая, когда корабль подбит дважды");
                    System.out.println(_1successfulCoord);
                    System.out.println(_2successfulCoord);*/

                    //раскладывание первой координаты
                    if (_1successfulCoord.equals("A10")
                            || _1successfulCoord.equals("B10")
                            || _1successfulCoord.equals("C10")
                            || _1successfulCoord.equals("D10")
                            || _1successfulCoord.equals("E10")
                            || _1successfulCoord.equals("E10")
                            || _1successfulCoord.equals("F10")
                            || _1successfulCoord.equals("G10")
                            || _1successfulCoord.equals("H10")
                            || _1successfulCoord.equals("I10")
                            || _1successfulCoord.equals("J10")) {

                        letter1 = randomCompCoord.charAt(0);
                        number1 = 10;
                        /*letter1 = _1successfulCoord.charAt(0);
                        n11 = _1successfulCoord.charAt(1);
                        n12 = _1successfulCoord.charAt(2);
                        n13 = (char) (n11 + n12);
                        number1 = Character.getNumericValue(n13);*/

                    } else {
                        letter1 = _1successfulCoord.charAt(0);
                        number1 = Character.getNumericValue(_1successfulCoord.charAt(1));
                    }

                    //раскладывание второй координаты
                    if (_2successfulCoord.equals("A10")
                            || _2successfulCoord.equals("B10")
                            || _2successfulCoord.equals("C10")
                            || _2successfulCoord.equals("D10")
                            || _2successfulCoord.equals("E10")
                            || _2successfulCoord.equals("E10")
                            || _2successfulCoord.equals("F10")
                            || _2successfulCoord.equals("G10")
                            || _2successfulCoord.equals("H10")
                            || _2successfulCoord.equals("I10")
                            || _2successfulCoord.equals("J10")) {

                        letter2 = randomCompCoord.charAt(0);
                        number2 = 10;
                        /*letter2 = _2successfulCoord.charAt(0);
                        n21 = _2successfulCoord.charAt(1);
                        n22 = _2successfulCoord.charAt(2);
                        n23 = (char) (n21 + n22);
                        number2 = Character.getNumericValue(n23);*/

                    } else {
                        letter2 = _2successfulCoord.charAt(0);
                        number2 = Character.getNumericValue(_2successfulCoord.charAt(1));
                    }

                /*Необходимо определиться стоят координата вертикально или горизонтально вертикально или горизонтально
                 * если буквы равны, то корабль находиться вертикально
                 * если цифры равны, то корабль находиться горизонтально
                 */
                    if (letter1 == letter2) { // по вертикали
                        if (number1 < number2) {
                            previousNumber1 = number1 - 1;
                            nextNumber1 = number2 + 1;
                        } else if (number1 > number2) {
                            previousNumber1 = number2 - 1;
                            nextNumber1 = number1 + 1;
                        }

                        _1CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(previousNumber1);
                        _2CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(nextNumber1);

                        /*System.out.println("Две новых координаты, когда корабль подбит дважды по вертикали: ");
                        System.out.println(_1CoordForWoundShip);
                        System.out.println(_2CoordForWoundShip);*/

                        randomN = (int) (Math.random() * 2 + 1);

                        switch (randomN) {
                            case 1:
                                randomCoordForWoundShip = _1CoordForWoundShip;
                                break;
                            case 2:
                                randomCoordForWoundShip = _2CoordForWoundShip;
                                break;
                        }
                    } else if (number1 == number2) { // по горизонтали
                        if (letter1 < letter2) {
                            previousLetter1 = letter1 - 1;
                            nextLetter1 = letter2 + 1;
                        } else if (letter1 > letter2) {
                            previousLetter1 = letter2 - 1;
                            nextLetter1 = letter1 + 1;
                        }

                        _1CoordForWoundShip = Character.toString((char) previousLetter1) + Integer.toString(number1);
                        _2CoordForWoundShip = Character.toString((char) nextLetter1) + Integer.toString(number1);

                        /*System.out.println("Две новых координаты, когда корабль подбит дважды по горизонтали: ");
                        System.out.println(_1CoordForWoundShip);
                        System.out.println(_2CoordForWoundShip);*/

                        randomN = (int) (Math.random() * 2 + 1);

                        switch (randomN) {
                            case 1:
                                randomCoordForWoundShip = _1CoordForWoundShip;
                                break;
                            case 2:
                                randomCoordForWoundShip = _2CoordForWoundShip;
                                break;
                        }
                    } else {
                        //System.out.println("Ошибка в методе определения следующей координаты для двух поражений");
                    }

                    //System.out.println("Выбранная случайно одна: " + randomCoordForWoundShip);

                } while ( battlefieldGamer.containsKey(randomCoordForWoundShip) == false || usedBattlefieldGamer.containsKey(randomCoordForWoundShip) == true);
                compInputWound.add(2, randomCoordForWoundShip);
                break;
            //case 3   3333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
            case 3:
                /* Следующий код необходим для отладки:
                System.out.println("До сортировки координат");
                _1successfulCoord = compInputWound.get(0);
                _2successfulCoord = compInputWound.get(1);
                _3successfulCoord = compInputWound.get(2);

                //Сортировка по возростанию входных координат
                Collections.sort(compInputWound);

                //System.out.println("После сортировки координат");
                _1successfulCoord = compInputWound.get(0);
                _2successfulCoord = compInputWound.get(1);
                _3successfulCoord = compInputWound.get(2);*/
                Collections.sort(compInputWound);
                do {
                    _1successfulCoord = compInputWound.get(0);
                    _3successfulCoord = compInputWound.get(2);

                    /* Следующий код необходим для отладки:
                    System.out.println("Входные координаты для случая, когда корабль подбит трижды");
                    System.out.println(_1successfulCoord);
                    System.out.println(_2successfulCoord);
                    System.out.println(_3successfulCoord);*/

                    //раскладывание первой координаты
                    if (       _1successfulCoord.equals("A10")
                            || _1successfulCoord.equals("B10")
                            || _1successfulCoord.equals("C10")
                            || _1successfulCoord.equals("D10")
                            || _1successfulCoord.equals("E10")
                            || _1successfulCoord.equals("E10")
                            || _1successfulCoord.equals("F10")
                            || _1successfulCoord.equals("G10")
                            || _1successfulCoord.equals("H10")
                            || _1successfulCoord.equals("I10")
                            || _1successfulCoord.equals("J10")) {

                        letter1 = randomCompCoord.charAt(0);
                        number1 = 10;
                        /*letter1 = _1successfulCoord.charAt(0);
                        n11 = _1successfulCoord.charAt(1);
                        n12 = _1successfulCoord.charAt(2);
                        n13 = (char) (n11 + n12);
                        number1 = Character.getNumericValue(n13);*/

                    } else {
                        letter1 = _1successfulCoord.charAt(0);
                        number1 = Character.getNumericValue(_1successfulCoord.charAt(1));
                    }

                    //раскладывание третей координаты
                    if (       _3successfulCoord.equals("A10")
                            || _3successfulCoord.equals("B10")
                            || _3successfulCoord.equals("C10")
                            || _3successfulCoord.equals("D10")
                            || _3successfulCoord.equals("E10")
                            || _3successfulCoord.equals("E10")
                            || _3successfulCoord.equals("F10")
                            || _3successfulCoord.equals("G10")
                            || _3successfulCoord.equals("H10")
                            || _3successfulCoord.equals("I10")
                            || _3successfulCoord.equals("J10")) {

                        letter3 = randomCompCoord.charAt(0);
                        number3 = 10;
                        /*letter3 = _3successfulCoord.charAt(0);
                        n31 = _3successfulCoord.charAt(1);
                        n32 = _3successfulCoord.charAt(2);
                        n33 = (char) (n31 + n32);
                        number3 = Character.getNumericValue(n33);*/

                    } else {
                        letter3 = _3successfulCoord.charAt(0);
                        number3 = Character.getNumericValue(_3successfulCoord.charAt(1));
                    }

                /*Необходимо определиться стоят координата вертикально или горизонтально вертикально или горизонтально
                 * если буквы равны, то корабль находиться вертикально
                 * если цифры равны, то корабль находиться горизонтально
                 */
                    if (letter1 == letter3) {
                        if (number1 < number3) {
                            previousNumber1 = number1 - 2;
                            nextNumber1 = number3 + 1;
                        } else if (number1 > number3) {
                            previousNumber1 = number3 - 1;
                            nextNumber1 = number1 + 2;
                        }

                        _1CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(previousNumber1);
                        _2CoordForWoundShip = Character.toString((char) letter1) + Integer.toString(nextNumber1);

                        /*System.out.println("Две новых координаты ( если уже подбито две): ");
                        System.out.println(_1CoordForWoundShip);
                        System.out.println(_2CoordForWoundShip);*/

                        randomN = (int) (Math.random() * 2 + 1);

                        switch (randomN) {
                            case 1:
                                randomCoordForWoundShip = _1CoordForWoundShip;
                                break;
                            case 2:
                                randomCoordForWoundShip = _2CoordForWoundShip;
                                break;
                        }
                    } else if (number1 == number3) {
                        if (letter1 < letter3) {
                            previousLetter1 = letter1 - 2;
                            nextLetter1 = letter3 + 1;
                        } else if (letter1 > letter3) {
                            previousLetter1 = letter3 - 1;
                            nextLetter1 = letter1 + 2;
                        }

                        _1CoordForWoundShip = Character.toString((char) previousLetter1) + Integer.toString(number1);
                        _2CoordForWoundShip = Character.toString((char) nextLetter1) + Integer.toString(number1);

                        /*System.out.println("Две новых координаты ( если уже подбито две): ");
                        System.out.println(_1CoordForWoundShip);
                        System.out.println(_2CoordForWoundShip);*/

                        randomN = (int) (Math.random() * 2 + 1);

                        switch (randomN) {
                            case 1:
                                randomCoordForWoundShip = _1CoordForWoundShip;
                                break;
                            case 2:
                                randomCoordForWoundShip = _2CoordForWoundShip;
                                break;
                        }
                    } else {
                        //System.out.println("Ошибка в методе определения следующей координаты для двух поражений");
                    }
                    //System.out.println("Выбранная случайно одна: " + randomCoordForWoundShip);

                } while (battlefieldGamer.containsKey(randomCoordForWoundShip) == false || usedBattlefieldGamer.containsKey(randomCoordForWoundShip) == true);
                compInputWound.add(3, randomCoordForWoundShip);
                break;
        }
        return compInputWound;
    }
}