package de.telran.lesson_26_20240610.synclist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleCooperationRobot {
    public static void main(String[] args) throws InterruptedException {
        int countPops = 2;
        Thread[] threadPops = new Thread[countPops];

        List<String> box = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < countPops; i++) {
            threadPops[i] = new Thread(new RobotPop(box,i+1));
        }
        RobotPut robotPut = new RobotPut(box);

        Thread threadPut = new Thread(robotPut);
        threadPut.start();

        for (int i = 0; i < countPops; i++) {
            threadPops[i].start();
        }

        Thread.sleep(5_000);

        threadPut.interrupt();
        for (int i = 0; i < countPops; i++) {
            threadPops[i].interrupt();
        }

        System.out.println(" == Конец главного потока! == ");
    }
}
