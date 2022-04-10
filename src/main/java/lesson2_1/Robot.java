package lesson2_1;

public class Robot implements Runs, Jump, Participant {

    private int runLength;
    private int jumpHeight;

    public Robot(int runLength, int jumpHeight) {
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    public int getRunLength() {
        return runLength;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    @Override
    public int run() {
        //System.out.println("robot run "+ this.getRunLength());
        return this.getRunLength();
    }

    @Override
    public int jump() {
        //System.out.println( "robot jump " + this.getJumpHeight());
        return this.getJumpHeight();
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
