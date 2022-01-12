package Lesson1_3;

import java.util.Arrays;

public class Lesson1_3 {
    public static void main(String[] args) {

        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                arr1[i] = 0;
            } else arr1[i] = 1;
            System.out.print(arr1[i]);
        }
        System.out.println();
        System.out.println(arr1);

      /*  2. Задать пустой целочисленный массив длиной 100.
        С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;*/

        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr2));

        /*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти
        по нему циклом, и числа меньшие 6 умножить на 2; */

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr3));

       /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
                и с помощью цикла(-ов) заполнить его диагональные элементы единицами
                (можно только одну из диагоналей, если обе сложно).
                Определить элементы одной из диагоналей можно
        по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        */
        int[][] arr4 = new int[5][5];
        int len = arr4.length - 1;
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[0].length; j++) {
                if (i == j || i == len - j) {
                    arr4[i][j] = 1;
                }

            }
            System.out.println(Arrays.toString(arr4[i]));
        }

        System.out.println(Arrays.toString(arrGenerate(7, 10)));

        int[] a = {1, 24, 567, -20, 11};
        System.out.print("Минимальное и максимальное значение массива ");
        System.out.print(Arrays.toString(a) + " : ");
        System.out.println(Arrays.toString(arrMinMax(a)));

        int[] a3 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(a3));
        int[] a4 = {1, 1, 1, 2, 1};
        System.out.println(checkBalance(a4));
        int[] a5 = {2, 2, 2, 1, 2, 2, 10, -1};
        System.out.println(checkBalance(a5));

        System.out.println("Исходный массив: " + Arrays.toString(a));
        System.out.println("Смещение влево 1: " + Arrays.toString(arrShiftLeft(a, 1)));
        System.out.println("Смещение влево 2: " + Arrays.toString(arrShiftLeft(a, 2)));
        System.out.println("Смещение влево 4: " + Arrays.toString(arrShiftLeft(a, 4)));

        System.out.println();
        int[] a2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Исходный массив: " + Arrays.toString(a2));
        System.out.println("Смещение вправо 1: " + Arrays.toString(arrShiftRight(a2, 1)));
        System.out.println("Смещение вправо 4: " + Arrays.toString(arrShiftRight(a2, 4)));


    }

    /*
        5. Написать метод, принимающий на вход два аргумента: len и initialValue,
        и возвращающий одномерный массив типа int длиной len,
        каждая ячейка которого равна initialValue;
         */

    public static int[] arrGenerate(int len, int initValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initValue;
        }

        return arr;
    }

    public static int[] arrMinMax(int[] args) {
        int[] min_max = {args[0], args[0]};
        for (int i = 0; i < args.length; i++) {
            if (args[i] < min_max[0]) {
                min_max[0] = args[i];
            }
            if (args[i] > min_max[1]) {
                min_max[1] = args[i];
            }
        }

        return min_max;
    }

    /*
    7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.
     */
    public static boolean checkBalance(int[] args) {
        int l_sum = 0;
        int r_sum = 0;
        for (int i = 0; i < args.length; i++) {
            l_sum = 0;
            r_sum = 0;
            for (int j = 0; j <= i; j++) {
                l_sum = l_sum + args[j];
            }
            for (int k = i + 1; k < args.length; k++) {
                r_sum = r_sum + args[k];
            }
            System.out.println(l_sum + " " + r_sum);
            if (l_sum == r_sum) {
                break;
            }
        }
        return l_sum == r_sum;
    }

    /*
     *** Написать метод, которому на вход подается одномерный массив и число n
      (может быть положительным, или отрицательным), при этом метод должен сместить
       все элементы массива на n позиций.
        Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
       Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1]
       при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

     */

    public static int[] arrShiftLeft(int[] args, int n) {

        for (int j = 1; j <= n; j++)  /* делаем смещение каждый раз по количеству n*/ {
            int i0 = args[0]; /*запоминаем первое значение*/
            for (int i = 0; i < args.length; i++) {
                if (i + 1 < args.length) {
                    args[i] = args[i + 1];
                } else {
                    args[i] = i0;
                }

            }
        }
        return args;
    }

    public static int[] arrShiftRight(int[] args, int n) {
        for (int j = 1; j <= n; j++)  /* делаем смещение каждый раз по количеству n*/ {
            int i_n = args[args.length - 1]; /*запоминаем последнее значение*/
            for (int i = args.length - 1; i >= 0; i--) {
                if (i > 0) {
                    args[i] = args[i - 1];
                } else {
                    args[0] = i_n;
                }
            }

        }

        return args;
    }
}