package de.telran.lesson_25_20240605;

public class RobotPop implements Runnable {
    private Table table;

    public RobotPop(Table table) {
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            if (!Thread.interrupted()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+ " is awaik");
                    return;
                }
                String box = table.pop();
            }else {
                System.out.println(Thread.currentThread().getName() + " your work is finished");
                return;
            }

        }


    }
}
