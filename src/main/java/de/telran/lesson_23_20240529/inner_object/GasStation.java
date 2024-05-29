package de.telran.lesson_23_20240529.inner_object;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Синхронизация через блок synchronized внешнего объекта
public class GasStation {
    public static void main(String[] args) {

        Barrel barrel = new Barrel(1000, 1000);

        int count = 0;
        while (barrel.getBalance() > 0) {
            Thread thread1 = new Thread(new Car(barrel, count + 1));
            Thread thread2 = new Thread(new Car(barrel, count + 2));
            Thread thread3 = new Thread(new Car(barrel, count + 3));
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

