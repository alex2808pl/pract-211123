package de.telran.lesson_3.pract;

public abstract class Account {

    protected String accountNumber; //IBAN
    protected double balance;
    protected String status;
    protected String openDate;
    protected String closeDate;

    public abstract double withdrawBalance(double sum);

    public abstract void addBalance(double sum);

    public void setStatus(String status) {
        if (status.equals("opened") || status.equals("closed") || status.equals("frozen")){
            this.status = status;
        } else {
            System.out.println("Incorrect status, try again.");
        }
    }

    public void closeAccount(String closeDate) {
        if (balance == 0) {
            this.status = "closed";
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