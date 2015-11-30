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
 * Описание класса. Deck1 - однопалубный корабль. Данный класс необходим для генерирования случайных координат
 * корабля и границ корабля. Поэтому в этом классе два метода.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Deck1 extends Ships {
    /** класс наследуется от класса Ships - корабли. Из него вызываются методы генерирования случайных чисел.*/

    /**
     * private int [] deck1 - массив чисел, передаваемых в конструктор
     * Deck1(int[] deck1, int limitDeck1, int serialNumberOfDeck1 ) при создании объекта в классе Preparation,
     * содержит числа 111, 121, 131, 141 или 151, 161, 171, 181. Эти числа выступают в качестве value в массиве
     * battlefieldGamer или battlefieldComp для определения однопалубного корабля. Дополнительную информацию см при
     * комментировании класса Main.
     */
    private int[] deck1;

    /**
     * private int limitDeck1 - число, передаваемое в конструктор
     * Deck1(int[] deck1, int limitDeck1, int serialNumberOfDeck1 ) при создании объекта в классе Preparation,
     * содержит числа 11, 12, 13, 14 или 15, 16, 17, 18. Эти числа выступает в качестве value в массиве
     * battlefieldGamer или battlefieldComp для определения границ однопалубного корабля. Дополнительную информацию см
     * при комментировании класса Main.
     */
    private int limitDeck1;

    /**
     * rightLimitNumberForLetter (leftLimitNumberForLetter) -  число (от 65 до 74), которое будет преобразовано
     * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
     * координаты корабля.
     */
    private int rightLimitNumberForLetter;
    private int leftLimitNumberForLetter;

     /** topLimitNumber (bottomLimitNumber) - число ( от 1 до 10 ), вторая составляющая (т.к координата состоит
      * из буквы и цифры) верхней (нижней) граничной координаты корабля.
      */
    private int topLimitNumber;
    private int bottomLimitNumber;

    /** _(1-8)LimitCoord ( _(1-8)LimitCoord ) - (1-я - 8-я) координата границы корабля. В игре существует 9 случаев
     * расположения корабля. От определенного случая расположения будет зависеть колличество координат.
     * Отчет координат границы корабля всегда идет по часовой стрелке.
     */
    private String _1LimitCoord;
    private String _2LimitCoord;
    private String _3LimitCoord;
    private String _4LimitCoord;
    private String _5LimitCoord;
    private String _6LimitCoord;
    private String _7LimitCoord;
    private String _8LimitCoord;

    /** private int firstRandomNumberForLetter - случайное число, в последствии будет преобразованно в букву
      * (координата состоит из буквы и цифры). Составляющая координаты однопалубного корабля.
      */
    private int firstRandomNumberForLetter;

    /**
     * private randomNumberForNumber - случайное число, составляющая координаты однопалубного корабля
     * (координата состоит из буквы и цифры).
     */
    private int randomNumberForNumber;

    /** private String firstCoordinate - кордината однопалубного корабля (например A1). */
    private String firstCoordinate;

    /** private int serialNumberOfDeck1 - порядковый номер корабля. Может быть 1, 2, 3, 4*/
    private int serialNumberOfDeck1;

    public Deck1(int[] deck1, int limitDeck1, int serialNumberOfDeck1 ) {

        this.deck1 = deck1;
        this.limitDeck1 = limitDeck1;
        this.serialNumberOfDeck1 = serialNumberOfDeck1;
    }
    public Deck1 ( int limitDeck1,  int serialNumberOfDeck1) {

        this.limitDeck1 = limitDeck1;
        this.serialNumberOfDeck1 = serialNumberOfDeck1;
    }

    // МЕТОД, который устанавливает координаты однопалубного корабля

    /**
     * Метод genCoordDeck1 - генерирует случайную координату однопалубного корабля (Например B3). Заносит эту координату
     * в key коллекции battlefield. Значения int[] deck1, int limitDeck1 которое мы получили из конструктора заносим
     * в value коллекции battlefield.
     *
     * @param battlefield - коллекция поля игрока или поля компьютера. В этом классе название приобретает универсальный
     *                    характер, т.к. класс предназначен для генерации координат как игрока так и компьютера.
     * @return - возвращает коллекцию.
     */
    public Map<String, Integer> genCoordDeck1(Map battlefield) {

        //выбираем случайное число для единственной буквы. Это будут буква координаты однопалубного корабля
        firstRandomNumberForLetter = mFirstRandomNumberForLetter(); // число должно быть от 65 до 74

        // добавляем в коллекцию вспомогательную пару для правильной генерации грациц корабля
        battlefield.put("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1, firstRandomNumberForLetter);

        // выбираем случайное число для координаты корабля
        randomNumberForNumber = mFirstRandomNumberForNumber(); // число должно быть от 1 до 10

        // добавляем в коллекцию вспомогательную пару для правильной генерации грациц корабля
        battlefield.put("randomNumberForNumber_deck1" + serialNumberOfDeck1, randomNumberForNumber);

        // соодиняем букву и цифру, получаем координаты корабля
        firstCoordinate = Character.toString((char) firstRandomNumberForLetter) + Integer.toString(randomNumberForNumber);

        // Вывод на экран сформировавшихся координат корабля ДО проверки
        //System.out.println(firstCoordinate + " координаты корабля для отладки по горизонтали ДО проверки"); // координаты корабля для отладки

        // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
        if (battlefield.get(firstCoordinate).equals(0)) {
        } else {
            return genCoordDeck1(battlefield);
        }

        // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
        //System.out.println(firstCoordinate/* + " координаты корабля для отладки по горизонтали ПОСЛЕ проверки"*/); // координаты корабля для отладки

        // заменяем 0 на число, обозначающее границу данного однопалубного корабля, например 11.
        battlefield.replace(firstCoordinate, battlefield.get(firstCoordinate), deck1[0]);

        // добавляем в массив новые значения для генерации границ корабля в другом методе
        battlefield.put("firstCoord_deck1" + serialNumberOfDeck1, firstCoordinate);

        return battlefield;
    }

    /**
     * public Map<String, Integer> genLimitCoordDeck1 - "сгенерируй координаты границ однопалубного корабля"
     * МЕТОД, который устанавливает координаты границ однопалубного корабля.
     *
     * @param battlefield - принимает в качестве аргумента коллекцию поля игрока или поля компьютера. Метод универсален
     *                      для двух игроков.
     * @return
     */

    public Map<String, Integer> genLimitCoordDeck1 (Map battlefield) {
        /**
         *  В зависимости от первой координаты однопалубного корабля выбираем один из 9 - ти случаев
         *  расположения корабля. Для этого из коллекции Map Battlefield получаем значение
         *  firstCoordinate по ключу firstCoord_1deck.
         */

        /** int b - вспомогательная переменная, используется в качестве аргумента для оператора switch */
        int b;
        if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A1")) {
            b = 0;
        } else if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("B1")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("C1")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("D1")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("E1")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("F1")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("G1")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("H1")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("I1")) {
            b = 1;
        } else if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J1")) {
            b = 2;
        } else if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J2")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J3")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J4")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J5")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J6")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J7")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J8")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J9")) {
            b = 3;
        } else if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("J10")) {
            b = 4;
        } else if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("B10")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("C10")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("D10")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("E10")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("F10")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("G10")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("H10")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("I10")) {
            b = 5;
        } else if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A10")) {
            b = 6;
        } else if (battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A2")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A3")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A4")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A5")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A6")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A7")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A8")
                || battlefield.get("firstCoord_deck1" + serialNumberOfDeck1).equals("A9")) {
            b = 7;
        } else {
            b = 8;
        }
        //System.out.println(b + " число для выбора switch"); // Для отладки программы

        /*
         * Исходя из выбранного числа b выбираем необходимый case и расставляем границы корабля
         * Переменные описаны выше.
         */
        switch (b) {
            case 0:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) - 1;

                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) - 1;

                _1LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + bottomLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord );

                break;
            case 1:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) - 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) + 1;

                _1LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + bottomLimitNumber;
                _4LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _5LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " +_4LimitCoord + " " + _5LimitCoord);

                break;
            case 2:
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) - 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) + 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + bottomLimitNumber;
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord);

                break;
            case 3:
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) - 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) - 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + bottomLimitNumber;
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _3LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));
                _4LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _5LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + topLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord + " " + _5LimitCoord);

                break;
            case 4:
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) - 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) - 1;

                _1LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + topLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord);

                break;
            case 5:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) - 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) - 1;

                _1LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));
                _2LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + topLimitNumber;
                _4LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _5LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord + " "+ _5LimitCoord);

                break;
            case 6:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) - 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + topLimitNumber;
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord);

                break;
            case 7:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) + 1;
                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) - 1;

                _1LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + topLimitNumber;
                _2LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _3LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));
                _4LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _5LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + bottomLimitNumber;

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord + " " + _5LimitCoord );

                break;
            case 8:
                rightLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) + 1;
                leftLimitNumberForLetter = ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1)) - 1;

                bottomLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) + 1;
                topLimitNumber = ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1)) - 1;

                _1LimitCoord = Character.toString((char) leftLimitNumberForLetter) + topLimitNumber;
                _2LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + topLimitNumber;
                _3LimitCoord = Character.toString((char) rightLimitNumberForLetter) + topLimitNumber;
                _4LimitCoord = Character.toString((char) rightLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));
                _5LimitCoord = Character.toString((char) rightLimitNumberForLetter) + bottomLimitNumber;
                _6LimitCoord = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck1" + serialNumberOfDeck1))) + bottomLimitNumber;
                _7LimitCoord = Character.toString((char) leftLimitNumberForLetter) + bottomLimitNumber;
                _8LimitCoord = Character.toString((char) leftLimitNumberForLetter) + ((int) battlefield.get("randomNumberForNumber_deck1" + serialNumberOfDeck1));

                battlefield.replace(_1LimitCoord, battlefield.get(_1LimitCoord), limitDeck1);
                battlefield.replace(_2LimitCoord, battlefield.get(_2LimitCoord), limitDeck1);
                battlefield.replace(_3LimitCoord, battlefield.get(_3LimitCoord), limitDeck1);
                battlefield.replace(_4LimitCoord, battlefield.get(_4LimitCoord), limitDeck1);
                battlefield.replace(_5LimitCoord, battlefield.get(_5LimitCoord), limitDeck1);
                battlefield.replace(_6LimitCoord, battlefield.get(_6LimitCoord), limitDeck1);
                battlefield.replace(_7LimitCoord, battlefield.get(_7LimitCoord), limitDeck1);
                battlefield.replace(_8LimitCoord, battlefield.get(_8LimitCoord), limitDeck1);

                //System.out.println(_1LimitCoord + " " + _2LimitCoord + " " + _3LimitCoord + " " + _4LimitCoord
                //        + " " + _5LimitCoord + " " + _6LimitCoord + " " + _7LimitCoord + " " + _8LimitCoord);
                break;
        } // выход из оператора switch (b)

        return battlefield;
    } // выход из метода, определяющий границы корабля
} // выход из класса
