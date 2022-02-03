package lesson1_7;

public class Plate {

    /*
    количество еды в тарелке
    */
    private int size;

    public Plate(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void info() {
        System.out.println("В тарелке доступно " + this.size + " еды");
    }

    /*пополнение тарелки на size*/
    public void addSize(int size) {
        this.size = this.size + size;
    }
}
