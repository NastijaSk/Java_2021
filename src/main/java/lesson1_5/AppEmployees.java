package lesson1_5;

public class AppEmployees {
    public static void main(String[] args) {

        Employee emp1 = new Employee("Иванов И.И.", "методист", "ivamov@mail.ru", 791111111111L, 50000, 20);
        emp1.info();

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов И.И.", "методист", "ivamov@mail.ru", 791111111111L, 50000, 20);
        employees[1] = new Employee("Петров П.П.", "кассир", "petrov@mail.ru", 791111111112L, 30000, 41);
        employees[2] = new Employee("Зотов А.А.", "историк", "zotov@mail.ru", 791111111113L, 30000, 78);
        employees[3] = new Employee("Крупнова В.В.", "певица", "krupnova@mail.ru", 791111111114L, 40000, 48);
        employees[4] = new Employee("Antonov М.М.", "студент", "antonov@mail.ru", 791111111115L, 2000, 18);

        System.out.println();
        System.out.println("Сотрудники старше 40 лет");
        for (Employee emp : employees) {
            if (emp.getAge() > 40) {
                emp.info();
            }
        }

    }
}
