package lesson1_6;

public class Cat extends Animals {

    private static int catCnt = 0;

    public Cat(String name, int speedRun, int speedSwim) {
        super(name, speedRun, speedSwim);
        this.limitRun = 200;
        /*если при создании экземпляра характеристика больше чем лимит, то ограничиваем растояние лимитом*/
        if (speedRun > this.limitRun) {
            this.speedRun = this.limitRun;
        } else {
            this.speedRun = speedRun;
        }
        this.speedSwim = 0;
        catCnt += 1;

    }

    @Override
    public void run(int length) {
        if (length <= limitRun && speedRun >= length) {
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
