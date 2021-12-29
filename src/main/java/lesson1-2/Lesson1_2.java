public class Lesson1_2 {
    public static void main(String[] args) {


        System.out.println(compareInt(5, 7));
        System.out.println(compareInt(-5, 7));
        System.out.println(compareInt(15, 7));
        checkInt(0);
        checkInt(5);
        checkInt(-10);
        checkInt2(0);
        checkInt2(15);
        checkInt2(-18);
        System.out.println(checkIntNegative(-10));
        System.out.println(checkIntNegative(18));
        printNStr("привет", 4);

    }

    public static boolean compareInt(int a, int b) {
        boolean result;
        if (a + b >= 10 && a + b <= 20) {
            result = true;
        } else {
            result = false;
        }
        return result;

    }

    public static void checkInt(int a) {
        if (a >= 0) {
            System.out.println(a + " положительное");
        } else System.out.println(a + " отрицательное");
        ;
    }

    public static void checkInt2(int a) {
        int check;
        if (a >= 0) {
            check = 1;
        } else check = 0;

        switch (check) {
            case 1:
                System.out.println(a + " положительное");
                break;
            case 0:
                System.out.println(a + " отрицательное");
        }
        ;
    }

    public static boolean checkIntNegative(int a) {
        boolean result;
        if (a < 0) {
            result = true;
        } else {
            result = false;
        }
        return result;

    }

    public static void printNStr(String str, int cnt) {
        for (int i = 0; i <= cnt; i++) {
            System.out.println(str);
        }
    }


}