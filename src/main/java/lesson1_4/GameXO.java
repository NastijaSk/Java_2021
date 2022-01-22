package lesson1_4;

import java.util.Random;
import java.util.Scanner;

public class GameXO {

    public static char map[][];
    /*
    SIZE_X - строки
    SIZE_Y - столбцы
     */
    public static final int SIZE_X = 4;
    public static final int SIZE_Y = 10;

    public static final char DOT_DEFAULT = '*';
    public static final char DOT_USER = 'U';
    public static final char DOT_ROBOT = 'R';
    public static final int SIZE_WIN = 3;

    public static void initMap() {
        map = new char[SIZE_X][SIZE_Y];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = DOT_DEFAULT;
            }
    }

    public static void printMap() {
        for (int k = 0; k <= SIZE_Y; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_X; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE_Y; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Scanner sc = new Scanner(System.in);

    public static void userTurn() {
        System.out.println("Введи координаты хода: строка, столбец");
        int x, y;
        do {
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_USER;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 | x >= SIZE_X | y < 0 | y >= SIZE_Y) {
            System.out.println("Значение выходит за пределы поля, введите другое значение");
            return false;
        }
        if (map[x][y] == DOT_DEFAULT) {
            return true;
        }
        return false;

    }

    public static Random rand = new Random();

    public static void robotTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE_X - 1);
            y = rand.nextInt(SIZE_Y - 1);
        } while (!isCellValid(x, y));
        map[x][y] = DOT_ROBOT;
    }

    /*

    Поле можно задавать квадратом, прямоугольником.
    Проверка победы определяется по числу SIZE_WIN.
    Такое количество одинаковых символов должно быть последовательно в строке или в столбце или по главной диагонале
    Например, для SIZE_WIN=4
            0 1 2 3 4 5 6 7 8 9 10
            1 U R * * * * * * * *
            2 * U * R * * R * * *
            3 * * U * * R * * * *
            4 * * * U * * * U * *
    Победа U
     */
    public static boolean checkWin(char symb) {
        int check = 0;
        /*
            по горизонтале символ встечается SIZE_WIN раз
         */
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                for (int k = 0; k < SIZE_WIN; k++) {
                    if (j + k < SIZE_Y) {
                        if (map[i][j + k] == symb) {
                            check = check + 1;
                        }
                    }
                }
                if (check >= SIZE_WIN) {
                    System.out.println("Победа " + symb);
                    return true;
                }
                check = 0;
            }

            check = 0;
        }

        /*по вертикали символ встечается SIZE_WIN раз*/
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                for (int k = 0; k < SIZE_WIN; k++) {
                    if (i + k < SIZE_X) {
                        if (map[i + k][j] == symb) {
                            check = check + 1;
                        }
                    }
                }
                if (check >= SIZE_WIN) {
                    System.out.println("Победа " + symb);
                    return true;
                }
                check = 0;
            }

            check = 0;
        }

        /*по диагонале символ встечается SIZE_WIN раз*/
        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < SIZE_WIN; k++) {
                if (i + k < SIZE_X) {
                    if (map[i + k][i + k] == symb) {
                        check = check + 1;
                    }
                }
            }
            if (check >= SIZE_WIN) {
                System.out.println("Победа " + symb);
                return true;
            }
            check = 0;
        }
        return false;

    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (map[i][j] == DOT_DEFAULT) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            userTurn();
            printMap();
            if (checkWin(DOT_USER)) {
                break;
            }
            ;
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            robotTurn();
            printMap();
            if (checkWin(DOT_ROBOT)) {
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            ;

        }


    }

}

