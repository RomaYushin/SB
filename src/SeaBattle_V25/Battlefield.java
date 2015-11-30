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

import java.util.HashMap;
import java.util.Map;

/**
 * Описание класса: класс Battlefield (поле битвы)предназначен для формирования поля игрока и поля компьютера.
 * Необходим для подготовительных операций перед игрой. В классе есть методы createOfGamerBattlefield(),
 * createOfCompBattlefield(). Они вызываются из класса Preparation.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Battlefield {

    /** Map<String, Integer> battlefieldGamer - коллекция, хранящая информацию о расположении кораблей игрока.
     * В этой коллекции храняться
     * данные о расположении кораблей игрока, границ кораблей, а также некоторых вспомогательных значений.
     * Если быть точнее, то это коллекция, которая хранит в ключе (key) значения координат, например A1, A2, C5... ,
     * а в значении (value) хранит числа. Каждое число (максимум трехзначные числа) - это код. Под ним в данной
     * программе понимается пустая ли координата либо там стоит корабль, либо это граница корабля
     * (см. описание класса Main). Также в этой коллекции встречаются например такие ключи:
     * "firstRandomNumberForLetter_deck1"... Это вспомогательные пары, необходимые для правильного формирования
     * границ корабля. Активно используются в классах Deck1, Deck2, Deck3, Deck4, Preparation
     */
    private Map<String, Integer> battlefieldGamer = new HashMap<String, Integer>();

     /** Map<String, Integer> battlefieldComp - данная коллекция ничем не отличается от battlefieldGamer кроме лишь того,
     * что она хранит информацию о расположении кораблей компьютера.
     */
    private Map<String, Integer> battlefieldComp = new HashMap<String, Integer>();

    /**
     * метод createOfGamerBattlefield() формирует ключи для поля игрока и возвращает коллекцию battlefieldGamer.
     * Значения ключей: A1...A10, B1...B10, C1...C10, D1...D10, E1...E10, F1...F10, G1...G10, H1...H10, I1...I10, J1...J10.
     * Значения (value) - 0; Т.е. свободные координаты (см. описание класса Main).
     *
     * @return
     */
    public Map<String, Integer> createOfGamerBattlefield() {
        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                battlefieldGamer.put(s, 0);
                //System.out.println(s + " вывод всех возможный ячеек");
            }
        }
        return battlefieldGamer;
    }

    /**
     * метод createOfCompBattlefield() формирует ключи для поля компьютера и возвращает коллекцию battlefieldComp.
     * Значения ключей: A1...A10, B1...B10, C1...C10, D1...D10, E1...E10, F1...F10, G1...G10, H1...H10, I1...I10, J1...J10.
     * Значения (value) - 0; Т.е. свободные координаты (см. описание класса Main).
     *
     * @return
     */
    public Map<String, Integer> createOfCompBattlefield() {

        for (char i = 65; i < 75; i++) {
            for (int j = 1; j <= 10; j++) {
                String s = String.valueOf(i) + j;
                battlefieldComp.put(s, 0);
                //System.out.println(s + " вывод всех возможный ячеек");
            }
        }
        return battlefieldComp;
    }
}

