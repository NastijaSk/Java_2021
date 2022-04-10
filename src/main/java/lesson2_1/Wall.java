package lesson2_1;

public class Wall implements Barrier {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void wallJamp(Jump jump) {
        if (this.getHeight() <= jump.jump()) {
            System.out.println(jump.toString() + " перепрыгнул");
        } else {
            System.out.println(jump.toString() + " не перепрыгнул");
        }
    }

    ;
}
