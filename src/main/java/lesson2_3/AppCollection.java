package lesson2_3;

import java.util.*;

public class AppCollection {

    public static void main(String[] args) {

        countOfFruits();
        System.out.println("-----------------------------------------------------");
        phoneFind();
    }

    /*
    1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    Посчитать сколько раз встречается каждое слово.
     */
    private static void countOfFruits() {
        List<String> array = new ArrayList<>();
        array.add("яблоко");
        array.add("апельсин");
        array.add("груша");
        array.add("яблоко");
        array.add("слива");
        array.add("ананас");
        array.add("киви");
        array.add("яблоко");
        array.add("мандарин");
        array.add("лимон");
        array.add("яблоко");
        array.add("киви");

        System.out.println(array);

        Set<String> unique = new HashSet<>(array);

        System.out.println(unique);

        Iterator<String> iterator = unique.iterator();
        //for(int i=0; i<=unique.size(); i++)
        for (; iterator.hasNext(); ) {
            int count = 0;
            String nextUniqueValue = iterator.next();
            Iterator<String> iteratorArray = array.iterator();
            for (; iteratorArray.hasNext(); ) {
                if (nextUniqueValue.equals(iteratorArray.next())) {
                    count += 1;
                }
            }
            System.out.println(nextUniqueValue + " = " + count);

        }
    }

    private static void phoneFind() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("111111", "Ivanov");
        phoneBook.add("222222", "Petrov");
        phoneBook.add("333333", "Petrov");
        phoneBook.add("444444", "Smirnov");
        phoneBook.add("555555", "Kolobov");
        phoneBook.add("666666", "Petrov");
        System.out.println(phoneBook.map);

        System.out.println("phones Kolobov: " + phoneBook.get("Kolobov"));
        System.out.println("phones Petrov: " + phoneBook.get("Petrov"));
    }

}
