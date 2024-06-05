package de.telran.lesson_25_20240605;

public class Table {
    String box;

    public synchronized void put(String box) throws InterruptedException {
        if (this.box != null) {
            wait();
        }
        this.box = box;
        System.out.println("+ Ложим на стол коробку - " + box);
        notify();

    }

    public synchronized String pop() throws InterruptedException {
        if (this.box == null) {
            wait();
        }
        String returnBox = box;
        box = null;
        System.out.println("- Забираем со стола - " + returnBox);
        notify();
        return returnBox;
    }
}
