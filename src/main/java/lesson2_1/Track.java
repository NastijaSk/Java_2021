package lesson2_1;

public class Track implements Barrier {

    private int length;

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void trackRun(Runs run) {
        if (this.getLength() <= run.run()) {
            System.out.println(run.toString() + " пробежал");
        } else {
            System.out.println(run.toString() + " не пробежал");
        }
    }

    ;

}
