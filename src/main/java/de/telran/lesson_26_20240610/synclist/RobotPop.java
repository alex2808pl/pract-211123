package de.telran.lesson_26_20240610.synclist;
import java.util.List;


public class RobotPop implements Runnable {
    private List<String> boxes;
    private int numberRobot;

    public RobotPop(List<String> box, int numberRobot) {
        this.boxes = box;
        this.numberRobot = numberRobot;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(500);
                    while (boxes.isEmpty()) {
                        synchronized (boxes) {
                            boxes.wait();
                        }
                    }
                    synchronized (boxes) {
                        String returnBox = boxes.removeFirst();
                        System.out.println("- " + numberRobot + " забирает со стола - " + returnBox + " остаток - " + boxes.size());
                        boxes.notify();
//                        boxes.notifyAll();
                    }
                } catch (InterruptedException e) {
                    System.out.println(numberRobot + " спал и остановлен");
                    return;
                }
            } else {
                System.out.println(numberRobot + " спал и остановлен");
                return;
            }

        }


    }
}
