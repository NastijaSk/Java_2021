package lesson2_5;

public class ApplicationThread {
    public static void main(String[] args) throws InterruptedException {

        long startMethod1 = 0;
        long endMethod1 = 0;

        float[] array = createArray(SIZE);
        startMethod1 = System.currentTimeMillis();
        float[] updateArrayMethod1 = updateArray1(array, 0);
        endMethod1 = System.currentTimeMillis();
        System.out.println("Время выполнения метод 1: " + (endMethod1 - startMethod1));
        //System.out.println(Arrays.toString(updateArrayMethod1));

        long startMethod2 = 0;
        long endMethod2 = 0;
        float[] array2 = createArray(SIZE);
        startMethod2 = System.currentTimeMillis();
        float[] updateArrayMethod2 = updateArray2(array2);
        endMethod2 = System.currentTimeMillis();
        System.out.println("Время выполнения метод 2: " + (endMethod2 - startMethod2));
        //System.out.println(Arrays.toString(updateArrayMethod2));

    }

    static final int SIZE = 10_000_000; //10
    static final int HALF = SIZE / 2;


    public static float[] createArray(int size) {
        float[] array = new float[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.0f;
        }
        return array;
    }

    public static float[] updateArray1(float[] array, int deltaI) {

        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + (i + deltaI) / 5) * Math.cos(0.2f + (i + deltaI) / 5) *
                    Math.cos(0.4f + (i + deltaI) / 2));
        }
        return array;

    }

    public static float[] updateArray2(float[] array2) {

        float[] arrayLeft = new float[HALF];
        System.arraycopy(array2, 0, arrayLeft, 0, HALF);
        float[] arrayRight = new float[HALF];
        System.arraycopy(array2, HALF - 1, arrayRight, 0, HALF);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                updateArray1(arrayLeft, 0);

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                updateArray1(arrayRight, HALF);
            }
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arrayLeft, 0, array2, 0, HALF);
        System.arraycopy(arrayRight, 0, array2, HALF, HALF);

        return array2;
    }
}
