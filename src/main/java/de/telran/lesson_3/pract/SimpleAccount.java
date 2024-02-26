package de.telran.lesson_3.pract;

public class SimpleAccount {
    public static void main(String[] args) {
        DepositAccount depositAccount = new DepositAccount(1000, "Ivan", "1234567890123456");
        System.out.println(depositAccount);

        depositAccount.addBalance(999);
        System.out.println(depositAccount);

        depositAccount.withdrawBalance(500);
        System.out.println(depositAccount);

        depositAccount.setStatus("closed");
        System.out.println(depositAccount);
    }
}
