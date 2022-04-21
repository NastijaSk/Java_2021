package lesson2_1;

public class Application {
    /*
    3 класса (человек, кот, робот) реализуют интерфейсы бегать и прыгать
    В каждом классе переопределены методы интерфейсов бежать и прыгать, которые возвращают длину бега и высоту прыжка
    2 класса препятсвий ( дорожка, стена) с параметрами длина и высота, которые реализуются общим интерфейсом препятствия
    В зависимости от типа препятствия (проверка instanceof) вызывается его метод преодоления
     */

    public static void main(String[] args) {
        Human human = new Human("Ivan", 500, 60);
        Cat cat = new Cat(1, 50, 50);
        Robot robot = new Robot(1000, 10);

        human.run();
        cat.run();
        robot.run();

        human.jump();
        cat.jump();
        robot.jump();

        System.out.println();
        Track track = new Track(100);
        Wall wall = new Wall(40);

        track.trackRun(human);
        track.trackRun(cat);
        track.trackRun(robot);

        wall.wallJamp(human);
        wall.wallJamp(cat);
        wall.wallJamp(robot);

        System.out.println();
        System.out.println("Массивы с циклом");

        Participant[] participants = new Participant[]{((Participant) human), ((Participant) cat), ((Participant) robot)};
        Barrier[] barriers = new Barrier[]{((Barrier) track), ((Barrier) wall)};

        for (Participant participant : participants) {
            for (Barrier barrier : barriers) {
                if (barrier instanceof Track) {
                    ((Track) barrier).trackRun((Runs) participant);
                } else if (barrier instanceof Wall) {
                    ((Wall) barrier).wallJamp((Jump) participant);
                }

            }

        }


    }

}
