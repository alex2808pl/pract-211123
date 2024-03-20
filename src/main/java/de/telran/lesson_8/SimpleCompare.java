package de.telran.lesson_8;

import java.util.*;

public class SimpleCompare {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();

        Auto auto1 = new Auto("KK456FF", "Audi", 2010);
        Auto auto2 = new Auto("AA456FF", "BMW", 2013);
        Auto auto3 = new Auto("CC456FF", "VW", 2015);
        Auto auto4 = new Auto("DD456FF", "Mersedes", 2012);

        Comparator<Auto> comparator1 = new AutoCompare();

        TreeSet<Auto> setAutos = new TreeSet<>(comparator1);
        setAutos.add(auto1);
        setAutos.add(auto2);
        setAutos.add(auto3);
        setAutos.add(auto4);
        System.out.println(setAutos);

        // Анонимный класс
        Comparator<Auto> comparator2 = new Comparator<Auto>() {
            @Override
            public int compare(Auto o1, Auto o2) {
                return o2.getManufactureYear() - o1.getManufactureYear();
            }
        };

        TreeSet<Auto> setAutosReverse = new TreeSet<>(comparator2);
        setAutosReverse.addAll(setAutos);
        System.out.println(setAutosReverse);

        TreeSet<Auto> setAutosNatural = new TreeSet<>();
        setAutosNatural.addAll(setAutos);
        System.out.println(setAutosNatural);

        Set<Auto> sets = new HashSet<>();
        sets.addAll(setAutos);
        System.out.println(sets);

        setAutosNatural= new TreeSet<>(sets);
        System.out.println(setAutosNatural);

        //LinkedHashSet - сохраняет порядок добавления
        Set<Auto> setsLinked = new LinkedHashSet<>();
        setsLinked.add(auto1);
        setsLinked.add(auto3);
        setsLinked.add(auto2);
        setsLinked.add(auto4);
        System.out.println(setsLinked);

        setAutos.add(new Auto("РР456FF", "ВАЗ", Integer.MIN_VALUE));
        System.out.println(setAutos);

        int res = Integer.MIN_VALUE - 2010;
        System.out.println(res);

        res = Integer.MAX_VALUE + 2010;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(res);

    }
}
