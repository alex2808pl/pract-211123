package de.telran.lesson_21_20240522;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Formatter;
import java.util.Locale;

public class Task {
    public static void main(String[] args) {
//    1) реализовать метод, который принимает год и проверяет на високосность
        System.out.println(isLeapYear(2024));
        System.out.println(isLeapYear(2021));

//   2) вывести на консоль дату локализованную для Индии (например)
        System.out.println(" 1 - " + LocalDateTime.now(ZoneId.of("Indian/Kerguelen")));

        ZonedDateTime timeForIndian = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Indian/Kerguelen"));
        System.out.println(" 2 - " + timeForIndian);

//   9) получить возраст человека на текущий момент, если известна его дата рождения.
        getAgeToNow(LocalDate.of(1997, 3, 24));
        LocalDate dateBirthday = LocalDate.of(2000, Month.MAY,25);
        LocalDate dateCurrent = LocalDate.now();

        long between = ChronoUnit.YEARS.between(dateBirthday, dateCurrent);
        System.out.println(between);

//   10) Вы просыпаетесь и смотрите на будильник. Вам на работу нужно на 9 часов. Узнайте, сколько времени
//   осталось еще до начала работы или если вы проспали, то на сколько.
        System.out.println(overslept());
//        System.out.println("you overslept for " + overslept()+ " hours");

//   3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
        LocalDateTime time = LocalDateTime.of(2022, 12, 19, 11, 47);
        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy DDD HH:mm").format(time));

//   4) создать дату своего рождения, вывести на консоль в формате "10 Января 1985"
        LocalDate birthday = LocalDate.of(1985, 1, 10);
        DateTimeFormatter local = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(local.withLocale(Locale.of("ru")).format(birthday));


//   5) проверить дата "10 Января 1985" - это пятница, попробуйте получить день недели для любой другой даты?
        System.out.println(isFriday(birthday));
        System.out.println(isFriday(LocalDate.of(2024, 5, 10)));


//   6) вычесть 10 лет из созданной даты, вывести на консоль
        System.out.println(birthday.minus(Period.ofYears(10)));
        System.out.println(LocalDate.now().minus(Period.ofYears(10)));

//   7) получить обьект Instant из "2022-12-19T06:55:30.00Z", вывести на консоль
        Instant newDate = Instant.parse("2022-12-19T06:55:30.00Z");
        System.out.println(newDate);

//   8) получить ZonedDateTime из "Pacific/Midway", вывести на консоль
        ZonedDateTime getZonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Pacific/Midway"));
        System.out.println(getZonedDateTime);


    }

    public static boolean isLeapYear(int date) {
        return LocalDate.of(date, 1, 1).isLeapYear();
    }

    public static void getAgeToNow(LocalDate birthday) {
        DateTimeFormatter local = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        System.out.println(local.withLocale(Locale.of("ru")).format(birthday));
    }

    public static String overslept() {
        LocalTime time = LocalTime.now();
        LocalTime workTime = LocalTime.of(9, 0);
         long min = ChronoUnit.MINUTES.between(workTime,time)- ChronoUnit.HOURS.between(workTime, time)* 60;

        return "You can sleep "+ ChronoUnit.HOURS.between(workTime, time) +" hours, "+ min+ " min";
    }


    public static boolean isFriday(LocalDate date) {
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return true;
        }
        return false;

    }

}
