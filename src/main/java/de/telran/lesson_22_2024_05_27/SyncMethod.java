package de.telran.lesson_22_2024_05_27;

public class SyncMethod {
    static Object mutex = new Object();

    public static void main(String[] args) {
        Barrel barrel = new Barrel(1000);
        int count = 0;
        while (barrel.getBarrel() > 0) {
            Auto auto1 = new Auto(barrel, 40, ++count);
            Auto auto2 = new Auto(barrel, 40, ++count);
            Auto auto3 = new Auto(barrel, 40, ++count);

            Thread thread1 = new Thread(auto1);
            Thread thread2 = new Thread(auto2);
            Thread thread3 = new Thread(auto3);

            thread1.start();
            thread2.start();
            thread3.start();

            try {
                thread1.join();
                thread2.join();
                thread3.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }

    static class Barrel {
        int barrel;
//        int liter;

        public int getBarrel() {
            return barrel;
        }

        public void setBarrel(int barrel) {
            this.barrel = barrel;
        }

        public  int addLiterInBarrel(int liter) {
            barrel += liter;
            return barrel;

        }

        @Override
        public String toString() {
            return "Barrel{" +
                    "barrel=" + barrel +
                    '}';
        }

        public synchronized int getLiterFromBarrel(int liter) {
            if (liter > barrel) {
                System.err.println("It's not impossible");
            } else {
                System.out.println("остаток топлива "+ barrel);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                barrel -= liter;
            }
            return barrel;
        }

        public Barrel(int barrel) {
            this.barrel = barrel;
//            this.liter = liter;

        }

    }

    public static class Auto implements Runnable {
        private Barrel barrel;
        private int liter;
        private int numberThread;

        public Auto(Barrel barrel, int liter, int numberThread) {
            this.barrel = barrel;
            this.liter = liter;
            this.numberThread = numberThread;
        }

        @Override
        public void run() {
//            synchronized (barrel){
//                int literBarrel = barrel.getBarrel();
//            System.out.println("Автомобиль " + numberThread + " увидел остаток в цистерне - " + literBarrel);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (barrel.getBarrel() >= liter) {
                    barrel.getLiterFromBarrel(liter);
                    System.out.println("Автомобиль " + numberThread + " заправился, остаток в цистерне - " + barrel);
                } else {
                    System.err.println("Топлива недостаточно для авто - " + numberThread);
                }
//            }

        }


        public int getLiter() {
            return liter;
        }

        public void setLiter(int liter) {
            this.liter = liter;
        }


    }
}
