package de.telran.lesson_25_20240605;

public class SimpleCooperationRobot {
    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();
        RobotPop robotPop = new RobotPop(table);
        RobotPut robotPut = new RobotPut(table);

        Thread threadPut = new Thread(robotPut);
        threadPut.start();
        Thread threadPop = new Thread(robotPop);
        threadPop.start();
        Thread.sleep(5_000);

        threadPut.interrupt();
        threadPop.interrupt();

        threadPut.join();
        threadPop.join();


//        Thread.sleep(5000);


    }
}
