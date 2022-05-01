package lesson2_2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j) {
        super(String.format("Элемент array[%d][%d] не число", i, j));
        /*super(message);
        System.out.println("Элемент " + message + " не число");*/
    }
}
