package de.telran.lesson_3.pract;

import de.telran.lesson_3.pract.interfaces.Owner;

import java.time.LocalDate;

public class SimpleAccount {
    public static void main(String[] args) {
        DepositAccount depositAccount = new DepositAccount(1000, "Ivan", "1234567890123456");
        System.out.println(depositAccount);

        depositAccount.addBalance(999);
        System.out.println(depositAccount);

        depositAccount.withdrawBalance(500);
        System.out.println(depositAccount);

        depositAccount.setStatus(StatusAccount.CLOSE);
        System.out.println(depositAccount);

        CreditAccount creditAccount = new CreditAccount("Ivan", "1234567890123456", 1000, 2000);
        System.out.println(creditAccount);

        System.out.println(creditAccount.withdrawBalance(1000)); // снятие
        System.out.println(creditAccount);

        creditAccount.addBalance(500);
        System.out.println(creditAccount);

        CardAccount cardAccount = new CardAccount(1000, "Ivan", "1234567890123456");
        cardAccount.withdrawBalance(575);
        System.out.println(cardAccount);

        cardAccount.addBalance(1000);
        System.out.println(cardAccount);

        // ограничили доступ с помощью интерфейса только конкретнім поведением
        Owner owner1 = new DepositAccount(1000, "Ivan", "1234567890123456");
        Owner owner2 = depositAccount;

        System.out.println(owner1.getBalance());


    }
}
