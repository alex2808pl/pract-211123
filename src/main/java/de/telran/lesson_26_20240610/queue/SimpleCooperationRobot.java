package de.telran.lesson_26_20240610.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class SimpleCooperationRobot {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3, true);

        int countPops = 2;
        Thread[] threadPops = new Thread[countPops];

        for (int i = 0; i < countPops; i++) {
            threadPops[i] = new Thread(new RobotPop(queue,i+1));
        }
        RobotPut robotPut = new RobotPut(queue);

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
