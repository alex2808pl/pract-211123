package de.telran.lesson_22_2024_05_27;

import java.util.concurrent.atomic.AtomicInteger;

public class GasStation {

    public static void main(String[] args) {
        AtomicInteger gas = new AtomicInteger(1000);
        int count = 0;
        while (gas.get() > 0) {
            Thread thread1 = new Thread(new Car(gas, count + 1));
            Thread thread2 = new Thread(new Car(gas, count + 2));
            Thread thread3 = new Thread(new Car(gas, count + 3));
            //System.out.println(gas);
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
            //System.out.println(gas);
        }


    }
}

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
        synchronized (barrelGas){
            int literBarrel = barrelGas.get();

            System.out.println("Автомобиль " + numberThread + " увидел остаток в цистерне - " + barrelGas);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (literBarrel >= countLiters) {
                barrelGas.addAndGet(-countLiters);
                System.out.println("Автомобиль " + numberThread + " заправился, остаток в цистерне - " + barrelGas);
            } else {
                System.out.println("Топлива недостаточно для авто - " + numberThread);
            }
        }

    }
}

