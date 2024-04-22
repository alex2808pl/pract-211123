package de.telran.lesson_14_20240417;

import java.util.*;
import java.util.stream.Collectors;

/**
 *      * 3. Получить список сотрудников с зп > 1000
 *       * 2 Вычислить среднюю зарплату всех сотрудников
 *      * 4*. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
 *      * 5*. Получить сотрудника с самой низкой зп
 *      * 6*. Получить сотрудника с самой высокой зп
 *      * 7**. Получите сотрудников из всех отделов с максимальной зп
 *      * 8**. Сгрупировать сотрудников по должности
 *
 */
public class SimpleManager {
    public static void main(String[] args) {

        Manager manager1 = new Manager("Opanas", "Director", "Boss", 12000.00);
        Manager manager2 = new Manager("Izya", "PomDirect", "Planing", 8000.00);
        Manager manager6 = new Manager("Izyaslav", "PomDirect", "Planing", 8000.00);
        Manager manager8 = new Manager("ILlya", "PomDirect", "Planing", 9000.00);
        Manager manager3 = new Manager("Salomon", "SalesManager", "Boss", 5000.00);
        Manager manager7 = new Manager("Jork", "SalesManager", "Boss", 9000.00);
        Manager manager4 = new Manager("Anton", "Intern", "Sales", 10000.00);
        Manager manager5 = new Manager("Wasya", "JobManager", "Sales", 8000.00);
        Manager manager9 = new Manager("Wasya", "JobManager", "Sales", 4000.00);
        Manager manager10 = new Manager("Wasya", "JobManager", "Sales", 5000.00);

        List<Manager> managerList = List.of(manager2,manager1,manager3,manager4,manager5,manager6,manager7,manager8,manager9,manager10);

        managerList.forEach(System.out::println);
        List<Manager> salaryBig = managerList.stream()
                .filter(manager -> manager.getSalary() >= 10000)
                .collect(Collectors.toList());
        System.out.println(salaryBig);

        System.out.println(" Вычислить среднюю зарплату всех сотрудников");

        OptionalDouble average = managerList.stream()
                .mapToDouble(manager -> manager.getSalary())
                .average() ;
        System.out.println(average);

        System.out.println(average.getAsDouble());

        System.out.println(average.orElse(0.00));
        System.out.println(average.isPresent());
        System.out.println(average.isEmpty());


        System.out.println("Получить список сотрудников из отдела Boss и увеличить зп на 15% ");
        System.out.println("С изменением текущих данных");

        System.out.println(managerList.stream()
                .filter(manager -> manager.getDepartmen().startsWith("Boss"))
                .peek(manager -> manager.setSalary(manager.getSalary() * 1.15))
                .toList());

        System.out.println("Без изменения текущих данных (Выводим только суммы)");

        System.out.println(managerList.stream()
                .filter(manager -> manager.getDepartmen().startsWith("Boss"))
                .map(manager ->manager.getSalary() * 1.15)
                .toList());

        System.out.println("Без изменения текущих данных (Выводим cотрудников и новые  суммы)");

        System.out.println(managerList.stream()
                .filter(manager -> manager.getDepartmen().startsWith("Boss"))
                .map(manager -> new Manager(manager.getName(), manager.getPosition(),manager.getDepartmen(),manager.getSalary() * 1.15))
                .toList());


        System.out.println("Получить сотрудника с самой низкой зп ");

        System.out.println(managerList.stream()
                .min(Comparator.comparing(Manager::getSalary)));

        System.out.println(" Получить сотрудника с самой высокой зп ");

        System.out.println(managerList.stream()     //получаем только сумму
                .mapToDouble(Manager::getSalary)
                .max().getAsDouble());
        // Если нужен сотрудник
        System.out.println(managerList.stream()                  
                .max(Comparator.comparing(Manager::getSalary)));


        //Получите сотрудников из всех отделов с максимальной зп
        System.out.println("Получите сотрудников из всех отделов с максимальной зп");

        System.out.println(" Количество человек в каждом департаменте");
        System.out.println(managerList.stream()
               .collect(Collectors.groupingBy(d -> d.getDepartmen(), Collectors.counting()))); //

        System.out.println("Получите сотрудников из всех отделов с максимальной зп");
        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(Manager::getDepartmen, Collectors.maxBy(Comparator.comparingDouble(Manager::getSalary)))));

        System.out.println(" Сгрупировать сотрудников по должности");

        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getPosition())));

        System.out.println("--");

      Map<String, List<Manager>> groupMap =  managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getDepartmen()));

      for (Map.Entry entry : groupMap.entrySet()){
          System.out.println(entry);
      }

        System.out.println(" Вывести имена людей по департаментам");
        System.out.println(managerList.stream()
                .collect(Collectors.groupingBy(m -> m.getDepartmen(),
                        Collectors.mapping(o -> o.getName(), Collectors.toList()))));


    }
}
