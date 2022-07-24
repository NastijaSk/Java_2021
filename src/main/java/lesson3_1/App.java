package lesson3_1;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        System.out.println("Обмен элементов массива");
        Integer[] integer = new Integer[]{1, 2, 3, 4, 5, 6};
        String[] strings = new String[]{"a", "b", "c", "d", "e"};

        System.out.println(Arrays.toString(change(integer, 0, 5)));
        System.out.println(Arrays.toString(change(strings, 4, 1)));

        System.out.println("Преобразование в ArrayList");
        System.out.println(integer.getClass());
        System.out.println(strings.getClass());

        ArrayList<Object>[] integerArrayList = ArrayToArrayList(integer);
        ArrayList<Object>[] stringArrayList = ArrayToArrayList(strings);
        System.out.println(integerArrayList.getClass());
        System.out.println(stringArrayList.getClass());

        System.out.println("Коробки с фруктами");
        Orange orange1 = new Orange(1.0f);
        Orange orange2 = new Orange(2.0f);
        Orange orange3 = new Orange(1.0f);
        Apple apple1 = new Apple(1.5f);
        Apple apple2 = new Apple(0.5f);

        Box<Orange> boxOrange = new Box<Orange>();
        boxOrange.addInBox(orange1);
        boxOrange.addInBox(orange2);
        //boxOrange.addInBox(apple1); //Idea подсвечивает ошибку, так как в коробке лежат апельсины
        System.out.println(boxOrange.getWeightBox());
        boxOrange.addInBox(orange3);
        boxOrange.removeFromBox(orange2);
        System.out.println(boxOrange.getWeightBox());

        Box<Apple> boxApple = new Box<Apple>();
        boxApple.addInBox(apple1);

        System.out.println("Сравнение веса коробки апельсинов и коробки с яблоками: " +
                boxOrange.compare(boxApple));

        boxApple.addInBox(apple2);
        System.out.println("Сравнение веса коробки апельсинов и коробки с яблоками: " +
                boxOrange.compare(boxApple));


        Box<Apple> boxApple2 = new Box<Apple>();
        boxApple2.shift(boxOrange); /* в пустую коробку типа яблок засыпали апельсины*/

        Box<Apple> boxApple3 = new Box<Apple>();
        boxApple3.addInBox(apple1);
        boxApple3.shift(boxOrange); /* в не пустую коробку типа яблок не засыпали апельсины*/

    }


    public static Object[] change(Object[] obj, int i, int j) {
        Object objZ = obj[j];
        obj[j] = obj[i];
        obj[i] = objZ;
        return obj;

    }

    public static <T> ArrayList<T>[] ArrayToArrayList(T[] arrays) {

        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(arrays));
        return new ArrayList[]{arrayList};
    }
}
