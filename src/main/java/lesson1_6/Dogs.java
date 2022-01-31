package lesson1_6;

public class Dogs extends Animals {
    public Dogs(String name, int speedRun, int speedSwim) {
        super(name, speedRun, speedSwim);
        /*тут можно сделать проверку как для котов на ограничения классов*/
        this.limitRun = 500;
        this.limitSwim = 10;
    }

    @Override
    public void run(int length) {
        if (length <= limitRun && speedRun >= length) {
            super.run(length);
        } else
            System.out.println(this.name + " не может бегать так далеко");

    }

    public void swim(int length) {
        if (length <= limitSwim && speedSwim >= length) {
            super.swim(length);
        } else
            System.out.println(this.name + " не может плавать так далеко");


    }
}
