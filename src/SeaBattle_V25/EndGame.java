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

/**
 * Описание класса: класс EndGame (конец игры) предназначен для предоставления выбора игроку окончить игру либо начать
 * ее заново.
 *
 * @version     2.5 26 Nov 2015
 * @author      Roman Yushin (Роман Юшин)
 */
public class EndGame {

    public void endGame() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Preparation pr = new Preparation();
        System.out.println("Если Вы желаете сыграть еще раз, введите YES. Если хотите закончить игру введите NO: ");
        String newGame;
        try {
            newGame = reader.readLine();
            if (newGame.equals("YES")) {
                pr.preparationGame();
            } else if (newGame.equals("NO")) {
                System.out.println("До свидания, " + Preparation.gamerName);
                System.exit(0);
            } else {
                System.out.println("Введено недопустимое значение, ответьте на вопрос заново.");
                endGame();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
