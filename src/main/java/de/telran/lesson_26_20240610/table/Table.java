package de.telran.lesson_26_20240610.table;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> boxes = new ArrayList<>();
    private final int countBoxes = 3;

    public synchronized void put(String box) throws InterruptedException {
        if (boxes.size() >= countBoxes) {
            wait();
        }
        boxes.add(box);
        System.out.println("+ Ложим на стол коробку - " + box + " остаток = " + boxes.size());
        notify();
//        notifyAll();

    }

    public synchronized String pop(int numberRobot) throws InterruptedException {
        while (boxes.isEmpty()) {
            wait();
        }
        String returnBox = boxes.removeFirst();
        System.out.println("- " + numberRobot + " забирает со стола - " + returnBox + " остаток - " + boxes.size());
        notify();
//        notifyAll();
        return returnBox;

    }
}
