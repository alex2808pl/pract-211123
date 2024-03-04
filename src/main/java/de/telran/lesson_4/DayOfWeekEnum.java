package de.telran.lesson_4;

public enum DayOfWeekEnum{
    MONDAY("понедельник"),
    TUESDAY("вторник", 1000),
    WEDNESDAY("среда"),
    THURSDAY("четверг", 3000),
    FRIDAY( "пятница"),
    SATURDAY("суббота", 5000),
    SUNDAY("воскресенье");
    private String title;
    private int countCalories;

    DayOfWeekEnum(String title) {
        this.title = title;
    }

    DayOfWeekEnum(String title, int countCalories) {
        this.title = title;
        this.countCalories = countCalories;
    }

    @Override
    public String toString() {
        return "DayOfWeekEnum{" +
                "title='" + title + '\'' +
                ", countCalories=" + countCalories +
                "} ";
    }

    public String getTitle() {
        return title;
    }

    public int getCountCalories() {
        return countCalories;
    }
}
