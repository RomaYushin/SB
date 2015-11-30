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
 * Описание класса. Deck3 - трехпалубный корабль. Данный класс необходим для генерирования случайных координат
 * корабля и границ корабля. Поэтому в этом классе два метода.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Deck3 extends Ships {
    /** класс наследуется от класса Ships - корабли. Из него вызываются методы генерирования случайных чисел.*/


    /**
     * private int [] deck3 - массив чисел, передаваемых в конструктор
     * Deck3(int[] deck3, int limitDeck3, int serialNumberOfDeck3 ) при создании объекта в классе Preparation,
     * содержит числа 311, 312, 313 или 351, 352, 353. Эти числа выступают
     * в качестве value в массиве battlefieldGamer или battlefieldComp для определения трехалубного корабля.
     * Дополнительную информацию см при комментировании класса Main.
     */
    private int[] deck3;

    /**
     * private int limitDeck3 - число, передаваемое в конструктор
     * Deck3(int[] deck3, int limitDeck3, int serialNumberOfDeck3 ) при создании объекта в классе Preparation,
     * содержит числа 31, 32 или 35, 36. Эти числа выступает в качестве value в массиве
     * battlefieldGamer или battlefieldComp для определения границ трехалубного корабля. Дополнительную информацию см
     * при комментировании класса Main.
     */
    private int limitDeck3;

    /**
     * rightLimitNumberForLetterHor (leftLimitNumberForLetterHor)-  число (от 65 до 73), которое будет преобразовано
     * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
     * координаты корабля для случая горизонтальной установки корабля (Hor).
     *
     * rightLimitNumberForLetterVer (leftLimitNumberForLetterVer)-  число (от 65 до 73), которое будет преобразовано
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

    /** _(1-12)LimitCoordHor ( _(1-12)LimitCoordVer ) - (1-я - 12-я) координата границы корабля, если корабль расположен
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
    private String _11LimitCoordHor;
    private String _12LimitCoordHor;

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
    private String _11LimitCoordVer;
    private String _12LimitCoordVer;

    /** private int firstRandomNumberForLetterHor (secondRandomNumberForLetterHor, thirdRandomNumberForLetterHor ) -
     * случайное число (в последствии будет преобразованно в букву)
     * для определения буквы (координата состоит из буквы и цифры) первой (второй, третьей соответственно)
     * координаты трехпалубного корабля по горизонтали
     */
    private int firstRandomNumberForLetterHor;
    private int secondRandomNumberForLetterHor;
    private int thirdRandomNumberForLetterHor;

    /**
     * private randomNumberForNumberHor - случайное число (координата состоит из буквы и цифры)
     * первой координаты трехпалубного корабля по горизонтали.
     * Не забываем, корабль находить по горизонтали, поэтому число одно, а буквы 2.
     */
    private int randomNumberForNumberHor;

    /**
     *  private int firstRandomNumberForNumberVer (secondRandomNumberForNumberVer, thirdRandomNumberForNumberVer)
     * случайное число (координата состоит из буквы и цифры)
     * первой (второй, третьей соответственно) координаты трехпалубного корабля по вертикали.
     */
    private int firstRandomNumberForNumberVer;
    private int secondRandomNumberForNumberVer;
    private int thirdRandomNumberForNumberVer;

    /**
     * private randomNumberForLetterVer - случайное число, в последствии будет преобразованно в букву)
     * первой координаты трехпалубного корабля по вертикали
     * Не забываем, корабль находить по вертикали, поэтому буква одна (цифры, в последствии будут преобразованы в буквы),
     * а цифры три.
     */
    private int randomNumberForLetterVer;

    /**
     *  private String firstCoordinateHor (secondCoordinateHor, thirdCoordinateHor ) - координаты трехпалубного
     *  корабля по горизонтали (например A1, B1, С1)
     */
    private String firstCoordinateHor;
    private String secondCoordinateHor;
    private String thirdCoordinateHor;

    /**
     * private String firstCoordinateVer (secondCoordinateVer, thirdCoordinateVer) - координаты трехпалубного корабля
     * по вертикали (например G1, G2, G3).
     */
    private String firstCoordinateVer;
    private String secondCoordinateVer;
    private String thirdCoordinateVer;

    /** private int serialNumberOfDeck3 - порядковый номер корабля. Может быть 1, 2, 3,*/
    int serialNumberOfDeck3;

    /**
     *  private int verOrHorPositionOfSpips - хранит число 1 или 0. Данная переменная определяет положение корабля.
     * 0 - горизонтально или 1 - вертикально
     */
    private int verOrHorPositionOfSpips;

    public Deck3(int[] deck3, int limitDeck3, int serialNumberOfDeck3 ) {

        this.deck3 = deck3;
        this.limitDeck3 = limitDeck3;
        this.serialNumberOfDeck3 = serialNumberOfDeck3;

    }
    public Deck3 ( int limitDeck3, int serialNumberOfDeck3 ) {

        this.limitDeck3 = limitDeck3;
        this.serialNumberOfDeck3 = serialNumberOfDeck3;
    }

    /**
     * Метод genCoordDeck3 - генерирует случайные координаты треххпалубного корабля (Например B3 B4 B5). Заносит эти
     * координаты в key коллекции battlefield. Значения int[] deck3, int limitDeck3 которое мы получили из конструктора
     * заносим в value коллекции battlefield.
     *
     * @param battlefield - в качестве аргумента принимает коллекцию - поле игрока либо поле компьютера.
     * @return - возвращает коллекцию battlefield.
     */
    public Map<String, Integer> genCoordDeck3(Map battlefield) {

        // вызываем метод, опередляющий положение корабля путем генерации числа 0 или 1 (горизонтально или вертикально)
        verOrHorPositionOfSpips = verOrHorPositionOfSpips();

        /*
         * в зависимости от выбранного числа verOrHorPositionOfSpips метод ветвиться на case 0,  case 1.
         * case 0 - горизонтально, case 1 - вертикально
         */
        switch (verOrHorPositionOfSpips) {
            case 0:
                /* выбираем случайное число для первой буквы и генерируем еще 2 числа. Это будут буквы координат 3-х
                 * палубного корабля firstRandomNumberForLetterHor, secondRandomNumberForLetterHor,
                 * thirdRandomNumberForLetterHor - буквы координат 3-х палубного корабля
                 */
                firstRandomNumberForLetterHor = (int) (Math.random() * 8 + 65); // число должно быть от 65 до 72
                // Генерируем еще 1 число путем прибавления 1.
                secondRandomNumberForLetterHor = firstRandomNumberForLetterHor + 1;
                // Генерируем еще 1 число путем прибавления 1.
                thirdRandomNumberForLetterHor = secondRandomNumberForLetterHor + 1;


                // заносим в коллекцию battlefield вспомогательные пары для границ корабля.
                battlefield.put("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3, firstRandomNumberForLetterHor);
                battlefield.put("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3, secondRandomNumberForLetterHor);
                battlefield.put("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3, thirdRandomNumberForLetterHor);

                // выбираем случайное число для координат корабля т.к корабль горизонтально, то буквы три, цифра одна.
                randomNumberForNumberHor = mFirstRandomNumberForNumber(); // число должно быть от 1 до 10

                // заносим в коллекцию battlefield вспомогательную пару для границ корабля.
                battlefield.put("randomNumberForNumber_deck3"+serialNumberOfDeck3, randomNumberForNumberHor);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateHor = Character.toString((char) firstRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);
                secondCoordinateHor = Character.toString((char) secondRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);
                thirdCoordinateHor = Character.toString((char) thirdRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);

                // Вывод на экран сформировавшихся координат корабля ДО проверки
                //System.out.println(firstCoordinateHor + " " + secondCoordinateHor + " " + thirdCoordinateHor +
                //        " координаты корабля для отладки по горизонтали ДО проверки"); // координаты корабля для отладки

                // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
                if (       battlefield.get(firstCoordinateHor).equals(0)
                        && battlefield.get(secondCoordinateHor).equals(0)
                        && battlefield.get(thirdCoordinateHor).equals(0)) {
                } else {
                    return genCoordDeck3(battlefield);
                }

                // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
                //System.out.println(firstCoordinateHor + " " + secondCoordinateHor + " " + thirdCoordinateHor +
                //        " координаты корабля для отладки по горизонтали ПОСЛЕ проверки"); // координаты корабля для отладки

                /* добавляем в коллекцию battlefield числа 311, 312, 313;  321, 322, 323.
                 * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
                 */
                battlefield.replace(firstCoordinateHor, battlefield.get(firstCoordinateHor), deck3[0]);
                battlefield.replace(secondCoordinateHor, battlefield.get(secondCoordinateHor), deck3[1]);
                battlefield.replace(thirdCoordinateHor, battlefield.get(thirdCoordinateHor), deck3[2]);

                // добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("positionOfDeck3" + serialNumberOfDeck3, verOrHorPositionOfSpips);
                battlefield.put("firstCoord_deck3" + serialNumberOfDeck3, firstCoordinateHor);
                battlefield.put("secondCoord_deck3" + serialNumberOfDeck3, secondCoordinateHor);
                battlefield.put("thirdCoord_deck3" + serialNumberOfDeck3, thirdCoordinateHor);
                break;

            case 1:
                //выбираем случайное число для буквы. Это будет единственная буква координат 3-х палубного корабля
                randomNumberForLetterVer = mFirstRandomNumberForLetter(); // число должно быть от 65 до 74

                // добавляем вспомогательную пару для генерации границ корабля
                battlefield.put("randomNumberForLetter_deck3" + serialNumberOfDeck3, randomNumberForLetterVer);

                // выбираем случайную цифру от 1 до 8, она будет показывать в каком ряде находиться первая координата корабля
                firstRandomNumberForNumberVer = (int) (Math.random() * 8 + 1); // число должно быть от 1 до 8
                secondRandomNumberForNumberVer = firstRandomNumberForNumberVer + 1;
                thirdRandomNumberForNumberVer = secondRandomNumberForNumberVer + 1;

                //добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3, firstRandomNumberForNumberVer);
                battlefield.put("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3, secondRandomNumberForNumberVer);
                battlefield.put("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3, thirdRandomNumberForNumberVer);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(firstRandomNumberForNumberVer);
                secondCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(secondRandomNumberForNumberVer);
                thirdCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(thirdRandomNumberForNumberVer);

                // Вывод на экран сформировавшихся координат корабля ДО проверки
                //System.out.println(firstCoordinateVer + " " + secondCoordinateVer + " " + thirdCoordinateVer +
                //        " координаты корабля для отладки по вертикали ДО проверки"); // координаты корабля для отладки

                // Выполним проверку, не совпали ли сформировавшиеся координаты с координатами уже установленных кораблей
                if (battlefield.get(firstCoordinateVer).equals(0)
                        && battlefield.get(secondCoordinateVer).equals(0)
                        && battlefield.get(thirdCoordinateVer).equals(0)) {
                } else {
                    return genCoordDeck3(battlefield);
                }

                // Вывод на экран сформировавшихся координат корабля ПОСЛЕ проверки
                //System.out.println(firstCoordinateVer + " " + secondCoordinateVer + " " + thirdCoordinateVer +
                //        " координаты корабля для отладки по вертикали ПОСЛЕ проверки"); // координаты корабля для отладки

                /* добавляем в коллекцию battlefield числа 311, 312, 313, или 321, 322, 323.
                 * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
                 */
                battlefield.replace(firstCoordinateVer, battlefield.get(firstCoordinateVer), deck3[0]);
                battlefield.replace(secondCoordinateVer, battlefield.get(secondCoordinateVer), deck3[1]);
                battlefield.replace(thirdCoordinateVer, battlefield.get(thirdCoordinateVer), deck3[2]);

                // добавляем вспомогательные пары в коллекцию для генерации границ корабля в другом методе
                battlefield.put("positionOfDeck3" + serialNumberOfDeck3, verOrHorPositionOfSpips);
                battlefield.put("firstCoord_deck3"+ serialNumberOfDeck3, firstCoordinateVer);
                battlefield.put("secondCoord_deck3"+ serialNumberOfDeck3, secondCoordinateVer);
                battlefield.put("thirdCoord_deck3"+ serialNumberOfDeck3, thirdCoordinateVer);

                break;
        } return battlefield;
    }

    /**
     * Метод genCoordDeck3 - генерирует случайную координату трехпалубного корабля (Например B3, C3, D3).
     * Заносит эти координаты в key коллекции battlefield. Значения int[] deck3, int limitDeck3 которое мы
     * получили из конструктора заносим в value коллекции battlefield.
     *
     * genLimitCoordDeck3 - метод, устанавливающий координаты границ трехпалубных кораблей.
     * @param battlefield
     * @return
     */
    public Map<String, Integer> genLimitCoordDeck3 (Map battlefield) {

        /**
         *  В игре есть 9 вариантов расположения корабля ГОРИЗОНТАЛЬНО (case 0) и  9 вариантов расположения корабля
         * ВЕРТИКАЛЬНО (case 1) в контексте относительно границ поля игры.
         * Необходимо описать каждый из вариантов. Выбор между вариантами будет выполнен с помощью оператора switch.
         * Для этого в коллекции Map battlefield получаем значение (value) verOrHorPositionOfSpips по ключу
         * positionOfDeck3.
         */
        switch ((int) battlefield.get("positionOfDeck3" + serialNumberOfDeck3)) {
            case 0:
                /*
                 * В зависимости от первой координаты трехпалубного корабля выбираем один из 9 - ти случаев
                 * ГОРИЗОНТАЛЬНОГО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateHor по ключу firstCoord_3deck.
                 */
                int b;
                if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A1")) {
                    b = 0;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("B1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("C1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("D1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("E1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("F1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("G1")) {
                    b = 1;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H1")) {
                    b = 2;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H2")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H3")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H4")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H5")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H6")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H7")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H9")) {
                    b = 3;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H10")) {
                    b = 4;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("B10")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("C10")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("D10")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("E10")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("F10")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("G10")) {
                    b = 5;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A10")) {
                    b = 6;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A2")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A3")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A4")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A5")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A6")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A7")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A9")) {
                    b = 7;
                } else {
                    b = 8;
                }
                //System.out.println(b + " число для выбора switch"); // Для отладки программы

                /* Исходя из выбранного числа b выбираем один из девяти случаев расположения корабля и расставляем границы корабля
                 * Переменные описаны выше.
                 */
                switch (b) {
                    case 0:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3)) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) - 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor);

                        break;
                    case 1:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3)) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) + 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck3);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor);

                        break;
                    case 2:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3)) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) + 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor);

                        break;
                    case 3:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3)) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));
                        _6LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck3);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck3);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck3);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck3);


                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                        //        _9LimitCoordHor);

                        break;
                    case 4:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3)) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor);

                        break;
                    case 5:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3)) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck3);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //         + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor);

                        break;
                    case 6:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor);

                        break;
                    case 7:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3)) + 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck3);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck3);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck3);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                        //        _9LimitCoordHor);

                        break;
                    case 8:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3)) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3)) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));
                        _7LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _10LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_deck3"+serialNumberOfDeck3))) + bottomLimitNumberHor;
                        _11LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _12LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + ((int) battlefield.get("randomNumberForNumber_deck3"+serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck3);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck3);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck3);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck3);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck3);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck3);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck3);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck3);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck3);
                        battlefield.replace(_10LimitCoordHor, battlefield.get(_10LimitCoordHor), limitDeck3);
                        battlefield.replace(_11LimitCoordHor, battlefield.get(_11LimitCoordHor), limitDeck3);
                        battlefield.replace(_12LimitCoordHor, battlefield.get(_12LimitCoordHor), limitDeck3);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                        //        _9LimitCoordHor + " " + _10LimitCoordHor + " " + _11LimitCoordHor + " " + _12LimitCoordHor);
                        break;
                } break;
            case 1:
                /*
                 * В зависимости от первой координаты трехпалубного корабля выбираем один из 9 - ти случаев
                 * ВЕРТИКАЛЬНО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateVer по ключу firstCoord_3deck.
                 */
                int c = 0;
                if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A1")) {
                    c = 0;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("B1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("C1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("D1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("E1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("F1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("G1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H1")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("I1")) {
                    c = 1;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J1")) {
                    c = 2;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J2")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J3")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J4")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J5")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J6")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J7")) {
                    c = 3;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("J8")) {
                    c = 4;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("B8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("C8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("D8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("E8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("F8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("G8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("H8")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("I8")) {
                    c = 5;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A8")) {
                    c = 6;
                } else if (battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A2")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A3")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A4")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A5")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A6")
                        || battlefield.get("firstCoord_deck3" + serialNumberOfDeck3).equals("A7")) {
                    c = 7;
                } else {
                    c = 8;
                }
                //System.out.println(b + " число для выбора switch"); // Для отладки программы

                /* Исходя из выбранного числа b выбираем один из девяти случаев расположения корабля и расставляем границы корабля
                 * Переменные описаны выше.
                 */
                switch (c) {
                    case 0:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) - 1;

                        bottomLimitNumberVer = ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3)) - 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer );

                        break;
                    case 1:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3)) + 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + bottomLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _8LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _9LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck3);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck3);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck3);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                        //        + " " + _9LimitCoordVer);

                        break;
                    case 2:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3)) + 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer );

                        break;
                    case 3:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3)) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _6LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck3);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer );

                        break;
                    case 4:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3)) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer );

                        break;
                    case 5:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3)) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _5LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + topLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _8LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _9LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));


                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck3);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck3);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck3);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                        //        + " " + _9LimitCoordVer );

                        break;
                    case 6:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3)) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer );

                        break;
                    case 7:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) + 1;
                        bottomLimitNumberVer = ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3)) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck3);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer );

                        break;
                    case 8:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3)) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3)) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3)) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _7LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _8LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_deck3" + serialNumberOfDeck3))) + bottomLimitNumberVer;
                        _9LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _10LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _11LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_deck3" + serialNumberOfDeck3));
                        _12LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_deck3" + serialNumberOfDeck3));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck3);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck3);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck3);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck3);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck3);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck3);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck3);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck3);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck3);
                        battlefield.replace(_10LimitCoordVer, battlefield.get(_10LimitCoordVer), limitDeck3);
                        battlefield.replace(_11LimitCoordVer, battlefield.get(_11LimitCoordVer), limitDeck3);
                        battlefield.replace(_12LimitCoordVer, battlefield.get(_12LimitCoordVer), limitDeck3);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                        //        + " " + _9LimitCoordVer + " " + _10LimitCoordVer + " " + _11LimitCoordVer+ " " + _12LimitCoordVer);
                        break; // выход из case 8:
                }

        break; // выход из case 1
        } //конец switch ((int) battlefield.get("positionOfDeck3")) {
        return battlefield;
    } // выход из метода, определяющий границы корабля
} // выход из класса
