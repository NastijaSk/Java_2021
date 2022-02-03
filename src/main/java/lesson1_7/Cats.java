package lesson1_7;

public class Cats extends Animals {

    /*
    сытость
     */
    private boolean satiety;

    public Cats(String name) {
        super(name);
        this.satiety = false;
    }

    public boolean getSatiety() {
        return this.satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void info() {
        System.out.println(this.name + " сыт: " + this.getSatiety());
    }

    @Override
    void eat(Plate plate, int count) {
        if (plate.getSize() - count >= 0) {
            /*
            кормим кота
             */
            plate.setSize(plate.getSize() - count);
            this.satiety = true;
            System.out.println(this.name + " съел " + count);
        } else {
            System.out.println("В тарелке недостаточно еды");
        }
    }
}
