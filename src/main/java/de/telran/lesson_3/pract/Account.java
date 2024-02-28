package de.telran.lesson_3.pract;

import de.telran.lesson_3.pract.interfaces.Owner;

public abstract class Account implements Owner {

    protected String accountNumber; //IBAN
    protected double balance;
    protected StatusAccount status; //закрыт, приостановлен, открыт
    protected String openDate;
    protected String closeDate;

    public abstract double withdrawBalance(double sum);

    public abstract void addBalance(double sum);

    public void setStatus(StatusAccount status) {
            this.status = status;
    }

    public void closeAccount(String closeDate) {
        if (balance == 0) {
            this.status = StatusAccount.CLOSE;
            this.closeDate = closeDate;
            System.out.println("Your account is closed");
        } else {
            System.out.println("You can't close your account");
        }
    }

    public double getBalance() {
        return balance;
    }
}

//    Есть класс Банковский счет (Account)
//Характеристики: номер счета, баланс счета (количество денег на счете),
//        статус счета (закрыт, приостановлен, открыт), дата открытия счета, дата закрытия счета.
//        Поведение: положить деньги на счет, снять деньги со счета,
//        сменить статус счета, закрыть счет , вернуть остаток по счету.