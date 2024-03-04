package de.telran.lesson_4;

public class DayOfWeek {
    private String title;

    private DayOfWeek(String title) {
        this.title = title;
    }

    public static DayOfWeek MONDAY = new DayOfWeek("понедельник");
    public static DayOfWeek TUESDAY = new DayOfWeek("вторник");
    public static DayOfWeek WEDNESDAY = new DayOfWeek("среда");
    public static DayOfWeek THURSDAY  = new DayOfWeek("четверг");
    public static DayOfWeek FRIDAY  = new DayOfWeek("пятница");
    public static DayOfWeek SATURDAY  = new DayOfWeek("суббота");
    public static DayOfWeek SUNDAY  = new DayOfWeek("воскресенье");

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "title='" + title + '\'' +
                '}';
    }
}
