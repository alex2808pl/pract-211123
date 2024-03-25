package de.telran.lesson_9_20240325.queue;

import de.telran.lesson_9_20240325.House;

import java.util.*;

public class SimpleQueue {
    public static void main(String[] args) {
        House house1 = new House(150, 150_000, "Antalya", false);
        House house2 = new House(100, 120_000, "Antalya", true);
        House house7 = new House(200, 120_000, "Antalya", false);
        House house3 = new House(80, 180_000, "Antalya", true);
        House house4 = new House(100, 180_000, "Tübingen", true);
        House house5 = new House(190, 200_000, "Stuttgart", false);
        House house6 = new House(60, 80_000, "Lviv", true);

        List<House> houseList = new ArrayList<>(Arrays.asList(house1, house2, house3, house4, house5, house6, house7));

        Queue<House> houseQueue = new LinkedList<>();
        houseQueue.addAll(houseList);
        System.out.println(" Queue " + houseQueue);
        //Удаляем
        System.out.println(houseQueue.remove());
        System.out.println(houseQueue.remove());
        System.out.println(houseQueue);

        //Добавляем
        houseQueue.add(house3);
        houseQueue.offer(house1);
        System.out.println(houseQueue);

        //Просматриваем
        houseQueue.peek();
        System.out.println(houseQueue);
    }
}
