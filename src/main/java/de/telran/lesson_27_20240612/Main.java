package de.telran.lesson_27_20240612;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Cafe> cafeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Cafe cafe = new Cafe();
            cafeList.add(cafe);
        }
        FutureTask<Double> future = new FutureTask<>(new NDS(cafeList));
        new Thread(future).start();
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
