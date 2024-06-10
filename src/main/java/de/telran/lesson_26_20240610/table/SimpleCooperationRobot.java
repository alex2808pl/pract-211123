package de.telran.lesson_26_20240610.table;

public class SimpleCooperationRobot {
    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();
        RobotPop robotPop1 = new RobotPop(table,1);
        RobotPop robotPop2 = new RobotPop(table,2);
        RobotPut robotPut = new RobotPut(table);

        Thread threadPut = new Thread(robotPut);
        threadPut.start();

        Thread threadPop1 = new Thread(robotPop1);
        threadPop1.start();

        Thread threadPop2 = new Thread(robotPop2);
        threadPop2.start();

        Thread.sleep(5_000);

        threadPut.interrupt();
        threadPop1.interrupt();
        threadPop2.interrupt();

        threadPut.join();
        threadPop1.join();
        threadPop2.join();
    }
}
