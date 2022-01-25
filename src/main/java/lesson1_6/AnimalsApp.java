package lesson1_6;

public class AnimalsApp {
    public static void main(String[] args) {

        Animals animal = new Animals("Енот", 100, 50);
        animal.run(10);
        animal.swim(10);

        System.out.println();

        Cat cat1 = new Cat("Мурзик", 250, 9);
        Cat cat2 = new Cat("Кис", 100, 10);
        cat1.run(100);
        cat2.run(80);
        cat1.run(300);
        cat1.swim(50);

        System.out.println("Количество котов: " + Cat.getCatCnt());

        System.out.println();

        Dogs dog1 = new Dogs("Шарик", 250, 9);
        Dogs dog2 = new Dogs("Лайка", 100, 14);
        Dogs dog3 = new Dogs("Свист", 600, 6);

        dog1.run(300);
        dog1.swim(50);
        dog2.run(70);
        dog2.swim(3);
        dog2.swim(11);
        dog3.run(505);
        dog3.swim(5);

        System.out.println();
        System.out.println("Количество животных: " + Animals.getCntAnimal());

    }
}
