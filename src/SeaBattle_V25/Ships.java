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

/**
 * Класс Ships - корабли, родительский класс для классов Deck1, Deck2, Deck3, Deck4. Сам класс состоит из трех методов
 * генерирующие случайные числа в определенном диапазоне.
 */
public class Ships { //implements IShips {


    /**
     * int random1 - переменная, хранящая число 0 или 1.
     * 0 - корабль будет установлен горизонтально
     * 1 - корабль будет установлен вертикально
     */
    private int random1;

    /**
     * int firstRandomNumberForLetter - переменная, хранящая случайное число для от 65 до 74. Далее будет преобразована
     * в букву в соответствии с стандартом Unicode. Этим числам соответствуют буквы A B C D E F G H I J.
     */
    private int firstRandomNumberForLetter;

    /**
     * int firstRandomNumberForNumber - переменная, хранящая случайное число от 1 до 10. Соответствует номерам поля
     * игры.
     */
    private int firstRandomNumberForNumber;

    /**
     * метод verOrHorPositionOfSpips () возвращает 0 или 1. Эти числа характерезуют расположения корабля вертикально
     * или горизонтально. 0 - горизонтально, 1 - вертикально.
     * @return
     */
    public int verOrHorPositionOfSpips () {
        random1 = (int) (Math.random() * 2);
        //int random1 = 0; // для отладки
        //System.out.println(random1 + " случайное число 0 - горизонтально или 1 - вертикально."); // для отладки
        return random1;
    }

    /**
     * int mFirstRandomNumberForLetter () - возвращает случайное число (переменная firstRandomNumberForLetter)
     * от 65 до 74 (соответствует буквам от A до J). Это будет буква координаты корабля.
     * @return
     */
    public int mFirstRandomNumberForLetter () {
        firstRandomNumberForLetter = (int) (Math.random() * 10 + 65); // генерирует число от 65 до 75
        return firstRandomNumberForLetter;
    }

    /**
     *  int mFirstRandomNumberForNumber () - возвращает случайно число (переменная firstRandomNumberForNumber )
     *  выбираем случайную цифру от 1 до 10, она будет показывать в каком ряде находиться корабль
     *
     * @return
     */
    public int mFirstRandomNumberForNumber () {
        firstRandomNumberForNumber = (int) (Math.random() * 10 + 1); // генерирует число от 1 до 10
        return firstRandomNumberForNumber;
    }

}
