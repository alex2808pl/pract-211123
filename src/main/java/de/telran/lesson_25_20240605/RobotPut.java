package de.telran.lesson_25_20240605;

import java.rmi.server.UID;
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
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " is awaik");
                    return;
                }
                String id = UUID.randomUUID().toString();
                table.put(id);
            } else {
                System.out.println(Thread.currentThread().getName() + " your work is finished");
                return;
            }

        }

    }
}

