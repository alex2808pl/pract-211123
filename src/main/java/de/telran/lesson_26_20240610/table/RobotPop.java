package de.telran.lesson_26_20240610.table;

public class RobotPop implements Runnable {
    private Table table;
    private int numberRobot;

    public RobotPop(Table table, int numberRobot) {
        this.table = table;
        this.numberRobot = numberRobot;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()) {
                try {
                    Thread.sleep(500);
                    String box = table.pop(numberRobot);
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
