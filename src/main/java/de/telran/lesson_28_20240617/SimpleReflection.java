package de.telran.lesson_28_20240617;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SimpleReflection {
    public static void main(String[] args) {
        Student student1 = new Student("Vasya", "21_11", 19);

        Class<?> studentClass = student1.getClass();
        if (studentClass.isAnnotationPresent(BadCode.class)) {
            System.out.print("Class "+studentClass.getSimpleName() + " -> ");
            BadCode badCode = studentClass.getAnnotation(BadCode.class);
            System.out.println(badCode.name() + ": " + badCode.comment());
        }

        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(BadCode.class)) {
                System.out.print("Field "+field.getName() + " -> ");
                BadCode badCode = field.getAnnotation(BadCode.class);
                System.out.println(badCode.name() + ": " + badCode.comment());
            }
        }

        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(BadCode.class)) {
                System.out.print("Method "+method.getName() + " -> ");
                BadCode badCode = method.getAnnotation(BadCode.class);
                System.out.println(badCode.name() + ": " + badCode.comment());
            }

        }
    }
}
