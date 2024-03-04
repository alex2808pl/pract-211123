package de.telran.lesson_4;

public class SimpleNoEnum {
    public static void main(String[] args) {
//        DayOfWeek dayOfWeek1 = new DayOfWeek("понедельник");
//        DayOfWeek dayOfWeek2 = new DayOfWeek("вторник");
//        DayOfWeek dayOfWeek3 = new DayOfWeek("среда");
//        System.out.println(dayOfWeek1);
//        System.out.println(dayOfWeek2);
//        System.out.println(dayOfWeek3);
//
//        DayOfWeek dayOfWeekBad = new DayOfWeek("слон");
//        System.out.println(dayOfWeekBad);

        // перечисление с помощью стандартного класса
        DayOfWeek dayOfWeek1 = DayOfWeek.MONDAY;
        System.out.println(dayOfWeek1);
        DayOfWeek dayOfWeek2 = DayOfWeek.THURSDAY;
        System.out.println(dayOfWeek2);

        // перечисление с помощью enum
        DayOfWeekEnum dayOfWeekEnum = DayOfWeekEnum.SATURDAY;
        System.out.println(dayOfWeekEnum);

        System.out.println();
        for (DayOfWeekEnum day : DayOfWeekEnum.values()) {
            System.out.println(day);
            System.out.println(day.getCountCalories());
        }

    }
}
