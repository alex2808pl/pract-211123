package de.telran.lesson_25_20240605;

public class Table {
    String box;

    public synchronized void put(String box)  {
        if (this.box != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.box = box;
            System.out.println("Ложим на стол коробку - "+box);
            notify();
        }
    }

    public synchronized String pop() {
        if (this.box != null) {
             String returnBox = box;
             box = null;
             System.out.println("Забираем со стола - "+returnBox);
             notify();
             return returnBox;
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return box;
    }
}
