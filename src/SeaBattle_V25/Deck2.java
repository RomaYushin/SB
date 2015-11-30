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

import java.util.Map;

/**
 * Описание класса. Deck2 - двухпалубный корабль. Данный класс необходим для генерирования случайных координат
 * корабля и границ корабля. Поэтому в этом классе два метода.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Deck2 extends Ships {
    /** класс наследуется от класса Ships - корабли. Из него вызываются методы генерирования случайных чисел.*/

    /**
     * private int [] deck2 - массив чисел, передаваемых в конструктор
     * Deck2(int[] deck2, int limitDeck2, int serialNumberOfDeck2 ) при создании объекта в классе Preparation,
     * содержит числа 211, 212,  221, 222,  231, 232 или 251, 252,  261, 262,  271, 272. Эти числа выступают
     * в качестве value в массиве battlefieldGamer или battlefieldComp для определения трехалубного корабля.
     * Дополнительную информацию см при комментировании класса Main.
     */
    private int[] deck2;

    /**
     * private int limitDeck2 - число, передаваемое в конструктор
     * Deck2(int[] deck2, int limitDeck2, int serialNumberOfDeck2 ) при создании объекта в классе Preparation,
     * содержит числа 21, 22, 23 или 25, 26, 27. Эти числа выступает в качестве value в массиве
     * battlefieldGamer или battlefieldComp для определения границ трехалубного корабля. Дополнительную информацию см
     * при комментировании класса Main.
     */
    private int limitDeck2;

    /**
     * rightLimitNumberForLetterHor (leftLimitNumberForLetterHor)-  число (от 65 до 74), которое будет преобразовано
     * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
     * координаты корабля для случая горизонтальной установки корабля (Hor).
     *
     * rightLimitNumberForLetterVer (leftLimitNumberForLetterVer)-  число (от 65 до 74), которое будет преобразовано
     * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
     * координаты корабля для случая вертикальной установки корабля (Ver).
     *
     * topLimitNumberHor (bottomLimitNumberHor) - число ( от 1 до 10 ), вторая составляющая (т.к координата состоит
     * из буквы и цифры) верхней (нижней) граничной координаты корабля для случая горизонтальной установки корабля (Hor)
     *
     * topLimitNumberVer (bottomLimitNumberVer) - число ( от 1 до 10 ), вторая составляющая (т.к координата состоит
     * из буквы и цифры) верхней (нижней) граничной координаты корабля для случая вертикальной установки корабля (Ver).
     */
    private int rightLimitNumberForLetterHor;
    private int leftLimitNumberForLetterHor;
    private int topLimitNumberHor;
    private int bottomLimitNumberHor;

    private int rightLimitNumberForLetterVer;
    private int leftLimitNumberForLetterVer;
    private int topLimitNumberVer;
    private int bottomLimitNumberVer;

    /** _(1-10)LimitCoordHor ( _(1-10)LimitCoordVer ) - (1-я - 10-я) координата границы корабля, если корабль расположен
     * горизонтально (Hor), (если корабль расположен вертикально (Ver)). В игре существует 9 случаев
     * расположения корабля (9 случаев горизонтального расположенрия и 9 случаев вертикального расположения).
     * От определенного случая расположения будет зависеть колличество координат. Отчет координат границы корабля всегда
     * идет по часовой стрелке.
     */
    private String _1LimitCoordHor;
    private String _2LimitCoordHor;
    private String _3LimitCoordHor;
    private String _4LimitCoordHor;
    private String _5LimitCoordHor;
    private String _6LimitCoordHor;
    private String _7LimitCoordHor;
    private String _8LimitCoordHor;
    private String _9LimitCoordHor;
    private String _10LimitCoordHor;

    private String _1LimitCoordVer;
    private String _2LimitCoordVer;
    private String _3LimitCoordVer;
    private String _4LimitCoordVer;
    private String _5LimitCoordVer;
    private String _6LimitCoordVer;
    private String _7LimitCoordVer;
    private String _8LimitCoordVer;
    private String _9LimitCoordVer;
    private String _10LimitCoordVer;

    /** private int firstRandomNumberForLetterHor (secondRandomNumberForLetterHor) -
     * случайное число (в последствии будет преобразованно в букву)
     * для определения буквы (координата состоит из буквы и цифры) первой (второй, соответственно)
     * координаты двухпалубного корабля по горизонтали
     */
    private int firstRandomNumberForLetterHor;
    private int secondRandomNumberForLetterHor;

    /**
     * private randomNumberForNumberHor - случайное число (координата состоит из буквы и цифры)
     * первой координаты двухпалубного корабля по горизонтали.
     * Не забываем, корабль находить по горизонтали, поэтому число одно, а буквы 2.
     */
    private int randomNumberForNumberHor;

    /** private int firstRandomNumberForNumberVer (secondRandomNumberForNumberVer -
     * случайное число (координата состоит из буквы и цифры)
     * первой (второй, соответственно) координаты двухпалубного корабля по вертикали.
     */
    private int firstRandomNumberForNumberVer;
    private int secondRandomNumberForNumberVer;

    /** private randomNumberForLetterVer - случайное число, в последствии будет преобразованно в букву)
     * первой координаты двухпалубного корабля по вертикали
     * Не забываем, корабль находить по вертикали, поэтому буква одна (цифры, в последствии будут преобразованы в буквы),
     * а цифры две.
     */
    private int randomNumberForLetterVer;

    /**
     *  private String firstCoordinateHor (secondCoordinateHor ) - координаты двухпалубного корабля по горизонтали
     *  (например A1, B1)
     */
    private String firstCoordinateHor;
    private String secondCoordinateHor;

    /** private String firstCoordinateVer (secondCoordinateVer) - координаты двухпалубного корабля по вертикали
     * (например G1, G2)
     */
    private String firstCoordinateVer;
    private String secondCoordinateVer;

    /** private int serialNumberOfDeck2 - порядковый номер корабля. Может быть 1, 2, 3,*/
    int serialNumberOfDeck2;

    /**
     *  private int verOrHorPositionOfSpips - хранит число 1 или 0. Данная переменная определяет положение корабля.
     * 0 - горизонтально или 1 - вертикально
     */
    private int verOrHorPositionOfSpips;


    public Deck2(int[] deck2, int limitDeck2,  int serialNumberOfDeck2) {

        this.deck2 = deck2;
        this.limitDeck2 = limitDeck2;
        this.serialNumberOfDeck2 = serialNumberOfDeck2;
    }
    public Deck2 ( int limitDeck2, int serialNumberOfDeck2 ) {

        this.limitDeck2 = limitDeck2;
        this.serialNumberOfDeck2 = serialNumberOfDeck2;
    }

    /**
     * Метод genCoordDeck2 - генерирует случайные координаты двухпалубного корабля (Например B3 B4). Заносит эти
     * координаты в key коллекции battlefield. Значения int[] deck2, int limitDeck2 которое мы получили из конструктора
     * заносим в value коллекции battlefield.
     *
     * @param battlefield - в качестве аргумента принимает коллекцию - поле игрока либо поле компьютера.
     * @return - возвращает коллекцию battlefield.
     */

    public Map<String, Integer> genCoordDeck2(Map battlefield) {

        // вызываем метод, опередляющий положение корабля путем генерации числа 0 или 1 (горизонтально или вертикально)
        verOrHorPositionOfSpips = verOrHorPositionOfSpips();

        /* в зависимости от выбранного числа verOrHorPositionOfSpips метод ветвиться на case 0,  case 1.
         * case 0 - горизонтально, case 1 - вертикально
         */

        switch (verOrHorPositionOfSpips) {
            case 0:
                //выбираем случайное число для первой буквы.
                firstRandomNumberForLetterHor = (int) (Math.random() * 9 + 65); // число должно быть от 65 до 73
                // Генерируем еще 1 число путем прибавления 1.
                // firstRandomNumberForLetterHor, secondRandomNumberForLetterHor - буквы координат 2-х палубного корабля
                secondRandomNumberForLetterHor = firstRandomNumberForLetterHor + 1;

                // заносим в коллекцию battlefield вспомогательные пары для границ корабля.
                battlefield.put("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2, firstRandomNumberForLetterHor);
                battlefield.put("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2, secondRandomNumberForLetterHor);

                // выбираем случайное число для координат корабля т.к корабль горизонтально, то буквы две, цифра одна.
                randomNumberForNumberHor = mFirstRandomNumberForNumber(); // число должно быть от 1 до 10

                // заносим в коллекцию battlefield вспомогательную пару для границ корабля.
                battlefield.put("randomNumberForNumber_deck2" + serialNumberOfDeck2, randomNumberForNumberHor);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateHor = Character.toString((char) firstRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);
                secondCoordinateHor = Character.toString((char) secondRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);

                // Вывод на экран сформировавшихся координат корабля ДО проверки
                //System.out.println(firstCoordinateHor + " " + secondCoordinateHor+
                //        " координаты корабля для отладки по горизонтали ДО проверки"); // координаты корабля для отладки

                // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
                if (battlefield.get(firstCoordinateHor).equals(0) && battlefield.get(secondCoordinateHor).equals(0)) {}
                else {
                    return genCoordDeck2(battlefield);
                }

                // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
                //System.out.println(firstCoordinateHor + " " + secondCoordinateHor +
                //        " координаты корабля для отладки по горизонтали ПОСЛЕ проверки"); // координаты корабля для отладки

                /* добавляем в коллекцию battlefield числа 211,212;   221,222;   231,232.
                 * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
                 * Числа и есть содержимое.
                 */
                battlefield.replace(firstCoordinateHor, battlefield.get(firstCoordinateHor), deck2[0]);
                battlefield.replace(secondCoordinateHor, battlefield.get(secondCoordinateHor), deck2[1]);

                // добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("positionOfDeck2" + serialNumberOfDeck2, verOrHorPositionOfSpips);
                battlefield.put("firstCoord_deck2" + serialNumberOfDeck2, firstCoordinateHor);
                battlefield.put("secondCoord_deck2" + serialNumberOfDeck2, secondCoordinateHor);
                break;

            case 1:
                //выбираем случайное число для буквы. Это будет единственная буква координат 2-х палубного корабля
                randomNumberForLetterVer = mFirstRandomNumberForLetter(); // число должно быть от 65 до 74

                // добавляем в массив для генерации границ корабля
                battlefield.put("randomNumberForLetter_deck2" + serialNumberOfDeck2, randomNumberForLetterVer);

                // выбираем случайную цифру от 1 до 9, она будет показывать в каком ряде находиться первая координата корабля
                firstRandomNumberForNumberVer = (int) (Math.random() * 9 + 1); // число должно быть от 1 до 9
                secondRandomNumberForNumberVer = firstRandomNumberForNumberVer + 1;

                //добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2, firstRandomNumberForNumberVer);
                battlefield.put("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2, secondRandomNumberForNumberVer);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(firstRandomNumberForNumberVer);
                secondCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(secondRandomNumberForNumberVer);

                // Вывод на экран сформировавшихся координат корабля ДО проверки
                //System.out.println(firstCoordinateVer + " " + secondCoordinateVer +
                //        " координаты корабля для отладки по вертикали ДО проверки"); // координаты корабля для отладки

                // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
                if (battlefield.get(firstCoordinateVer).equals(0)
                        && battlefield.get(secondCoordinateVer).equals(0)) {
                } else {
                    return genCoordDeck2(battlefield);
                }

                // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
                //System.out.println(firstCoordinateVer + " " + secondCoordinateVer +
                //        " координаты корабля для отладки по вертикали ПОСЛЕ проверки"); // координаты корабля для отладки

                // добавляем в массив battlefield наш корабль, ему соответствуют числа из массива int[] deck2.
                battlefield.replace(firstCoordinateVer, battlefield.get(firstCoordinateVer), deck2[0]);
                battlefield.replace(secondCoordinateVer, battlefield.get(secondCoordinateVer), deck2[1]);

                // добавляем в коллекцию вспомогательные пары для генерации границ корабля.
                battlefield.put("positionOfDeck2" + serialNumberOfDeck2, verOrHorPositionOfSpips);
                battlefield.put("firstCoord_deck2" + serialNumberOfDeck2, firstCoordinateVer);
                battlefield.put("secondCoord_deck2" + serialNumberOfDeck2, secondCoordinateVer);

                break;
        } return battlefield;
    }

    /**
     * Метод genCoordDeck2 - генерирует случайную координату двухпалубного корабля (Например B3, C3).
     * Заносит эти координаты в key коллекции battlefield. Значения int[] deck2, int limitDeck2 которое мы
     * получили из конструктора заносим в value коллекции battlefield.
     *
     * genLimitCoordDeck2 - метод, устанавливающий координаты границ двухпалубных кораблей.
     * @param battlefield
     * @return
     */

    public Map<String, Integer> genLimitCoordDeck2 (Map battlefield) {

        /**
         *  В игре есть 9 вариантов расположения корабля ГОРИЗОНТАЛЬНО (case 0) и  9 вариантов расположения корабля
         * ВЕРТИКАЛЬНО (case 1) в контексте относительно границ поля игры.
         * Необходимо описать каждый из вариантов. Выбор между вариантами будет выполнен с помощью оператора switch.
         * Для этого в коллекции Map battlefield получаем значение (value) verOrHorPositionOfSpips по ключу
         * positionOfDeck2.
         */
        switch ((int) battlefield.get("positionOfDeck2" + serialNumberOfDeck2)) {
            case 0:
                /* В зависимости от первой координаты двухпалубного корабля выбираем один из 9-ти случаев
                 * ГОРИЗОНТАЛЬНОГО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateHor по ключу firstCoord_2deck.
                 */
                int b;
                if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A1")) {
                    b = 0;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("B1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("C1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("D1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("E1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("F1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("G1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("H1")) {
                    b = 1;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I1")) {
                    b = 2;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I2")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I3")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I4")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I5")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I6")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I7")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I8")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I9")) {
                    b = 3;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I10")) {
                    b = 4;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("B10")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("C10")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("D10")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("E10")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("F10")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("G10")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("H10")) {
                    b = 5;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A10")) {
                    b = 6;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A2")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A3")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A4")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A5")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A6")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A7")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A8")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A9")) {
                    b = 7;
                } else {
                    b = 8;
                }
                //System.out.println(b + " число для выбора switch"); // Для отладки программы

                /*
                 * Исходя из выбранного числа b выбираем один из девяти случаев расположения корабля,
                 * формируем координаты, заносим в коллекцию поля игрока/компьютера.
                 */
                switch (b) {
                    case 0:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 1:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " +_4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 2:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 3:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                        //       + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor);

                        break;
                    case 4:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 5:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 6:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor);

                        break;
                    case 7:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor);

                        break;
                    case 8:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _10LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck2);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck2);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck2);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck2);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck2);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck2);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck2);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck2);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck2);
                        battlefield.replace(_10LimitCoordHor, battlefield.get(_10LimitCoordHor), limitDeck2);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                        //        _9LimitCoordHor + " " + _10LimitCoordHor);
                        break;
                } break;
            case 1:
                /*
                 * В зависимости от первой координаты двухпалубного корабля выбираем один из 9 - ти случаев
                 * ВЕРТИКАЛЬНО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateVer по ключу firstCoord_2deck.
                 */
                int c = 0;
                if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A1")) {
                    c = 0;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("B1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("C1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("D1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("E1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("F1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("G1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("H1")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I1")) {
                    c = 1;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J1")) {
                    c = 2;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J2")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J3")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J4")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J5")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J6")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J7")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J8")) {
                    c = 3;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("J9")) {
                    c = 4;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("B9")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("C9")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("D9")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("E9")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("F9")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("G9")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("H9")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("I9")) {
                    c = 5;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A9")) {
                    c = 6;
                } else if (battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A2")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A3")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A4")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A5")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A6")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A7")
                        || battlefield.get("firstCoord_deck2" + serialNumberOfDeck2).equals("A8")) {
                    c = 7;
                } else {
                    c = 8;
                }
                //System.out.println(b + " число для выбора switch"); // Для отладки программы

                /*
                 * Исходя из выбранного числа b выбираем один из девяти случаев расположения корабля,
                 * формируем координаты, заносим в коллекцию поля игрока/компьютера.
                 */
                switch (c) {
                    case 0:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;

                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 1:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _7LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer);

                        break;
                    case 2:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 3:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 4:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 5:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _7LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer);

                        break;
                    case 6:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer);

                        break;
                    case 7:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 8:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2)) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck2" + serialNumberOfDeck2))) + bottomLimitNumberVer;
                        _8LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _9LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck2" + serialNumberOfDeck2));
                        _10LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck2" + serialNumberOfDeck2));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck2);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck2);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck2);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck2);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck2);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck2);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck2);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck2);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck2);
                        battlefield.replace(_10LimitCoordVer, battlefield.get(_10LimitCoordVer), limitDeck2);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                        //        + " " + _9LimitCoordVer + " " + _10LimitCoordVer);
                        break; // выход из case 8:
                }

                break; // выход из case 1
        } //конец switch ((int) battlefield.get("positionOfDeck2" + serialNumberOfDeck2)) {
        return battlefield;
    } // выход из метода, определяющий границы корабля
} // выход из класса
