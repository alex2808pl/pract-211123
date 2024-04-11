package de.telran.lesson_11_20240408;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/* 3) Автозаправка. По умолчанию автомобили заправляются согласно стандартной очереди FIFO. Но автомобили скорой помощи
        всегда заправляются вне очереди.
        В час пик, общественные автобусы получают максимальный приоритет по заправке, но скорая помощь все равно более приоритетна.
        Во время стихийных бедствий (снегопад, наводнение) технологический транспорт городских служб заправляется вне очереди.
        Какую бы коллекцию Вы использовали для реализацию данного алгоритма?
                Напишите программу, которая бы имитировала работу.*/
public class SimplePriorityQueue {
    public static void main(String[] args) {
        Transport transport1 = new Transport("Скорая",1,TransportTypes.AMBULANCE);
        Transport transport2 = new Transport("Аварийная",2,TransportTypes.SERVICE);
        Transport transport3 = new Transport("Автобус",2,TransportTypes.BUS);
        Transport transport4 = new Transport("Авто синее",2,TransportTypes.CAR);
        Transport transport5 = new Transport("Авто красное",2,TransportTypes.CAR);

        Queue<Transport> transportsQueue = new PriorityQueue<>();
        transportsQueue.add(transport5);
        transportsQueue.add(transport4);
        transportsQueue.add(transport1);
        transportsQueue.add(transport2);
        transportsQueue.add(transport3);

        System.out.println(transportsQueue);

        System.out.println(transportsQueue.peek());


        //час пик
        Queue<Transport> transportsQueuePick = new PriorityQueue<>(new Comparator<Transport>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                if (o1.getTransportTypes().equals(TransportTypes.SERVICE)
                        || o1.getTransportTypes().equals(TransportTypes.CAR)){
                    o1.setPriorityLevel(3);
                }
                if (o2.getTransportTypes().equals(TransportTypes.SERVICE)
                        || o2.getTransportTypes().equals(TransportTypes.CAR)){
                    o2.setPriorityLevel(3);
                }
                return Integer.compare(o1.getPriorityLevel(), o2.getPriorityLevel());
            }
        });

        transportsQueuePick.addAll(transportsQueue);
        System.out.println(transportsQueuePick);
        System.out.println(transportsQueuePick.remove());
        System.out.println(transportsQueuePick.peek());
        System.out.println(transportsQueuePick.remove());
        System.out.println(transportsQueuePick.peek());
        System.out.println(transportsQueuePick.peek());

        //Стихийное бедствие
        Queue<Transport> transportQueueAlarm = new PriorityQueue<>(new Comparator<Transport>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                if (o1.getTransportTypes().equals(TransportTypes.SERVICE)) {
                    o1.setPriorityLevel(1);
                }
                if (o2.getTransportTypes().equals(TransportTypes.SERVICE)) {
                    o2.setPriorityLevel(1);
                }
                if (o1.getTransportTypes().equals(TransportTypes.AMBULANCE)) {
                    o1.setPriorityLevel(2);
                }
                if (o2.getTransportTypes().equals(TransportTypes.AMBULANCE)) {
                    o2.setPriorityLevel(2);
                }

                if (o1.getTransportTypes().equals(TransportTypes.CAR)) {
                    o1.setPriorityLevel(2);
                }
                if (o2.getTransportTypes().equals(TransportTypes.CAR)) {
                    o2.setPriorityLevel(2);
                }
                return Integer.compare(o1.getPriorityLevel(), o2.getPriorityLevel());

            }
        });
        System.out.println();
        transportQueueAlarm.addAll(transportsQueue);
        System.out.println(transportQueueAlarm);
        System.out.println(transportQueueAlarm.poll());
        System.out.println(transportQueueAlarm.poll());
        System.out.println(transportQueueAlarm.peek());
        System.out.println(transportQueueAlarm);
    }
}
