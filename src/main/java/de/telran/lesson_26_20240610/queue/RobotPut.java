package de.telran.lesson_26_20240610.queue;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class RobotPut implements Runnable {
    private final BlockingQueue<String> queue;
    private int countBoxes = 3; // макс вместимость стола

    public RobotPut(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(200);
                    String id = UUID.randomUUID().toString();
                    if(queue.offer(id)) {
                        System.out.println("+ Ложим на стол коробку - " + id + " остаток = " + queue.size());
                    } else {
                        System.out.println("!!! Не удалось положить на стол коробку - " + id + " остаток = " + queue.size());
                    }
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

