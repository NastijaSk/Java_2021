package lesson2_2;
/*
1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов,
при условии что подали на вход корректный массив).
 */

public class App {

    public static void main(String[] args) {

        String[][] array = {{"1", "2", "3", "4"}, {"5", "-6", "7", "8dhg"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        //String[][] array = {{"1", "2", "3", "4"}, {"5", "-6", "8dhg"}, {"9", "10"}, {"13", "14", "15", "16"}};


        try {
            sumArray(array);
        } catch (Exception e) {
            //System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }
    }

    static void sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != 4 | array[0].length != 4 | array[1].length != 4 | array[2].length != 4 | array[3].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    //throw new MyArrayDataException(array[i][j]);
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println(sum);
    }
}
