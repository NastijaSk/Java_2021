package lesson1_6;

public class Animals {

    private static int cntAnimal = 0;

    protected String name;
    protected int speedRun;
    protected int speedSwim;

    protected int limitRun;
    protected int limitSwim;

    public Animals(String name, int speedRun, int speedSwim) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        cntAnimal += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(int length) {
        System.out.println(name + "  бегает на дистанцию " + length + " при доступных " + speedRun);
    }

    public void swim(int length) {
        System.out.println(name + "  плавает на дистанцию " + length + " при доступных " + speedSwim);
    }

    public static int getCntAnimal() {
        return cntAnimal;
    }
}
