package lesson2_2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super(message);
        System.out.println("Элемент " + message + " не число");
    }
}
