package de.telran.lesson_28_20240617;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@BadCode(name = "Yevgeniia", comment = "Некорректный класс")
public class Student {
    private String name;
    private  String group;

    @BadCode(name = "Yevgeniia", comment = "Некорректный формат")
    private int age;

    public Student(String name, String group, int age) {
        this.name = name;
        this.group = group;
        this.age = age;
    }

    public void introduction() {
        System.out.println("My name is " + name + ". My group is " + group + ". I am " + age);
    }

    @BadCode(name = "Yevgeniia", comment = "Некорректное условие")
    private boolean isDrinking() {
        return age >= 21;
    }

    @BadCode(name = "Yevgeniia", comment = "Дискриминация по возрасту")
    void party(){
        System.out.println(isDrinking() ? "Можно ли наливать алкоголь" : "Нельзя наливать алкоголь");
    }
}
