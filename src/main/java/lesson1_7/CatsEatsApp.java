package lesson1_7;

public class CatsEatsApp {

    public static void main(String[] args) {

        Cats cat1 = new Cats("Мурзик");
        Plate plate1 = new Plate(100);

        cat1.info();
        cat1.eat(plate1, 80);
        cat1.info();
        plate1.info();
        cat1.eat(plate1, 30);

        System.out.println();
        System.out.println();
        Cats[] cats = new Cats[5];
        plate1.addSize(200);
        cats[0] = new Cats("Кот0");
        cats[1] = new Cats("Кот1");
        cats[2] = new Cats("Кот2");
        cats[3] = new Cats("Кот3");
        cats[4] = new Cats("Кот4");

        cats[0].eat(plate1, 300);
        cats[1].eat(plate1, 100);
        cats[2].eat(plate1, 50);
        cats[3].eat(plate1, 100);
        cats[4].eat(plate1, 15);

        for (Cats cat : cats) {
            cat.info();
        }
        plate1.info();

    }
}
