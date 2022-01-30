package lesson1_5;

public class Employee {

    /*ФИО, должность, email, телефон, зарплата, возраст */
    private String fio;
    private String position;
    private String email;
    private long phone;
    private int salary;
    private int age;

    public Employee(String fio, String position, String email, long phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void info() {
        System.out.println("Сотрудник: " + fio + ", возраста: " + age + ", работает: " + position + ", ЗП: " + salary
                + ", имеет email: " + email + ", тел.: " + phone);
    }

}
