package de.telran.lesson_9_20240325;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        House house1 = new House(150, 150_000, "Antalya", false);
        House house2 = new House(100, 120_000, "Antalya", true);
        House house7 = new House(200, 120_000, "Antalya", false);
        House house3 = new House(80, 180_000, "Antalya", true);
        House house4 = new House(100, 180_000, "Tübingen", true);
        House house5 = new House(190, 200_000, "Stuttgart", false);
        House house6 = new House(60, 80_000, "Lviv", true);

        List<House> houseList = new ArrayList<>(Arrays.asList(house1, house2, house3, house4, house5, house6, house7));
        Collections.sort(houseList);
        System.out.println(houseList);
        TreeSet<House> treeSet = new TreeSet<>(houseList);
        System.out.println(treeSet);

        // Город + цена
        Collections.sort(houseList, new CompByCityAndPrice());
        System.out.println(houseList);

        // Город + площадь
        Comparator<House> compCityAndArea = new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                int result = o1.getCity().compareTo(o2.getCity());
                if (result == 0) result = Integer.compare(o2.getArea(), o1.getArea());
                return result;
            }
        };

        Collections.sort(houseList, compCityAndArea);
        System.out.println(houseList);

        // Город + цена + наличие мебели
        Collections.sort(houseList, new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                int result = o1.getCity().compareTo(o2.getCity());
                if (result == 0) result = Integer.compare(o1.getPrice(), o2.getPrice());
                if (result == 0) result = Boolean.compare(o2.isHasFurniture(), o1.isHasFurniture());
                return result;
            }
        });
        System.out.println(houseList);

    }
}
