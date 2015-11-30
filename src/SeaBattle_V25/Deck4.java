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
 * Описание класса. Deck4 - четырехпалубный корабль. Данный класс необходим для генерирования случайных координат
 * корабля и границ корабля. Поэтому в этом классе два метода.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class Deck4 extends Ships {
    /** класс наследуется от класса Ships - корабли. Из него вызываются методы генерирования случайных чисел.*/

    /**
     * private int [] deck4 - массив чисел, передаваемых в конструктор
     * Deck4(int[] deck4, int limitDeck4, int serialNumberOfDeck4 ) при создании объекта в классе Preparation,
     * содержит числа 411, 412, 413, 414 или 451, 452, 453, 454. Эти числа выступают
     * в качестве value в массиве battlefieldGamer или battlefieldComp для определения трехалубного корабля.
     * Дополнительную информацию см при комментировании класса Main.
     */
    private int [] deck4;

    /**
     * private int limitDeck4 - число, передаваемое в конструктор
     * Deck4(int[] deck4, int limitDeck4, int serialNumberOfDeck4 ) при создании объекта в классе Preparation,
     * содержит числа 41 или 45. Эти числа выступает в качестве value в массиве
     * battlefieldGamer или battlefieldComp для определения границ четырехпалубного корабля. Дополнительную информацию
     * см при комментировании класса Main.
     */
    private int limitDeck4;

    /**
     * rightLimitNumberForLetterHor (leftLimitNumberForLetterHor)-  число (от 65 до 72), которое будет преобразовано
     * в букву через char, первая составляющая (т.к координата состоит из буквы и цифры) правой (левой)граничной
     * координаты корабля для случая горизонтальной установки корабля (Hor).
     *
     * rightLimitNumberForLetterVer (leftLimitNumberForLetterVer)-  число (от 65 до 72), которое будет преобразовано
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

    /** _(1-14)LimitCoordHor ( _(1-14)LimitCoordVer ) - (1-я - 14-я) координата границы корабля, если корабль расположен
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
    private String _13LimitCoordHor;
    private String _14LimitCoordHor;

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
    private String _13LimitCoordVer;
    private String _14LimitCoordVer;

    /**
     * private int firstRandomNumberForLetterHor (secondRandomNumberForLetterHor, thirdRandomNumberForLetterHor,
     * fourthRandomNumberForLetterHor) - случайное число (в последствии будет преобразованно в букву)
     * для определения буквы (координата состоит из буквы и цифры) первой (второй, третьей соответственно)
     * координаты трехпалубного корабля по горизонтали
     */
    private int firstRandomNumberForLetterHor;
    private int secondRandomNumberForLetterHor;
    private int thirdRandomNumberForLetterHor;
    private int fourthRandomNumberForLetterHor;

    /**
     * private randomNumberForNumberHor - случайное число (координата состоит из буквы и цифры)
     * первой координаты трехпалубного корабля по горизонтали.
     * Не забываем, корабль находить по горизонтали, поэтому число одно, а буквы 2.
     */
    private int randomNumberForNumberHor;

    /**
     *  private int firstRandomNumberForNumberVer (secondRandomNumberForNumberVer, thirdRandomNumberForNumberVer,
     *  fourthRandomNumberForNumberVer) - случайное число (координата состоит из буквы и цифры)
     *  первой (второй, третьей, четвертьой соответственно) координаты четырехпалубного корабля по вертикали.
     */
    private int firstRandomNumberForNumberVer;
    private int secondRandomNumberForNumberVer;
    private int thirdRandomNumberForNumberVer;
    private int fourthRandomNumberForNumberVer;

    /**
     * private randomNumberForLetterVer - случайное число, в последствии будет преобразованно в букву)
     * первой координаты трехпалубного корабля по вертикали
     * Не забываем, корабль находить по вертикали, поэтому буква одна (цифры, в последствии будут преобразованы в буквы),
     * а цифры четыре.
     */
    private int randomNumberForLetterVer;

    /**
     *  private String firstCoordinateHor (secondCoordinateHor, thirdCoordinateHor ) - координаты трехпалубного
     *  корабля по горизонтали (например A1, B1, С1, D1)
     */
    private String firstCoordinateHor;
    private String secondCoordinateHor;
    private String thirdCoordinateHor;
    private String fourthCoordinateHor;

    /**
     * private String firstCoordinateVer (secondCoordinateVer, thirdCoordinateVer) - координаты трехпалубного корабля
     * по вертикали (например G1, G2, G3, G4).
     */
    private String firstCoordinateVer;
    private String secondCoordinateVer;
    private String thirdCoordinateVer;
    private String fourthCoordinateVer;

    /**
     *  private int verOrHorPositionOfSpips - хранит число 1 или 0. Данная переменная определяет положение корабля.
     * 0 - горизонтально или 1 - вертикально
     */
    int verOrHorPositionOfSpips;

    // Конструкторы
    public Deck4 (int[] deck4, int limitDeck4) {

        this.deck4 = deck4;
        this.limitDeck4=limitDeck4;
    }
    public Deck4 (int limitDeck4) {

        this.limitDeck4=limitDeck4;
    }

    /**
     * Метод genCoordDeck4 - генерирует случайные координаты четырехпалубного корабля (Например B3 B4 B5, B6)
     * Заносит эти координаты в key коллекции battlefield. Значения int[] deck4, int limitDeck4 которое мы получили
     * из конструктора заносим в value коллекции battlefield.
     *
     * @param battlefield - в качестве аргумента принимает коллекцию - поле игрока либо поле компьютера.
     * @return - возвращает коллекцию battlefield.
     */
    public Map<String, Integer> genCoordDeck4(Map battlefield) {

        // вызываем метод, опередляющий положение корабля путем генерации числа 0 или 1 (горизонтально или вертикально)
        verOrHorPositionOfSpips = verOrHorPositionOfSpips();

        /*
         * в зависимости от выбранного числа verOrHorPositionOfSpips метод ветвиться на case 0,  case 1.
         * case 0 - горизонтально, case 1 - вертикально
         */
        switch (verOrHorPositionOfSpips) {
            case 0:
                /*
                 * выбираем случайное число для первой буквы и генерируем еще 3 числа. Это будут буквы координат 4-х
                 * палубного корабля firstRandomNumberForLetterHor, secondRandomNumberForLetterHor,
                 * thirdRandomNumberForLetterHor fourthRandomNumberForLetterHor - буквы координат 4-х палубного корабля
                 */
                firstRandomNumberForLetterHor = (int) (Math.random() * 7 + 65); // число должно быть от 65 до 71
                // Генерируем еще 1 число путем прибавления 1.
                secondRandomNumberForLetterHor = firstRandomNumberForLetterHor + 1;
                // Генерируем еще 1 число путем прибавления 1.
                thirdRandomNumberForLetterHor = secondRandomNumberForLetterHor + 1;
                // Генерируем еще 1 число путем прибавления 1.
                fourthRandomNumberForLetterHor = thirdRandomNumberForLetterHor + 1;

                // заносим в коллекцию battlefield вспомогательные пары для границ корабля.
                battlefield.put("firstRandomNumberForLetter_4deck", firstRandomNumberForLetterHor);
                battlefield.put("secondRandomNumberForLetter_4deck", secondRandomNumberForLetterHor);
                battlefield.put("thirdRandomNumberForLetter_4deck", thirdRandomNumberForLetterHor);
                battlefield.put("fourthRandomNumberForLetter_4deck", fourthRandomNumberForLetterHor);

                // выбираем случайное число для координат корабля т.к корабль горизонтально, то буквы четыре, цифра одна.
                randomNumberForNumberHor = mFirstRandomNumberForNumber(); // число должно быть от 1 до 10

                // заносим в коллекцию battlefield вспомогательную пару для границ корабля.
                battlefield.put("randomNumberForNumber_4deck", randomNumberForNumberHor);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateHor = Character.toString((char) firstRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);
                secondCoordinateHor = Character.toString((char) secondRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);
                thirdCoordinateHor = Character.toString((char) thirdRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);
                fourthCoordinateHor = Character.toString((char) fourthRandomNumberForLetterHor) + Integer.toString(randomNumberForNumberHor);

                /*
                 * добавляем в коллекцию battlefield числа 411, 412, 413, 414;  451, 452, 453, 454.
                 * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
                 */
                battlefield.replace(firstCoordinateHor, battlefield.get(firstCoordinateHor), deck4[0]);
                battlefield.replace(secondCoordinateHor, battlefield.get(secondCoordinateHor), deck4[1]);
                battlefield.replace(thirdCoordinateHor, battlefield.get(thirdCoordinateHor), deck4[2]);
                battlefield.replace(fourthCoordinateHor, battlefield.get(fourthCoordinateHor), deck4[3]);

                // добавляем в массив новые значения для генерации границ корабля в другом методе
                battlefield.put("positionOfDeck4", verOrHorPositionOfSpips);
                battlefield.put("firstCoord_4deck", firstCoordinateHor);
                battlefield.put("secondCoord_4deck", secondCoordinateHor);
                battlefield.put("thirdCoord_4deck", thirdCoordinateHor);
                battlefield.put("fourthCoord_4deck", fourthCoordinateHor);

                //System.out.println(firstCoordinateHor + " " + secondCoordinateHor + " " + thirdCoordinateHor + " " + fourthCoordinateHor
                //        + " координаты корабля для отладки по горизонтали"); // координаты корабля для отладки
                break;

            case 1:
                //выбираем случайное число для буквы. Это будет единственная буква координат 4-х палубного корабля
                randomNumberForLetterVer = mFirstRandomNumberForLetter(); // число должно быть от 65 до 74

                // добавляем вспомогательную пару для генерации границ корабля
                battlefield.put("randomNumberForLetter_4deck", randomNumberForLetterVer);

                // выбираем случайную цифру от 1 до 7, генерируем еще три числа, эту будут числа координат корабля
                firstRandomNumberForNumberVer = (int) (Math.random() * 7 + 1); // число должно быть от 1 до 7
                secondRandomNumberForNumberVer = firstRandomNumberForNumberVer + 1;
                thirdRandomNumberForNumberVer = secondRandomNumberForNumberVer + 1;
                fourthRandomNumberForNumberVer = thirdRandomNumberForNumberVer + 1;

                // добавляем вспомогательную пару для генерации границ корабля
                battlefield.put("firstRandomNumberForNumber_4deck", firstRandomNumberForNumberVer);
                battlefield.put("secondRandomNumberForNumber_4deck", secondRandomNumberForNumberVer);
                battlefield.put("thirdRandomNumberForNumber_4deck", thirdRandomNumberForNumberVer);
                battlefield.put("fourthRandomNumberForNumber_4deck", fourthRandomNumberForNumberVer);

                // соодиняем букву и цифру, получаем координаты корабля
                firstCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(firstRandomNumberForNumberVer);
                secondCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(secondRandomNumberForNumberVer);
                thirdCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(thirdRandomNumberForNumberVer);
                fourthCoordinateVer = Character.toString((char) randomNumberForLetterVer) + Integer.toString(fourthRandomNumberForNumberVer);

                /* добавляем в коллекцию battlefield числа 411, 412, 413, 414.
                 * Они в дальнейшем понадобяться для сравнения введенного игроком значения с содержимим координаты.
                 */
                battlefield.replace(firstCoordinateVer, battlefield.get(firstCoordinateVer), deck4[0]);
                battlefield.replace(secondCoordinateVer, battlefield.get(secondCoordinateVer), deck4[1]);
                battlefield.replace(thirdCoordinateVer, battlefield.get(thirdCoordinateVer), deck4[2]);
                battlefield.replace(fourthCoordinateVer, battlefield.get(fourthCoordinateVer), deck4[3]);

                // добавляем вспомогательные пары в коллекцию для генерации границ корабля в другом методе
                battlefield.put("positionOfDeck4", verOrHorPositionOfSpips);
                battlefield.put("firstCoord_4deck", firstCoordinateVer);
                battlefield.put("secondCoord_4deck", secondCoordinateVer);
                battlefield.put("thirdCoord_4deck", thirdCoordinateVer);
                battlefield.put("fourthCoord_4deck", fourthCoordinateVer);

                //System.out.println(firstCoordinateVer + " " + secondCoordinateVer + " " + thirdCoordinateVer + " " + fourthCoordinateVer
                //        + " координаты корабля для отладки по вертикали"); // для отладки координаты корабля по вертикали


                break;
        } return battlefield;
    }

    /**
     * Метод genCoordDeck4 - генерирует случайную координату четырехпалубного корабля (Например B3, C3, D3, E3).
     * Заносит эти координаты в key коллекции battlefield. Значения int[] deck4, int limitDeck4 которое мы
     * получили из конструктора заносим в value коллекции battlefield.
     *
     * genLimitCoordDeck4 - метод, устанавливающий координаты границ четырехпалубных кораблей.
     * @param battlefield
     * @return
     */
    public Map<String, Integer> genLimitCoordDeck4 (Map battlefield) {

        /**
         *  В игре есть 9 вариантов расположения корабля ГОРИЗОНТАЛЬНО (case 0) и  9 вариантов расположения корабля
         * ВЕРТИКАЛЬНО (case 1) в контексте относительно границ поля игры.
         * Необходимо описать каждый из вариантов. Выбор между вариантами будет выполнен с помощью оператора switch.
         * Для этого в коллекции Map battlefield получаем значение (value) verOrHorPositionOfSpips по ключу
         * positionOfDeck4.
         */
        switch ((int) battlefield.get("positionOfDeck4")) {
            case 0:
                /*
                 * В зависимости от первой координаты четырехпалубного корабля выбираем один из 9 - ти случаев
                 * ГОРИЗОНТАЛЬНОГО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateHor по ключу firstCoord_4deck.
                 */
                int b;
                if (battlefield.get("firstCoord_4deck").equals("A1")) {
                    b = 0;
                } else if (battlefield.get("firstCoord_4deck").equals("B1")
                        || battlefield.get("firstCoord_4deck").equals("C1")
                        || battlefield.get("firstCoord_4deck").equals("D1")
                        || battlefield.get("firstCoord_4deck").equals("E1")
                        || battlefield.get("firstCoord_4deck").equals("F1")) {
                    b = 1;
                } else if (battlefield.get("firstCoord_4deck").equals("G1")) {
                    b = 2;
                } else if (battlefield.get("firstCoord_4deck").equals("G2")
                        || battlefield.get("firstCoord_4deck").equals("G3")
                        || battlefield.get("firstCoord_4deck").equals("G4")
                        || battlefield.get("firstCoord_4deck").equals("G5")
                        || battlefield.get("firstCoord_4deck").equals("G6")
                        || battlefield.get("firstCoord_4deck").equals("G7")
                        || battlefield.get("firstCoord_4deck").equals("G8")
                        || battlefield.get("firstCoord_4deck").equals("G9")) {
                    b = 3;
                } else if (battlefield.get("firstCoord_4deck").equals("G10")) {
                    b = 4;
                } else if (battlefield.get("firstCoord_4deck").equals("B10")
                        || battlefield.get("firstCoord_4deck").equals("C10")
                        || battlefield.get("firstCoord_4deck").equals("D10")
                        || battlefield.get("firstCoord_4deck").equals("E10")
                        || battlefield.get("firstCoord_4deck").equals("F10")) {
                    b = 5;
                } else if (battlefield.get("firstCoord_4deck").equals("A10")) {
                    b = 6;
                } else if (battlefield.get("firstCoord_4deck").equals("A2")
                        || battlefield.get("firstCoord_4deck").equals("A3")
                        || battlefield.get("firstCoord_4deck").equals("A4")
                        || battlefield.get("firstCoord_4deck").equals("A5")
                        || battlefield.get("firstCoord_4deck").equals("A6")
                        || battlefield.get("firstCoord_4deck").equals("A7")
                        || battlefield.get("firstCoord_4deck").equals("A8")
                        || battlefield.get("firstCoord_4deck").equals("A9")) {
                    b = 7;
                } else {
                    b = 8;
                }
                //System.out.println(b + " число для выбора switch"); // Для отладки программы

                /*
                 * Исходя из выбранного числа b выбираем один из девяти случаев расположения корабля и расставляем границы корабля
                 * Переменные описаны выше.
                 */
                switch (b) {
                    case 0:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("fourthRandomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_4deck")) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) + 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 1:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("fourthRandomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_4deck")) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) + 1;

                        _1LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");
                        _2LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck4);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck4);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor);

                        break;
                    case 2:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_4deck")) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) + 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 3:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_4deck")) - 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");
                        _7LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _10LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _11LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck4);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck4);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck4);
                        battlefield.replace(_10LimitCoordHor, battlefield.get(_10LimitCoordHor), limitDeck4);
                        battlefield.replace(_11LimitCoordHor, battlefield.get(_11LimitCoordHor), limitDeck4);


                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                        //        _9LimitCoordHor + " " + _10LimitCoordHor + " " + _11LimitCoordHor);

                        break;
                    case 4:
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_4deck")) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + topLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 5:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("fourthRandomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterHor =((int) battlefield.get("firstRandomNumberForLetter_4deck")) - 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");
                        _2LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck4);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck4);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor);

                        break;
                    case 6:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("fourthRandomNumberForLetter_4deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor);

                        break;
                    case 7:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("fourthRandomNumberForLetter_4deck")) + 1;
                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");
                        _7LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _8LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _10LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _11LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck4);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck4);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck4);
                        battlefield.replace(_10LimitCoordHor, battlefield.get(_10LimitCoordHor), limitDeck4);
                        battlefield.replace(_11LimitCoordHor, battlefield.get(_11LimitCoordHor), limitDeck4);

                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                        //        _9LimitCoordHor + " " + _10LimitCoordHor + " " + _11LimitCoordHor);

                        break;
                    case 8:
                        rightLimitNumberForLetterHor = ((int) battlefield.get("fourthRandomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterHor = ((int) battlefield.get("firstRandomNumberForLetter_4deck")) - 1;

                        bottomLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) + 1;
                        topLimitNumberHor = ((int) battlefield.get("randomNumberForNumber_4deck")) - 1;

                        _1LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + topLimitNumberHor;
                        _2LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _3LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _4LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _5LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + topLimitNumberHor;
                        _6LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + topLimitNumberHor;
                        _7LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");
                        _8LimitCoordHor = Character.toString((char) rightLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _9LimitCoordHor = Character.toString((char) ((int) battlefield.get("fourthRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _10LimitCoordHor = Character.toString((char) ((int) battlefield.get("thirdRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _11LimitCoordHor = Character.toString((char) ((int) battlefield.get("secondRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _12LimitCoordHor = Character.toString((char) ((int) battlefield.get("firstRandomNumberForLetter_4deck"))) + bottomLimitNumberHor;
                        _13LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + bottomLimitNumberHor;
                        _14LimitCoordHor = Character.toString((char) leftLimitNumberForLetterHor) + battlefield.get("randomNumberForNumber_4deck");

                        battlefield.replace(_1LimitCoordHor, battlefield.get(_1LimitCoordHor), limitDeck4);
                        battlefield.replace(_2LimitCoordHor, battlefield.get(_2LimitCoordHor), limitDeck4);
                        battlefield.replace(_3LimitCoordHor, battlefield.get(_3LimitCoordHor), limitDeck4);
                        battlefield.replace(_4LimitCoordHor, battlefield.get(_4LimitCoordHor), limitDeck4);
                        battlefield.replace(_5LimitCoordHor, battlefield.get(_5LimitCoordHor), limitDeck4);
                        battlefield.replace(_6LimitCoordHor, battlefield.get(_6LimitCoordHor), limitDeck4);
                        battlefield.replace(_7LimitCoordHor, battlefield.get(_7LimitCoordHor), limitDeck4);
                        battlefield.replace(_8LimitCoordHor, battlefield.get(_8LimitCoordHor), limitDeck4);
                        battlefield.replace(_9LimitCoordHor, battlefield.get(_9LimitCoordHor), limitDeck4);
                        battlefield.replace(_10LimitCoordHor, battlefield.get(_10LimitCoordHor), limitDeck4);
                        battlefield.replace(_11LimitCoordHor, battlefield.get(_11LimitCoordHor), limitDeck4);
                        battlefield.replace(_12LimitCoordHor, battlefield.get(_12LimitCoordHor), limitDeck4);
                        battlefield.replace(_13LimitCoordHor, battlefield.get(_13LimitCoordHor), limitDeck4);
                        battlefield.replace(_14LimitCoordHor, battlefield.get(_14LimitCoordHor), limitDeck4);


                        //System.out.println(_1LimitCoordHor + " " + _2LimitCoordHor + " " + _3LimitCoordHor + " " + " " + _4LimitCoordHor
                        //        + " " + _5LimitCoordHor + " " + _6LimitCoordHor + " " + _7LimitCoordHor + " " + _8LimitCoordHor + " " +
                        //        _9LimitCoordHor + " " + _10LimitCoordHor + " " + _11LimitCoordHor + " " +
                        //        _12LimitCoordHor + " " + _13LimitCoordHor + " " + _14LimitCoordHor);
                        break; // выход из case 8
                } break; // выход из case 0
            case 1:
                /*
                 * В зависимости от первой координаты четырехпалубного корабля выбираем один из 9 - ти случаев
                 * ВЕРТИКАЛЬНО расположения корабля. Для этого из коллекции Map Battlefield получаем значение
                 * firstCoordinateVer по ключу firstCoord_4deck.
                 */

                int c = 0;
                if (battlefield.get("firstCoord_4deck").equals("A1")) {
                    c = 0;
                } else if (battlefield.get("firstCoord_4deck").equals("B1")
                        || battlefield.get("firstCoord_4deck").equals("C1")
                        || battlefield.get("firstCoord_4deck").equals("D1")
                        || battlefield.get("firstCoord_4deck").equals("E1")
                        || battlefield.get("firstCoord_4deck").equals("F1")
                        || battlefield.get("firstCoord_4deck").equals("G1")
                        || battlefield.get("firstCoord_4deck").equals("H1")
                        || battlefield.get("firstCoord_4deck").equals("I1")) {
                    c = 1;
                } else if (battlefield.get("firstCoord_4deck").equals("J1")) {
                    c = 2;
                } else if (battlefield.get("firstCoord_4deck").equals("J2")
                        || battlefield.get("firstCoord_4deck").equals("J3")
                        || battlefield.get("firstCoord_4deck").equals("J4")
                        || battlefield.get("firstCoord_4deck").equals("J5")
                        || battlefield.get("firstCoord_4deck").equals("J6")) {
                    c = 3;
                } else if (battlefield.get("firstCoord_4deck").equals("J7")) {
                    c = 4;
                } else if (battlefield.get("firstCoord_4deck").equals("B7")
                        || battlefield.get("firstCoord_4deck").equals("C7")
                        || battlefield.get("firstCoord_4deck").equals("D7")
                        || battlefield.get("firstCoord_4deck").equals("E7")
                        || battlefield.get("firstCoord_4deck").equals("F7")
                        || battlefield.get("firstCoord_4deck").equals("G7")
                        || battlefield.get("firstCoord_4deck").equals("H7")
                        || battlefield.get("firstCoord_4deck").equals("I7")) {
                    c = 5;
                } else if (battlefield.get("firstCoord_4deck").equals("A7")) {
                    c = 6;
                } else if (battlefield.get("firstCoord_4deck").equals("A2")
                        || battlefield.get("firstCoord_4deck").equals("A3")
                        || battlefield.get("firstCoord_4deck").equals("A4")
                        || battlefield.get("firstCoord_4deck").equals("A5")
                        || battlefield.get("firstCoord_4deck").equals("A6")) {
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
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) - 1;

                        bottomLimitNumberVer = ((int) battlefield.get("fourthRandomNumberForNumber_4deck")) + 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 1:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("fourthRandomNumberForNumber_4deck")) + 1;

                        _1LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + bottomLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _8LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _9LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _10LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _11LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck4);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck4);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck4);
                        battlefield.replace(_10LimitCoordVer, battlefield.get(_10LimitCoordVer), limitDeck4);
                        battlefield.replace(_11LimitCoordVer, battlefield.get(_11LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                        //        + " " + _9LimitCoordVer + " " + _10LimitCoordVer + " " + _11LimitCoordVer);

                        break;
                    case 2:
                        leftLimitNumberForLetterVer = randomNumberForLetterVer - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("fourthRandomNumberForNumber_4deck")) + 1;

                        _1LimitCoordVer = Character.toString((char) randomNumberForLetterVer) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _6LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 3:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) - 1;
                        bottomLimitNumberVer = ((int) battlefield.get("fourthRandomNumberForNumber_4deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_4deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + bottomLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _6LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _7LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _8LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck4);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer);

                        break;
                    case 4:
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_4deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + topLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 5:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) - 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_4deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _2LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _3LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _6LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + topLimitNumberVer;
                        _7LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _8LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _9LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _10LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _11LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck4);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck4);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck4);
                        battlefield.replace(_10LimitCoordVer, battlefield.get(_10LimitCoordVer), limitDeck4);
                        battlefield.replace(_11LimitCoordVer, battlefield.get(_11LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //       + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                        //       + " " + _9LimitCoordVer + " " + _10LimitCoordVer + " " + _11LimitCoordVer);

                        break;
                    case 6:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_4deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);


                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer);

                        break;
                    case 7:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) + 1;
                        bottomLimitNumberVer = ((int) battlefield.get("fourthRandomNumberForNumber_4deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_4deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _7LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _8LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + bottomLimitNumberVer;

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck4);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer);

                        break;
                    case 8:
                        rightLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) + 1;
                        leftLimitNumberForLetterVer = ((int) battlefield.get("randomNumberForLetter_4deck")) - 1;

                        bottomLimitNumberVer = ((int) battlefield.get("fourthRandomNumberForNumber_4deck")) + 1;
                        topLimitNumberVer = ((int) battlefield.get("firstRandomNumberForNumber_4deck")) - 1;

                        _1LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + topLimitNumberVer;
                        _2LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + topLimitNumberVer;
                        _3LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + topLimitNumberVer;
                        _4LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));
                        _5LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _6LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _7LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _8LimitCoordVer = Character.toString((char) rightLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _9LimitCoordVer = Character.toString((char) ((int) battlefield.get("randomNumberForLetter_4deck"))) + bottomLimitNumberVer;
                        _10LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + bottomLimitNumberVer;
                        _11LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("fourthRandomNumberForNumber_4deck"));
                        _12LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("thirdRandomNumberForNumber_4deck"));
                        _13LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("secondRandomNumberForNumber_4deck"));
                        _14LimitCoordVer = Character.toString((char) leftLimitNumberForLetterVer) + ((int) battlefield.get("firstRandomNumberForNumber_4deck"));

                        battlefield.replace(_1LimitCoordVer, battlefield.get(_1LimitCoordVer), limitDeck4);
                        battlefield.replace(_2LimitCoordVer, battlefield.get(_2LimitCoordVer), limitDeck4);
                        battlefield.replace(_3LimitCoordVer, battlefield.get(_3LimitCoordVer), limitDeck4);
                        battlefield.replace(_4LimitCoordVer, battlefield.get(_4LimitCoordVer), limitDeck4);
                        battlefield.replace(_5LimitCoordVer, battlefield.get(_5LimitCoordVer), limitDeck4);
                        battlefield.replace(_6LimitCoordVer, battlefield.get(_6LimitCoordVer), limitDeck4);
                        battlefield.replace(_7LimitCoordVer, battlefield.get(_7LimitCoordVer), limitDeck4);
                        battlefield.replace(_8LimitCoordVer, battlefield.get(_8LimitCoordVer), limitDeck4);
                        battlefield.replace(_9LimitCoordVer, battlefield.get(_9LimitCoordVer), limitDeck4);
                        battlefield.replace(_10LimitCoordVer, battlefield.get(_10LimitCoordVer), limitDeck4);
                        battlefield.replace(_11LimitCoordVer, battlefield.get(_11LimitCoordVer), limitDeck4);
                        battlefield.replace(_12LimitCoordVer, battlefield.get(_12LimitCoordVer), limitDeck4);
                        battlefield.replace(_13LimitCoordVer, battlefield.get(_13LimitCoordVer), limitDeck4);
                        battlefield.replace(_14LimitCoordVer, battlefield.get(_14LimitCoordVer), limitDeck4);

                        //System.out.println(_1LimitCoordVer + " " + _2LimitCoordVer + " " + _3LimitCoordVer + " " + " " + _4LimitCoordVer
                        //        + " " + _5LimitCoordVer + " " + _6LimitCoordVer + " " + _7LimitCoordVer + " " + _8LimitCoordVer
                        //        + " " + _9LimitCoordVer + " " + _10LimitCoordVer + " " + _11LimitCoordVer
                        //        + " " + _12LimitCoordVer + " " + _13LimitCoordVer + " " + _14LimitCoordVer);
                        break; // выход из case 8:
                }

        break; // выход из case 1
        } //конец switch ((int) battlefield.get("positionOfDeck4")) {
        return battlefield;
    } // выход из метода, определяющий границы корабля
} // выход из класса