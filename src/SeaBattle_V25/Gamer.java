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
import java.util.Map;

/**
 * Gamer - игрок
 * Описание класса: данный класс предназначен для выполнения хода игрока, передаче хода компьютеру в случае промаха
 * или передаче хода классу EndGame в случае победы игрока. В классе есть методы gamerMove,
 * gamerDeck1SinkOrWound.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Gamer  {

    /**
     * static private Map <String, Integer> limitCoordDeck1 - вспомогательня коллекция в ключах (key) которой
     * храняться координаты границ однопалубных кораблей. В значениях (value) храняться соответствующие числа.
     * После того, как топиться однопалубный корабль, вызывается метод генерации границ однопалубного корабля, чтобы
     * полученные значения могли внести в коллекцию коллекцию уже открытых (использованных) координат
     * Map usedBattlefieldGamer. Данная коллекция перезаписывается при каждом новом потоплении однопалубного корабля.
     */
    static Map<String, Integer> limitCoordDeck1;

    /**
     * static private Map <String, Integer> limitCoordDeck2 - см комментарий к коллекции limitCoordDeck1, отличие
     * только в том, что это относиться к двухпалубным кораблям.
     */
    static Map<String, Integer> limitCoordDeck2;

    /**
     * static private Map <String, Integer> limitCoordDeck3 - см комментарий к коллекции limitCoordDeck1, отличие
     * только в том, что это относиться к трехпалубным кораблям.
     */
    static Map<String, Integer> limitCoordDeck3;

    /**
     * static private Map <String, Integer> limitCoordDeck4 - см комментарий к коллекции limitCoordDeck1, отличие
     * только в том, что это относиться к четырехпалубному кораблю.
     */
    static Map<String, Integer> limitCoordDeck4;

    /**
     * int valueOfBattlefieldComp - хранит в себе число, характерезующее координату, по которой "стрельнул" корабль
     * Компьютер генерирует случайную координату, например B3. Как узнать находиться ли там корабль, либо компьютер
     * промахнулся. Для этого смотрим, какое же число находиться в коллекции battlefieldGamer (value) по координате B3.
     * Там 411. Вот это число мы заносим в данную переменную. Дополнительную информацию можно получить в описании класса
     * Main.
     */
    static int valueOfBattlefieldComp;

    /** String gamerInput - переменная, хранящая в себе координу, которую ввел игрок. Например A1, F5, J6...  */
    static String gamerInput = null;

    /**
     * int limitDeck1 - вспомогательная переменная, хранящая в себе число - границу однопалубного корабля.
     * Используется в качестве аргумента метода compDeck1SinkOrWound.
     */
    static int limitDeck1;

    /**
     * int serialNumberOfDeck1 - переменная, хранящая в себе число - порядковый номер однопалубного корабля.
     * Т.к. однопалубных кораблей - четыре.
     */
    static int serialNumberOfDeck1;

    /**
     * gamerMove - основной метод для данного класса. В нем делает свой ход игрок, проверяет ноходиться ли по
     * этой координате корабль компьютера, либо игрок промахнулся. В зависимости от этого производяться
     * дальнейшие действия: передача хода компьютеру, либо повторный ход, либо вывод сообщения о победе и передача
     * действий методу EndGame.
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

    public static void gamerMove(Map battlefieldGamer, Map battlefieldComp, Map usedBattlefieldGamer, Map usedBattlefieldComp, ArrayList<String> compInputWound) throws IOException {

        //System.out.println("usedBattlefieldComp" + usedBattlefieldComp.size()); // для отладки
        //System.out.println("usedBattlefieldGamer" + usedBattlefieldGamer.size()); // для отладки
        //System.out.println("compInputWound.size()" + compInputWound.size()); // для отладки

        // проверка, победил ли игрок или нет
        if (usedBattlefieldComp.containsValue(151)
                && usedBattlefieldComp.containsValue(161)
                && usedBattlefieldComp.containsValue(171)
                && usedBattlefieldComp.containsValue(181)
                && usedBattlefieldComp.containsValue(251)
                && usedBattlefieldComp.containsValue(252)
                && usedBattlefieldComp.containsValue(261)
                && usedBattlefieldComp.containsValue(262)
                && usedBattlefieldComp.containsValue(271)
                && usedBattlefieldComp.containsValue(272)
                && usedBattlefieldComp.containsValue(351)
                && usedBattlefieldComp.containsValue(352)
                && usedBattlefieldComp.containsValue(353)
                && usedBattlefieldComp.containsValue(361)
                && usedBattlefieldComp.containsValue(362)
                && usedBattlefieldComp.containsValue(363)
                && usedBattlefieldComp.containsValue(451)
                && usedBattlefieldComp.containsValue(452)
                && usedBattlefieldComp.containsValue(453)
                && usedBattlefieldComp.containsValue(454)) {
            System.out.println("Игра закончена!");
            System.out.println("ПОБЕДИТЕЛЬ: " + Preparation.gamerName);
            EndGame eGG = new EndGame();
            eGG.endGame();
        }

        // игрок делает свой ход, даллее идет проверка введенного значения на допустимость введенных символов.
        try {
            System.out.print(Preparation.gamerName + ", сделай свой ход (например A1, F5, C10): ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            gamerInput = reader.readLine();

            if (battlefieldComp.containsKey(gamerInput)) {
            } else {
                System.out.println("Вы ввели недопустимое значение!");
                System.out.println("");
                gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // проверка на повторность хода
        if (usedBattlefieldComp.containsKey(gamerInput)) {
            System.out.println("Вы уже стреляли по этой координате!");
            System.out.println("");
            gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
        }

        // заносим в переменную valueOfBattlefieldComp значение value по введенной игроком координате (key)
        valueOfBattlefieldComp = (int) battlefieldComp.get(gamerInput);

        // добавляем новую координату в коллекцию "стреляных" координат.
        usedBattlefieldComp.put(gamerInput, valueOfBattlefieldComp);

        // ищем необходимое нам число, и соответствующий этому числу корабль.
        switch (valueOfBattlefieldComp) {
            case 0:
            case 15:
            case 16:
            case 17:
            case 18:
            case 25:
            case 26:
            case 27:
            case 35:
            case 36:
            case 45:
                System.out.println(Preparation.gamerName + ", МИМО!");
                System.out.println("");
                Comp.compMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                break;
            case 151:
            case 161:
            case 171:
            case 181:
                switch (valueOfBattlefieldComp) {
                    case 151:
                        limitDeck1 = 15;
                        serialNumberOfDeck1 = 1;
                        break;
                    case 161:
                        limitDeck1 = 16;
                        serialNumberOfDeck1 = 2;
                        break;
                    case 171:
                        limitDeck1 = 17;
                        serialNumberOfDeck1 = 3;
                        break;
                    case 181:
                        limitDeck1 = 18;
                        serialNumberOfDeck1 = 4;
                        break;
                }
                usedBattlefieldComp = gamerDeck1SinkOrWound(usedBattlefieldComp, battlefieldComp, limitDeck1, serialNumberOfDeck1);
                gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                break;
            case 251:
            case 252:
            case 261:
            case 262:
            case 271:
            case 272:
                switch (valueOfBattlefieldComp) {
                    case 251:
                    case 252:
                        // Проверка потоплен ли корабль или подбит
                        if (usedBattlefieldComp.containsValue(251) && usedBattlefieldComp.containsValue(252)) {
                            // выводим сообщение на экран и
                            System.out.println("ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck2 deck2 = new Deck2(25, 1);
                            limitCoordDeck2 = deck2.genLimitCoordDeck2(battlefieldComp);

                            // добавляем границы корабля в массив usedBattlefieldComp
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck2.get(s) == 25) {
                                        usedBattlefieldComp.put(s, 25);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldComp.values());
                            System.out.println("");

                        } else {
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                        }
                        break;
                    case 261:
                    case 262:
                        /*limitDeck2 = 26;
                        serialNumberOfDeck2 = 2;*/
                        if (usedBattlefieldComp.containsValue(261) && usedBattlefieldComp.containsValue(262)) {
                            // выводим сообщение на экран и
                            System.out.println("ПОТОПЛЕН ДВУХПАЛУБНЫЙ КОРАБЛЬ!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck2 deck2 = new Deck2(26, 2);
                            limitCoordDeck2 = deck2.genLimitCoordDeck2(battlefieldComp);

                            // добавляем границы корабля в массив usedBattlefieldComp
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck2.get(s) == 26) {
                                        usedBattlefieldComp.put(s, 26);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldComp.values());
                            System.out.println("");

                        } else {
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                        }
                        break;
                    case 271:
                    case 272:
                        /*limitDeck2 = 27;
                        serialNumberOfDeck3 = 3;*/
                        if (usedBattlefieldComp.containsValue(271) && usedBattlefieldComp.containsValue(272)) {
                            // выводим сообщение на экран и
                            System.out.println("ПОТОПЛЕН  ДВУХПАЛУБНЫЙ КОРАБЛЬ!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck2 deck2 = new Deck2(27, 3);
                            limitCoordDeck2 = deck2.genLimitCoordDeck2(battlefieldComp);

                            // добавляем границы корабля в массив usedBattlefieldComp
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck2.get(s) == 27) {
                                        usedBattlefieldComp.put(s, 27);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldComp.values());
                            System.out.println("");

                        } else {
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                        }
                        break;
                }
                // Необходимо запомнить соосдояние переменных usedCompDeck2_1  usedCompDeck2_2  usedCompDeck2_3
                //gamerCareTaker.saveState(usedCompDeck2_1,  usedCompDeck2_2,  usedCompDeck2_3);

                gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                break;
            case 351:
            case 352:
            case 353:
            case 361:
            case 362:
            case 363:
                switch (valueOfBattlefieldComp) {
                    case 351:
                    case 352:
                    case 353:
                        /*limitDeck3 = 35;
                        serialNumberOfDeck3 = 1;*/
                        if (usedBattlefieldComp.containsValue(351) && usedBattlefieldComp.containsValue(352) && usedBattlefieldComp.containsValue(353)) {
                            // выводим сообщение на экран и записываем в
                            System.out.println("ПОТОПЛЕН ТРЕХПАЛУБНЫЙ КОРАБЛЬ!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck3 deck3 = new Deck3(35, 1);
                            limitCoordDeck3 = deck3.genLimitCoordDeck3(battlefieldComp);

                            // добавляем границы корабля в массив usedGamerBattlefield
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck3.get(s) == 35) {
                                        usedBattlefieldComp.put(s, 35);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldComp.values());
                            System.out.println("");
                        } else {
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                        }
                        break;
                    case 361:
                    case 362:
                    case 363:
                        /*limitDeck3 = 36;
                        serialNumberOfDeck3 = 2;*/
                        if (usedBattlefieldComp.containsValue(361) && usedBattlefieldComp.containsValue(362) && usedBattlefieldComp.containsValue(363)) {
                            // выводим сообщение на экран и записываем в
                            System.out.println("ПОТОПЛЕН ТРЕХПАЛУБНЫЙ КОРАБЛЬ №2!");
                            //System.out.println("Выводим границы корабля: ");
                            // выводим границы корабля на экран
                            Deck3 deck3 = new Deck3(36, 2);
                            limitCoordDeck3 = deck3.genLimitCoordDeck3(battlefieldComp);

                            // добавляем границы корабля в массив usedGamerBattlefield
                            for (char i = 65; i < 75; i++) {
                                for (int j = 1; j <= 10; j++) {
                                    String s = String.valueOf(i) + j;
                                    if (limitCoordDeck3.get(s) == 36) {
                                        usedBattlefieldComp.put(s, 2);
                                    }
                                }
                            }
                            //System.out.println(usedBattlefieldComp.values());
                            System.out.println("");
                        } else {
                            System.out.println("ПОДБИТ КОРАБЛЬ!");
                            System.out.println("");
                        }
                        break;
                }
                gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                break;
            case 451:
            case 452:
            case 453:
            case 454:
                /*limitDeck4 = 45;*/
                if (usedBattlefieldComp.containsValue(451) && usedBattlefieldComp.containsValue(452) && usedBattlefieldComp.containsValue(453) && usedBattlefieldComp.containsValue(454)) {
                    // выводим сообщение на экран и

                    System.out.println("ПОТОПЛЕН ЧЕТЫРЕХПАЛУБНЫЙ КОРАБЛЬ!");
                    //System.out.println("Выводим границы корабля: ");
                    // выводим границы корабля на экран
                    Deck4 deck4 = new Deck4(45);
                    limitCoordDeck4 = deck4.genLimitCoordDeck4(battlefieldComp);

                    // добавляем границы корабля в массив usedBattlefieldComp
                    for (char i = 65; i < 75; i++) {
                        for (int j = 1; j <= 10; j++) {
                            String s = String.valueOf(i) + j;
                            if (limitCoordDeck4.get(s) == 45) {
                                usedBattlefieldComp.put(s, 454);
                            }
                        }
                    }
                    //System.out.println(usedBattlefieldComp.values());
                    System.out.println("");

                } else {
                    System.out.println("ПОДБИТ КОРАБЛЬ!");
                    System.out.println("");
                }
                gamerMove(battlefieldGamer, battlefieldComp, usedBattlefieldGamer, usedBattlefieldComp, compInputWound);
                break;
            default:
                System.out.println("ОШИБКА в определении значения valueOfBattlefieldComp для Gamer!!!");
        } // выход из switch (valueOfBattlefielComp)
    } // выход из метода gamerMove

    /**
     * compDeck1SinkOrWound - метод необходимый для: вывода сообщения об потоплении одного из однопалубных кораблей
     * ИГРОКА, вызова метода, который генерирует границы корабля, добавлении этих границ в коллекцию usedBattlefieldGamer,
     * чтобы исключить возможность повторного выстрела по использованной границе корабля.
     *
     * @param usedBattlefieldComp - коллекция, хранящая информацию об уже использованных ("стреляных")
     *                               координатах ИГРОКА
     * @param battlefieldComp - коллекция, хранящая информацию о расположении кораблей КОМПЬЮТЕРА
     * @param limitDeck1 - вспомогательная коллекция, хранящая информацию о граничных координатах однопалубных кораблей.
     * @param serialNumberOfDeck1 - порядковый номер однопалубного корабля.
     * @return - метод возвращает дополненную новыми значениями коллекцию usedBattlefieldGamer.
     *
     */
    public static Map gamerDeck1SinkOrWound(Map usedBattlefieldComp, Map battlefieldComp, int limitDeck1, int serialNumberOfDeck1) {

        // выводим сообщение на экран
        System.out.println("ПОТОПЛЕН ОДНОПАЛУБНЫЙ КОРАБЛЬ!");
        //System.out.println("Выводим границы корабля: ");
        // выводим границы корабля на экран
        Deck1 deck1 = new Deck1(limitDeck1, serialNumberOfDeck1);
        limitCoordDeck1 = deck1.genLimitCoordDeck1(battlefieldComp);

        // добавляем границы корабля в массив usedBattlefieldComp
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                if (limitCoordDeck1.get(s) == limitDeck1) {
                    usedBattlefieldComp.put(s, limitDeck1);
                }
            }
        }
        System.out.println("");

        return usedBattlefieldComp;
    }
}