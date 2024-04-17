package de.telran.lesson_14_20240417;

import java.util.Objects;

public class Manager {

    /**
     * 1. Создать класс Employee с характеристиками:
     *  - фамилия, имя, отчество
     *  - должность
     *  - отдел
     *  - зарплата
     * 2. Вычислить среднюю зарплату всех сотрудников
     * 3. Получить список сотрудников с зп > 1000
     * 4*. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
     * 5*. Получить сотрудника с самой низкой зп
     * 6*. Получить сотрудника с самой высокой зп
     * 7**. Получите сотрудников из всех отделов с максимальной зп
     * 8**. Сгрупировать сотрудников по должности
     */
  private   String name;
  private   String position;
    private String departmen;
   private double salary;

    public Manager(String name, String position, String departmen, double salary) {
        this.name = name;
        this.position = position;
        this.departmen = departmen;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmen() {
        return departmen;
    }

    public void setDepartmen(String departmen) {
        this.departmen = departmen;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", departmen='" + departmen + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Double.compare(salary, manager.salary) == 0 && Objects.equals(name, manager.name) && Objects.equals(position, manager.position) && Objects.equals(departmen, manager.departmen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, departmen, salary);
    }
}
