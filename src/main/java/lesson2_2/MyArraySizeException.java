package lesson2_2;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
        System.out.println("Массив не 4х4");
    }
}
