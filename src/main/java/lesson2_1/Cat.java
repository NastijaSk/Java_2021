package lesson2_1;

public class Cat implements Runs, Jump, Participant {

    private int age;
    private int runLength;
    private int jumpHeight;


    public Cat(int age) {
        this.age = age;
    }

    public Cat(int age, int runLength, int jumpHeight) {
        this.age = age;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    public int getAge() {
        return age;
    }

    public int getRunLength() {
        return runLength;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public int run() {
        // System.out.println( "cat run "+  this.getRunLength());
        return this.getRunLength();
    }

    @Override
    public int jump() {
        //System.out.println( "cat jump " + this.getJumpHeight());
        return this.getJumpHeight();
    }

    @Override
    public String toString() {
        return "Cat";
    }
}
