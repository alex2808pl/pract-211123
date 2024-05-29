package de.telran.lesson_23_20240529.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Синхронизация через ReentrantLock
public class GasStationLock {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        AtomicInteger gas = new AtomicInteger(1000);

        int count = 0;
        while (gas.get() > 0) {

            Thread thread1 = new Thread(new de.telran.lesson_23_20240529.lock.Car(gas, count + 1,lock));
            Thread thread2 = new Thread(new de.telran.lesson_23_20240529.lock.Car(gas, count + 2,lock));
            Thread thread3 = new Thread(new de.telran.lesson_23_20240529.lock.Car(gas, count + 3,lock));
            thread1.start();
            thread2.start();
            thread3.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count += 3;
        }


    }
}

