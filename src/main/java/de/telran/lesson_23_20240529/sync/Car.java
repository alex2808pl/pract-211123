package de.telran.lesson_23_20240529.sync;

import java.util.concurrent.atomic.AtomicInteger;

class Car implements Runnable {
    private int countLiters = 40;
    private AtomicInteger barrelGas;
    private int numberThread;

    public Car(AtomicInteger barrelGas, int numberThread) {
        this.barrelGas = barrelGas;
        this.numberThread = numberThread;
    }

    @Override
    public void run() {
        synchronized (barrelGas) {
            int countGas = barrelGas.get();
            System.out.println("Автомобиль " + numberThread + " узнал остаток в цистерне = " + countGas);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (countGas >= countLiters) {
                barrelGas.addAndGet(-countLiters);
                System.out.println("Автомобиль " + numberThread + " заправился, остаток в цистерне = " + barrelGas);
            } else {
                System.out.println("Топлива недостаточно для авто - " + numberThread);
            }
        }
    }
}
