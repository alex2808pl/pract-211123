package de.telran.lesson_21_20240522;


// 1) реализовать метод, который принимает год и проверяет на високосность
//2) вывести на консоль дату локализованную для Индии (например)
//9) получить возраст человека на текущий момент, если известна его дата рождения.
//            10) Вы просыпаетесь и смотрите на будильник. Вам на работу нужно на 9 часов. Узнайте, сколько времени
//    осталось еще до начала работы или если вы проспали, то на сколько.
//
//3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
//            4) создать дату своего рождения, вывести на консоль в формате "10 Января 1985"
//            5) проверить дата "10 Января 1985" - это пятница, попробуйте получить день недели для любой другой даты?
//            6) вычесть 10 лет из созданной даты, вывести на консоль
//7) получить обьект Instant из "2022-12-19T06:55:30.00Z", вывести на консоль
//8) получить ZonedDateTime из "Pacific/Midway", вывести на консоль

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class DateTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите год: ");
//        int date = scanner.nextInt();
//        System.out.printf("%d год високосный? %b", date, isLeapYear(date));

        ZoneId zoneId = ZoneId.of("Indian/Kerguelen");
        System.out.println(LocalDate.now(zoneId));
        System.out.println(LocalDateTime.now(zoneId));
        System.out.println(ZonedDateTime.now(zoneId));


    }

    public static boolean isLeapYear(int date) {
        LocalDate localDate = LocalDate.of(date, 1, 1);
        return localDate.isLeapYear();
    }




}
