package de.telran.lesson_26_20240610.table;

import java.util.UUID;

public class RobotPut implements Runnable {
    private Table table;

    public RobotPut(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(200);
                    String id = UUID.randomUUID().toString();
                    table.put(id);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " спал и остановлен");
                    return;
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " спал и остановлен");
                return;
            }

        }

    }
}

