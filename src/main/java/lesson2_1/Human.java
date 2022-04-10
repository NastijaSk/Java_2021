package lesson2_1;

public class Human implements Runs, Jump, Participant {

    private String name;
    private int runLength;
    private int jumpHeight;


    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int runLength, int jumpHeight) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    public int getRunLength() {
        return runLength;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public int run() {
        //  System.out.println(this.getName() + " run " + this.getRunLength());
        return this.getRunLength();
    }

    @Override
    public int jump() {
        // System.out.println(this.getName() + " jump " + this.getJumpHeight());
        return this.getJumpHeight();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
