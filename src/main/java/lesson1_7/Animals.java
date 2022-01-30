package lesson1_7;

abstract public class Animals {

    protected String name;

    public Animals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void eat(Plate plate, int count);

}
