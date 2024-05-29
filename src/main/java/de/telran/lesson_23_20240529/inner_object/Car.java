package de.telran.lesson_23_20240529.inner_object;

import java.util.concurrent.atomic.AtomicInteger;

class Car implements Runnable {
    private int countLiters = 40;
    private Barrel barrel;
    private int numberThread;

    public Car(Barrel barrel, int numberThread) {
        this.barrel = barrel;
        this.numberThread = numberThread;
    }

    @Override
    public void run() {
        // при такой реализации для решение проблемы "гонки" можно так же использовать
        // синхронизацию внешнего объекта (например: synchronized (barrelGas)) или ReentrantLock
        barrel.minusFuel(countLiters, numberThread);
    }
}

