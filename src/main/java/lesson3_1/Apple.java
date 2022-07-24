package lesson3_1;

public class Apple extends Fruit {

    @Override
    public float getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(float weight) {
        super.setWeight(weight);
    }

    public Apple(  float weight) {
        super(weight);
    }
}
