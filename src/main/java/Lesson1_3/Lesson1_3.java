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

        System.out.println(Arrays.toString(arrGenerate(7,10)));

        int[] a = {1,24,567,-20,11};
        System.out.print("Минимальное и максимальное значение массива ");
        System.out.print(Arrays.toString(a) + " : ");
        System.out.println(Arrays.toString(arrMinMax(a)));

    }

    /*
        5. Написать метод, принимающий на вход два аргумента: len и initialValue,
        и возвращающий одномерный массив типа int длиной len,
        каждая ячейка которого равна initialValue;
         */

    public static int[] arrGenerate ( int len, int initValue)
    {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initValue;
        }

        return arr;
    }

    public static int[] arrMinMax (int[] args)
    {
        int[] min_max = {args[0], args[0]};
        for(int i=0; i< args.length; i++)
        {
            if (args[i] < min_max[0])
            {
                min_max[0] = args[i];
            }
            if (args[i] > min_max[1])
            {
                min_max[1] = args[i];
            }
        }

        return min_max;
    }


}