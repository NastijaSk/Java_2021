package lesson1_6;

public class Animals {

    private static int cntAnimal = 0;

    protected String name;
    protected int speed_run;
    protected int speed_swim;

    protected int limit_run;
    protected int limit_swim;

    public Animals(String name, int speed_run, int speed_swim) {
        this.name = name;
        this.speed_run = speed_run;
        this.speed_swim = speed_swim;
        cntAnimal += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(int length) {
        System.out.println(name + "  бегает на дистанцию " + length + " при доступных " + speed_run);
    }

    public void swim(int length) {
        System.out.println(name + "  плавает на дистанцию " + length + " при доступных " + speed_swim);
    }

    public static int getCntAnimal() {
        return cntAnimal;
    }
}
