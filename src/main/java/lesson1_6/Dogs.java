package lesson1_6;

public class Dogs extends Animals {
    public Dogs(String name, int speed_run, int speed_swim) {
        super(name, speed_run, speed_swim);
        /*тут можно сделать проверку как для котов на ограничения классов*/
        this.limit_run = 500;
        this.limit_swim = 10;
    }

    @Override
    public void run(int length) {
        if (length <= limit_run && speed_run >= length) {
            super.run(length);
        } else
            System.out.println(this.name + " не может бегать так далеко");

    }

    public void swim(int length) {
        if (length <= limit_swim && speed_swim >= length) {
            super.swim(length);
        } else
            System.out.println(this.name + " не может плавать так далеко");


    }
}
