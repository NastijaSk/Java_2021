public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Привет");

        printThreeWords();
        checkSumSign();
        printColor(-9);
        printColor(10);
        printColor(100);
        printColor(101);
        compareNumbers(10, 20);
        compareNumbers(10 ,-5);
    }
    
    public static void printThreeWords()
    {
        System.out.println("Orange\n" +
                "Banana\n" +
                "Apple");
    }

    public static void checkSumSign()
    { int a = 10, b = -20;
        if (a + b>=0) {
         System.out.println("Сумма положительная");}
            else {System.out.println("Сумма отрицательная");}

    }

    public static void printColor( int value)
    {

       /* Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
        если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
        если больше 100 (100 исключительно) - “Зеленый”; */
        if (value<=0) { System.out.println("Красный");}
        else if (value >0 && value <=100) {System.out.println("Желтый");}
        else {System.out.println("Зеленый");}

    }

    public static void compareNumbers(int a, int b)
    {
        /*Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
         в противном случае “a < b
         */
        if (a>=b ){print_a("a >= b");}
        else {print_a("a < b");}

    }

    public static void print_a(String a)
    {
        System.out.println(a);
    }
}
