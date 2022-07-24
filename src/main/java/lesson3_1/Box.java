package lesson3_1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> arrayListBox = new ArrayList<T>();
    private float weightBox;

    public ArrayList<T> getArrayList() {
        return arrayListBox;
    }

    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayListBox = arrayList;
    }

    public void removeFromBox(T t) {
        this.arrayListBox.remove(t);
    }


    public float getWeightBox() {
        this.weightBox = this.getWeight();
        return weightBox;
    }

    private void setWeightBox(float weightBox) {
        this.weightBox = weightBox;
    }

    public void addInBox(T t) {
        this.arrayListBox.add(t);
    }

    public Box() {
        this.arrayListBox = arrayListBox;
        this.weightBox = 0.0f;
    }

    public float getWeight() {
        float weightBox = 0;
        for (T t : arrayListBox) {
            weightBox += t.getWeight();
        }
        return weightBox;
    }

    public boolean compare(Box box) {
        return this.weightBox == box.getWeight();
    }

    /*пересыпаем фрукты из коробки 1 в this */
    public Box shift(Box box1) {

        if (this.getWeightBox() == 0) {

            for (Object listBox : box1.arrayListBox) {
                box1.removeFromBox((T) listBox);
                this.addInBox((T) listBox);

            }

        } else {
            System.out.println("Коробка не пустая");
        }
        return this;
    }

}
