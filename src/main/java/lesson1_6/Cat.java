package lesson1_6;

public class Cat extends Animals {

    private static int catCnt = 0;

    public Cat(String name, int speed_run, int speed_swim) {
        super(name, speed_run, speed_swim);
        this.limit_run = 200;
        /*если при создании экземпляра характеристика больше чем лимит, то ограничиваем растояние лимитом*/
        if (speed_run > this.limit_run) {
            this.speed_run = this.limit_run;
        } else {
            this.speed_run = speed_run;
        }
        this.speed_swim = 0;
        catCnt += 1;

    }

    @Override
    public void run(int length) {
        if (length <= limit_run && speed_run >= length) {
            super.run(length);
        } else
            System.out.println(this.name + " не может бегать так далеко");

    }

    public void swim(int length) {
        System.out.println("Коты не плавают");
    }

    public static int getCatCnt() {
        return catCnt;
    }
}
