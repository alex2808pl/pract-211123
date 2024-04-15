package de.telran.lesson_13_20240415;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

//У нас есть профессия в строительстве - чернорабочий. Он может выполнять любые низкоквалифицированные
//        работы на стройке. На каждый день ему дается список работ, которые он должен выполнить, но не факт
//        что в течении рабочего времени его задание может измениться.
//        Напишите программу рабочего дня профессии, которая позволяет динамический давать ему задание на работу,
//        в любое нужное время. И он их должен выполнять. Применяйте функциональные интерфейсы.
public class Main {
    public static void main(String[] args) {
        Consumer<String> task = (s) -> System.out.println(s + ", грузи кирпичи");
        task.accept("Вася");

        task = (s) -> System.out.println(s + ", копай");
        task.accept("Вася");

        List<Consumer<String>> taskDay = new ArrayList<>();
        taskDay.add((s) -> System.out.println(s + ", грузи мусор"));
        taskDay.add((s) -> System.out.println(s + ", носи мешки с цементом"));
        taskDay.add((s) -> System.out.println(s + ", мешай бетон"));

        taskDay.forEach(task1 -> task1.accept("Вася"));

        System.out.println("----");
        taskDay.remove(0);
        taskDay.add(0, new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string + ", разгрузи машину с песком");
            }
        });

        taskDay.forEach(task1 -> task1.accept("Вася"));


        job("Вася", s -> System.out.println(s + " шабаш!"));
        job("Вася", new NewJob());

    }

    public static void job(String name, Consumer<String> jobs) {
        System.out.println("Меня зовут " + name);
        jobs.accept(name);
    }



}

class NewJob implements Consumer<String> {

    @Override
    public void accept(String string) {
        System.out.println(string + ", разгрузи гипсокартон");
    }
}