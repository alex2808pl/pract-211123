package de.telran.lesson_27_20240612;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//Вы владелец кафе. Вы предлагаете клиентам блюда собственного приготовления, снеки и алкоголь.
//Сгенерируйте выторг данного кафе (количество на Ваше усмотрение) в формате:
//        - наименование
//- тип (кухня, снек, алкоголь)
//- сумма (10-100)
//По окончании отчетного периода, вам нужно подсчитать налоги и доход:
//        1) Со всей суммы выторга нужно забрать НДС - 15%.
//        2) С алкоголя, нужно забрать 2% акцизного сбора.
//        3) Снеки облагаются доп.налогом 1%.
//        4) С продуктов кухни нужно снять 10%, как доп.выплату поварам.
//        5) Зарплата сотрудникам рассчитывается как 20% от общей суммы.
//        6) Инвесторам нужно выплатить 10 %.
//Вычислите сумму дохода и % составляет доход в от суммы общей выручки?

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Cafe> cafeList = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            Cafe cafe = new Cafe();
            cafeList.add(cafe);
        }

        // НДС
        FutureTask<Double> futureNds = new FutureTask<>(
                new Tax(cafeList, () -> cafeList.parallelStream().mapToDouble(cafe -> cafe.getSum()*0.15).sum()));
        Thread threadNds = new Thread(futureNds);
        threadNds.start();

        // Акциз на алкоголь
        FutureTask<Double> futureExcise = new FutureTask<>(
                new Tax(cafeList, () -> cafeList.parallelStream()
                        .filter(cafe -> cafe.getMenu()==Menu.ALCOHOL)
                        .mapToDouble(cafe -> cafe.getSum()*0.02)
                        .sum()));
        Thread threadExcise = new Thread(futureExcise);
        threadExcise.start();

        // Налог на снеки
        FutureTask<Double> futureSnacks = new FutureTask<>(
                new Tax(cafeList, () -> cafeList.parallelStream()
                        .filter(cafe -> cafe.getMenu()==Menu.ALCOHOL)
                        .mapToDouble(cafe -> cafe.getSum()*0.01)
                        .sum()));
        Thread threadSnacks = new Thread(futureSnacks);
        threadSnacks.start();

        // Доп.выплаты поварам
        FutureTask<Double> futureCook = new FutureTask<>(
                new Tax(cafeList, () -> cafeList.parallelStream()
                        .filter(cafe -> cafe.getMenu()==Menu.KITCHEN)
                        .mapToDouble(cafe -> cafe.getSum()*0.1)
                        .sum()));
        Thread threadCook = new Thread(futureCook);
        threadCook.start();

        // Зарплата
        FutureTask<Double> futureSalary = new FutureTask<>(
                new Tax(cafeList, () -> cafeList.parallelStream().mapToDouble(cafe -> cafe.getSum()*0.2).sum()));
        Thread threadSalary = new Thread(futureSalary);
        threadSalary.start();

        // Инвесторы
        FutureTask<Double> futureInvestors = new FutureTask<>(
                new Tax(cafeList, () -> cafeList.parallelStream().mapToDouble(cafe -> cafe.getSum()*0.1).sum()));
        Thread threadInvestors = new Thread(futureInvestors);
        threadInvestors.start();

        double sale = cafeList.parallelStream().mapToDouble(cafe -> cafe.getSum()).sum();
        System.out.println("Выторг - "+sale);
        System.out.println("----------------------");
        System.out.println("НДС - "+futureNds.get());
        System.out.println("Акциз на алкоголь - "+futureExcise.get());
        System.out.println("Налог на снеки - "+futureSnacks.get());
        System.out.println("Доп.выплаты поварам - "+futureCook.get());
        System.out.println("Зарплата - "+futureSalary.get());
        System.out.println("Выплаты инвесторам - "+futureInvestors.get());
        System.out.println("=======================");
        double profit  = sale - futureNds.get() - futureExcise.get() - futureSnacks.get() - futureCook.get() - futureSalary.get() - futureInvestors.get();
        System.out.println("Доход - "+profit+", % доходности - "+(profit * 100 / sale));

    }
}
