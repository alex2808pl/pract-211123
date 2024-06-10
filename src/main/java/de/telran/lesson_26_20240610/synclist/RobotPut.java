package de.telran.lesson_26_20240610.synclist;

import java.util.List;
import java.util.UUID;

public class RobotPut implements Runnable {
    private final List<String> boxes;
    private int countBoxes = 3; // макс вместимость стола

    public RobotPut(List<String> box) {
        this.boxes = box;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(200);
                    if (boxes.size() >= countBoxes) {
                        synchronized (boxes) {
                            boxes.wait();
                        }
                    }

                    synchronized (boxes) {
                        String id = UUID.randomUUID().toString();
                        boxes.add(id);
                        System.out.println("+ Ложим на стол коробку - " + id + " остаток = " + boxes.size());
                        boxes.notify();
//                        boxes.notifyAll();
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

